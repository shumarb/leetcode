// Question: https://leetcode.com/problems/minimum-absolute-difference/description/

class MinimumAbsoluteDifference {
    public List<List<Integer>> minimumAbsDifference(int[] arr) {
        List<List<Integer>> result = new ArrayList<>();
        boolean isTest = false;
        int minimumAbsoluteDifference = Integer.MAX_VALUE;

        Arrays.sort(arr);
        for (int i = 1; i < arr.length; i++) {
            int currentDifference = arr[i] - arr[i - 1];
            if (currentDifference <= minimumAbsoluteDifference) {
                if (currentDifference < minimumAbsoluteDifference) {
                    minimumAbsoluteDifference = currentDifference;
                    result.clear();
                }
                result.add(Arrays.asList(arr[i - 1], arr[i]));
            }
        }
        if (isTest) {
            System.out.println("result:");
            for (List<Integer> entry: result) {
                System.out.println(" * " + entry);
            }
        }

        return result;
    }
}