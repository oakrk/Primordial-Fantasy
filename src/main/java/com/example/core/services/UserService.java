package com.example.core.services;

import com.example.core.domain.User;
import com.example.core.domain.Character;
import com.example.core.domain.exceptions.UserNotFoundException;
import com.example.core.repositories.UserRepository;

import java.util.ArrayList;

public class UserService {
    private UserRepository userRepository;
    private String username;
    private int guestId = 0;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public boolean login(String username, String password) {
        if (username == null || username.isEmpty() || password == null || password.isEmpty()) {
            throw new IllegalArgumentException("Username and password are required");
        }
        User user = userRepository.getUser(username);

        if (user == null) {
           throw new UserNotFoundException("User not found");
        }

        if (!user.getPassword().equals(password)) {
            return false;
        }

        setUsername(username);

        return true;
    }

    public boolean guestLogin() {
        boolean success = false;
        String guestUsername = "guest" + guestId++;
        success = register(guestUsername, "guest");
        if (!success) {
            return false;
        }
        success = login(guestUsername, "guest");

        return success;
    }

    public boolean register(String username, String password) {
        if (username == null || username.isEmpty() || password == null || password.isEmpty()) {
            throw new IllegalArgumentException("Username and password are required");
        }
        User user = new User(username, password);

        return userRepository.createUser(user);
    }

    public User getUserInfo () {
        return userRepository.getUser(username);
    }

    public ArrayList<Character> getCharacters() {
        return userRepository.getUser(username).getCharacters();
    }



    public boolean newCharacter(Character character) {
        userRepository.createCharacter(username, character);
        return true;
    }

    public void setUserRepository(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
}
