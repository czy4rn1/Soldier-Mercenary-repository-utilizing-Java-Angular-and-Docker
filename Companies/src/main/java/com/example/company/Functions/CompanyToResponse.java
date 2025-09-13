package com.example.company.Functions;

import com.example.company.Classes.MilitaryCompany;
import com.example.company.DTO.GetCompanyResponse;
import org.springframework.stereotype.Component;


import java.util.function.Function;

@Component
public class CompanyToResponse implements Function<MilitaryCompany, GetCompanyResponse> {
    public GetCompanyResponse apply(MilitaryCompany company) {
        return GetCompanyResponse.builder()
                .id(company.getId())
                .name(company.getName())
                .foundingYear(company.getFoundingYear())
                .build();
    }
}
