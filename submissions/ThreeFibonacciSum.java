// Question: https://leetcode.com/contest/weekly-contest-523/problems/three-fibonacci-sum/

class ThreeFibonacciSum {
    public boolean threeFibonacciSum(int n) {
        if (n <= 1) {
            return false;
        }

        List<Integer> list = new ArrayList<>();
        boolean isTest = false;
        int k = 3;
        int limit = 0;
        int sum = 0;

        list.add(0);
        list.add(1);
        while (limit <= n) {
            int total = list.size();
            limit = list.get(total - 1) + list.get(total - 2);
            list.add(limit);
        }
        if (isTest) {
            System.out.println("n: " + n + "\nlimit: " + limit + "\nlist: " + list);
        }

        for (int i = 0; i <= list.size() - 3; i++) {
            int first = list.get(i);
            int second = list.get(i + 1);
            int third = list.get(i + 2);

            if (first + second + third == n) {
                if (isTest) {
                    System.out.println(" * indices: [" + i + ", " + (i + 1) + ", " + (i + 2) + "] | elements: [" + first + ", " + second + ", " + third + "]");
                }
                return true;
            }
        }

        return false;
    }
}
