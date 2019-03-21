package Moba;

abstract class Hero {
    int health, team, type;
    private int damage;
    boolean isAlive = true;

    private int getTeam() {
        return team;
    }

    void setTeam(int team) {
        if (team < 0) {
            this.team = -team;
        }
        this.team = team;
    }

    Hero(int type, int health, int damage) {
        this.health = health;
        this.type = type;
        this.damage = damage;
    }

    // override in Healer
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

    // override in Healer.
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
