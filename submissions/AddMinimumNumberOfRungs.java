// Question: https://leetcode.com/problems/add-minimum-number-of-rungs/description/

class AddMinimumNumberOfRungs {
    public int addRungs(int[] rungs, int dist) {
        int count = 0;

        if (rungs[0] > dist) {
            count += ((rungs[0] - 1) / dist);
        }
        for (int i = 1; i < rungs.length; i++) {
            int current = rungs[i];
            int previous = rungs[i - 1];
            if (current - previous > dist) {
                count += ((current - previous - 1) / dist);
            }
        }

        return count;
    }
}