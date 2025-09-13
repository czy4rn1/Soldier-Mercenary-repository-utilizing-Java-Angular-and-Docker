package com.example.company.Initialize;

import com.example.company.Classes.MilitaryCompany;
import com.example.company.Service.CompanyService;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
public class DataInitializer implements InitializingBean {
    private final CompanyService companyService;

    @Autowired
    public DataInitializer(CompanyService companyService) {
        this.companyService = companyService;
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        MilitaryCompany mc1 = MilitaryCompany.builder().name("Diamond_Dogs").foundingYear(1984).id(UUID.fromString("738a4c02-8796-11ee-b9d1-0242ac120002")).build();
        companyService.createCompany(mc1);

        MilitaryCompany mc2 = MilitaryCompany.builder().name("Outer_Heaven").foundingYear(1989).id(UUID.fromString("738a5756-8796-11ee-b9d1-0242ac120002")).build();
        companyService.createCompany(mc2);

        MilitaryCompany mc3 = MilitaryCompany.builder().name("MSF").foundingYear(1974).id(UUID.fromString("738a5d5a-8796-11ee-b9d1-0242ac120002")).build();
        companyService.createCompany(mc3);


    }
}
