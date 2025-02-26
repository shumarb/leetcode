// Question: https://leetcode.com/problems/sort-integers-by-the-number-of-1-bits/description/

class SortIntegersByTheNumberOf1Bits {
    public int[] sortByBits(int[] arr) {
        Arrays.sort(arr);
        List<int[]> sortedNumbers = new ArrayList();
        boolean isTest = false;

        for (int element: arr) {
            sortedNumbers.add(new int[] {element, Integer.bitCount(element)});
        }
        sortedNumbers.sort((e1, e2) -> e1[0] != e2[0] ? e1[1] - e2[1] : e1[0] - e2[0]);
        if (isTest) {
            System.out.println("before, nums: " + Arrays.toString(arr));
            System.out.print("sorted numbers: [");
            for (int i = 0; i < sortedNumbers.size() - 1; i++) {
                int[] current = sortedNumbers.get(i);
                System.out.print("(" + current[0] + ", " + current[1] + "), ");
            }
            int[] last = sortedNumbers.get(sortedNumbers.size() - 1);
            System.out.println("(" + last[0] + ", " + last[1] + ")]");
        }

        int i = 0;
        for (int[] current: sortedNumbers) {
            arr[i++] = current[0];
        }
        if (isTest) {
            System.out.println("after, nums: " + Arrays.toString(arr));
        }

        return arr;
    }
}