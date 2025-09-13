package com.example.company.DTO;

import lombok.*;

import java.util.UUID;

@ToString
@Data
@AllArgsConstructor
@EqualsAndHashCode
@Builder
public class GetCompanyResponse {

    private final UUID id;
    private final String name;
    private final int foundingYear;
}
