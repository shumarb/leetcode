// Question: https://leetcode.com/problems/lexicographically-smallest-string-after-reverse/description/

class LexicographicallySmallestStringAfterReverse {
    public String lexSmallest(String s) {
        String result = s;
        boolean isTest = false;
        char[] letters = s.toCharArray();
        int n = s.length();

        for (int i = 2; i <= n; i++) {
            String reverseFirst = reverse(letters.clone(), "reverseFirst", i);
            String reverseLast = reverse(letters.clone(), "reverseLast", i);
            if (isTest) {
                System.out.println("i: " + i + " -> reverseFirst: " + reverseFirst + ", reverseLast: " + reverseLast);
            }
            if (reverseFirst.compareTo(result) < 0) {
                result = reverseFirst;
            }
            if (reverseLast.compareTo(result) < 0) {
                result = reverseLast;
            }
        }

        return result;
    }

    private String reverse(char[] letters, String type, int size) {
        int i;
        int j;

        if (type.equals("reverseFirst")) {
            i = 0;
            j = size - 1;

        } else {
            i = letters.length - size;
            j = letters.length - 1;
        }

        while (i < j) {
            char temp = letters[i];
            letters[i++] = letters[j];
            letters[j--] = temp;
        }

        return new String(letters);
    }
}