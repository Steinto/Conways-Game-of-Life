/**
 * class Conways Game of Life
 *
 * Toby Steiner
 * 14/05/2024
 */
import java.util.Scanner;
import java.util.Arrays;
public class a{
    static int readNum(String msg){
        //this function ask the player for a number and asks again if it is not a number then return the number
        Scanner keyboard = new Scanner(System.in);
        System.out.println(msg);
        while(!keyboard.hasNextInt()){
            keyboard.nextLine();
            System.out.println("input error \n" + msg);
        }
        return(keyboard.nextInt());
    }
    static int readFirstLetter(String msg){
        //this code will read the inputed letter and convert it to an int only if the input in 1 charactor long and a lower case letter from a-t
        Scanner keyboard = new Scanner(System.in);
        boolean keepGoing = true;
        int inptInt = 0;
        while (keepGoing){
            System.out.println(msg);
            String a = keyboard.nextLine();
            if(a.length() == 1){
                inptInt = a.charAt(0);
                inptInt = inptInt-'a';
                System.out.println(inptInt);
                if(inptInt >= 0 && inptInt <= 25){
                    keepGoing = false;
                }else{
                    System.out.println("I need a letter");
                }
            }
        }
        return inptInt;
    }
    static void setBoard(int[][] board, int x, int y){
        //sets whole board to 0
        for (int i = 0; i < y; i++){
            for (int j = 0; j < x; j++){
                board[i][j] = 0;
            }
        }
    }
    static void renderBoard(int[][] board, int x, int y){
        //this function prints the current board state
        //clear screen and bring x axis
        System.out.print('\u000c');
        System.out.print("    A B C D E F G H I J K L M N O P Q R S T");
        System.out.print("\n");
        for (int i = 0; i < x; i++){
            //pring y axis
            if(i < 9){
                System.out.print(" ");
                System.out.print(i + 1);
            }else{
                System.out.print(i + 1);
            }
            System.out.print("| ");
            for (int j = 0; j < y; j++){
                //brind board wit"." if value is 0 and "■" if not
                if(board[i][j] == 0){
                    System.out.print(". ");
                }else{
                    System.out.print("■ ");
                }
            }
            System.out.print("|" + (i + 1));
            System.out.println("");
        }
        System.out.println("    A B C D E F G H I J K L M N O P Q R S T");
    }
    static boolean startQuestion(){
        //this function asks player if they want to start the imulation
        boolean start = false;
        boolean keepAsking = true;
        int S = 0;
        while(keepAsking){
            S = readFirstLetter("Do you want to start the simulation? \n(enter 'y' for yes or 'n' for no)");
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
    static void clearQuestion(int[][] board, int x, int y){
        //this function asks player if they want to clear the board after a turn
        boolean keepAsking = true;
        int S = 0;
        while(keepAsking){
            S = readFirstLetter("Do you want to clear the board? \n(enter 'y' for yes or 'n' for no)");
            if (S == 24 || S == 13){
                keepAsking = false;
            }
        }
        if (S == 24){
            setBoard(board, x, y);
            renderBoard(board, x, y);
        }
    }
    static void changeSquare(int[][] board){
        //this function asks the x and y coordinates the player wants to change and changes that part of the 2d array
        Scanner keyboard = new Scanner(System.in);
        System.out.println(" ");
        int placeX = readFirstLetter("In what x axis do you want to place the tile? \nput your answer as a lower case letter \n(note, you can only place tiles on white squares)");
        int placeY = -1;
        while(placeY < 0 || placeY > 20){
            placeY = readNum("In what y axis do you want to place the tile? \nput your answer as an int from 1 to 20\n(note, you can only place tiles on white squares)");
        }
        placeY = placeY - 1;
        System.out.println(placeY);
        if(board[placeY][placeX] == 0){
            board[placeY][placeX] = 1;
        }else if(board[placeY][placeX] == 1){
            board[placeY][placeX] = 0;
        }
    }
    static void turn(int YLength, int XLength, int[][] board){
        //this function checks the surrounding squares for all squares on the board then changes them depending on the 4 rules.
        int[][] newboard = new int [YLength + 2][XLength + 2];
        int turns = -1;
        while(turns < 0 || turns > 100){
            turns = readNum("How many numbers of turns do you want to advance? answer with an interger.");
        }
        int ajSquares = 0;
        int[][] logicBoard = new int [YLength + 2][XLength + 2];
        for (int l = 0; l < turns; l++){
            for (int i = 0; i < 20; i++){
                for (int j = 0; j < 20; j++){
                    logicBoard[i+1][j+1] = board[i][j];
                }
            }
            for (int x = 1; x < YLength + 1; x++){
                for (int y = 1; y < XLength + 1; y++){
                    for (int s = -1; s <= 1; s++){
                        for (int c = -1; c <= 1; c++){
                            if (logicBoard[x+c][y+s] != 0 && !(c == 0 && s == 0)){
                                ajSquares ++;
                                System.out.println(ajSquares);    
                            }
                        }
                    }
                    newboard[x][y] = ajSquares;
                    ajSquares = 0;
                }
            } 
            for (int i = 0; i < 20; i++){
                for (int j = 0; j < 20; j++){
                    board[i][j] = newboard[i+1][j+1];
                }
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
            renderBoard(board, XLength, YLength);
            try { 
                Thread.sleep(1 * 100); 
            } catch (InterruptedException ie) { 
                Thread.currentThread().interrupt(); 
            } 
        }
    }
    public static void main(String[] args){
        //variables that will be used throughout the programme
        int XLength = 20;
        int YLength = 20;
        int[][] board = new int [YLength][XLength];
        boolean keepGoing = true;
        
        //set and render board
        setBoard(board, XLength, YLength);
        renderBoard(board, XLength, YLength);
        System.out.println("\nWelcome to Conways Game of Life! \n---------------------------------\n \nThis is a cellular automation game. \nMeaning that you choose starting conditions and\nthe simulation runs from a set of predetermined rules;\ndependant on the surrounding cells.\n \nIn the grid above you will choose what cells are\nalive or not by inputting their x and y coordinates.\nTo input a number or letter the program will first prompt you,\nthen you can input a letter or number depending on the question.\n --------------------------------------------------------------\n \nHere are the four rules:\n    Rule 1 Each cell with one or no neighbors dies as if by solitude.\n    Rule 2 Each cell with four or more neighbors dies as if by overpopulation.\n    Rule 3 Each cell with two or three neighbors survives.\n    Rule 4 Each unpopulated cell with three neighbors becomes populated");

        
        //loop to keep programme running
        while(keepGoing){
            changeSquare(board);
            renderBoard(board, XLength, YLength);
            boolean start = startQuestion();
            //if they want to start a turn
            if(start){
                renderBoard(board, XLength, YLength);
                turn(YLength, XLength, board);
                clearQuestion(board, XLength, YLength);
            }
        }
    }
}