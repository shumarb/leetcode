// Question:

class NextGreaterElementOne {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        boolean t = false;
        Map<Integer, Integer> indexMap = new HashMap<>();
        int max = getMax(nums2);
        for (int i = 0; i < nums2.length; i++) {
            indexMap.put(nums2[i], i);
        }
        if (t) {
            System.out.println("nums1: " + Arrays.toString(nums1));
            System.out.println("nums2: " + Arrays.toString(nums2));
            System.out.println("max in nums2: " + max);
            System.out.println("indexMap of nums2: " + indexMap);
        }

        for (int i = 0; i < nums1.length; i++) {
            if (nums1[i] == max) {
                nums1[i] = -1;
            } else {
                nums1[i] = findGreater(nums1[i], indexMap, nums2);
            }
        }
        if (t) {
            System.out.println("final nums1: " + Arrays.toString(nums1));
        }
        return nums1;
    }

    private int findGreater(int elem, Map<Integer, Integer> map, int[] arr) {
        int startIndex = map.get(elem);
        for (int i = startIndex + 1; i < arr.length; i++) {
            if (arr[i] > elem) {
                return arr[i];
            }
        }
        return -1;
    }

    private int getMax(int[] n) {
        int max = n[0];
        for (int x: n) {
            max = Math.max(max, x);
        }
        return max;
    }
}