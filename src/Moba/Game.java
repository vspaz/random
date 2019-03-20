package Moba;

import java.util.Random;

public class Game {
    private static int count = 0;
    private Random random = new Random();
    Hero[] createTeam(int playerCount, int team) {
        Hero[] heroes = new Hero[playerCount];
        Hero hero;
        for (int i = 0; i < playerCount; i++) {
            int playerType = random.nextInt(Player.count + 1) + 1;
            hero = PlayerFactory.getPlayer(playerType);
            hero.setTeam(team);
            heroes[i] = hero;
        }
        return heroes;
    }

    Hero getAlivePlayer(Hero[] players, int num) {
        Hero player = players[num];
        if (player.isAlive ) {
            return player;
        }
        for (int i = 0; i < players.length; i++) {
            player = players[i];
            if (player.isAlive) {
                return player;
            }
        }
        return null;
    }

    int getType() {
        return random.nextInt(Player.count);
    }

    void makeMove(Hero offender, Hero defender, Hero[] team) {
        System.out.println(String.format("============ fight %s =============", count++));
        if (offender instanceof Healer) {
            Hero teammate = getAlivePlayer(team, getType());
            offender.heal(teammate);
        } else {
            offender.hit(defender);
        }
        offender.info();
        defender.info();
    }

    void printResults(Hero[] team, int teamName) {
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
        System.out.println("======================================");
    }
}
