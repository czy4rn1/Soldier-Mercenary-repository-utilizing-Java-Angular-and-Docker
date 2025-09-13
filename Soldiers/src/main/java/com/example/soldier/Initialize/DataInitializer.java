package com.example.soldier.Initialize;

import com.example.soldier.Classes.MilitaryCompany;
import com.example.soldier.Classes.Soldier;
import com.example.soldier.Service.CompanyService;
import com.example.soldier.Service.SoldierService;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
public class DataInitializer implements InitializingBean {
    private final SoldierService soldierService;
    private final CompanyService companyService;

    @Autowired
    public DataInitializer(SoldierService soldierService, CompanyService companyService) {
        this.companyService = companyService;
        this.soldierService = soldierService;
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        MilitaryCompany mc1 = MilitaryCompany.builder().id(UUID.fromString("738a4c02-8796-11ee-b9d1-0242ac120002")).build();
        Soldier s1 = Soldier.builder()
                .codename("Venom Snake")
                .skillRank(10)
                .specialty("Infiltration")
                .id(UUID.fromString("738a4f7c-8796-11ee-b9d1-0242ac120002"))
                .militaryCompany(mc1).build();
        Soldier s2 = Soldier.builder()
                .codename("Revolver Ocelot")
                .skillRank(9)
                .specialty("Hypnosis")
                .id(UUID.fromString("738a512a-8796-11ee-b9d1-0242ac120002"))
                .militaryCompany(mc1).build();
        Soldier s3 = Soldier.builder()
                .codename("Kaz")
                .skillRank(5)
                .specialty("Communication")
                .id(UUID.fromString("738a5378-8796-11ee-b9d1-0242ac120002"))
                .militaryCompany(mc1).build();
        Soldier s4 = Soldier.builder()
                .codename("Quiet")
                .skillRank(10)
                .specialty("Sniper")
                .id(UUID.fromString("738a5256-8796-11ee-b9d1-0242ac120002"))
                .militaryCompany(mc1).build();
        companyService.createCompany(mc1);
        soldierService.createSoldier(s1);
        soldierService.createSoldier(s2);
        soldierService.createSoldier(s3);
        soldierService.createSoldier(s4);


        MilitaryCompany mc2 = MilitaryCompany.builder().id(UUID.fromString("738a5756-8796-11ee-b9d1-0242ac120002")).build();
        Soldier s5 = Soldier.builder().codename("Big Boss").skillRank(10).specialty("Stealth").id(UUID.fromString("738a5896-8796-11ee-b9d1-0242ac120002")).militaryCompany(mc2).build();
        Soldier s6 = Soldier.builder().codename("Code Talker").skillRank(2).specialty("Translation").id(UUID.fromString("738a59b8-8796-11ee-b9d1-0242ac120002")).militaryCompany(mc2).build();
        Soldier s7 = Soldier.builder().codename("Psycho Mantis").skillRank(10).specialty("Telekinesis").id(UUID.fromString("738a5ac6-8796-11ee-b9d1-0242ac120002")).militaryCompany(mc2).build();
        Soldier s8 = Soldier.builder().codename("Volgin").skillRank(6).specialty("Commander").id(UUID.fromString("738a5be8-8796-11ee-b9d1-0242ac120002")).militaryCompany(mc2).build();
        companyService.createCompany(mc2);
        soldierService.createSoldier(s5);
        soldierService.createSoldier(s6);
        soldierService.createSoldier(s7);
        soldierService.createSoldier(s8);


        MilitaryCompany mc3 = MilitaryCompany.builder().id(UUID.fromString("738a5d5a-8796-11ee-b9d1-0242ac120002")).build();
        Soldier s9 = Soldier.builder().codename("Vic Voss").skillRank(10).specialty("Stealth").id(UUID.fromString("738a5e9a-8796-11ee-b9d1-0242ac120002")).militaryCompany(mc3).build();
        Soldier s10 = Soldier.builder().codename("Paz").skillRank(7).specialty("Traitor").id(UUID.fromString("738a5fa8-8796-11ee-b9d1-0242ac120002")).militaryCompany(mc3).build();
        Soldier s11 = Soldier.builder().codename("Zadornov").skillRank(4).specialty("Backstabber").id(UUID.fromString("738a63b8-8796-11ee-b9d1-0242ac120002")).militaryCompany(mc3).build();
        Soldier s12 = Soldier.builder().codename("Huey").skillRank(1).specialty("Scientist").id(UUID.fromString("738a64ee-8796-11ee-b9d1-0242ac120002")).militaryCompany(mc3).build();
        companyService.createCompany(mc3);
        soldierService.createSoldier(s9);
        soldierService.createSoldier(s10);
        soldierService.createSoldier(s11);
        soldierService.createSoldier(s12);


    }
}
