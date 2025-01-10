class KthMissingPositiveNumber {
    public int findKthPositive(int[] arr, int k) {
        int[] nums = new int[arr[arr.length - 1] + 1];
        List<Integer> missing = new ArrayList<> ();
        boolean t = false;
        for (int x: arr) {
            nums[x] = 1;
        }
        if (t) {
            System.out.println("arr: " + Arrays.toString(arr));
            System.out.println("nums: " + Arrays.toString(nums));
        }

        // 1. Check if kth missing is within arr)
        for (int i = 1; i <= nums.length - 1; i++) {
            // 1. Missing number found, increase count by 1
            if (nums[i] == 0) {
                if (t) {
                    System.out.println("adding " + i);
                }
                missing.add(i);
                if (missing.size() == k) {
                    return i;
                }
            }
        }
        if (t) {
            System.out.println("missing: " + missing);
        }

        // At this point, number of missing numbers accumulated < k
        // so starting from last element of arr, keep on adding until k numbers of missing obtained
        int num = arr[arr.length - 1] + 1;
        if (t) {
            System.out.println("start from " + num);
        }

        while (missing.size() != k) {
            missing.add(num);
            if (missing.size() == k) {
                break;
            }
            num += 1;
        }
        if (t) {
            System.out.println("missing: " + missing);
        }

        return num;
    }
}