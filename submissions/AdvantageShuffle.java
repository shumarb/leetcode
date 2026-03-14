// Question: https://leetcode.com/problems/advantage-shuffle/description/

class AdvantageShuffle {
    public int[] advantageCount(int[] nums1, int[] nums2) {
        PriorityQueue<int[]> maxHeap = new PriorityQueue<>(
                (a, b) -> Integer.compare(b[0], a[0])
        );
        boolean isTest = false;
        int left = 0;
        int n = nums1.length;
        int right = n - 1;
        int[] result = new int[n];

        Arrays.sort(nums1);
        for (int i = 0; i < n; i++) {
            maxHeap.offer(new int[] {nums2[i], i});
        }
        if (isTest) {
            System.out.println("sorted nums1: " + Arrays.toString(nums1));
            System.out.println("max heap:");
            for (int[] e: maxHeap) {
                System.out.println(" * " + Arrays.toString(e));
            }
        }

        while (!maxHeap.isEmpty()) {
            int[] top = maxHeap.poll();
            int nums2Element = top[0];
            int nums2Index = top[1];
            if (isTest) {
                System.out.println("--------------------------------------------------------------\ncompare:");
                System.out.println(" * nums2 | " + nums2Element + " @ index " + nums2Index);
                System.out.println(" * nums1 | " + nums1[right] + " @ index " + right + " | " + nums1[left] + " @ index " + left);
                System.out.println(" ** before, result: " + Arrays.toString(result));
            }

            // 1. Compare largest-available element in nums1 with largest-available element in nums2
            result[nums2Index] = nums1[right] > nums2Element ? nums1[right--] : nums1[left++];
            if (isTest) {
                System.out.println(" ** after, result:  " + Arrays.toString(result));
            }
        }
        if (isTest) {
            System.out.println("--------------------------------------------------------------\nresult: " + Arrays.toString(result));
        }

        return result;
    }
}