// Question: https://leetcode.com/problems/alternating-groups-i/description/

class AlternatingGroupsOne {
    public int numberOfAlternatingGroups(int[] colors) {
        boolean isTest = false;
        int count = 0;
        int i = 1;
        int len = colors.length;

        if (isTest) {
            System.out.println("colors: " + Arrays.toString(colors));
            System.out.println("----------------------------------------------------------------");
            System.out.println("compare indices: " + (len - 1) + ", 0, 1");
        }
        if (colors[len - 1] != colors[0] && colors[0] != colors[1]) {
            count++;
        }

        if (isTest) {
            System.out.println("compare indices: " + (len - 2) + ", " + (len - 1) + ", 0");
            System.out.println("----------------------------------------------------------------");
        }
        if (colors[len - 2] != colors[len - 1] && colors[len - 1] != colors[0]) {
            count++;
        }

        while (i < len - 1) {
            if (isTest) {
                System.out.println("compare indices: " + (i - 1) + ", " + i + ", " + (i + 1));
            }
            if (colors[i - 1] != colors[i] && colors[i] != colors[i + 1]) {
                count++;
            }
            i++;
        }

        return count;
    }
}