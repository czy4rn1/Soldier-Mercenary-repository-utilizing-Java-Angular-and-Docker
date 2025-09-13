package com.example.company.DTO;

import lombok.*;

import java.util.UUID;

@Data
@Builder
@ToString
@AllArgsConstructor
@EqualsAndHashCode
public class PutMilitaryRequest {
    private final UUID id;
    private final String name;
    private final int foundingYear;
}
