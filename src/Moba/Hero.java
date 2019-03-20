package Moba;

public abstract class Hero {
    protected int health, type, damage;
    protected boolean isAlive = true;
    protected int team;

    public int getTeam() {
        return team;
    }

    public void setTeam(int team) {
        this.team = team;
    }

    public Hero(int type, int health, int damage) {
        this.health = health;
        this.type = type;
        this.damage = damage;
    }

    void hit(Hero hero) {
        if (hero.getTeam() != this.team) {
            hero.causeDamage(damage);
        }
    }

    private void causeDamage(int damage) {
        health -= damage;
        if (health <= 0) {
            isAlive = false;
        }
    }

    void heal(Hero hero) {
        System.out.println(String.format("%s cant't heal", this.getClass().getSimpleName()));
    }

    void info() {
        System.out.println(String.format("%s %d: health %d, damage %d",
                this.getClass().getSimpleName(),
                type,
                health,
                damage));
    }
}
