package Moba;

public class Healer extends Hero {

    public Healer(int type, int health, int damage) {
        super(type, health, damage);
    }

    @Override
    void hit(Hero hero) {
        System.out.println(String.format("%s %d  can't hit", this.getClass().getSimpleName(), type));
    }

    @Override
    void heal(Hero hero) {
        if (hero != this && hero.team == this.team)
            hero.health += health;
        if (hero.health > 1000) {
            hero.health = 500;
        }
    }
}
