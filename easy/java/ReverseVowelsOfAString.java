// Question: https://leetcode.com/problems/reverse-vowels-of-a-string/description/

class ReverseVowels {
    public String reverseVowels(String s) {
        StringBuilder reverseVowelsString = new StringBuilder();
        boolean isTest = false;

        for (char letter: s.toCharArray()) {
            reverseVowelsString.append(letter);
        }
        if (isTest) {
            System.out.println("s: " + s + "\nreverseVowelsString: " + reverseVowelsString);
        }
        int low = 0;
        int high = s.length() - 1;
        while (low < high) {
            boolean isStop = false;

            while (!isVowel(Character.toLowerCase(reverseVowelsString.charAt(high)))) {
                high--;
                if (high < low) {
                    isStop = true;
                    break;
                }
            }
            while (!isVowel(Character.toLowerCase(reverseVowelsString.charAt(low)))) {
                low++;
                if (low > high) {
                    isStop = true;
                    break;
                }
            }
            if (isStop) {
                break;
            }

            char lowLetter = reverseVowelsString.charAt(low);
            char highLetter = reverseVowelsString.charAt(high);
            if (isTest) {
                System.out.println("swap | " + low + "-" + reverseVowelsString.charAt(low) + ", " + high + "-" + reverseVowelsString.charAt(high));
            }
            reverseVowelsString.setCharAt(high--, lowLetter);
            reverseVowelsString.setCharAt(low++, highLetter);
        }

        return reverseVowelsString.toString();
    }

    private boolean isVowel(char letter) {
        return letter == 'a' || letter == 'e' || letter == 'i' || letter == 'o' || letter == 'u';
    }
}