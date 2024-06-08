package com.example.controllers.character;

import com.example.controllers.interfaces.Controller;
import com.example.presentation.views.character.EditCharacterView;

import java.util.Scanner;

public class EditCharacterController implements Controller {
    private final Scanner scanner;
    private final EditCharacterView view;
    private Character character;
    public EditCharacterController() {
        this.scanner = new Scanner(System.in);
        this.view = new EditCharacterView();
    }
    public void setCharacter(Character character) {
        if (this.character == null) {
            throw new IllegalArgumentException("Character cannot be null");
        }
        this.character =  character;
    }
    @Override
    public Controller execute() {
        view.display();
        scanner.nextLine();
        return this;
    }
}
