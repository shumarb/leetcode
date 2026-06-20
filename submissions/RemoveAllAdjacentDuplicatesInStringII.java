// Question: https://leetcode.com/problems/remove-all-adjacent-duplicates-in-string-ii/description/

class RemoveAllAdjacentDuplicatesInStringII {
    private Stack<Pair> stack;

    public String removeDuplicates(String s, int k) {
        boolean isTest = false;
        char[] letters = s.toCharArray();
        char[] result = new char[0];
        int j = 0;
        int totalLetters = 0;
        stack = new Stack<>();

        // 1. Not enough consecutive characters to remove.
        if (k > letters.length) {
            return s;
        }

        for (char c: letters) {
            if (isTest) {
                print("incoming: " + c + "\n\nbefore: ");
            }

            totalLetters++;
            if (!stack.isEmpty() && stack.peek().c == c) {
                if (++stack.peek().count == k) {
                    stack.pop();
                    totalLetters -= k;
                }

            } else {
                stack.push(new Pair(c, 1));
            }
            if (isTest) {
                print("\nafter: ");
                System.out.println("----------------------------------");
            }
        }

        result = new char[totalLetters];

        if (totalLetters > 0) {
            j = totalLetters - 1;
            while (!stack.isEmpty()) {
                Pair top = stack.pop();
                while (top.count-- > 0) {
                    result[j--] = top.c;
                }
            }
        }
        if (isTest) {
            System.out.println("totalLetters: " + totalLetters + "\nresult: " + Arrays.toString(result));
        }

        return new String(result);
    }

    private void print(String s) {
        System.out.println(s);
        for (Pair e: stack) {
            System.out.println(" * [" + e.c + ", " + e.count + "]");
        }
    }
}

class Pair {
    char c;
    int count;

    public Pair(char c, int count) {
        this.c = c;
        this.count = count;
    }
}
