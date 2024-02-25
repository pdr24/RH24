package edu.utsa.cs.acm.rh24.Model;

public class Pet {
    private int health;
    private int hunger;
    private int thrist;
    private int energy;

    public Pet (){
        this.health = 100;
        this.energy = 10;
        this.thrist = 10;
        this.hunger = 10;
    }

    public Pet(int health, int hunger, int thrist, int energy) {
        this.health = health;
        this.hunger = hunger;
        this.thrist = thrist;
        this.energy = energy;
    }

    public void dying(int food, int water) {
        if(food < hunger/2 && water < thrist/2) {
            setHealth(getHealth() - 1);
        }
    }

    public void setThrist(int thrist) {
        this.thrist = thrist;
    }

    public void setHunger(int hunger) {
        this.hunger = hunger;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public int getHealth() {
        return health;
    }

    public int getHunger() {
        return hunger;
    }

    public int getThrist() {
        return thrist;
    }

    public int getEnergy() {
        return energy;
    }

    public void setEnergy(int energy) {
        this.energy = energy;
    }

}
