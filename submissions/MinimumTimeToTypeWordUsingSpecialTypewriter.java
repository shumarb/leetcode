// Question: https://leetcode.com/problems/minimum-time-to-type-word-using-special-typewriter/description/

class MinimumTimeToTypeWordUsingSpecialTypewriter {
    public int minTimeToType(String word) {
        boolean isTest = false;
        char previous = 'a';
        int result = 0;

        for (char current: word.toCharArray()) {
            int clockwise = Math.abs((current - previous) % 26);

            if (isTest) {
                System.out.println("previous: " + previous + ", current: " + current);
                System.out.println(" * clockwise | " + previous + " ==> " + current + ": " + clockwise);
                System.out.println(" * anticlockwise |  " + current + " ==> " + previous + ": " + (26 - clockwise));
                System.out.println("----------------------------------------------");
            }

            // 1. Increase result by minimum steps from clockwise and anticlockwise directions.
            result += Math.min(clockwise, 26 - clockwise);

            // 2. Increase result by time taken to type letter.
            ++result;
            previous = current;
        }
        if (isTest) {
            System.out.println("result: " + result);
        }

        return result;
    }
}