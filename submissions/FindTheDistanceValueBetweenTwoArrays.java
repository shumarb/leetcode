// Question: https://leetcode.com/problems/find-the-distance-value-between-two-arrays/description/

class FindTheDistanceValueBetweenTwoArrays {
    private boolean isTest;

    public int findTheDistanceValue(int[] arr1, int[] arr2, int d) {
        int result = 0;
        isTest = false;

        arr2 = sort(arr2);
        if (isTest) {
            System.out.println("sorted arr2: " + Arrays.toString(arr2));
            System.out.println("----------------------------");
        }
        for (int element: arr1) {
            int closest = findClosest(element, arr2);
            if (isTest) {
                System.out.println(" ** element: " + element + ", closest: " + closest);
            }
            if (Math.abs(closest - element) > d) {
                result++;
            }
        }
        if (isTest) {
            System.out.println("----------------------------\nresult: " + result);
        }

        return result;
    }

    private int findClosest(int key, int[] arr) {
        /*
            1.  Edge cases: key <= minimum or >= maximum,
                so the closest element is either minimum or maximum accordingly.
        */
        int left = 0;
        int n = arr.length;
        int right = n - 1;

        if (key <= arr[0]) {
            return arr[0];
        } else if (key >= arr[n - 1]) {
            return arr[n - 1];
        }

        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (key == arr[mid]) {
                return key;
            } else if (key < arr[mid]) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        if (isTest) {
            System.out.println(" * key: " + key + " -> left: " + left + ", right: " + right);
        }

        return Math.abs(arr[left] - key) < Math.abs(arr[right] - key)
                ? arr[left] : arr[right];
    }

    private int[] sort(int[] arr) {
        int[] frequency = new int[2001];
        int j = 0;

        for (int number: arr) {
            frequency[number + 1000]++;
        }
        for (int i = 0; i <= 2000; i++) {
            while (frequency[i]-- > 0) {
                arr[j++] = i - 1000;
            }
        }

        return arr;
    }
}