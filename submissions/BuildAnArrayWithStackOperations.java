// Question: https://leetcode.com/problems/build-an-array-with-stack-operations/description/

class BuildAnArrayWithStackOperations {
    public List<String> buildArray(int[] target, int n) {
        List<String> result = new ArrayList<>();
        int j = 0;

        for (int i = 1; j < target.length && i <= n; i++) {
            if (i == target[j]) {
                result.add("Push");
                j++;
            } else {
                result.add("Push");
                result.add("Pop");
            }
        }

        return result;
    }
}