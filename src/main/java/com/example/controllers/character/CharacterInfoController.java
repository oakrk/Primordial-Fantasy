package com.example.controllers.character;

import com.example.controllers.interfaces.Controller;
import com.example.controllers.interfaces.NavigationController;
import com.example.presentation.views.character.CharacterInfoView;
import com.example.core.domain.Character;
import java.util.Scanner;

public class CharacterInfoController implements NavigationController {
    Scanner scanner;
    private Character character;
    private final CharacterInfoView view;

    public CharacterInfoController() {
        this.view = new CharacterInfoView();
        this.scanner = new Scanner(System.in);
    }

    public void setCharacter(Character character) {
        this.character = character;
    }

    @Override
    public int getUserInputChoice() {
        return scanner.nextInt();
    }

    @Override
    public Controller execute() {
        view.setCharacter(character);
        view.display();

        return this;
    }
}
