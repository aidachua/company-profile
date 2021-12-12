package com.company.profile.dto;

import com.company.profile.util.ImmutableValue;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import org.immutables.value.Value;

@ImmutableValue
@Value.Immutable
@JsonDeserialize
public interface ErrorDef {

  String error();

  String error_description();

}
