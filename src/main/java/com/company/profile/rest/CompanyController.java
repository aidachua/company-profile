package com.company.profile.rest;

import static org.springframework.http.HttpStatus.OK;

import com.company.profile.dto.Company;
import com.company.profile.service.CompanyService;
import javax.inject.Inject;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/companies")
public class CompanyController {

  private CompanyService companyService;

  @Inject
  public CompanyController(CompanyService companyService) {
    this.companyService = companyService;
  }

  @GetMapping("/{id}")
  @ResponseStatus(OK)
  public Company getCompanyById(@PathVariable final String id) {

    return companyService.getCompanyById(id);
  }

}
