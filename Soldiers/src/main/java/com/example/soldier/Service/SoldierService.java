package com.example.soldier.Service;

import com.example.soldier.Repository.CompanyRepository;
import com.example.soldier.Repository.SoldierRepository;
import com.example.soldier.Classes.Soldier;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class SoldierService {
    private final SoldierRepository soldierRep;
    private final CompanyRepository companyRep;
    @Autowired
    public SoldierService(SoldierRepository soldierRep, CompanyRepository companyRep) {
        this.soldierRep = soldierRep;
        this.companyRep = companyRep;
    }

    public List<Soldier> getAllSoldiers() {
        return soldierRep.findAll();
    }

    public Optional<List<Soldier>> findAllByMilitaryCompany(UUID id) {
        return companyRep.findById(id)
                .map(soldierRep::findAllByMilitaryCompany);
    }

    //public List<Soldier> getSoldiersByMilitaryCompany(String name) {
     //   return soldierRep.findByMilitaryCompanyName(name);
    //}

    public UUID getID(String codename) {
        return soldierRep.getSoldierByCodename(codename).getId();
    }

    public Optional<Soldier> getSoldierById(UUID id) {
        return soldierRep.findById(id);
    }

    public void createSoldier(Soldier soldier) {
        soldierRep.save(soldier);
    }

    public void updateSoldier(Soldier soldier) {
        soldierRep.save(soldier);
    }

    public void deleteSoldier(UUID id) {
        soldierRep.findById(id).ifPresent(soldierRep::delete);
    }
}
