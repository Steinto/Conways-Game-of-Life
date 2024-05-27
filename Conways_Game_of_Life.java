/**
 * class Conways Game of Life
 *
 * Toby Steiner
 * 14/05/2024
 */
import java.util.Scanner;
import java.util.Arrays;

public class Conways_Game_of_Life{
    static int readnum(String msg){
        Scanner keyboard = new Scanner(System.in);
        System.out.println(msg);
        while(!keyboard.hasNextInt()){
            keyboard.nextLine();
            System.out.println("input error " + msg);
        }
        return(keyboard.nextInt());
    }
    static int readfirstletter(String msg){
        Scanner keyboard = new Scanner(System.in);
        boolean keepGoing = true;
        int x = 0;
        while (keepGoing){
            System.out.println(msg);
            String a = keyboard.nextLine();
            x = a.charAt(0);
            x = x-'a';
            System.out.println(x);
            if(x >= 0 && x <= 25){
                keepGoing = false;
            }else{
                System.out.println("I need a letter");
            }
        }
        return x;
    }
    static void setBoard(int[][] board, int x, int y){
        for (int i = 0; i < y; i++){
            for (int j = 0; j < j; j++){
                board[i][j] = 0;
            }
        }
    }
    static void renderBoard(int[][] board, int x, int y){
        System.out.print('\u000c');
        // System.out.print("    A  B C  D E  F G H  I J  K L M  N O  P Q  R S T");
        System.out.print("    A B C D E F G H I J K L M N O P Q R S T");
        System.out.print("\n");
        
        for (int i = 0; i < y; i++){
            if(i < 9){
                System.out.print(" ");
                System.out.print(i + 1);
            }else{
                System.out.print(i + 1);
            }
            System.out.print("| ");
            for (int j = 0; j < x; j++){
                if(board[i][j] == 0){
                    System.out.print(". ");
                }else{
                    System.out.print("■ ");
                }
            }
            System.out.println("");
        }
        
    }
    static boolean StartQuestion(){
        boolean start = false;
        boolean keepAsking = true;
        int S = 0;
        while(keepAsking){
            S = readfirstletter("do you want to start the simulation? (enter 'yes' or 'no')");
            if (S == 24 || S == 13){
                keepAsking = false;
            }
        }
        if (S == 24){
            start = true;
            return start;
        }else{
            return start;
        }
        
    }
    static void changeSquare(int[][] board){
        Scanner keyboard = new Scanner(System.in);
        
        System.out.println(" ");
        int placeX = readfirstletter("in what x axis do you want to place the tile? put your answer as a lower case letter \n(note, you can only place tiles on white squares)");
        int placeY = -1;
        while(placeY < 0 || placeY > 20){
            placeY = readnum("in what y axis do you want to place the tile? put your answer as an int from 1 to 20\n(note, you can only place tiles on white squares)");
        }
        placeY = placeY - 1;
        System.out.println(placeY);
        
        board[placeY][placeX] = 1;
        
        
        
        
    }
    static void Turn(int YLength, int XLength, int[][] board){
        int[][] newboard = new int [YLength + 2][XLength + 2];
        int turns = readnum("How many numbers of turns do you want to advance? answer with an interger.");
        int ajSquares = 0;
        int[][] logicBoard = new int [YLength + 2][XLength + 2];
        for (int i = 0; i < 20; i++){
            for (int j = 0; j < 20; j++){
                logicBoard[i+1][j+1] = board[i][j];
            }
        }
        
        for (int l = 0; l < turns; l++){
            for (int x = 1; x < YLength + 1; x++){
                for (int y = 1; y < XLength + 1; y++){
                    for (int s = -1; s <= 1; s++){
                        for (int c = -1; c <= 1; c++){
                            //if(!(x == 19 || y == 19)){
                                //if(!(x == 0 || y == 0)){
                                    if (logicBoard[x+c][y+s] != 0 && !(c == 0 && s == 0)){
                                        
                                        ajSquares ++;
                                        System.out.println(ajSquares);
                                        
                                    }
                                //}
                            // }else if(x == 1 && !(y == 19 || y == 0)){
                                // if(c > -1){
                                    // if (board[x+c][y+s] != 0 && !(c == 0 && s == 0)){
                                        
                                        // ajSquares ++;
                                        // System.out.println(ajSquares);
                                        
                                    // }
                                // }
                            //}
                        }
                    }
                    newboard[x][y] = ajSquares;
                    ajSquares = 0;
                }
            }
        }
        
        for (int i = 0; i < 22; i++){
            for (int j = 0; j < 22; j++){
                System.out.print(newboard[i][j]);
            }
            System.out.println("");
        }
        
        for (int i = 0; i < 20; i++){
            for (int j = 0; j < 20; j++){
                board[i][j] = newboard[i+1][j+1];
            }
        }
        for (int i = 0; i < 20; i++){
            for (int j = 0; j < 20; j++){
                System.out.print(board[i][j]);
            }
            System.out.println("");
        }
        for (int i = 0; i < 20; i++){
            for (int j = 0; j < 20; j++){
                if(board[i][j] < 2){
                    board[i][j] = 0;
                }
                if(board[i][j] > 3){
                    board[i][j] = 0;
                }
                if(board[i][j] == 3){
                    board[i][j] = 1;
                }
                if(logicBoard[i+1][j+1] == 1){
                    if(board[i][j] == 2 || board[i][j] == 3){
                        board[i][j] = 1;
                    }
                }else if(board[i][j] == 2){
                    board[i][j] = 0;
                }
            }
        }
        
        for (int i = 0; i < 20; i++){
            for (int j = 0; j < 20; j++){
                System.out.print(board[i][j]);
            }
            System.out.println("");
        }
        
        renderBoard(board, XLength, YLength);
    }
    public static void main(String[] args){
        int XLength = 20;
        int YLength = 20;
        int[][] board = new int [YLength][XLength];
        boolean keepGoing = true;
        
        setBoard(board, XLength, YLength);
        renderBoard(board, XLength, YLength);
        
        while(keepGoing){
            changeSquare(board);
            renderBoard(board, XLength, YLength);
            boolean start = StartQuestion();
            if(start){
                renderBoard(board, XLength, YLength);
                Turn(YLength, XLength, board);
                //renderBoard(board, XLength, YLength);
                keepGoing = false;
            }
        }
    }
}
