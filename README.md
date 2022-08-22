
# EStock-Market Backend Usecase

1. Clone Project.
2. Build estock-market using mvn clean install.
3. Start docker containers required for running application. Do docker-compose up.
4. Start comapany-command, company-query applications.
5. Start keycloak container with below command:
 docker run -p 8080:8080 --name keycloak --hostname keycloak --network backup_default -e KEYCLOAK_ADMIN=admin -e KEYCLOAK_ADMIN_PASSWORD=admin -e DB_VENDOR=MYSQL -e MYSQL_ADDR=mysql-container -e DB_DATABASE=keycloak -e DB_USER=root -e DB_PASSWORD=estockMarketRootPw quay.io/keycloak/keycloak:18.0.0 start-dev

6. Import realms setting available in git repository.
7. Get Access token using postman request available in git repository.
8. Use Postman collection to test other services.

