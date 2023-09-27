package com.brewit.backend.service;

import com.brewit.backend.model.dto.ResponseDTO;
import com.brewit.backend.model.dto.UserLoginDTO;
import com.brewit.backend.model.dto.UserRegisterDTO;
import com.brewit.backend.utility.exception.EmailFailureException;

public interface IUserService {
    public ResponseDTO registerUser(UserRegisterDTO newUser) throws EmailFailureException;

    ResponseDTO loginUser(UserLoginDTO loginBody);
}
