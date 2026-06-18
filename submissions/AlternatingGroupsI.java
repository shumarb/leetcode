// Question: https://leetcode.com/problems/alternating-groups-i/description/

class AlternatingGroupsI {
    public int numberOfAlternatingGroups(int[] colors) {
        int n = colors.length;
        int result = 0;

        if (colors[0] != colors[1] && colors[0] != colors[n - 1]) {
            result++;
        }
        if (colors[n - 1] != colors[n - 2] && colors[n - 1] != colors[0]) {
            result++;
        }
        for (int i = 1; i < n - 1; i++) {
            if (colors[i] != colors[i - 1] && colors[i] != colors[i + 1]) {
                result++;
            }
        }

        return result;
    }
}
