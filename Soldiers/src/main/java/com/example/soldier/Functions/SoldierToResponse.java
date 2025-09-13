package com.example.soldier.Functions;

import com.example.soldier.Classes.Soldier;
import com.example.soldier.DTO.GetSoldierResponse;
import org.springframework.stereotype.Component;
import java.util.function.Function;

@Component
public class SoldierToResponse implements Function<Soldier, GetSoldierResponse> {
    public GetSoldierResponse apply(Soldier soldier) {
        return GetSoldierResponse.builder()
                .id(soldier.getId())
                .codename(soldier.getCodename())
                .specialty(soldier.getSpecialty())
                .skillRank(soldier.getSkillRank())
                .militaryCompany(soldier.getMilitaryCompany().getId())
                .build();
    }
}
