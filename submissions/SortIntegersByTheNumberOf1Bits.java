// Question: https://leetcode.com/problems/sort-integers-by-the-number-of-1-bits/description/

class SortIntegersByTheNumberOf1Bits {
    public int[] sortByBits(int[] arr) {
        Integer[] values = new Integer[arr.length];
        boolean isTest = false;
        int n = arr.length;

        for (int i = 0; i < n; i++) {
            values[i] = arr[i];
        }
        if (isTest) {
            System.out.println("before, arr: " + Arrays.toString(arr));
        }

        Arrays.sort(values,
                (a, b) -> Integer.compare(Integer.bitCount(a), Integer.bitCount(b)) == 0
                        ? Integer.compare(a, b)
                        : Integer.compare(Integer.bitCount(a), Integer.bitCount(b))
        );
        for (int i = 0; i < n; i++) {
            arr[i] = values[i];
        }
        if (isTest) {
            System.out.println("after, arr:  " + Arrays.toString(arr));
        }

        return arr;
    }
}