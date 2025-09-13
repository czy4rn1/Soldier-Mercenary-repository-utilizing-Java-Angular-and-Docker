package com.example.soldier.Classes;
import com.example.soldier.Classes.MilitaryCompany;
import lombok.*;

import jakarta.persistence.*;
import org.hibernate.annotations.Cascade;

import java.io.Serializable;
import java.util.UUID;


@AllArgsConstructor
@Data
@NoArgsConstructor
@Entity
@Builder
@Table(name = "Soldiers")
public class Soldier implements Serializable {

    @Id
    private UUID id;

    @Column(unique = true)
    private String codename;

    private String specialty;

    private int skillRank;

    @ManyToOne
    @EqualsAndHashCode.Exclude
    @JoinColumn(name="company")
    private MilitaryCompany militaryCompany;



    @Override
    public String toString() {
        return id.toString() + " | Soldier's codename: " + this.codename + ", specialty: " + this.specialty + ", Skill Rank: " + this.skillRank
                + ", Military Company: " + this.militaryCompany.getId();
    }

}
