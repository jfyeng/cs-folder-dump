// CheckersBoard.java
// James
// A class called CheckersBoard, intended to be used to play the game Checkers.
// It stores a board of checkers pieces, and has a method useful for moving the pieces and making sure moves are valid.
// It can print out a crude ASCII display of the board.

class CheckersBoard {
    
    // -- FIELDS -- 
    // some constants used for accessibility
    public static final int BLACK = 1, RED = 2, EMPTY = 0;
    public final int BOARD_SIZE = 8;

    // the base starting board
    public int[][] board = {
        {2,0,2,0,2,0,2,0},
        {0,2,0,2,0,2,0,2},
        {2,0,2,0,2,0,2,0},
        {0,0,0,0,0,0,0,0},
        {0,0,0,0,0,0,0,0},
        {0,1,0,1,0,1,0,1},
        {1,0,1,0,1,0,1,0},
        {0,1,0,1,0,1,0,1},
    };

    // -- METHODS --

    // using recursive search here
    // x1 y1 is the home position, x2 y2 is the destination
    // move(x1, y1, x2, y2) returns true if it was a valid move or false if not
    private int dx, dy, dir, ally_color;
    public boolean move(int x1, int y1, int x2, int y2) {

        dir = y1 < y2? 1 : -1;
        dx = x2; dy = y2; ally_color = board[y1][x1];

        // - ASSERTING INVALID CASES - none of these cases are valid
        // if the y values are the same
        if (y1 == y2) return false;
        // if any coordinate is out of bounds
        if (x1 < 0 || BOARD_SIZE <= x1 || y1 < 0 || BOARD_SIZE <= y1 ||
            x2 < 0 || BOARD_SIZE <= x2 || y2 < 0 || BOARD_SIZE <= y2) return false;
        // if the starting pos is empty, if the ending pos is not empty
        if (board[y1][x1] == EMPTY) return false;
        if (board[y2][x2] != EMPTY) return false;
        // if a piece is trying to go backwards
        if (dir == -1 && ally_color == RED) return false;
        if (dir == 1 && ally_color == BLACK) return false;

        if (move(x1, y1, 0)) { // move was valid, move the actual piece itself.
            board[y1][x1] = EMPTY;
            board[y2][x2] = ally_color;
            return true;
        } else return false; // move was invalid, return false
    }
    // a recursive method to try and reach the destination
    // RETURNS: false = does not ultimately reach destination, true = ultimately reaches destination
    // cx is current x, cy is current y, jumping is the jump status
    private boolean move(int cx, int cy, int jumping) { // jumping 0 = undecided, 1 = yes, 2 = no
        if (cx == dx && cy == dy) return true;

        int nxt;
        if (jumping == 0) { // undecided jump status
            nxt = checkNext(cx, cy, -1);
            if (nxt == 0) { // slide
                if (move(cx - 1, cy + dir, 2)) return true;
            }
            if (nxt == 1) { // jump
                if (move(cx - 1 - 1, cy + dir + dir, 1)) {
                    board[cy + dir][cx - 1] = EMPTY; // remove the piece that was jumped over
                    return true;
                }
            }
            nxt = checkNext(cx, cy, 1);
            if (nxt == 0) { // slide
                if (move(cx + 1, cy + dir, 2)) return true;
            }
            if (nxt == 1) { // jump
                if (move(cx + 1 + 1, cy + dir + dir, 1)) {
                    board[cy + dir][cx + 1] = EMPTY; // remove the piece that was jumped over
                    return true;
                }
            }
        }
        if (jumping == 1) { // jump status true
            nxt = checkNext(cx, cy, -1);
            if (nxt == 1) {
                if (move(cx - 1 - 1, cy + dir + dir, jumping)) {
                    board[cy + dir][cx - 1] = EMPTY; // remove the piece that was jumped over
                    return true;
                }
            }
            nxt = checkNext(cx, cy, 1);
            if (nxt == 1) {
                if (move(cx + 1 + 1, cy + dir + dir, jumping)) {
                    board[cy + dir][cx + 1] = EMPTY; // remove the piece that was jumped over
                    return true;
                }
            }
        }
        if (jumping == 2) { // if the piece wasn't jumping, the current tile should already have been the dest
            return false;
        }
        return false;
    }
    // check if the next direction can be jumped, slid, or if the piece cannot go in that direction
    // RETURNS: 0 = empty, 1 = jumpable, -1 = cannot go there (out of bounds, or there's an ally blocking the way)
    private int checkNext(int x, int y, int ix) { // ix = x increment
        int enemy_color = colorFlip(ally_color);
        x += ix; y += dir;
        if (x < 0 || BOARD_SIZE <= x || y < 0 || BOARD_SIZE <= y) return -1;
        if (board[y][x] == ally_color) return -1; // cannot anything-able
        if (board[y][x] == EMPTY) return 0; // slide-able
        if (board[y][x] == enemy_color) { // jump-able
            x += ix; y += dir;
            if (x < 0 || BOARD_SIZE <= x || y < 0 || BOARD_SIZE <= y) return -1;
            if (board[y][x] == EMPTY) return 1;
        }
        return -1;
    }

    // returns how many of that color is on the board
    public int count(int color) {
        int cnt = 0;
        for (int y = 0; y < BOARD_SIZE; ++y) {
            for (int x = 0; x < BOARD_SIZE; ++x) {
                if (board[y][x] == color) {
                    ++cnt;
                }
            }
        }
        return cnt;
    }

    // prints a crude ascii display of the board
    public void display() {
        System.out.println("+---".repeat(BOARD_SIZE) + "+");
        for (int y = 0; y < BOARD_SIZE; ++y) {
            for (int x = 0; x < BOARD_SIZE; ++x) {
                System.out.printf("| ");
                if (board[y][x] == EMPTY) System.out.printf(" ");
                if (board[y][x] == RED) System.out.printf("R");
                if (board[y][x] == BLACK) System.out.printf("B");
                System.out.printf(" ");
            }
            System.out.println("|");
            System.out.println("+---".repeat(BOARD_SIZE) + "+");
        }
    }

    // this method was not even requested on the assignment's document, but the test program wanted it so here it is.
    public int get(int x, int y) {
        return board[y][x];
    }

    // -- GENERAL UTILITY --

    // flips color RED to BLACK or BLACK to RED
    private int colorFlip(int color) {
        if (color == this.RED) return this.BLACK;
        else if (color == this.BLACK) return this.RED;
        else return color;
    }
}