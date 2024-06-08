package com.example.core.domain;

import com.example.core.domain.abstracts.Item;

import java.util.ArrayList;

public class Character {
    private final String name;
    private int health;
    private final ArrayList<Item> bag;
    private Weapon weapon;

    public Character(String name) {
        this.name = name;
        this.health = 100;
        this.bag = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public ArrayList<Item> getBag() {
        return bag;
    }
}