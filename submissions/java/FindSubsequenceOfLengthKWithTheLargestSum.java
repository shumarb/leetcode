// Question: https://leetcode.com/problems/find-subsequence-of-length-k-with-the-largest-sum/description/

class FindSubsequenceOfLengthKWithTheLargestSum {
    public int[] maxSubsequence(int[] nums, int k) {
        int[] result = new int[k];
        List<int[]> list = new ArrayList<>();
        boolean isTest = false;

        for (int i = 0; i < nums.length; i++) {
            list.add(new int[] {nums[i], i});
        }
        if (isTest) {
            displayList("list before sort: ", list);
        }

        /**
         1.  Sort list in descending order of element and ascending order of index
         to preserve order of elements.
         */
        list.sort((a, b) -> b[0] - a[0]);
        if (isTest) {
            displayList("list after sort: ", list);
        }

        // 2. Retrieve largest k elements whilst preserving order.
        List<int[]> topKElements = list.subList(0, k);
        if (isTest) {
            displayList("top k elements: ", list);
        }

        /**
         3.  Sort k elements in ascending order of value whilst preserving order,
         an populate result array accordingly.
         */
        topKElements.sort((a, b) -> a[1] - b[1]);
        for (int i = 0; i < k; i++) {
            result[i] = topKElements.get(i)[0];
        }
        if (isTest) {
            System.out.println("result: " + Arrays.toString(result));
        }

        return result;
    }

    private void displayList(String str, List<int[]> list) {
        System.out.println(str);
        for (int i = 0; i < list.size(); i++) {
            int[] array = list.get(i);
            if (i != list.size() - 1) {
                System.out.print(Arrays.toString(array) + ", ");
            } else {
                System.out.print(Arrays.toString(array));
            }
        }
        System.out.println();
        System.out.println("------------------------------------------------------------------------");
    }
}