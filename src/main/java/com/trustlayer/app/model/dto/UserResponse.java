package com.trustlayer.app.model.dto;

public record UserResponse(
    Long id,
    String username,
    String email
) {}
