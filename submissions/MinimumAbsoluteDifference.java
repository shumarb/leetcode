// Question: https://leetcode.com/problems/minimum-absolute-difference/description/

class MinimumAbsoluteDifference {
    public List<List<Integer>> minimumAbsDifference(int[] arr) {
        List<List<Integer>> result = new ArrayList<>();
        boolean isTest = false;

        Arrays.sort(arr);
        int minimumAbsoluteDifference = Integer.MAX_VALUE;
        for (int i = 1; i < arr.length; i++) {
            int currentDifference = arr[i] - arr[i - 1];
            if (currentDifference < minimumAbsoluteDifference) {
                minimumAbsoluteDifference = currentDifference;
                result.clear();
                result.add(Arrays.asList(arr[i - 1], arr[i]));
            } else if (currentDifference == minimumAbsoluteDifference) {
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