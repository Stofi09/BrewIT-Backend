package com.brewit.backend.service;

import com.brewit.backend.model.dto.ResponseDTO;
import com.brewit.backend.model.dto.UserRegisterDTO;

public interface IUserService {
    public ResponseDTO registerUser(UserRegisterDTO newUser);
}
