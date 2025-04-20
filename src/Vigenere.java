public class Vigenere {

    public static String encrypt(String plaintext, String key) {
        StringBuilder encryptedText = new StringBuilder();
        plaintext = plaintext.toUpperCase();
        key = key.toUpperCase();

        for (int i = 0, keyIndex = 0; i < plaintext.length(); i++) {
            char currentChar = plaintext.charAt(i);


            if (Character.isLetter(currentChar)) {

                char keyChar = key.charAt(keyIndex % key.length());
                int shift = keyChar - 'A';


                char encryptedChar = (char) ((currentChar - 'A' + shift) % 26 + 'A');
                encryptedText.append(encryptedChar);


                keyIndex++;
            } else {

                encryptedText.append(currentChar);
            }
        }
        return encryptedText.toString();
    }

    public static String decrypt(String ciphertext, String key) {
        StringBuilder decryptedText = new StringBuilder();
        ciphertext = ciphertext.toUpperCase();
        key = key.toUpperCase();

        for (int i = 0, keyIndex = 0; i < ciphertext.length(); i++) {
            char currentChar = ciphertext.charAt(i);

            if (Character.isLetter(currentChar)) {
                char keyChar = key.charAt(keyIndex % key.length());
                int shift = keyChar - 'A';

                char decryptedChar = (char) ((currentChar - 'A' - shift + 26) % 26 + 'A');
                decryptedText.append(decryptedChar);

                keyIndex++;
            } else {
                decryptedText.append(currentChar);
            }
        }
        return decryptedText.toString();
    }

    public static void main(String[] args) {
        String message = "SHIHEMI NE ROUTE 66 NE ORA 6";
        String secretKey = "LIMONI";

        String encryptedMessage = encrypt(message, secretKey);
        String decryptedMessage = decrypt(encryptedMessage, secretKey);

        System.out.println("Mesazhi plaintext: " + message);
        System.out.println("Celesi i enkriptimit: " + secretKey);
        System.out.println("Mesazhi i enkriptuar: " + encryptedMessage);
        System.out.println("Mesazhi i dekriptuar: " + decryptedMessage);

    }
}