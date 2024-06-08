package com.example.presentation.views.character;

import com.example.presentation.views.View;
import com.example.core.domain.Character;

public class CharacterInfoView implements View {
    private Character character;

    @Override
    public void display() {
        System.out.println("characters list");
        System.out.println("----------------------");
        System.out.println("Name: " + character.getName());
        System.out.println("Health: " + character.getHealth());
        System.out.println("Bag: " + character.getBag());
    }

    public void setCharacter(Character character) {
        this.character = character;
    }
}
