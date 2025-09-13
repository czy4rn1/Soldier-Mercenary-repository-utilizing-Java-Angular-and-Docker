package com.example.company.Repository;

import com.example.company.Classes.MilitaryCompany;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface CompanyRepository extends JpaRepository<MilitaryCompany, UUID>{
    MilitaryCompany getMilitaryCompanyByName(String name);
    Optional<MilitaryCompany> getMilitaryCompanyById(UUID id);
}
