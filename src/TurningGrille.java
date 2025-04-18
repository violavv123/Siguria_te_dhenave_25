import java.util.Arrays;
import java.util.Scanner;

public class TurningGrille {

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
        Scanner sc = new Scanner(System.in);
        String choice;

        System.out.println("| DEMONSTRIM I TURNING GRILLE ENCRYPTION |");
        System.out.println("----------------------------------------\n");

        do {
            System.out.println("Zgjidhni nje opsion:");
            System.out.println("1 - Enkriptim");
            System.out.println("2 - Dekriptim");
            System.out.print("Zgjedhja juaj: ");
            choice = sc.nextLine().trim();

            if (choice.equals("1")) {
                System.out.print("Shkruani mesazhin per enkriptim (max 16 karaktere): ");
                String message = sc.nextLine().replaceAll("\\s+", "").toUpperCase();

                try {
                    String encrypted = encrypt(message);
                    System.out.println("\n----------------------------------------");
                    System.out.println("Teksti origjinal:   " + message);
                    System.out.println("Teksti i enkriptuar: " + encrypted);
                    System.out.println("----------------------------------------");
                } catch (IllegalArgumentException e) {
                    System.out.println("Gabim: " + e.getMessage());
                }
            } // qitu e bon ni else if edhe e shkrun tani pjesen tone per dekriptim

            System.out.print("\nDeshironi te vazhdoni? (p/j): ");
            choice = sc.nextLine().trim().toLowerCase();

        } while (!choice.equals("j"));

        sc.close();
        System.out.println("\nProgrami ka perfunduar ekzekutimin!");
    }
}


