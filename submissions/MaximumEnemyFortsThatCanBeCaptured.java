// Question: https://leetcode.com/problems/maximum-enemy-forts-that-can-be-captured/description/

class MaximumEnemyFortsThatCanBeCaptured {
    public int captureForts(int[] forts) {
        boolean isTest = false;
        int n = forts.length;
        int previousIndex = -1; // store index of previous 1 or -1.
        int result = 0;

        for (int i = 0; i < n; i++) {
            if (forts[i] == 0) {
                continue;
            }

            if (previousIndex != -1 && forts[i] != forts[previousIndex]) {
                int countEnemyForts = i - previousIndex - 1;
                if (isTest) {
                    System.out.println(" * valid: [" + previousIndex + ", " + i + "]: " + countEnemyForts);
                }
                result = Math.max(countEnemyForts, result);
            }

            previousIndex = i;
        }
        if (isTest) {
            System.out.println("--------------------------------------------\nresult: " + result);
        }

        return result;
    }
}
