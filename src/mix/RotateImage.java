package mix;

public class RotateImage {
    public void rotate(int[][] matrix) {
        if(matrix == null || matrix[0].length <= 1) return; // no need to rotate

        final int N = matrix[0].length;

        // for each layer
        for(int i=0; i<N/2; i++) {
            int[] top = getTop(matrix, i);
            int[] bottom = getBottom(matrix, i);
            int[] right = getRight(matrix, i);
            int[] left = getLeft(matrix, i);

            moveTopToRight(matrix, i, top);
            moveRightToBottom(matrix, i, right);
            moveBottomToLeft(matrix, i, bottom);
            moveLeftToTop(matrix, i, left);
        }
    }

    private void moveTopToRight(int[][] matrix, int i, int[] top) {
        final int N = matrix[0].length;
        for(int n=0; n<top.length; n++) {
            matrix[i+n][N-1-i] = top[n];
        }
    }

    private void moveRightToBottom(int[][] matrix, int i, int[] right) {
        final int N = matrix[0].length;
        for(int n=0; n<right.length; n++) {
            matrix[N-1-i][N-1-i-n] = right[n];
        }
    }

    private void moveBottomToLeft(int[][] matrix, int i, int[] bottom) {
        final int N = matrix[0].length;
        for(int n=0; n<bottom.length; n++) {
            matrix[i+n][i] = bottom[n];
        }
    }

    private void moveLeftToTop(int[][] matrix, int i, int[] left) {
        final int N = matrix[0].length;
        for(int n=0; n<left.length; n++) {
            matrix[i][N-1-i-n] = left[n];
        }
    }

    private int[] getTop(int[][] matrix, int i) {
        final int N = matrix[0].length;
        int[] top = new int[N - 2*i];
        for(int n=i; n<N-i; n++) {
            top[n-i] = matrix[i][n];
        }
        return top;
    }

    private int[] getBottom(int[][] matrix, int i) {
        final int N = matrix[0].length;
        int[] bottom = new int[N - 2*i];
        for(int n=i; n<N-i; n++) {
            bottom[n-i] = matrix[N-i-1][n];
        }
        return bottom;
    }

    private int[] getRight(int[][] matrix, int i) {
        final int N = matrix[0].length;
        int[] right = new int[N - 2*i];
        for(int n=i; n<N-i; n++) {
            right[n-i] = matrix[n][N-1-i];
        }
        return right;
    }

    private int[] getLeft(int[][] matrix, int i) {
        final int N = matrix[0].length;
        int[] left = new int[N - 2*i];
        for(int n=i; n<N-i; n++) {
            left[n-i] = matrix[n][i];
        }
        return left;
    }
}
