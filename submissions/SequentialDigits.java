// Question: https://leetcode.com/problems/sequential-digits/description/

class SequentialDigits {
    private List<Integer> result;
    private boolean isTest;
    private int high;
    private int low;

    public List<Integer> sequentialDigits(int low, int high) {
        isTest = false;
        result = new ArrayList<>();
        this.high = high;
        this.low = low;

        for (int i = 1; i <= 9; i++) {
            if (isTest) {
                System.out.println("------------------------------");
            }
            dfs(i, 0);
        }
        Collections.sort(result);

        return result;
    }

    private void dfs(int digit, int value) {
        if (isTest) {
            System.out.println(" * digit: " + digit + " | value: " + value);
        }

        int next = value * 10 + digit;

        if (digit > 9 || next > high) {
            return;
        }

        if (next >= low) {
            if (isTest) {
                System.out.println(" ** valid: " + next);
            }

            result.add(next);
        }

        dfs(digit + 1, next);

    }
}
