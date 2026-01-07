// Question: https://leetcode.com/problems/add-minimum-number-of-rungs/description/

class AddMinimumNumberOfRungs {
    public int addRungs(int[] rungs, int dist) {
        int count = 0;
        int previous = 0;

        for (int i = 0; i < rungs.length; i++) {
            int current = rungs[i];
            if (current - previous > dist) {
                count += ((current - previous - 1) / dist);
            }
            previous = current;
        }

        return count;
    }
}