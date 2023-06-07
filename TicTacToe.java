import java.util.Scanner;
public class TicTacToe {
    public static void main(String [] args){
        char[][] board = new char[3][3];
        for(int row=0;row<board.length;row++){
            for(int column=0;column<board[row].length;column++){
                board[row][column]=' ';
            }
        }
        char player='x';
        boolean gameOver=false;
        Scanner sc = new Scanner(System.in);
        while(gameOver!=true){
            printBoard(board);
            System.out.println("Player " + player + " Enter: ");
            int row = sc.nextInt();
            int col = sc.nextInt();
            if(board[row][col] == ' '){
                board[row][col] = player;
                gameOver = haveWon(board,player);
                if(gameOver == true){
                    System.out.println("Player " + player + " has won: ");
                }
                else{
                    if(player == 'x'){
                        player = 'o';
                    }
                    else{
                        player = 'x';
                    }
                }
            }
            else{
                System.out.println("Invalid move. Try again! ");
            }
        }
        printBoard(board);
    }
    public static boolean haveWon(char [][]board,char player){
        for(int row=0;row<board.length;row++){
            if(board[row][0] == player && board[row][1] == player && board[row][2] == player){
                return true;
            }
        }
        for(int col=0;col<board.length;col++){
            if(board[0][col] == player && board[1][col] == player && board[2][col] == player){
                return true;
            }
        }
        if(board[0][0] == player && board[1][1] == player && board[2][2] == player){
            return true;
        }
        if(board[0][2] == player && board[1][1] == player && board[2][0] == player){
            return true;
        }
        return false;
    }
    public static void printBoard(char[][] board){
        for(int row=0;row<board.length;row++){
            for(int column=0;column<board[row].length;column++){
                System.out.print(board[row][column] + " | ");
            }
            System.out.println();
        }
    }
}