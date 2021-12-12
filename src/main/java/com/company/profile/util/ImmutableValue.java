package com.company.profile.util;

import java.lang.annotation.ElementType;
import java.lang.annotation.Target;
import org.immutables.value.Value;

@Target(ElementType.TYPE)
@Value.Style(
    typeAbstract = "*Def",
    typeImmutable = "*",
    allParameters = true,
    defaultAsDefault = true,
    visibility = Value.Style.ImplementationVisibility.PUBLIC,
    defaults = @Value.Immutable(builder = false, copy = false, intern = false, prehash = true))
public @interface ImmutableValue {

}
