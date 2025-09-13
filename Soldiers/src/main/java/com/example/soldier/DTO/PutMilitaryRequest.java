package com.example.soldier.DTO;

import lombok.*;

import java.util.UUID;

@Data
@Builder
@ToString
@AllArgsConstructor
@EqualsAndHashCode
@NoArgsConstructor(force = true)
public class PutMilitaryRequest {
    private final UUID id;

}
