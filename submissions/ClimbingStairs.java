// Question: https://leetcode.com/problems/climbing-stairs/description/

class ClimbingStairs {
    public int climbStairs(int n) {
        List<Integer> list = new ArrayList<>();
        boolean isTest = false;

        /**
            1. Only 1 way to get to step 0 (current step) to step 1.
         */
        if (n == 1) {
            return 1;
        }

        /**
             2.  1 way to get to step 0 (current step),
             and 1 way to reach step 1 from step 0 (climb 1 step).
         */
        list.add(1);
        list.add(1);
        for (int i = 2; i <= n; i++) {
            list.add(list.get(i - 1) + list.get(i - 2));
        }
        if (isTest) {
            System.out.println("n: " + n + "\nlist: " + list);
        }

        return list.get(list.size() - 1);
    }
}