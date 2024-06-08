package com.example.core.domain;

import java.util.ArrayList;

public class User {
    private final String username;
    private final String password;
    private ArrayList<Character>  characters;
    public User(String username, String password) {
        this.characters = new ArrayList<Character>();
        this.username = username;
        this.password = password;
    }

    public ArrayList<Character> getCharacters() {
        return characters;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public boolean addCharacter(Character character) {
        return characters.add(character);
    }

}
