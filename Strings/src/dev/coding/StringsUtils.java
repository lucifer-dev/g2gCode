package dev.coding;

import java.util.LinkedHashSet;

/**
 * @author monisram
 */

public class StringsUtils {
    private static int HASH_PRIME = 47;

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

    private static void rabinKarpPatternSearch(String text, String pattern) {
        final int patternLength = pattern.length();
        final int patternHash = getHash(pattern);
        int textHash = getHash(text.substring(0, patternLength));
        int startIndex = 0, endIndex = patternLength-1;
        Double hashExponent;
        while (endIndex < text.length()) {
            // System.out.println("Text Hash : " + textHash);
            if (textHash == patternHash && (pattern.contentEquals(text.substring(startIndex,endIndex+1)))) {
                System.out.println("Match found at : " + startIndex + " ; " + endIndex);
            } else if (endIndex == text.length() - 2) {
                return;
            }
            hashExponent = Math.pow(HASH_PRIME, patternLength - 1);
            textHash = ((textHash - (int)text.charAt(startIndex)) / HASH_PRIME) +
                    (hashExponent.intValue() * text.charAt(endIndex + 1));
            endIndex = endIndex + 1;
            startIndex = startIndex + 1;
        }
    }

    private static int getHash(String input) {
        int hash = 0;
        Double hashExponent;
        for (int index = 0; index < input.length(); index++) {
            hashExponent = Math.pow(HASH_PRIME, index);
            hash = hash + ((int)input.charAt(index) * hashExponent.intValue());
        }
        return hash;
    }

}
