package com.example.company.Functions;

import com.example.company.Classes.MilitaryCompany;
import com.example.company.DTO.GetCompaniesResponse;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.function.Function;

@Component
public class CompaniesToResponse implements Function<List<MilitaryCompany>, GetCompaniesResponse> {
    public GetCompaniesResponse apply(List<MilitaryCompany> entities) {
        return GetCompaniesResponse.builder()
                .companies(entities.stream()
                        .map(company -> GetCompaniesResponse.MilitaryCompany.builder()
                                .id(company.getId())
                                .name(company.getName())
                                .build())
                        .toList()).build();
    }
}
