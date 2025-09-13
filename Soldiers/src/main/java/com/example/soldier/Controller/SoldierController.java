package com.example.soldier.Controller;

import com.example.soldier.Classes.Soldier;
import com.example.soldier.Functions.RequestToSoldier;
import com.example.soldier.Functions.SoldierToResponse;
import com.example.soldier.Functions.SoldiersToResponse;
import com.example.soldier.DTO.GetSoldierResponse;
import com.example.soldier.DTO.GetSoldiersResponse;
import com.example.soldier.DTO.PutSoldierRequest;
import com.example.soldier.Service.SoldierService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.UUID;

@RestController
@RequestMapping("/soldier")
public class SoldierController {

    private final SoldierService service;
    private final SoldierToResponse soldierToResponse;
    private final SoldiersToResponse soldiersToResponse;
    private final RequestToSoldier requestToSoldier;


    @Autowired
    public SoldierController(SoldierService service,
                             SoldierToResponse soldierToResponse,
                             SoldiersToResponse soldiersToResponse,
                             RequestToSoldier requestToSoldier
                             ) {
        this.service = service;
        this.soldierToResponse = soldierToResponse;
        this.soldiersToResponse = soldiersToResponse;
        this.requestToSoldier = requestToSoldier;
    }

    @GetMapping("/soldiers")
    @ResponseStatus(HttpStatus.OK)
    @ResponseBody
    public GetSoldiersResponse getSoldiers() {
        return soldiersToResponse.apply(service.getAllSoldiers());
    }

    @GetMapping("/soldiersCompany/{id}")
    @ResponseStatus(HttpStatus.OK)
    @ResponseBody
    public GetSoldiersResponse getMilitaryCompanySoldiers(@PathVariable UUID id) {
        return service.findAllByMilitaryCompany(id)
                .map(soldiersToResponse)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
    }

    @GetMapping("/one-soldier/{id}")
    @ResponseStatus(HttpStatus.OK)
    @ResponseBody
    public GetSoldierResponse getSoldier(@PathVariable UUID id) {
        return service.getSoldierById(id)
                .map(soldierToResponse)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
    }

    @PutMapping("/create/{id}")
    @ResponseStatus(HttpStatus.CREATED)
    public void putSoldier(@PathVariable UUID id, @RequestBody PutSoldierRequest request) {
        service.createSoldier(requestToSoldier.apply(id, request));
    }

    @PutMapping("/update/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void updateSoldier(@PathVariable UUID id, @RequestBody PutSoldierRequest request) {
        Soldier soldier = requestToSoldier.apply(id, request);
        service.getSoldierById(id)
                .ifPresentOrElse(
                        (Soldier soldierToUpdate) -> {
                            soldierToUpdate.setCodename(soldier.getCodename());
                            soldierToUpdate.setSpecialty(soldier.getSpecialty());
                            soldierToUpdate.setSkillRank(soldier.getSkillRank());
                            soldierToUpdate.setMilitaryCompany(soldier.getMilitaryCompany());
                            service.createSoldier(soldierToUpdate);
                        },
                        () -> {
                            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
                        }
                );
    }

    @DeleteMapping("/delete/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteSoldier(@PathVariable UUID id) {
        service.getSoldierById(id)
                .ifPresentOrElse(
                        soldier -> service.deleteSoldier(id),
                        () -> {
                            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
                        }
                );
    }




}
