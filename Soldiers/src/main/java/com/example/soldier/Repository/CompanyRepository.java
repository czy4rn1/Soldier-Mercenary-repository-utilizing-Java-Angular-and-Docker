package com.example.soldier.Repository;

import com.example.soldier.Classes.MilitaryCompany;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface CompanyRepository extends JpaRepository<MilitaryCompany, UUID>{
    Optional<MilitaryCompany> getMilitaryCompanyById(UUID id);
}
