package homework.MatrixMultiplication;

import java.util.Scanner;

public class Matrix{

    private int[][] matrix;
    private int rows;
    private int columns;
    private Scanner in = new Scanner(System.in);

    public int[][] getMatrix(){
        return matrix;
    }
    public int getRows(){
        return rows;
    }
    public int getColumns() {
        return columns;
    }

    public Matrix(int rows, int columns, boolean fillable){
        this.rows = rows;
        this.columns = columns;
        matrix = new int[rows][columns];
        if(fillable){
            fill();
        }else{
            for (int index = 0; index < rows; index++){
                for (int i = 0; i < columns; i++){
                    matrix[index][i] = 1;
                }
            }
        }
    }

    private void fill(){
        int row = 0;
        int column = 0;
        while (row < rows){
            while(column < columns){
                System.out.print("\n\n\n");
                System.out.println("Define the matrix");
                for (int index = 0; index <= row; index++){
                    for (int i = 0; i < columns; i++){
                        if (index == row && i == column){
                            System.out.print(" * ");
                            break;
                        }
                        System.out.print(matrix[index][i] + " | ");

                    }
                    System.out.println();
                }
                matrix[row][column] = in.nextInt();
                column++;
            }
            column = 0;
            row++;
        }

    }

    public Matrix multiply(Matrix second) throws IncompatibleMatrixesException{
        if(rows == second.getColumns()){
            Matrix result = new Matrix(rows, second.getColumns(), false);
            for(int iRow = 0; iRow < rows; iRow++){
                for(int iCol = 0; iCol < second.getColumns(); iCol++){

                    int[] row = new int[columns];
                    for (int index = 0; index < columns; index++){
                        row[index] = matrix[iCol][index];
                    }

                    int[] column = new int[second.getRows()];
                    for (int index = 0; index < second.getRows(); index++){
                        column[index] = second.getMatrix()[index][iRow];
                    }

                    System.out.println("Passed to Calculator thread");
                    Thread calc = new Thread(new Calculator(row, column, result, iRow, iCol));
                    calc.start();
                }
            }
            return result;
        }else{
            throw new IncompatibleMatrixesException();
        }
    }

}

class Calculator implements Runnable{

    private int[] column;
    private int[] row;
    private Matrix running;
    private int iCol;
    private int iRow;

    public Calculator(int[] row, int[] column, Matrix running, int y, int x){
        this.column = column;
        this.row = row;
        this.running = running;
        iCol = y;
        iRow = x;
    }

    @Override
    public void run() {
        running.getMatrix()[iCol][iRow] = calcElement(row, column);
        System.out.println("Calculated");
    }

    private int calcElement(int[] row, int[] column){
        int result = 0;
        for (int index = 0; index < column.length; index++){
            result += column[index] * row[index];
        }
        return result;
    }
}
