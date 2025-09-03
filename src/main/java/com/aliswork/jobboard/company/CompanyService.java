package com.aliswork.jobboard.company;

import java.util.List;

public interface CompanyService {
    List<Company> findAll();
    Company getCompany(Long id);
    void createCompany(Company company);
    boolean updateCompany(Long id, Company updatedCompany);
    boolean deleteCompany(Long id);
}
