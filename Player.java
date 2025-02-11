import java.util.ArrayList;
import java.util.List;

public class Player {
    private String name;
    private char symbol;
    private List<Integer> moves;

    public Player(String name, char symbol) {
        this.name = name;
        this.symbol = symbol;
        this.moves = new ArrayList<>();
    }

    public void addMove(int pos) {
        moves.add(pos);
    }

    public boolean hasWon(List<List<Integer>> winConditions) {
        for (List<Integer> condition : winConditions) {
            if (moves.containsAll(condition)) {
                return true;
            }
        }
        return false;
    }

    public String getName() {
        return name;
    }

    public char getSymbol() {
        return symbol;
    }

    public List<Integer> getMoves() {
        return moves;
    }
}

