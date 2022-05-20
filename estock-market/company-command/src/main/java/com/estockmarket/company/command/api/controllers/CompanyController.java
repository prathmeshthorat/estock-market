package com.estockmarket.company.command.api.controllers;

import com.estockmarket.company.command.api.AddStockPriceCommand;
import com.estockmarket.company.command.api.DeleteCompanyCommand;
import com.estockmarket.company.command.api.RegisterComapnyCommand;
import com.estockmarket.company.command.api.Validator;
import com.estockmarket.company.command.api.dto.RegisterCompanyResponse;
import com.estockmarket.cqrscore.commands.common.dto.BaseResponse;
import com.estockmarket.cqrscore.infra.CommandDispatcher;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.oauth2.core.oidc.OidcIdToken;
import org.springframework.security.oauth2.core.oidc.user.OidcUser;
import org.springframework.web.bind.annotation.*;

import java.util.logging.Logger;

@RestController
@RequestMapping("/api/v1.0/market")
public class CompanyController {

    // To Do: Add logger with kafka appender.

    private final Logger logger = Logger.getLogger(CompanyController.class.getName());

    @Autowired
    private CommandDispatcher commandDispatcher;

    @GetMapping("/")
    public OidcIdToken login(@AuthenticationPrincipal OidcUser user ){
        logger.info("Logged in: token:  "+user.getIdToken());
        logger.info("Logged in: user:  "+user.getEmail());
        return user.getIdToken();
    }

    @Operation(summary = "to register a company")
    @PostMapping("/company/register")
    public ResponseEntity<BaseResponse> registerCompany(@RequestBody RegisterComapnyCommand command) {
        logger.info("Registering comapany: ");
        Validator.validateRequest(command);
        command.setId(command.getCompanyCode());
        commandDispatcher.send(command);
        logger.info("Dispatched RegisterComapnyCommand: " + command);
        return new ResponseEntity<BaseResponse>(new RegisterCompanyResponse("Company registered successfully.", command.getCompanyCode()), HttpStatus.OK);
    }

    @Operation(summary = "adding stockPrice to a company")
    @PostMapping("/stock/add/{companyCode}")
    public ResponseEntity<BaseResponse> addNewStockPrice(@PathVariable("companyCode") String companyCode,
                                                         @RequestBody AddStockPriceCommand command) {
        logger.info("Adding stock price for comapany: " + companyCode);
        command.setId(companyCode);
        commandDispatcher.send(command);
        return new ResponseEntity<BaseResponse>(
                new BaseResponse("New stock price added for company code: " + companyCode), HttpStatus.OK);
    }

    @Operation(summary = "deleting a company")
    @DeleteMapping("/company/delete/{companyCode}")
    public ResponseEntity<BaseResponse> deleteCompany(@PathVariable("companyCode") String companyCode) {
        logger.info("Deleting comapany: " + companyCode);
        DeleteCompanyCommand command = new DeleteCompanyCommand(companyCode);
        command.setId(companyCode);
        commandDispatcher.send(command);
        return new ResponseEntity<BaseResponse>(
                new BaseResponse(String.format("Company with company code: %s deleted successfully.", companyCode)),
                HttpStatus.OK);
    }

}
