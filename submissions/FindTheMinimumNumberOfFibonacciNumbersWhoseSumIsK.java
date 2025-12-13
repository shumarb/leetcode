// Question: https://leetcode.com/problems/find-the-minimum-number-of-fibonacci-numbers-whose-sum-is-k/description/

class FindTheMinimumNumberOfFibonacciNumbersWhoseSumIsK {
    public int findMinFibonacciNumbers(int k) {
        List<Integer> list = new ArrayList<>();
        boolean isTest = false;
        int count = 0;
        int fibonacci = 2;

        list.add(1);
        list.add(1);
        while (fibonacci <= k) {
            list.add(fibonacci);
            int n = list.size();
            fibonacci = list.get(n - 2) + list.get(n - 1);
        }
        for (int i = list.size() - 1; i >= 0; i--) {
            int current = list.get(i);
            if (current <= k) {
                k -= current;
                count++;
            }
            if (k == 0) {
                break;
            }
        }
        if (isTest) {
            System.out.println("list: " + list + "\ncount: " + count);
        }

        return count;
    }
}