package com.dev.autoflex_back.dto.request;

import java.math.BigDecimal;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

public record ProductRequest(
    @NotBlank String code,
    @NotBlank String name,
    @NotNull @Positive BigDecimal price
) {

}
