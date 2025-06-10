// Question: https://leetcode.com/problems/alternating-groups-i/description/

class AlternatingGroupsOne {
    public int numberOfAlternatingGroups(int[] colors) {
        boolean isTest = false;
        int count = 0;
        int len = colors.length;

        if (colors[len - 2] != colors[len - 1] && colors[len - 1] != colors[0] && colors[len - 2] == colors[0]) {
            if (isTest) {
                System.out.println(" * check: " + (len - 2) + ", " + (len - 1) + ", 0");
            }
            count++;
        }
        if (colors[len - 1] != colors[0] && colors[len - 1] == colors[1] && colors[0] != colors[1]) {
            if (isTest) {
                System.out.println(" * check: " + (len - 1) + ", 0, 1");
            }
            count++;
        }
        for (int i = 0; i <= len - 3; i++) {
            if (colors[i] != colors[i + 1] && colors[i] == colors[i + 2] && colors[i + 1] != colors[i + 2]) {
                if (isTest) {
                    System.out.println(" * check: " + i + ", " + (i + 1) + ", " + (i + 2));
                }
                count++;
            }
        }

        return count;
    }
}