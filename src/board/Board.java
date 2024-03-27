package board;

import triple.Triple;
import java.util.ArrayList;

public class Board {
    public int size;
    public int[][] matrix;
    
    public Board(int size){
        this.size = size;
        this.matrix = new int[size][size];
    }

    public void printboard(){
        int n = this.size;
        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++){
                System.out.print(this.matrix[i][j] + " "); // Added space to separate numbers
            }
            System.out.println();
        }
    }

    public void setvalue(int row, int col, int num){
        if(num <= 9 && num >= 0 && row >= 0 && row < size && col >= 0 && col < size){
            this.matrix[row][col] = num;
        } else {
            System.out.println("Invalid row, col, or value");
        }
    }

    public void setupcoloumnwise(int row, ArrayList<Integer> col, ArrayList<Integer> val){
        for(int i = 0; i < col.size(); i++){
            if(col.get(i) >= 0 && col.get(i) < size){
                this.matrix[row][col.get(i)] = val.get(i);
            } else {
                System.out.println("Invalid column index");
            }
        }
    }

    public void setupBoard(ArrayList<Triple> triple){
        for(int i = 0; i < triple.size(); i++){
            int row = triple.get(i).row;
            int col = triple.get(i).col;
            int val = triple.get(i).val;
            if(row >= 0 && row < size && col >= 0 && col < size){
                matrix[row][col] = val;
            } else {
                System.out.println("Invalid row or column index");
            }
        }
    }
}
