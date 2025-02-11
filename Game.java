import java.util.*;

public class Game {
    private Player player1;
    private Player player2;
    private Board board;
    private List<List<Integer>> winConditions;

    public Game() {
        player1 = new Player("Player 1", 'X');
        player2 = new Player("Player 2", 'O');
        board = new Board();
        winConditions = Arrays.asList(
                Arrays.asList(1, 2, 3), Arrays.asList(4, 5, 6), Arrays.asList(7, 8, 9),
                Arrays.asList(1, 4, 7), Arrays.asList(2, 5, 8), Arrays.asList(3, 6, 9),
                Arrays.asList(1, 5, 9), Arrays.asList(3, 5, 7)
        );
    }

    public void start() {
        Scanner scan = new Scanner(System.in);
        Player currentPlayer = player1;

        while (true) {
            board.printBoard();
            System.out.println(currentPlayer.getName() + ", kies een plek op het bord (1-9):");
            int pos = scan.nextInt();

            while (isOccupied(pos)) {
                System.out.println("Maak een geldige zet!");
                pos = scan.nextInt();
            }

            currentPlayer.addMove(pos);
            board.placePiece(pos, currentPlayer.getSymbol());

            if (currentPlayer.hasWon(winConditions)) {
                board.printBoard();
                System.out.println(currentPlayer.getName() + " heeft gewonnen!");
                break;
            } else if (isDraw()) {
                board.printBoard();
                System.out.println("Gelijkspel!");
                break;
            }

            currentPlayer = (currentPlayer == player1) ? player2 : player1;
        }
        scan.close();
    }

    private boolean isOccupied(int pos) {
        return player1.getMoves().contains(pos) || player2.getMoves().contains(pos);
    }

    private boolean isDraw() {
        return player1.getMoves().size() + player2.getMoves().size() == 9;
    }
}
