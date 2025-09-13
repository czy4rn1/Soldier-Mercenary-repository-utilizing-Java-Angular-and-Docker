package com.example.soldier.Classes;

import lombok.*;

import jakarta.persistence.*;
import org.hibernate.annotations.Cascade;

import java.io.Serializable;
import java.util.List;
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

    @OneToMany(mappedBy = "militaryCompany", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @ToString.Exclude
    private List<Soldier> soldiers;




}
