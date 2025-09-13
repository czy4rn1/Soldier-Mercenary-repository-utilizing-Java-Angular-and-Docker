package com.example.soldier.Functions;

import com.example.soldier.Classes.MilitaryCompany;
import com.example.soldier.Classes.Soldier;
import com.example.soldier.DTO.PutSoldierRequest;
import org.springframework.stereotype.Component;

import java.util.UUID;
import java.util.function.BiFunction;

@Component
public class RequestToSoldier implements BiFunction<UUID, PutSoldierRequest, Soldier> {

    public Soldier apply(UUID id, PutSoldierRequest request) {
        return Soldier.builder()
                .id(id)
                .codename(request.getCodename())
                .specialty(request.getSpecialty())
                .skillRank(request.getSkillRank())
                .militaryCompany(MilitaryCompany.builder()
                        .id(request.getMilitaryCompany())
                        .build())
                .build();
    }
}
