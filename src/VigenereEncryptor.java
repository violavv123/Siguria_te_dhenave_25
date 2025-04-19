public class VigenereEncryptor {

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

    public static void main(String[] args) {
        String message = "SHIHEMI NE ROUTE 66 NE ORA 6";
        String secretKey = "LIMONI";

        String encryptedMessage = encrypt(message, secretKey);

        System.out.println("Mesazhi plaintext: " + message);
        System.out.println("Celesi i enkriptimit: " + secretKey);
        System.out.println("Mesazhi i enkriptuar: " + encryptedMessage);
    }
}