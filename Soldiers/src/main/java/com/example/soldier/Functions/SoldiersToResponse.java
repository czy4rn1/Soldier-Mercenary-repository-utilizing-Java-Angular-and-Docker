package com.example.soldier.Functions;

import com.example.soldier.Classes.Soldier;
import com.example.soldier.DTO.GetSoldiersResponse;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.function.Function;

@Component
public class SoldiersToResponse implements Function<List<Soldier>, GetSoldiersResponse> {
    public GetSoldiersResponse apply(List<Soldier> entities) {
        return GetSoldiersResponse.builder()
                .soldiers(entities.stream()
                        .map(soldier -> GetSoldiersResponse.Soldier.builder()
                                .id(soldier.getId())
                                .codename(soldier.getCodename())
                                .build())
                        .toList()).build();
    }
}
