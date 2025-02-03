// Question: https://leetcode.com/problems/sort-an-array/description/

class SortAnArray {
    private boolean t = false;

    public int[] sortArray(int[] nums) {
        if (isSorted(nums)) {
            return nums;
        }

        if (t) {
            System.out.println("nums: " + Arrays.toString(nums));
            System.out.println("---------------------------------");
            System.out.println("heapify:\n");
        }

        int n = nums.length;

        // 1. Build max heap
        for (int i = (n - 1) / 2; i >= 0; i--) {
            heapify(nums, n, i);
        }
        if (t) {
            System.out.println("---------------------------------");
            System.out.println("after heapify, nums: " + Arrays.toString(nums));
            System.out.println("---------------------------------");
            System.out.println("heap sort | nums: " + Arrays.toString(nums) + "\n");
        }

        // 2. Heap sort
        for (int i = n - 1; i > 0; i--) {
            swap(nums, i, 0);
            heapify(nums, i, 0);
        }

        if (t) {
            System.out.println("---------------------------------");
            System.out.println("after heap sort, nums: " + Arrays.toString(nums));
        }
        return nums;
    }

    private void heapify(int[] n, int heapSize, int i) {
        int largest = i;
        int left = 2 * i + 1;
        int right = 2 * i + 2;
        if (t) {
            System.out.println("indices | largest: " + largest + ", left: " + left + ", right: " + right);
        }

        if (left < heapSize && n[left] > n[largest]) {
            largest = left;
        }
        if (right < heapSize && n[right] > n[largest]) {
            largest = right;
        }
        if (largest != i) {
            if (t) {
                System.out.println("swap | indices: [" + i + ", " + largest + "] | elements: " + n[largest] + ", " + n[i]);
            }
            swap(n, i, largest);
            heapify(n, heapSize, largest);
        }
    }

    private boolean isSorted(int[] n) {
        for (int i = 0; i < n.length - 1; i++) {
            int j = i + 1;
            if (n[j] < n[i]) {
                return false;
            }
        }
        return true;
    }

    private void swap(int[] n, int a, int b) {
        int temp = n[a];
        n[a] = n[b];
        n[b] = temp;
    }
}