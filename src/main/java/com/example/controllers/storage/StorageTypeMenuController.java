package com.example.controllers.storage;

import com.example.controllers.interfaces.Controller;
import com.example.controllers.interfaces.NavigationController;
import com.example.core.repositories.file.FileUserRepository;
import com.example.core.repositories.jdbc.JdbcUserRepository;
import com.example.core.services.UserService;
import com.example.presentation.views.storage.StorageTypeView;

import java.util.Scanner;

public class StorageTypeMenuController implements Controller {
    private final StorageTypeView view;
    private final Scanner scanner;
    private Controller callBackController;
    private final UserService userService;

    public StorageTypeMenuController( UserService userService) {
        this.scanner = new Scanner(System.in);
        this.view = new StorageTypeView();
        this.userService = userService;
    }

    public void withCallback(Controller controller) {
        this.callBackController = controller;
    }

    @Override
    public Controller execute() {
        view.display();
        int choice = scanner.nextInt();
        return switch (choice) {
            case 1 -> {
                userService.setUserRepository(new FileUserRepository());
                yield callBackController;
            }
            case 2 -> {
                userService.setUserRepository(new JdbcUserRepository());
                yield callBackController;
            }
            default -> {
                System.out.println("Invalid choice. Please try again.");
                yield this;
            }
        };
    }
}
