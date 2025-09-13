package com.example.soldier.Functions;

import com.example.soldier.Classes.MilitaryCompany;
import com.example.soldier.DTO.PutMilitaryRequest;
import org.springframework.stereotype.Component;

import java.util.UUID;
import java.util.function.BiFunction;

@Component
public class RequestToCompany implements BiFunction<UUID, PutMilitaryRequest, MilitaryCompany> {

    public MilitaryCompany apply(UUID id, PutMilitaryRequest request) {
        return MilitaryCompany.builder()
                .id(id)
                .build();
    }
}
