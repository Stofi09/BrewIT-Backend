package com.brewit.backend.service;

import com.brewit.backend.model.BrewITUser;

public interface IJWTService {
    public String generateJWT(BrewITUser user);
    String getUserName(String token);
    String generateVerificationJWT(BrewITUser user);
}
