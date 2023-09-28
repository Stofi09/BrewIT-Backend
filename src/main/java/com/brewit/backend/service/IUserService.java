package com.brewit.backend.service;

import com.brewit.backend.model.BrewITUser;
import com.brewit.backend.model.dto.ResponseDTO;
import com.brewit.backend.model.dto.UserLoginDTO;
import com.brewit.backend.model.dto.UserRegisterDTO;
import com.brewit.backend.utility.exception.EmailFailureException;

import java.util.Optional;

public interface IUserService {
    public ResponseDTO registerUser(UserRegisterDTO newUser) throws EmailFailureException;

    ResponseDTO loginUser(UserLoginDTO loginBody);

    Optional<BrewITUser> checkForUserName(String username);
}
