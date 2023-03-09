package rocks.zipcodewilmington.tictactoe;

/**
 * @author leon on 6/22/18.
 */
public class Board {
    Character[][] game;

    public Board(Character[][] matrix) {
        game = matrix;
    }

    public Boolean isInFavorOfX() {
        return (IsItWinning('X')=='X');
    }

    public Boolean isInFavorOfO() {
        return (IsItWinning('O')=='O');
    }

    public Boolean isTie() {
        return !isInFavorOfX() && !isInFavorOfO();
    }

    public String getWinner() {
        if (isInFavorOfO()){
            return "O";
        }else if(isInFavorOfX()){
            return "X";
        }else {
            return "";
        }
    }
    public char IsItWinning(char c) {
        boolean win = false;
        for (int y = 0; y < game.length; y++) {
            if (game[y][y] != c) {
                win = false;
                break;
            } else {
                win = true;
            }
        }
        if (win) {
            return c;
        }
        for (int y = 0; y < game.length; y++) {
            if (game[(game.length-1)-y][(game.length-1)-y] != c) {
                win = false;
                break;
            } else {
                win = true;
            }
        }
        if (win) {
            return c;
        }
        for (int y = 0; y < game.length; y++) {
            if (game[y][(game.length-1)-y] != c) {
                win = false;
                break;
            } else {
                win = true;
            }
        }
        if (win) {
            return c;
        }
        for (int y = 0; y < game.length; y++) {
            if (game[(game.length-1)-y][y] != c) {
                win = false;
                break;
            } else {
                win = true;
            }
        }
        if (win) {
            return c;
        }

        for (int y = 0; y < game.length; y++) {
            for (int x = 1; x < game.length; x++) {
                if (game[y][x] == c) {
                    if (game[y][x] != game[y][x - 1]) {
                        win = false;
                        break;
                    } else {
                        win = true;
                    }
                } else {
                    win = false;
                }
            }
            if (win) {
                return c;
            }
        }

        for (int y = 0; y < game.length; y++) {
            for (int x = 1; x < game.length; x++) {
                if (game[x][y] == c) {
                    if (game[x][y] != game[x - 1][y]) {
                        win = false;
                        break;
                    } else {
                        win = true;
                    }
                } else {
                    win = false;
                }
            }
            if (win) {
                return c;
            }
        }
        return 'p';

    }
}
