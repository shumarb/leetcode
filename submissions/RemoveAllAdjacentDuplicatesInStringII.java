// Question: https://leetcode.com/problems/remove-all-adjacent-duplicates-in-string-ii/description/

class RemoveAllAdjacentDuplicatesInStringII {
    private Stack<Pair> stack;

    public String removeDuplicates(String s, int k) {
        boolean isTest = false;
        char[] letters = new char[0];
        int j = 0;
        int totalLetters = 0;
        stack = new Stack<>();

        for (char c: s.toCharArray()) {
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

        letters = new char[totalLetters];
        j = totalLetters - 1;

        if (totalLetters > 0) {
            while (!stack.isEmpty()) {
                Pair top = stack.pop();
                while (top.count-- > 0) {
                    letters[j--] = top.c;
                }
            }
        }
        if (isTest) {
            System.out.println("totalLetters: " + totalLetters + "\nletters: " + Arrays.toString(letters));
        }

        return new String(letters);
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
