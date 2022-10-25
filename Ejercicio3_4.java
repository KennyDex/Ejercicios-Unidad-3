import java.util.Scanner;

/*Simulation of a Tic-Tac-Toe game (does not do strategy). */
public class Ejercicio3_4 {

    public static final int X = 1, O = -1; // players
    public static final int EMPTY = 0; // empty cell
    private int board[ ][ ] = new int[3][3]; // game board
    private int player; // current player
    /* Constructor */
    public Ejercicio3_4( ) { clearBoard( ); }
    /* Clears the board */
    public void clearBoard( ) {
        for (int i = 0; i < 3; i++)
        for (int j = 0; j < 3; j++)
        board[i][j] = EMPTY; // every cell should be empty
        player = X; // the first player is 'X'
    }
    
    public void putMark(int i, int j) throws IllegalArgumentException {
        Ejercicio3_4 game = new Ejercicio3_4();
        int JugadorGanador = game.winner();
        if ((i < 0) || (i > 2) || (j < 0) || (j > 2))
            throw new IllegalArgumentException("Invalid board position");
        if (board[i][j] != EMPTY)
            throw new IllegalArgumentException("Board position occupied");
        if(JugadorGanador == 0){
            board[i][j] = player; // place the mark for the current player
            player = - player; // switch players (uses fact that O = - X)
        }
        else{
            throw new IllegalArgumentException("Juego Finalizado, movimiento invalido");
        }
        
    }
    /* Checks whether the board configuration is a win for the given player. */
    public boolean isWin(int mark) {
        return ((board[0][0] + board[0][1] + board[0][2] == mark*3) // row 0
        || (board[1][0] + board[1][1] + board[1][2] == mark*3) // row 1
        || (board[2][0] + board[2][1] + board[2][2] == mark*3) // row 2
        || (board[0][0] + board[1][0] + board[2][0] == mark*3) // column 0
        || (board[0][1] + board[1][1] + board[2][1] == mark*3) // column 1
        || (board[0][2] + board[1][2] + board[2][2] == mark*3) // column 2
        || (board[0][0] + board[1][1] + board[2][2] == mark*3) // diagonal
        || (board[2][0] + board[1][1] + board[0][2] == mark*3)); // rev diag
    }
    /* Returns the winning player's code, or 0 to indicate a tie (or unfinished game). */
    public int winner( ) {
        if (isWin(X))
        return(X);
        else if (isWin(O))
        return(O);
        else
        return(0);
    }
    /* Returns a simple character string showing the current board. */
    public String toString( ) {
        StringBuilder sb = new StringBuilder( );
        for (int i=0; i<3; i++) {
            for (int j=0; j<3; j++) {
                switch (board[i][j]) {
                    case X: sb.append("X"); break;
                    case O: sb.append("O"); break;
                    case EMPTY: sb.append(" "); break;
                }
                if (j < 2) sb.append("|"); // column boundary
            }
            if (i < 2) sb.append("\n-----\n"); // row boundary
        }
        return sb.toString( );
    }
    /* Test run of a simple game */
    /**
     * @param args
     */
    public static void main(String[ ] args) {
        Ejercicio3_4 game = new Ejercicio3_4( );
        Scanner escaner = new Scanner(System.in);
        int columna, fila;
        int JugadorGanador = game.winner();
        for (int i = 0; i < 0; i++){
            System.out.println("Inserte numero de filas ( * ,   )");
            columna = escaner.nextInt();
            System.out.println("Inserte numero de columnas ( * ,   )");
            fila = escaner.nextInt();
            game.putMark(columna - 1, fila - 1);
            System.out.println("(" + columna + "," + fila + "): ");
            System.out.println(game);
            JugadorGanador = game.winner();
            if(JugadorGanador == X || JugadorGanador == 0){
                i = 0;
            }
        }
        String[ ] outcome = {"O wins", "Tie", "X wins"}; // rely on ordering
        System.out.println(outcome[1 + JugadorGanador]);
    }
}

 