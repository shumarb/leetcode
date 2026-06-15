// Question: https://leetcode.com/problems/number-of-laser-beams-in-a-bank/description/

class NumberOfLaserBeamsInABank {
    public int numberOfBeams(String[] bank) {
        List<Integer> rowsWithLasers = new ArrayList<>();
        boolean isTest = false;
        int m = bank.length;
        int n = bank[0].length();
        long result = 0;

        for (int i = 0; i < m; i++) {
            if (bank[i].indexOf('1') >= 0) {
                rowsWithLasers.add(i);
            }
        }
        if (isTest) {
            System.out.println("bank: " + Arrays.toString(bank));
            System.out.println("rows with lasers: " + rowsWithLasers);
            System.out.println("------------------------------------------");
        }

        for (int i = 0; i < rowsWithLasers.size() - 1; i++) {
            int current = rowsWithLasers.get(i);
            int next = rowsWithLasers.get(i + 1);
            long totalLaserBeams = count(bank[current].toCharArray(), bank[next].toCharArray());

            if (isTest) {
                System.out.println(" * " + current + " -> " + next + ": " + totalLaserBeams);
            }

            result += totalLaserBeams;
        }
        if (isTest) {
            System.out.println("------------------------------------------\nresult: " + result);
        }

        return (int) result;
    }

    private long count(char[] first, char[] second) {
        long lasersInFirst = 0;
        long lasersInSecond = 0;

        for (char e: first) {
            if (e == '1') {
                lasersInFirst++;
            }
        }
        for (char e: second) {
            if (e == '1') {
                lasersInSecond++;
            }
        }

        return lasersInFirst * lasersInSecond;
    }
}
