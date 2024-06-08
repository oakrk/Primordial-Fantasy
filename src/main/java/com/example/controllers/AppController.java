package com.example.controllers;


import com.example.controllers.auth.LoginController;
import com.example.controllers.auth.RegisterController;
import com.example.controllers.character.CharacterListController;
import com.example.controllers.character.EditCharacterController;
import com.example.controllers.game.GameMenuController;
import com.example.controllers.interfaces.Controller;
import com.example.controllers.storage.StorageTypeMenuController;
import com.example.core.repositories.memory.InMemoryUserRepository;
import com.example.core.services.UserService;


import java.util.ArrayList;
import java.util.Arrays;

public class AppController {
    private Controller currentController;
    private UserService userService;
    private final MainMenuController mainMenuController;
    private final LoginController loginController;
    private final RegisterController registerController;
    private final StorageTypeMenuController storageTypeMenuController;
    private final GameMenuController gameMenuController;
    private final CharacterListController characterListController;
    private final EditCharacterController editCharacterController;


    public AppController() {
        // services
        userService = new UserService(new InMemoryUserRepository());


        // controllers
        this.storageTypeMenuController = new StorageTypeMenuController(userService);
        this.registerController = new RegisterController(userService);
        this.editCharacterController = new EditCharacterController();
        this.characterListController = new CharacterListController(userService, editCharacterController);

        // main menu
        ArrayList<Controller> gameMenus = new ArrayList<Controller>(
                Arrays.asList(null, characterListController)
        );

        this.gameMenuController = new GameMenuController(gameMenus, userService);
        this.loginController = new LoginController(gameMenuController, userService);

        // main menu
        ArrayList<Controller> mainMenus = new ArrayList<Controller>(
                Arrays.asList(loginController, registerController, gameMenuController)
        );

        // menu controller
        this.mainMenuController = new MainMenuController(mainMenus, storageTypeMenuController);

        this.currentController = mainMenuController;


    }

    public void run() {
        boolean exit = false;
        while (!exit) {
            clearConsole();
            Controller nextController = currentController.execute();

            if (nextController == null && currentController == mainMenuController) {
                exit = true;
            } else if (nextController == null) {
                currentController = mainMenuController;
            } else {
                currentController = nextController;
            }
        }
        System.out.println("Have a great day. :)");
    }

    public void clearConsole() {
        System.out.print("\033\143");
    }
}
