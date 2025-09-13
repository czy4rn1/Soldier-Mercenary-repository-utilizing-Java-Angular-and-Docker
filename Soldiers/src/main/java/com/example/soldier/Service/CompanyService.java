package com.example.soldier.Service;

import com.example.soldier.Classes.MilitaryCompany;
import com.example.soldier.Repository.CompanyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;
import java.util.Optional;

@Service
public class CompanyService {
    private final CompanyRepository companyRep;

    @Autowired
    public CompanyService(CompanyRepository companyRep) {
        this.companyRep = companyRep;
    }

    public List<MilitaryCompany> getAllCompanies() {
        return companyRep.findAll();
    }

    public Optional<MilitaryCompany> getByID(UUID id) {return companyRep.getMilitaryCompanyById(id);}

    public void createCompany(MilitaryCompany militaryCompany) {
        companyRep.save(militaryCompany);
    }

    public void updateCompany(MilitaryCompany militaryCompany) {
        companyRep.save(militaryCompany);
    }

    public void deleteCompany(UUID id) {
        companyRep.deleteById(id);
    }
}
