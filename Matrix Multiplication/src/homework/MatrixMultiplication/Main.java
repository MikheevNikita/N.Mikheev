package homework.MatrixMultiplication;

public class Main {

    public static void main(String[] args) {

        Matrix matrix = new Matrix(3, 2, true);
        try {
            Matrix result = matrix.multiply(new Matrix(2, 3, true));
            printResult(result);
        } catch (IncompatibleMatrixesException e) {
            e.printStackTrace();
        }

    }

    public static void printResult(Matrix result){
        System.out.println("\n\n\n");
        for (int index = 0; index < result.getRows(); index++){
            System.out.println();
            for(int i = 0; i < result.getColumns(); i++){
                System.out.print(result.getMatrix()[index][i] +" | ");
            }
        }
    }
}
