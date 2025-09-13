package com.example.company.Repository;

import com.example.company.Classes.MilitaryCompany;
import com.example.company.DTO.PutMilitaryRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.web.client.RestTemplate;

import java.util.UUID;

@Repository
public class CompanyEventRepository {
    private final RestTemplate restTemplate;

    @Autowired
    public CompanyEventRepository(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public void create(UUID id, PutMilitaryRequest request) {
        restTemplate.put("/military-company/create/{id}", request, id);
    }

    public void delete(UUID id) {
        restTemplate.delete("/military-company/delete/{id}", id);
    }
}
