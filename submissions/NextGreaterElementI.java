// Question: https://leetcode.com/problems/next-greater-element-i/description/

class NextGreaterElementI {
    private boolean isTest;

    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        int m = nums1.length;
        int[] nextGreater = getNextGreater(nums2);
        int[] result = new int[m];
        isTest = false;

        for (int i = 0; i < m; i++) {
            result[i] = nextGreater[nums1[i]];
        }
        if (isTest) {
            System.out.println("----------------------------------------------\nnextGreater: " + Arrays.toString(nextGreater) + "\nresult: " + Arrays.toString(result));
        }

        return result;
    }

    private int[] getNextGreater(int[] nums) {
        Stack<Integer> stack = new Stack<>();
        int[] result;
        int largest = 0;
        int n = nums.length;

        for (int e: nums) {
            largest = Math.max(e, largest);
        }
        result = new int[largest + 1];
        Arrays.fill(result, -1);
        if (isTest) {
            System.out.println("----------------------------------------------\nnums2: " + Arrays.toString(nums));
        }
        for (int i = n - 1; i >= 0; i--) {
            if (isTest) {
                System.out.println("incoming | i: " + i + " | e: " + nums[i] + "\n * before, stack: " + stack);
            }
            int element = nums[i];

            while (!stack.isEmpty() && nums[stack.peek()] <= element) {
                stack.pop();
            }
            if (!stack.isEmpty()) {
                result[element] = nums[stack.peek()];
            }

            if (isTest) {
                System.out.println(" * after, stack: " + stack + " | result: " + Arrays.toString(result) + "\n");
            }

            stack.push(i);
        }

        return result;
    }
}
