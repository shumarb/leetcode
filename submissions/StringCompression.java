// Question: https://leetcode.com/problems/string-compression/description/

class StringCompression {
    public int compress(char[] chars) {
        boolean isTest = false;
        char last = chars[0];
        int count = 1;
        int index = 0;
        int n = chars.length;

        if (n == 1) {
            return 1;
        }

        for (int i = 1; i < n; i++) {
            char incoming = chars[i];
            if (isTest) {
                System.out.println("i: " + i + ", incoming: " + incoming);
                System.out.println("before\n * last: " + last + "\n * count: " + count + "\n * chars: " + Arrays.toString(chars));
            }

            if (incoming == last) {
                count++;
            } else {
                chars[index++] = last;

                if (count > 1) {
                    for (char c: Integer.toString(count).toCharArray()) {
                        chars[index++] = c;
                    }
                }

                count = 1;
                last = incoming;
            }
            if (isTest) {
                System.out.println("\nafter\n * last: " + last + "\n * count: " + count + "\n * chars: " + Arrays.toString(chars));
                System.out.println("------------------------------------------------------");
            }
        }
        if (isTest) {
            System.out.println("iteration complete\nbefore\n * last: " + last + "\n * count: " + count + "\n * chars: " + Arrays.toString(chars));
        }

        chars[index++] = last;
        if (count > 1) {
            for (char c: Integer.toString(count).toCharArray()) {
                chars[index++] = c;
            }
        }
        if (isTest) {
            System.out.println("\nafter\n * last: " + last + "\n * count: " + count + "\n * chars: " + Arrays.toString(chars));
        }

        return index;
    }
}
