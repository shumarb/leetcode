// Question:

class AsteroidCollision {
    public int[] asteroidCollision(int[] asteroids) {
        Stack<Integer> stack = new Stack<>();
        boolean isTest = false;
        int[] result;
        int j;

        for (int incoming: asteroids) {
            if (isTest) {
                System.out.println("incoming: " + incoming);
                System.out.println(" * before: " + stack);
            }

            /**
             1.  No collision for empty stack,
                 incoming and top element travel in same direction,
                 or top element travels left and incoming travels right.
             */
            if (stack.isEmpty()
                    || (incoming < 0 && stack.peek() < 0)
                    || (incoming < 0 && stack.peek() < 0)
                    || incoming > 0 && stack.peek() < 0) {
                stack.push(incoming);

            } else {
                boolean isSurvive = true;
                int incomingStrength = Math.abs(incoming);

                while (!stack.isEmpty()) {
                    int top = stack.peek();
                    if ((top < 0 && incoming < 0)
                            || (top > 0 && incoming > 0)
                            || (top < 0 && incoming > 0)) {
                        break;
                    }

                    int topStrength = Math.abs(top);
                    if (topStrength == incomingStrength) {
                        isSurvive = false;
                        stack.pop();
                        break;

                    } else if (topStrength > incomingStrength) {
                        isSurvive = false;
                        break;

                    } else {
                        stack.pop();
                    }
                }
                if (isSurvive) {
                    stack.push(incoming);
                }
            }
            if (isTest) {
                System.out.println(" * after: " + stack);
                System.out.println("-----------------------------");
            }
        }

        j = stack.size() - 1;
        result = new int[stack.size()];
        while (!stack.isEmpty()) {
            result[j--] = stack.pop();
        }
        if (isTest) {
            System.out.println("result: " + Arrays.toString(result));
        }

        return result;
    }
}
