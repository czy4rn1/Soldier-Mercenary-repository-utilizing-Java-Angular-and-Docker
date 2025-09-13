package com.example.soldier.Repository;

import com.example.soldier.Classes.MilitaryCompany;
import com.example.soldier.Classes.Soldier;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface SoldierRepository extends JpaRepository<Soldier, UUID>{
    //List<Soldier> findByMilitaryCompanyName(String companyName);
    Soldier getSoldierByCodename(String codename);

    List<Soldier> findAllByMilitaryCompany(MilitaryCompany militaryCompany);
}
