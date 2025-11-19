// Question: https://leetcode.com/problems/combination-sum-iii/description/

class CombinationSumThree {
    private List<List<Integer>> result;
    private boolean isTest;
    private int[] numbers;
    private int k;
    private int n;

    public List<List<Integer>> combinationSum3(int k, int n) {
        isTest = false;
        numbers = new int[9];
        result = new ArrayList<>();
        this.k = k;
        this.n = n;

        for (int i = 0; i < numbers.length; i++) {
            numbers[i] = i + 1;
        }
        if (isTest) {
            System.out.println("numbers: " + Arrays.toString(numbers));
            System.out.println("k: " + k + "\nn: " + n);
        }

        helper(new ArrayList<>(), 0, 0);
        if (isTest) {
            System.out.println("-----------------------------\nresult:");
            for (List<Integer> e: result) {
                System.out.println(e);
            }
        }

        return result;
    }

    private void helper(List<Integer> list, int i, int sum) {
        if (isTest) {
            System.out.println("-----------------------------\nlist: " + list);
        }

        if (sum == n && list.size() == k) {
            if (isTest) {
                System.out.println(" ** add: " + list);
            }
            result.add(new ArrayList<>(list));
            return;
        }

        for (int j = i; j < numbers.length; j++) {
            int current = numbers[j];
            if (list.size() < k && sum + current <= n) {
                list.add(current);
                helper(list, j + 1, sum + current);
                list.removeLast();
            }
        }
    }
}