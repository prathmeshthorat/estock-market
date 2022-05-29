package com.estockmarket.company.query.dto;

import com.estockmarket.cqrscore.commands.common.dto.BaseResponse;
import com.estockmarket.cqrscore.domain.BaseEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import java.util.List;

@Data
@NoArgsConstructor
@SuperBuilder
@AllArgsConstructor
public class CompanyLookupResponse extends BaseResponse {

    private List<BaseEntity> data;
    private double min;
    private double max;
    private double avg;

    public CompanyLookupResponse(String message) {
        super(message);
    }

}
