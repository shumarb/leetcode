// Question: https://leetcode.com/problems/add-minimum-number-of-rungs/description/

class AddMinimumNumberOfRungs {
    public int addRungs(int[] rungs, int dist) {
        int count = 0;
        int previous = 0;

        for (int rung: rungs) {
            int difference = rung - previous;
            count += ((difference - 1) / dist);
            previous = rung;
        }

        return count;
    }
}