// Question: https://leetcode.com/problems/next-greater-element-i/description/

class NextGreaterElementOne {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        Map<Integer, Integer> map = new HashMap<>();
        Stack<Integer> stack = new Stack<>();
        boolean isTest = false;

        // 1. Map will contain mapping of an element and its next greater element
        // Eg: [1 3 4 2] ==> map: {1=3, 3=4}
        for (Integer element: nums2) {
            // 1.1. Keep removing all elements from stack until first greater element
            // than current element is found
            while (!stack.isEmpty() && stack.peek() < element) {
                map.put(stack.pop(), element);
            }
            stack.push(element);
        }
        if (isTest) {
            System.out.println("nums1: " + Arrays.toString(nums1) + ", nums2: " + Arrays.toString(nums2) + "\nmap: " + map);
        }

        // 2. Iterate through all elements in nums1 and check if its element is in the map.
        // If yes, that means there exists a first greater element to the right of the current element,
        // else there is no first greater element to the right of the current element.
        int len = nums1.length;
        int[] ans = new int[len];
        for (int i = 0; i < len; i++) {
            ans[i] = map.getOrDefault(nums1[i], -1);
        }

        if (isTest) {
            System.out.println("ans: " + Arrays.toString(ans));
        }
        return ans;
    }
}