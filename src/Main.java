import class_4.TicTacToe;


public class Main {

    public static void main(String[] args) {
        TicTacToe game = new TicTacToe();
        game.initGrid();
        game.printGrid();

        while (true) {
            game.makeMove("user");
            game.printGrid();
            if (game.isWin("user")) {
                System.out.println("User wins!");
                break;
            }
            if (game.isDraw()) {
                System.out.println("Draw");
                break;
            }
            game.makeMove("ai");
            game.printGrid();
            if (game.isWin("ai")) {
                System.out.println("ai wins!");
                break;
            }
            if (game.isDraw()) {
                System.out.println("Draw");
                break;
            }
        }
    }
}
