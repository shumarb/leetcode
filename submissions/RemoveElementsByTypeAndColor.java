// Question: https://leetcode.com/problems/remove-elements-by-type-and-color/description/

class RemoveElementsByTypeAndColor {
    public boolean canRemoveAll(int[] types, int[] colors, int[] groupSize) {
        Stack<int[]> stack = new Stack<>();
        boolean isTest = false;
        int n = types.length;

        stack.push(new int[] {types[0], colors[0], 1});

        int currentSize = stack.peek()[2];
        int currentType = stack.peek()[0];
        if (groupSize[currentType] == currentSize) {
            if (isTest) {
                System.out.println(" ** remove");
            }

            stack.pop();

        }
        for (int i = 1; i < n; i++) {
            int incomingColor = colors[i];
            int incomingType = types[i];

            if (isTest) {
                System.out.println("i: " + i + "\n * incomingColor: "  + incomingColor + ", incomingType: " + incomingType);
                System.out.println("\n * before:");
                for (int[] e: stack) {
                    System.out.println(" - [t: " + e[0] + ", c: " + e[1] + ", s: " + e[2] + "]");
                }
            }

            if (stack.isEmpty() || stack.peek()[0] != incomingType || stack.peek()[1] != incomingColor) {
                stack.push(new int[] {incomingType, incomingColor, 1});

            } else {
                stack.peek()[2]++;
            }

            if (isTest) {
                System.out.println("\n * after:");
                for (int[] e: stack) {
                    System.out.println(" - [t: " + e[0] + ", c: " + e[1] + ", s: " + e[2] + "]");
                }
            }

            int[] top = stack.peek();
            currentSize = top[2];
            currentType = top[0];
            if (groupSize[currentType] == currentSize) {
                if (isTest) {
                    System.out.println(" ** remove");
                }

                stack.pop();
            }

            if (isTest) {
                System.out.println("\n * final stack before next round:");
                for (int[] e: stack) {
                    System.out.println(" - [t: " + e[0] + ", c: " + e[1] + ", s: " + e[2] + "]");
                }
                System.out.println("-----------------------------------------------");
            }
        }
        if (isTest) {
            System.out.println("final stack after all operations:");
            for (int[] e: stack) {
                System.out.println(" - [t: " + e[0] + ", c: " + e[1] + ", s: " + e[2] + "]");
            }
            System.out.println("-----------------------------------------------\nresult: " + stack.isEmpty());
        }

        return stack.isEmpty();
    }
}
