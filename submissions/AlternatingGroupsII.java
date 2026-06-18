// Question: https://leetcode.com/problems/alternating-groups-ii/description/

class AlternatingGroupsII {
    public int numberOfAlternatingGroups(int[] colors, int k) {
        boolean isTest = false;
        int alternatingLength = 1;
        int n = colors.length;
        int result = 0;

        for (int i = 1; i < n + k - 1; i++) {
            int current = colors[i % n];
            int previous = colors[(i - 1) % n];

            if (isTest) {
                System.out.println("--------------------------\ncurrent: " + current + "| index: " + i % n);
                System.out.println("previous: " + previous + "| index: " + (i - 1) % n);
            }

            alternatingLength = current != previous ? alternatingLength + 1 : 1;
            if (alternatingLength >= k) {
                if (isTest) {
                    System.out.println(" * valid @ start index of " + i % n);
                }
                result++;
            }
        }
        if (isTest) {
            System.out.println("--------------------------\nresult: " + result);
        }

        return result;
    }
}
