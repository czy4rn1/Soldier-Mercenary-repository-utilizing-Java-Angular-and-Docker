package com.example.company.Functions;


import com.example.company.Classes.MilitaryCompany;
import com.example.company.DTO.PatchCompanyRequest;
import org.springframework.stereotype.Component;

import java.util.function.BiFunction;

@Component
public class UpdateCompanyWithRequest implements BiFunction<MilitaryCompany, PatchCompanyRequest, MilitaryCompany> {
    @Override
    public MilitaryCompany apply(MilitaryCompany entity, PatchCompanyRequest request) {
        return MilitaryCompany.builder()
                .name(entity.getName())
                .foundingYear(entity.getFoundingYear())
                .build();
    }
}
