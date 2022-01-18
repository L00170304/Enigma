/// Filename: Enigma.java
// / Author: Dr. Shane Wilson
/// Description: Add a useful description of this file

import java.util.List;

public final class Enigma {

    public static String Encrypt(String message, int incrementNumber,List<String> rotors ){
        // TODO - Implement the Encrypt method
        // Steps in brief
        // 1. Apply the CAESAR shift using the increment number

        //creating array for message characters and add characters sequentially into it with CAESAR shift applied
        char[] ch = new char[message.length()];;
        for (int i = 0; i < message.length(); i++) {
            char temp = message.charAt(i);

            int ascii = (int) temp; // get ASCII value of the character
            for (int j = 0; j < incrementNumber; j++){

                //90 -> 65, 122 -> 97
                if (ascii == 90) ascii = 65; // rotate from Z to A
                if (ascii == 122) ascii = 97; // rotate from z = a
                if (ascii == 32) ascii = ascii - incrementNumber; //preserve blank_space
                ascii = ascii + 1;
            }
            ch[i] = (char)ascii; // add shifted character of ASCII value
        }
        StringBuilder sb = new StringBuilder();

        for (Character eChar: ch) {
            sb.append(eChar);
        }
        String encryptedMessage = sb.toString(); //test


        // 2. For each rotor in the list rotors
        //  2.1 Translate the message using the rotor
        // 3. Return the encrypted string

        return encryptedMessage;
    }


    public static String Decrypt(String message, int incrementNumber, List<String> rotors)
    {
        // TODO - Implement the Decrypt method

        // Steps in brief
        // 1. For each rotor in the list rotors, starting with the last rotor
        //  1.1 Translate the message using the rotor
        // 2. Apply the CAESAR shift


        //creating array for message characters and add characters sequentially into it with CAESAR shift applied
        char[] ch = new char[message.length()];;
        for (int i = 0; i < message.length(); i++) {
            char temp = message.charAt(i);

            int ascii = (int) temp; // get ASCII value of the character
            for (int j = 0; j < incrementNumber; j++){

                //65 -> 90, 97 -> 122
                if (ascii == 65) ascii = 90; // rotate from A to Z
                if (ascii == 97) ascii = 122; // rotate from a = z
                if (ascii == 32) ascii = ascii + incrementNumber; //preserve blank_space
                ascii = ascii - 1;
            }
            ch[i] = (char)ascii; // add shifted character of ASCII value
        }

        StringBuilder sb = new StringBuilder();

        for (Character eChar: ch) { //build up string from characters stored in ch[]
            sb.append(eChar);
        }
        String decryptedMessage = sb.toString();


        // 3. Return the decrypted string

        return decryptedMessage;

    }
}
