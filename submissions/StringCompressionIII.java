// Question: https://leetcode.com/problems/string-compression-iii/description/

class StringCompressionIII {
    public String compressedString(String word) {
        StringBuilder result = new StringBuilder();
        boolean isTest = false;
        char[] letters = word.toCharArray();
        char last = letters[0];
        int count = 1;

        for (int i = 1; i < letters.length; i++) {
            char incoming = letters[i];

            if (isTest) {
                System.out.println("i: " + i + ", incoming: " + incoming + "\n\nbefore: " + result + "\n * last: " + last + "\n * count: " + count);
            }

            if (incoming == last && count < 9) {
                count++;

            } else {
                result.append(count).append(last);
                count = 1;
                last = incoming;
            }

            if (isTest) {
                System.out.println("\nafter: " + result + "\n * last: " + last + "\n * count: " + count);
                System.out.println("-----------------------------------------------------");
            }
        }
        if (isTest) {
            System.out.println("after iteration\n\nbefore\n * result: " + result + "\n * last: " + last + "\n * count: " + count);
        }
        result.append(count).append(last);
        if (isTest) {
            System.out.println("\nafter\n * result: " + result);
        }

        return result.toString();
    }
}
