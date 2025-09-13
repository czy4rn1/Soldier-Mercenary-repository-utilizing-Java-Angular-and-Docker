package com.example.company.Service;

import com.example.company.Classes.MilitaryCompany;
import com.example.company.DTO.PutMilitaryRequest;
import com.example.company.Repository.CompanyEventRepository;
import com.example.company.Repository.CompanyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;
import java.util.Optional;

@Service
public class CompanyService {
    private final CompanyRepository companyRep;
    private final CompanyEventRepository eventRepository;

    @Autowired
    public CompanyService(CompanyRepository companyRep, CompanyEventRepository eventRepository) {
        this.companyRep = companyRep;
        this.eventRepository = eventRepository;
    }

    public List<MilitaryCompany> getAllCompanies() {
        return companyRep.findAll();
    }

    public MilitaryCompany getCompany(String name) {
        return companyRep.getMilitaryCompanyByName(name);
    }

    public Optional<MilitaryCompany> getByID(UUID id) {return companyRep.getMilitaryCompanyById(id);}

    public void createCompany(MilitaryCompany militaryCompany) {
        companyRep.save(militaryCompany);
    }

    public void createCompanyForEvent(UUID id, PutMilitaryRequest request) {
        eventRepository.create(id, request);
    }

    public void updateCompany(MilitaryCompany militaryCompany) {
        companyRep.save(militaryCompany);
    }

    public void deleteCompany(UUID id) {
        companyRep.deleteById(id);
        eventRepository.delete(id);
    }
}
