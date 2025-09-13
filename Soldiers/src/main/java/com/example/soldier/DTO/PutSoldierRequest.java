package com.example.soldier.DTO;

import lombok.*;

import java.util.UUID;


@Data
@Builder
@EqualsAndHashCode
@AllArgsConstructor
@ToString
public class PutSoldierRequest{

    private final String codename;
    private final String specialty;
    private final int skillRank;
    private final UUID militaryCompany;


}
