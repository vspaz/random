package Moba;

public class TestGame {
    public static void main(String[] argv) {
        int teamName1 = 1;
        int teamName2 = 2;
        Game game = new Game();
        Hero[] team1 = game.createTeam(3, teamName1);
        Hero[] team2 = game.createTeam(3, teamName2);
        Hero player1, player2;
        while ((player1 = game.getAlivePlayer(team1, game.getRandomType())) != null &&
                (player2 = game.getAlivePlayer(team2, game.getRandomType())) != null) {
            game.makeMove(player1, player2, team1);
            game.makeMove(player2, player1, team2);
        }
        game.printResults(team1, teamName1);
        game.printResults(team2, teamName2);
    }
}
