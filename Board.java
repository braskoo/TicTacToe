public class Board {
    private char[][] gameBoard;

    public Board() {
        this.gameBoard = new char[][]{
                {' ', '|', ' ', '|', ' '},
                {'─', '+', '─', '+', '─'},
                {' ', '|', ' ', '|', ' '},
                {'─', '+', '─', '+', '─'},
                {' ', '|', ' ', '|', ' '}
        };
    }

    public void printBoard() {
        for (char[] row : gameBoard) {
            System.out.println(row);
        }
    }

    public void placePiece(int pos, char mark) {
        switch (pos) {
            case 1:
                gameBoard[0][0] = mark;
                break;
            case 2:
                gameBoard[0][2] = mark;
                break;
            case 3:
                gameBoard[0][4] = mark;
                break;
            case 4:
                gameBoard[2][0] = mark;
                break;
            case 5:
                gameBoard[2][2] = mark;
                break;
            case 6:
                gameBoard[2][4] = mark;
                break;
            case 7:
                gameBoard[4][0] = mark;
                break;
            case 8:
                gameBoard[4][2] = mark;
                break;
            case 9:
                gameBoard[4][4] = mark;
                break;
            default:
                break;
        }
    }
}
