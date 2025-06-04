// Question: https://leetcode.com/problems/find-k-closest-elements/description/

class FindKClosestElements {
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        boolean isTest = false;
        if (isTest) {
            System.out.println("arr: " + Arrays.toString(arr) + "\nk: " + k + "\nx: " + x);
        }

        List<Integer> result = new ArrayList<>();
        if (k == arr.length) {
            for (int number: arr) {
                result.add(number);
            }
            return result;
        }

        int left = 0;
        int right = arr.length - 1;
        while (right - left >= k) {
            if (Math.abs(arr[left] - x) > Math.abs(arr[right] - x)) {
                left++;
            } else {
                right--;
            }
        }

        for (int i = left; i <= right; i++) {
            result.add(arr[i]);
        }
        if (isTest) {
            System.out.println("result: " + result);
        }

        return result;
    }
}