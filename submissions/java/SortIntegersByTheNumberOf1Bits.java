// Question: https://leetcode.com/problems/sort-integers-by-the-number-of-1-bits/description/

class SortIntegersByTheNumberOf1Bits {
    public int[] sortByBits(int[] arr) {
        boolean isTest = false;
        Integer[] integerArr = new Integer[arr.length];

        /**
         1.  Create new array Integer wrapper objects,
         where each element is order as per arr
         as comparator works on objects and not primitive types.
         */
        int i = 0;
        for (int number: arr) {
            integerArr[i++] = number;
        }
        if (isTest) {
            System.out.println("integerArr: " + Arrays.toString(integerArr));
        }

        Arrays.sort(integerArr, (a, b) -> {
            int numBitsA = Integer.bitCount(a);
            int numBitsB = Integer.bitCount(b);
            if (numBitsA != numBitsB) {
                return numBitsA - numBitsB;
            } else {
                return a - b;
            }
        });
        if (isTest) {
            System.out.println("integerArr: " + Arrays.toString(integerArr));
        }

        i = 0;
        for (int number: integerArr) {
            arr[i++] = number;
        }
        if (isTest) {
            System.out.println("arr: " + Arrays.toString(arr));
        }

        return arr;
    }
}