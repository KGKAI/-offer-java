package path_of_matrix;

// 矩阵中的路径
public class PathOfMatrix {
    public static boolean hasPath(char[] matrix, int rows, int cols, char[] str) {
        if (matrix == null || rows <= 0 || cols <= 0 || str == null) {
            return false;
        }
        if (str.length == 0) {
            return true;
        }

        boolean[] visited = new boolean[matrix.length];
        int pathLength = 0;
        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {
                if (hasPathCore(matrix, rows, cols, row, col, pathLength, str, visited)) {
                    return true;
                }
            }
        }
        return false;
    }

    private static boolean hasPathCore(char[] matrix, int rows, int cols, int row, int col, int pathLength, char[] str, boolean[] visited) {
        if (matrix == null || row < 0 || row >= rows || col < 0 || col >= cols || str[pathLength] != matrix[row * cols + col] || visited[row * cols + col]) {
            return false;
        }
        if (pathLength == str.length - 1) {
            return true;
        }

        visited[row * cols + col] = true;
        if (hasPathCore(matrix, rows, cols, row - 1, col, pathLength + 1, str, visited)
            || hasPathCore(matrix, rows, cols, row + 1, col, pathLength + 1, str, visited)
            || hasPathCore(matrix, rows, cols, row, col - 1, pathLength + 1, str, visited)
            || hasPathCore(matrix, rows, cols, row, col + 1, pathLength + 1, str, visited)) {
            return true;
        }
        visited[row * cols + col] = false;
        return false;
    }

    public static void main(String[] args) {
        char[] matrix = {'a', 'b', 't', 'g',
                         'c', 'f', 'c', 's',
                         'j', 'd', 'e', 'h'};
        char[] str = {'a', 'b', 'f', 'd'};
        System.out.println(hasPath(matrix, 3, 4, str));
    }
}
