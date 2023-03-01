package nme.cs102.lab14;

public class Determinant {
    public static int determinant (int[][] a) {
        if (a.length != a[0].length) {
            throw new IllegalArgumentException("行数和列数不相等");
        }

        if (a.length == 1) {
            return a[0][0];
        }

        int sum = 0;
        for (int i = 0; i < a.length; i++) {
            int[][] reduced = new int[a.length - 1][a.length - 1];
            for (int j = 1; j < a.length; j++) {
                for (int k = 0; k < a[j].length; k++) {
                    if (k == i) {
                        continue;
                    }
                    reduced[j - 1][k < i ? k : k - 1] = a[j][k];
                }
            }
            sum += a[0][i] * determinant(reduced) * (i % 2 == 0 ? 1 : -1);
        }

        return sum;
    }

    public static void main(String[] args) {
        System.out.println(determinant(new int[][]{{1, 2, 3, 4, 1}, {0, -1, 2, 4, 2}, {0, 0, 4, 0, 0}, {-3, -6, -9, -12, 4}, {0, 0, 1, 1, 1}}));
    }
}
