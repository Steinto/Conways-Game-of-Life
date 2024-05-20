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
    static void Turn(){
        int turns = readnum("How many numbers of turns do you want to advance? answer with an interger.");
        SimulateTurns(turns);
    }
    static void SimulateTurns(int turnNumber){
        
        
        
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
                Turn();
                keepGoing = false;
            }
        }
    }
}
