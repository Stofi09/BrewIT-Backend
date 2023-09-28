package com.brewit.backend.controller;

import com.brewit.backend.model.BrewITUser;
import com.brewit.backend.model.dto.ResponseDTO;
import com.brewit.backend.model.dto.UserLoginDTO;
import com.brewit.backend.model.dto.UserRegisterDTO;
import com.brewit.backend.service.IUserService;
import com.brewit.backend.utility.exception.EmailFailureException;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;

@RestController
@RequestMapping("/api/user/v1")
public class UserController {

    private final IUserService userService;

    public UserController(IUserService userService){
        this.userService = userService;
    }
    @PostMapping("/register")
    public ResponseEntity<HashMap<String, String>> register(@Valid @RequestBody UserRegisterDTO userDTO) throws EmailFailureException {
        ResponseDTO response = userService.registerUser(userDTO);
        return ResponseEntity.status(response.getStatus()).body(new HashMap<String, String>() {{
            put("message", response.getMessage());
        }});
    }

    @PostMapping("/login")
    public ResponseEntity<HashMap<String, String>> loginUser(@Valid @RequestBody UserLoginDTO loginBody) {
        try {
            ResponseDTO response = userService.loginUser(loginBody);
            return ResponseEntity.status(response.getStatus()).body(new HashMap<String, String>() {{
                put("message", response.getMessage());
            }});
        }catch (Exception ex) {
            System.err.println(ex.getMessage());
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body(new HashMap<String, String>() {{
                        put("message", "There was an internal error.");
                    }});
        }
    }
}