package com.brewit.backend.service;

import com.brewit.backend.model.BrewITUser;
import com.brewit.backend.model.dto.ResponseDTO;
import com.brewit.backend.model.dto.UserLoginDTO;
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

    @Override
    public ResponseDTO loginUser(UserLoginDTO loginBody) {
        ResponseDTO response;
        Optional<BrewITUser> userByName = checkForUserName(loginBody.getUsername());
        if(userByName.isPresent()){
            if (encryptionService.verifyPassword(loginBody.getPassword(), userByName.get().getPassword())) {
                return response = new ResponseDTO(HttpStatus.OK,"Login successful");
            }
        }
        return new ResponseDTO(HttpStatus.UNAUTHORIZED, "Incorrect password or username");
    }

    private Optional<BrewITUser> checkForExistingUser(UserRegisterDTO userDTO) {
        Optional<BrewITUser> userByName = checkForUserName(userDTO.getName());
        if(userByName.isPresent()){
            return userByName;
        }
        Optional<BrewITUser> userByEmail = checkForEmail(userDTO.getEmail());
        if(userByEmail.isPresent()){
            return userByEmail;
        }
        return Optional.empty();
    }

    private Optional<BrewITUser> checkForUserName(String name){
        Optional<BrewITUser> user = userRepository.findByNameIgnoreCase(name);
        return user.isPresent() ? user : Optional.empty();
    }

    private Optional<BrewITUser> checkForEmail(String email){
        Optional<BrewITUser> user = userRepository.findByEmail(email);
        return user.isPresent() ? user : Optional.empty();
    }


}
