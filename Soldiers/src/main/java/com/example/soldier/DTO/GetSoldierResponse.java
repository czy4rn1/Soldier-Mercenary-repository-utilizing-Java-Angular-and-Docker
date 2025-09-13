package com.example.soldier.DTO;

import lombok.*;

import java.util.UUID;

@Data
@Builder
@EqualsAndHashCode
@AllArgsConstructor
@ToString
public class GetSoldierResponse implements Comparable<GetSoldierResponse>{

    private final UUID id;
    private final String codename;
    private final String specialty;
    private final int skillRank;
    private final UUID militaryCompany;


    @Override
    public int compareTo(GetSoldierResponse o) {
        return codename.compareTo(o.codename);
    }

    @Override
    public String toString() {
        return id.toString() + " | " + codename + " | " + specialty + " | " + skillRank + " | " + militaryCompany + "\n";
    }
}
