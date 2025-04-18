import java.util.Arrays;
import java.util.Scanner;

public class Turning_Grille_Encryption {

    static int n = 4;

    static boolean[][] grille = {
            { true, false, false, false },
            { false, false, true, false },
            { false, false, false, true },
            { false, true, false, false }
    };

    static boolean[][] rotate(boolean[][] grid) {
        boolean[][] rotated = new boolean[n][n];
        for (int i = 0; i < n; i++)
            for (int j = 0; j < n; j++)
                rotated[j][n - 1 - i] = grid[i][j];
        return rotated;
    }

    public static String encrypt(String text) {
        if (text.length() > n * n)
            throw new IllegalArgumentException("Teksti është shumë i gjatë për këtë grilë (maksimumi " + (n * n) + " karaktere).");

        char[][] matrix = new char[n][n];
        Arrays.stream(matrix).forEach(row -> Arrays.fill(row, '*'));

        int k = 0;
        boolean[][] currentGrille = grille;

        for (int rotation = 0; rotation < 4; rotation++) {
            for (int i = 0; i < n; i++)
                for (int j = 0; j < n; j++)
                    if (currentGrille[i][j] && k < text.length())
                        matrix[i][j] = text.charAt(k++);
            currentGrille = rotate(currentGrille);
        }

        StringBuilder encrypted = new StringBuilder();
        for (int i = 0; i < n; i++)
            for (int j = 0; j < n; j++)
                encrypted.append(matrix[i][j]);
        return encrypted.toString();
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Shkruaj një fjali për ta enkriptuar (maksimumi 16 karaktere): ");
        String plainText = scanner.nextLine().toUpperCase(); // i kthejmë në uppercase për thjeshtësi

        try {
            String encrypted = encrypt(plainText);
            System.out.println("Teksti i enkriptuar: " + encrypted);
        } catch (IllegalArgumentException e) {
            System.out.println("Gabim: " + e.getMessage());
        }
    }
}
