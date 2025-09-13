package com.example.company.Functions;

import com.example.company.Classes.MilitaryCompany;
import com.example.company.DTO.PutMilitaryRequest;
import org.springframework.stereotype.Component;

import java.util.UUID;
import java.util.function.BiFunction;

@Component
public class RequestToCompany implements BiFunction<UUID, PutMilitaryRequest, MilitaryCompany> {

    public MilitaryCompany apply(UUID id, PutMilitaryRequest request) {
        return MilitaryCompany.builder()
                .id(id)
                .name(request.getName())
                .foundingYear(request.getFoundingYear())
                .build();
    }
}
