package com.example.controllers.game;

import com.example.controllers.interfaces.Controller;
import com.example.core.services.UserService;
import com.example.presentation.views.game.GameMenuView;

import java.util.ArrayList;
import java.util.Scanner;

public class GameMenuController implements Controller {
    private final Scanner scanner;
    private final GameMenuView view;
    private final UserService userService;
    private final ArrayList<Controller> controllers;

    public GameMenuController(ArrayList<Controller> controllers, UserService userService) {
        this.view = new GameMenuView();
        this.userService = userService;
        this.scanner = new Scanner(System.in);
        this.controllers = controllers;
    }

    @Override
    public Controller execute() {
        if (userService.getUsername() == null) {
            boolean success = userService.guestLogin();

            if (!success) {
                throw new IllegalArgumentException("Create not continue with guest");
            }
        }

        view.display();
        int choice = scanner.nextInt();
        int index = choice - 1;
        return switch (choice) {
            case 3 -> {
                userService.setUsername(null);
                yield null;
            }
            default -> controllers.get(index);
        };
    }

}
