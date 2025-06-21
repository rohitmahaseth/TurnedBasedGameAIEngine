import javax.print.DocFlavor;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {

    }

    public Board start(){
        return new Board();
    }

    public void move(Board board, Player player, Move move){

    }

    public GameResult isComplete( Board board ){
        if ( board instanceof TicTacToeBoard ){
            TicTacToeBoard board1 = (TicTacToeBoard) board;
            String firstCharacter = board1.cells[0][0];;
            boolean rowComplete = true;
            for( int i = 0; i < 3; i++ ){
                firstCharacter = board1.cells[i][0];
                for ( int j = 1; j < 3; j++ ){
                    if ( !board1.cells[i][j].equals(firstCharacter) ){
                        rowComplete = false;
                        break;
                    }
                }
            }
            if ( rowComplete ){
                return new GameResult(true, firstCharacter);
            }

            boolean colComplete = true;
            for( int i = 0; i < 3; i++ ){
                firstCharacter = board1.cells[0][i];
                for ( int j = 1; j < 3; j++ ){
                    if ( !board1.cells[j][i].equals(firstCharacter) ){
                        colComplete = false;
                        break;
                    }
                }
            }
            if ( colComplete ){
                return new GameResult(true, firstCharacter);
            }

            boolean diagComplete = true;
            for( int i = 0; i < 3; i++ ){
                firstCharacter = board1.cells[0][0];
                if ( !board1.cells[i][i].equals(firstCharacter) ){
                    diagComplete = false;
                    break;
                }
            }
            if ( diagComplete ){
                return new GameResult(true, firstCharacter);
            }

            boolean revDiagComplete = true;
            for( int i = 0; i < 3; i++ ){
                firstCharacter = board1.cells[2][2];
                if ( !board1.cells[i][2 - i].equals(firstCharacter) ){
                    revDiagComplete = false;
                    break;
                }
            }

            int countOfFilledCells = 0;
            for( int i = 0; i < 3; i++ ){
                for ( int j = 0; j < 3; j++ ){
                    if ( board1.cells[i][j] != null ){
                        countOfFilledCells++;
                    }
                }
            }
            if ( revDiagComplete ){
                return new GameResult(true, firstCharacter);
            }

            if ( countOfFilledCells == 9 ){
                return new GameResult(true, "-");
            }else{
                return new GameResult(false, "Draw");
            }

        }
        else {
            return new GameResult(false, "-");
        }
    }
}

class Board{

}

class TicTacToeBoard extends Board{
    String cells[][] = new String[3][3];
}

class Player{

}

class Move{

}

class GameResult{
    boolean isOver;
    String winner;

    public GameResult(boolean isOver, String winner) {
        this.isOver = isOver;
        this.winner = winner;
    }
}