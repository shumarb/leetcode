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
            dfs(i, 0);
            if (isTest) {
                System.out.println("------------------------------");
            }
        }
        Collections.sort(result);
        if (isTest) {
            System.out.println("result: " + result);
        }

        return result;
    }

    private void dfs(int digit, int value) {
        value = value * 10 + digit;

        if (digit == 10 || value > high) {
            return;
        }

        if (isTest) {
            System.out.println(" * digit: " + digit + " | value: " + value);
        }

        if (value >= low) {
            if (isTest) {
                System.out.println(" ** valid");
            }

            result.add(value);
        }

        dfs(digit + 1, value);
    }
}
