// Question:

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

            if (incoming != last) {
                if (count > 0) {
                    result.append(count);
                    result.append(last);
                }
                last = incoming;
                count = 1;

            } else {
                if (++count == 9) {
                    result.append(count);
                    result.append(last);
                    count = 0;
                }
            }

            if (isTest) {
                System.out.println("\nafter: " + result + "\n * last: " + last + "\n * count: " + count);
                System.out.println("-----------------------------------------------------");
            }
        }
        if (isTest) {
            System.out.println("after iteration\n\nbefore\n * result: " + result + "\n * last: " + last + "\n * count: " + count);
        }
        if (count > 0) {
            result.append(count);
            result.append(last);
        }
        if (isTest) {
            System.out.println("\nafter\n * result: " + result);
        }

        return result.toString();
    }
}
