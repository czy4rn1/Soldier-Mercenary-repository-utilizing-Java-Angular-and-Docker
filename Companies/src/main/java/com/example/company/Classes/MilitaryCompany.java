package com.example.company.Classes;

import lombok.*;

import jakarta.persistence.*;
import java.io.Serializable;
import java.util.UUID;

@ToString
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Builder
@Table(name = "MilitaryCompanies")
public class MilitaryCompany implements Serializable {
    @Id
    private UUID id;

    @Column(unique = true)
    private String name;

    private int foundingYear;


}
