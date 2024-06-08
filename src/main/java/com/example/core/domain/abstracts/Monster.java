package com.example.core.domain.abstracts;

public abstract class Monster {
    private String name;
    private int health;
    private int damage;

    public int getHealth() {
        return health;
    }

    public int getDamage() {
        return damage;
    }

    public String getName() {
        return name;
    }

    public abstract void skill();
    public abstract void ultimate();
}
