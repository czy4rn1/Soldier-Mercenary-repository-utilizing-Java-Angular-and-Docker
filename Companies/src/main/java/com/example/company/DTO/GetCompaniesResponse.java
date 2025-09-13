package com.example.company.DTO;
import lombok.*;

import java.util.List;
import java.util.UUID;

@Data
@Builder
@EqualsAndHashCode
@AllArgsConstructor
@ToString
public class GetCompaniesResponse {
    @Data
    @Builder
    @EqualsAndHashCode
    @AllArgsConstructor
    @ToString
    public static class MilitaryCompany {
        private UUID id;
        private String name;

    }

    @Singular
    private List<MilitaryCompany> companies;
}
