package com.company.profile.util;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

import com.company.profile.dto.Company;
import com.company.profile.exception.InternalServiceErrorException;
import com.company.profile.exception.ResourceNotFoundException;
import org.junit.Test;

public class ReadXmlParserTest {
  private static final String PATH =
      "/home/aida.chua/git/company-profile/src/main/resources/xml-api/";

  @Test
  public void fileExists() {

    Company expectedResult = Company.of(1, "MWNZ", "..is awesome");

    Company result = ReadXmlParser.xmlParser(PATH,"1");

    assertThat(result).isEqualTo(expectedResult);
  }

  @Test
  public void badXml() {
    assertThrows(InternalServiceErrorException.class, () -> ReadXmlParser.xmlParser(PATH,"x"));
  }

  @Test
  public void fileNotExisting() {

    assertThrows(ResourceNotFoundException.class, () -> ReadXmlParser.xmlParser(PATH,"3"));
  }
}
