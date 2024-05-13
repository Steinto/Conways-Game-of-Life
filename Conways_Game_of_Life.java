/**
 * class Conways Game of Life
 *
 * Toby Steiner
 * 14/05/2024
 */
import java.util.Scanner;
import java.util.Arrays;

public class Conways_Game_of_Life{
    static void setBoard(int[][] board, int x, int y){
        for (int i = 0; i < y; i++){
            for (int j = 0; j < j; j++){
                board[i][j] = 0;
            }
        }
    }
    static void renderBoard(int[][] board, int x, int y){
        System.out.print("    ⓪ ➀ ➁➂ ➃ ➄ ➅➆ ➇ ➈⑩  ⑪⑫ ⑬ ⑭ ⑮⑯ ⑰ ⑱ ⑲");
        System.out.print("\n");
        
        for (int i = 0; i < y; i++){
            if(i < 10){
                System.out.print(" ");
                System.out.print(i);
            }else{
                System.out.print(i);
            }
            System.out.print("| ");
            for (int j = 0; j < x; j++){
                if(board[i][j] == 0){
                    System.out.print("⬜ ");
                }else{
                    System.out.print("⬛ ");
                }
            }
            System.out.println("");
        }
        // ⬛⬜
    }
    public static void main(String[] args){
        int XLength = 20;
        int YLength = 20;
        int[][] board = new int [YLength][XLength];
        setBoard(board, XLength, YLength);
        renderBoard(board, XLength, YLength);
    }
}
