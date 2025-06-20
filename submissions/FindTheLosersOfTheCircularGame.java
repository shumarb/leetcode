// Question: https://leetcode.com/problems/find-the-losers-of-the-circular-game/description/

class FindTheLosersOfTheCircularGame {
    public int[] circularGameLosers(int n, int k) {
        boolean[] isReceived = new boolean[n];
        boolean isTest = false;
        int[] result;
        int countReceived = 0;
        int current = 0;
        int turn = 1;

        while (!isReceived[current]) {
            if (isTest) {
                System.out.println(" * current: " + current);
            }
            isReceived[current] = true;
            countReceived++;

            current = (current + turn * k) % n;
            turn++;
            if (isTest) {
                System.out.println(" * next: " + current);
                System.out.println("isReceived: " + Arrays.toString(isReceived));
                System.out.println("------------------------------------");
            }
        }

        result = new int[n - countReceived];
        int j = 0;
        for (int i = 0; i < n; i++) {
            if (!isReceived[i]) {
                result[j++] = i + 1;
            }
        }
        if (isTest) {
            System.out.println("n: " + n + "\nk: " + k);
            System.out.println("isReceived: " + Arrays.toString(isReceived));
            System.out.println("result: " + Arrays.toString(result));
        }

        return result;
    }
}