package com.example.presentation.views.character;

import com.example.core.domain.Character;
import com.example.presentation.views.View;

import java.util.ArrayList;

public class CharacterListView implements View {
    private ArrayList<Character> characters;

    public CharacterListView() {
        characters = new ArrayList<>();
    }

    public void setCharacters(ArrayList<Character> characters) {
        this.characters = characters;
    }

    @Override
    public void display() {
        System.out.println("characters list");
        System.out.println("Enter '0' for new character");
        System.out.println("----------------------");
        for (int i = 0; i < characters.size(); i++) {
            System.out.println("("+i+1+") " + characters.get(i).getName());
        }
        System.out.println("----------------------");
        System.out.print("Please enter your number: ");
    }
}
