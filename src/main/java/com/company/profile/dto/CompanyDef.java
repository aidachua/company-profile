package com.company.profile.dto;

import com.company.profile.util.ImmutableValue;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import javax.annotation.Nullable;
import org.immutables.value.Value;

@ImmutableValue
@Value.Immutable
@JsonDeserialize
public interface CompanyDef {

  int id();

  @Nullable
  String name();

  @Nullable
  String description();

}
