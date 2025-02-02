// Question: https://leetcode.com/problems/rank-transform-of-an-array/description/

class RankTransformOfAnArray {
    public int[] arrayRankTransform(int[] arr) {
        boolean isTest = false;
        Map<Integer, Integer> rankMap = new HashMap<>();
        if (isTest) {
            System.out.println("arr: " + Arrays.toString(arr));
        }

        int[] arrCopy = Arrays.copyOf(arr, arr.length);
        Arrays.sort(arrCopy);
        if (isTest) {
            System.out.println("sorted arrCopy: " + Arrays.toString(arrCopy));
        }

        int rank = 1;
        for (int element: arrCopy) {
            if (!rankMap.containsKey(element)) {
                rankMap.put(element, rank++);
            }
        }
        if (isTest) {
            System.out.println("rankMap: " + rankMap);
        }

        for (int i = 0; i < arr.length; i++) {
            arr[i] = rankMap.get(arr[i]);
        }
        if (isTest) {
            System.out.println("rank transform: " + Arrays.toString(arr));
        }
        return arr;
    }
}