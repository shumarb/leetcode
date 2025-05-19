// Question: https://leetcode.com/problems/positions-of-large-groups/description/

class PositionsOfLargeGroups {
    public List<List<Integer>> largeGroupPositions(String s) {
        List<List<Integer>> result = new ArrayList<>();
        boolean isTest = false;
        int i = 0;
        int len = s.length();

        while (i < len) {
            int j = i;
            while (j < len && s.charAt(j) == s.charAt(i)) {
                j++;
            }
            if (isTest) {
                System.out.println("i: " + i + ", j: " + j);
            }
            if (j - i >= 3) {
                result.add(Arrays.asList(i, j - 1));
            }
            i = j;
        }

        if (isTest) {
            System.out.println("result:");
            for (List<Integer> entry: result) {
                System.out.println(entry);
            }
        }

        return result;
    }
}