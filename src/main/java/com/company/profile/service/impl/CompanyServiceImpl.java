package com.company.profile.service.impl;

import com.company.profile.dto.Company;
import com.company.profile.service.CompanyService;
import com.company.profile.util.ReadXmlParser;
import javax.inject.Inject;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class CompanyServiceImpl implements CompanyService {

  private final String path;

  @Inject
  public CompanyServiceImpl(@Value("${xml-location}") String path) {
    this.path = path;
  }

  @Override
  public Company getCompanyById(String id) {

    return ReadXmlParser.xmlParser(path, id);
//    return ReadXmlParser.xmlParser(path, String.valueOf(id));
  }

}
