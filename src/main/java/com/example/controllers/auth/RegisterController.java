package com.example.controllers.auth;

import com.example.controllers.interfaces.Controller;
import com.example.core.services.UserService;
import com.example.presentation.views.register.RegisterView;

import java.io.Console;

public class RegisterController implements Controller {
    private final Console console;
    private final RegisterView view;
    private final UserService userService;

    public RegisterController(UserService userService) {
        this.console = System.console();
        this.view = new RegisterView();
        this.userService = userService;
    }

    @Override
    public Controller execute() {
        view.display();
        return this;
    }
}
