package com.example.company.Controller;

import com.example.company.Classes.MilitaryCompany;
import com.example.company.DTO.GetCompaniesResponse;
import com.example.company.DTO.GetCompanyResponse;
import com.example.company.DTO.PatchCompanyRequest;
import com.example.company.DTO.PutMilitaryRequest;
import com.example.company.Functions.CompanyToResponse;
import com.example.company.Functions.CompaniesToResponse;
import com.example.company.Functions.RequestToCompany;
import com.example.company.Functions.UpdateCompanyWithRequest;
import com.example.company.Service.CompanyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.UUID;

@RestController
@RequestMapping("/military-company")
public class MilitaryCompanyController {
    private final CompanyService service;
    private final CompanyToResponse companyToResponse;
    private final CompaniesToResponse companiesToResponse;
    private final UpdateCompanyWithRequest updateCompanyWithRequest;

    private final RequestToCompany requestToCompany;
    @Autowired
    public MilitaryCompanyController(CompanyService service,
                                     CompanyToResponse companyToResponse,
                                     CompaniesToResponse companiesToResponse,
                                     RequestToCompany requestToCompany,
                                     UpdateCompanyWithRequest updateCompanyWithRequest) {
        this.service = service;
        this.companyToResponse = companyToResponse;
        this.companiesToResponse = companiesToResponse;
        this.requestToCompany = requestToCompany;
        this.updateCompanyWithRequest = updateCompanyWithRequest;
    }

    @GetMapping("/companies")
    @ResponseStatus(HttpStatus.OK)
    @ResponseBody
    public GetCompaniesResponse getCompanies() {
        return companiesToResponse.apply(service.getAllCompanies());
    }

    @GetMapping("/one-company/{id}")
    @ResponseStatus(HttpStatus.OK)
    @ResponseBody
    public GetCompanyResponse getCompany(@PathVariable UUID id) {
        return service.getByID(id)
                .map(companyToResponse)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
    }

    @PutMapping("/create/{id}")
    @ResponseStatus(HttpStatus.CREATED)
    public void createCompany(@PathVariable UUID id, @RequestBody PutMilitaryRequest request) {
        service.createCompany(requestToCompany.apply(id, request));
        service.createCompanyForEvent(id, request);
    }

    @PutMapping("/update/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void updateCompany(@PathVariable UUID id, @RequestBody PutMilitaryRequest request) {
        MilitaryCompany company = requestToCompany.apply(id, request);
        service.getByID(id)
                .ifPresentOrElse(
                        (MilitaryCompany companyToUpdate) -> {
                            companyToUpdate.setName(company.getName());
                            companyToUpdate.setFoundingYear(company.getFoundingYear());
                            service.createCompany(companyToUpdate);
                        },
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
