package Moba;

import java.util.Random;

public class Game {
    private static int count = 0;
    private Random random = new Random();

    Hero[] createTeam(int playerCount, int team) {
        Hero[] heroes = new Hero[playerCount];
        Hero hero;
        for (int i = 0; i < playerCount; i++) {
            hero = PlayerFactory.getPlayer(getRandomType());
            hero.setTeam(team);
            heroes[i] = hero;
        }
        return heroes;
    }

    public Hero getAlivePlayer(Hero[] players, int num) {
        if (players[num].isAlive) {
            return players[num];
        }
        for (Hero player : players) {
            if (player.isAlive) {
                return player;
            }
        }
        return null;
    }

    public int getRandomType() {
        return random.nextInt(1000) % Player.count;
    }

    public void makeMove(Hero offender, Hero defender, Hero[] team) {
        System.out.println(String.format("============= fight %s ==============", count++));
        if (offender instanceof Healer) {
            Hero teammate = getAlivePlayer(team, getRandomType());
            offender.heal(teammate);
        } else {
            offender.hit(defender);
        }
        offender.info();
        defender.info();
    }

    private void printSeparator() {
        System.out.println("======================================");
    }

    public void printResults(Hero[] team, int teamName) {
        printSeparator();
        boolean isWin = false;
        for (Hero player : team) {
            if (player.isAlive) {
                isWin = true;
            }
            System.out.println(String.format("%s %d is %s",
                    player.getClass().getSimpleName(),
                    player.type,
                    player.isAlive ? "alive" : "dead"
            ));
        }
        System.out.println(String.format("Team %d %s!", teamName, isWin ? "win" : "lose"));
    }
}
