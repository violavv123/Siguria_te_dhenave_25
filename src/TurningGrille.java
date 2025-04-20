import java.util.Arrays;
import java.util.Scanner;

public class TurningGrille {

    static int n = 4;

    static boolean[][] grille = {
            { true, false, false, false },
            { false, false, false, true },
            { false, false, true, false },
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
    public static String decrypt(String encryptedmessage) {
        if (encryptedmessage.length() != n * n)
            throw new IllegalArgumentException("Teksti i enkriptuar duhet të jetë " + (n * n) + " karakterësh!");

        char[][] matrixfill = new char[n][n];
        int index = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                matrixfill[i][j] = encryptedmessage.charAt(index++);
            }
        }

        StringBuilder decryptedmessage = new StringBuilder();
        for (int r = 0; r < 4; r++) {
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if(grille[i][j]) {
                        decryptedmessage.append(matrixfill[i][j]);
                    }
                }
            }
            grille = rotate(grille);
        }

        return decryptedmessage.toString().toUpperCase().replace("*", "");
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
            } else if (choice.equals("2")) {
                System.out.print("Per dekriptim, shkruani mesazhin e enkriptuar (16 karaktere): ");
                String encryptedinput = sc.nextLine().replaceAll("\\s+", "").toUpperCase();

                try {
                    String decrypted = decrypt(encryptedinput);
                    System.out.println("\n----------------------------------------");
                    System.out.println("Teksti i enkriptuar: " + encryptedinput);
                    System.out.println("Teksti i dekriptuar: " + decrypted);
                    System.out.println("----------------------------------------");
                } catch (IllegalArgumentException e) {
                    System.out.println("Gabim: " + e.getMessage());
                }
            }

            System.out.print("\nDeshironi te vazhdoni? (p/j): ");
            choice = sc.nextLine().trim().toLowerCase();

        } while (!choice.equals("j"));

        sc.close();
        System.out.println("\nProgrami ka perfunduar ekzekutimin!");
    }
}


