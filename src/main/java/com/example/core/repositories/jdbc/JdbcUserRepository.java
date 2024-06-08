package com.example.core.repositories.jdbc;

import com.example.core.domain.Character;
import com.example.core.domain.User;
import com.example.core.repositories.UserRepository;

public class JdbcUserRepository implements UserRepository {
    @Override
    public User getUser(String username) {
        return null;
    }

    @Override
    public boolean createUser(User user) {
        return false;
    }

    @Override
    public boolean createCharacter(String username, Character character) {
        return false;
    }
}
