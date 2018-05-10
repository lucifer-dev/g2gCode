package dev.coding;

import java.util.LinkedHashSet;

public class Main {

    public static void main(String[] args) {
        String inputString = "127.0.0.1";
        System.out.print(isIPAddressValid(inputString));
    }

    /**
     * https://www.geeksforgeeks.org/remove-duplicates-from-a-given-string/
     */
    private static String removeAllDuplicates(String inputString) {
        LinkedHashSet<Character> uniqueCharacters = new LinkedHashSet<>();
        for (int index = 0; index < inputString.length(); index++) {
            uniqueCharacters.add(inputString.charAt(index));
        }
        return uniqueCharacters.toArray().toString();
    }

    /*
     * https://www.geeksforgeeks.org/run-length-encoding/
     */
    private static String runLengthEncoding(String input) {
        final int DECIMAL_RADIX = 10;
        StringBuilder outputStringBuilder = new StringBuilder();
        char currentChar;
        int currentCharCount = 1;
        if (input == null || input.length() <= 0) {
            return null;
        }
        currentChar = input.charAt(0);
        for (int index = 1; index < input.length(); index++) {
            if (input.charAt(index) == currentChar) {
                currentCharCount++;
            } else {
                outputStringBuilder.append(currentChar);
                outputStringBuilder.append(Character.forDigit(currentCharCount, DECIMAL_RADIX));
                System.out.println(currentChar + " : " + String.valueOf(currentCharCount));
                currentChar = input.charAt(index);
                currentCharCount = 1;
            }
        }
        outputStringBuilder.append(currentChar);
        outputStringBuilder.append(Character.forDigit(currentCharCount, DECIMAL_RADIX));
        System.out.println(currentChar + " : " + Character.forDigit(currentCharCount, DECIMAL_RADIX));
        return outputStringBuilder.toString();
    }

    /*
     * https://www.geeksforgeeks.org/program-to-validate-an-ip-address/
     */
    private static Boolean isIPAddressValid(String ipAddress) {
        String[] octets;
        int octetValue = 0;
        octets = ipAddress.split("[.]");
        for (String octet : octets) {
            try {
                octetValue = Integer.parseInt(octet);
            } catch (NumberFormatException numberFormatException) {
                System.out.println(numberFormatException.getMessage());
                numberFormatException.printStackTrace();
                return false;
            }
            if (!(octetValue >= 0 && octetValue <= 255)) {
                return false;
            }
        }
        return true;
    }
}
