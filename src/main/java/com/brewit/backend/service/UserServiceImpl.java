package com.brewit.backend.service;

import com.brewit.backend.model.BrewITUser;
import com.brewit.backend.model.dto.ResponseDTO;
import com.brewit.backend.model.dto.UserRegisterDTO;
import com.brewit.backend.repository.UserRepository;
import com.brewit.backend.utility.exception.EmailFailureException;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserServiceImpl implements IUserService{

    private final IEncryptionService encryptionService;
    private final UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository, IEncryptionService encryptionService){
        this.userRepository = userRepository;
        this.encryptionService = encryptionService;
    }
    @Override
    public ResponseDTO registerUser(UserRegisterDTO newUser)  throws EmailFailureException {
        Optional<BrewITUser> existingUserResponse = checkForExistingUser(newUser);
        if(existingUserResponse.isPresent()) {
            return new ResponseDTO(HttpStatus.BAD_REQUEST, "Email or Name already exists");
        }
        BrewITUser user = new BrewITUser();
        user.setName(newUser.getName());
        user.setEmail(newUser.getEmail());
        user.setPassword(encryptionService.encryptPassword(newUser.getPassword()));

        userRepository.save(user);
        return new ResponseDTO(HttpStatus.CREATED, "User registered successfully");
    }

    private Optional<BrewITUser> checkForExistingUser(UserRegisterDTO userDTO) {
        // Check if name already exists in the database
        if(userRepository.findByNameIgnoreCase(userDTO.getName()).isPresent()){
            return userRepository.findByNameIgnoreCase(userDTO.getName());
        }
        // Check if email already exists in the database
        if(userRepository.findByEmail(userDTO.getEmail()).isPresent()){
            return userRepository.findByEmail(userDTO.getEmail());
        }
        return Optional.empty();
    }
}
