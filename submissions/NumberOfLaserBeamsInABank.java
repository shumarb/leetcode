// Question: https://leetcode.com/problems/number-of-laser-beams-in-a-bank/description/

class NumberOfLaserBeamsInABank {
    public int numberOfBeams(String[] bank) {
        boolean isTest = false;
        int index = 0;
        int m = bank.length;
        int n = bank[0].length();
        int result = 0;
        int[] rowsWithLasers = new int[m];

        for (int i = 0; i < m; i++) {
            if (bank[i].indexOf('1') >= 0) {
                rowsWithLasers[index++] = i;
            }
        }
        if (isTest) {
            System.out.println("bank: " + Arrays.toString(bank));
            System.out.println("rows with lasers: " + Arrays.toString(rowsWithLasers));
            System.out.println("------------------------------------------");
        }

        for (int i = 0; i < index - 1; i++) {
            int current = rowsWithLasers[i];
            int next = rowsWithLasers[i + 1];
            int totalLaserBeams = count(bank[current], bank[next]);

            if (isTest) {
                System.out.println(" * " + current + " -> " + next + ": " + totalLaserBeams);
            }

            result += totalLaserBeams;
        }
        if (isTest) {
            System.out.println("------------------------------------------\nresult: " + result);
        }

        return result;
    }

    private int count(String first, String second) {
        char[] firstTokens = first.toCharArray();
        char[] secondTokens = second.toCharArray();
        int lasersInFirst = 0;
        int lasersInSecond = 0;

        for (char e: firstTokens) {
            if (e == '1') {
                lasersInFirst++;
            }
        }
        for (char e: secondTokens) {
            if (e == '1') {
                lasersInSecond++;
            }
        }

        return lasersInFirst * lasersInSecond;
    }
}
