package com.company.profile.exception;

public class InternalServiceErrorException extends RuntimeException{

  public InternalServiceErrorException(String message) {
    super(message);
  }

}
