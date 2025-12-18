
class TicBoard {

    public static final int X = 1, O = 2, E = 0;

    int[][] board = {
        {0, 0, 0},
        {0, 0, 0},
        {0, 0, 0}
    };

    public TicBoard() {

    }

    public boolean gameOver() {
        for (int i = 0; i < 3; ++i) {
            if (board[0][i] == board[1][i] && board[1][i] == board[2][i] && board[0][i] != E) {
                return true;
            }
            if (board[i][0] == board[i][1] && board[i][1] == board[i][2] && board[i][0] != E) {
                return true;
            }
        }
        if (board[0][0] != E && board[0][0] == board[1][1] && board[1][1] == board[2][2]) return true;
        if (board[1][1] == board[2][0] && board[1][1] == board[0][2] && board[1][1] != E) return true;

        for (int i = 0; i < 3; ++i) {
            for (int j = 0; j < 3; ++j) {
                if (board[i][j] == E) return false;
            }
        }

        return true;
    }

    public String winner() {
        if (!gameOver()) return "";
        for (int i = 0; i < 3; ++i) {
            if (board[0][i] != E && board[0][i] == board[1][i] && board[1][i] == board[2][i]) {
                if (board[0][i] == X) return "X";
                else if (board[0][i] == O) return "O";
                else return Integer.toString(board[0][i]);
            }
            if (board[i][0] != E && board[i][0] == board[i][1] && board[i][1] == board[i][2]) {
                if (board[i][0] == X) return "X";
                else if (board[i][0] == O) return "O";
                else return Integer.toString(board[i][0]);
            }
        }
        if (board[0][0] == board[1][1] && board[1][1] == board[2][2] && board[0][0] != E) {
            if (board[0][0] == X) return "X";
            else if (board[0][0] == O) return "O";
            else return Integer.toString(board[0][0]);
        }
        if (board[2][0] == board[1][1] && board[1][1] == board[0][2] && board[1][1] != E) {
            if (board[1][1] == X) return "X";
            else if (board[1][1] == O) return "O";
            else return Integer.toString(board[1][1]);
        }

        return "Cats";
    }

    public int get(int x, int y) {
        return board[y][x];
    }

    public boolean open(int x, int y) {
        if (board[y][x] == E) return true;
        return false;
    }

    public void move(int x, int y, int value) {
        board[y][x] = value;
    }
}