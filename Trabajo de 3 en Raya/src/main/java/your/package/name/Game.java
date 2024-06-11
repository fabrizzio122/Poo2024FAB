public class Game {
    private String player1;
    private String player2;
    private String currentPlayer;
    private String winner;
    private String[][] board;
    private Database database;

    public Game(String player1, String player2, Database database) {
        this.player1 = player1;
        this.player2 = player2;
        this.currentPlayer = player1;
        this.winner = null;
        this.board = new String[3][3];
        this.database = database;
        database.createTable();
    }

    public boolean makeMove(int row, int col) {
        if (board[row][col] == null) {
            board[row][col] = currentPlayer.equals(player1) ? "X" : "O";
            if (checkWin()) {
                winner = currentPlayer;
                database.insertGameResult(player1, player2, winner, getBoardString(), "Finished");
            } else if (isBoardFull()) {
                database.insertGameResult(player1, player2, null, getBoardString(), "Draw");
            } else {
                currentPlayer = (currentPlayer.equals(player1)) ? player2 : player1;
            }
            return true;
        }
        return false;
    }

    private boolean checkWin() {
        // Check rows and columns
        for (int i = 0; i < 3; i++) {
            if ((board[i][0] != null && board[i][0].equals(board[i][1]) && board[i][0].equals(board[i][2])) ||
                (board[0][i] != null && board[0][i].equals(board[1][i]) && board[0][i].equals(board[2][i]))) {
                return true;
            }
        }
        // Check diagonals
        if ((board[0][0] != null && board[0][0].equals(board[1][1]) && board[0][0].equals(board[2][2])) ||
            (board[0][2] != null && board[0][2].equals(board[1][1]) && board[0][2].equals(board[2][0]))) {
            return true;
        }
        return false;
    }

    private boolean isBoardFull() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (board[i][j] == null) {
                    return false;
                }
            }
        }
        return true;
    }

    private String getBoardString() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                sb.append(board[i][j] == null ? " " : board[i][j]);
                if (j < 2) sb.append("|");
            }
            if (i < 2) sb.append("\n-----\n");
        }
        return sb.toString();
    }

    public String getWinner() {
        return winner;
    }

    public String getCurrentPlayer() {
        return currentPlayer;
    }

    public String getPlayer1() {
        return player1;
    }

    public String getPlayer2() {
        return player2;
    }
}
