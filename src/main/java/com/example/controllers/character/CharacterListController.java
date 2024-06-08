package com.example.controllers.character;

import com.example.controllers.interfaces.Controller;
import com.example.controllers.interfaces.NavigationController;
import com.example.core.domain.Character;
import com.example.core.services.UserService;
import com.example.presentation.views.character.CharacterListView;

import java.util.ArrayList;

public class CharacterListController implements Controller {
    private final UserService userService;
    private final CharacterListView view;
    private final Controller editCharacterController;

    public CharacterListController(UserService userService, Controller editCharacterController) {
        this.view = new CharacterListView();
        this.userService = userService;
        this.editCharacterController = editCharacterController;
    }

    @Override
    public Controller execute() {
        ArrayList<Character> characters = userService.getCharacters();

        if (characters.isEmpty()) {
            return editCharacterController;
        }

        view.setCharacters(userService.getCharacters());
        view.display();
//        int choice = new CharacterListView();


        return this;
    }
}
