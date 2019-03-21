package Moba;

class Healer extends Hero implements HealerPlayer {

    Healer(int type, int health, int damage){
        super(type, health, damage);
    }

    @Override
    public void hit(Hero hero) {
        System.out.println(String.format("%s %d  can't hit", this.getClass().getSimpleName(), type));
    }

    @Override
    public void heal(Hero hero) {
        if (hero != this && hero.team == this.team)
            hero.health += health;
        if (hero.health > 1000) {
            hero.health = 500;
        }
    }
}
