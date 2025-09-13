package com.example.soldier.Controller;

import com.example.soldier.Classes.MilitaryCompany;
import com.example.soldier.DTO.PutMilitaryRequest;
import com.example.soldier.Functions.RequestToCompany;
import com.example.soldier.Service.CompanyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.UUID;

@RestController
@RequestMapping("/military-company")
public class MilitaryCompanyController {
    private final CompanyService service;
    private final RequestToCompany requestToCompany;
    @Autowired
    public MilitaryCompanyController(CompanyService service, RequestToCompany requestToCompany) {
        this.service = service;
        this.requestToCompany = requestToCompany;
    }

    @PutMapping("/create/{id}")
    @ResponseStatus(HttpStatus.CREATED)
    public void createCompany(@PathVariable UUID id, @RequestBody PutMilitaryRequest request) {
        service.createCompany(requestToCompany.apply(id, request));
    }

    @PutMapping("/update/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void updateCompany(@PathVariable UUID id, @RequestBody PutMilitaryRequest request) {
        MilitaryCompany company = requestToCompany.apply(id, request);
        service.getByID(id)
                .ifPresentOrElse(
                        service::createCompany,
                        () -> {
                            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
                        }
                );
    }

    @DeleteMapping("/delete/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteMilitaryCompany(@PathVariable UUID id) {
        service.getByID(id)
                .ifPresentOrElse(
                        company -> service.deleteCompany(id),
                        () -> {
                            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
                        }
                );


    }

}
