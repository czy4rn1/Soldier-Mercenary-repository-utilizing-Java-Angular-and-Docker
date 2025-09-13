package com.example.soldier.DTO;

import lombok.*;

import java.util.List;
import java.util.UUID;
import java.util.function.Consumer;

@Data
@Builder
@EqualsAndHashCode
@AllArgsConstructor
public class GetSoldiersResponse {
    @Data
    @Builder
    @EqualsAndHashCode
    @AllArgsConstructor
    public static class Soldier {
        private UUID id;
        private String codename;

    }

    @Singular
    private List<Soldier> soldiers;
}
