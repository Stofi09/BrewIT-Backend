package com.brewit.backend.service;

public interface IEncryptionService {
    String encryptPassword(String password);
    boolean verifyPassword(String password, String hash);
}
