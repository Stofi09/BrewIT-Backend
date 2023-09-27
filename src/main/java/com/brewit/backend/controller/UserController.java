package com.brewit.backend.controller;

import com.brewit.backend.model.dto.ResponseDTO;
import com.brewit.backend.model.dto.UserRegisterDTO;
import com.brewit.backend.service.IUserService;
import com.brewit.backend.utility.exception.EmailFailureException;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/user/v1")
public class UserController {

    private final IUserService userService;

    public UserController(IUserService userService){
        this.userService = userService;
    }
    @PostMapping("/register")
    public ResponseEntity<String> register(@Valid @RequestBody UserRegisterDTO userDTO) throws EmailFailureException {
        ResponseDTO response = userService.registerUser(userDTO);
        return new ResponseEntity<>(response.getMessage(), response.getStatus());
    }
}
