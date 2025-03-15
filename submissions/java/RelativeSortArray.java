// Question: https://leetcode.com/problems/relative-sort-array/description/

class RelativeSortArray {
    public int[] relativeSortArray(int[] arr1, int[] arr2) {
        boolean isTest = false;

        int maximum = Integer.MIN_VALUE;
        for (int number: arr1) {
            maximum = Math.max(maximum, number);
        }
        for (int number: arr2) {
            maximum = Math.max(maximum, number);
        }

        int[] arr1NumberFrequency = new int[maximum + 1];
        int[] arr2NumberFrequency = new int[maximum + 1];
        for (int number: arr1) {
            arr1NumberFrequency[number]++;
        }
        for (int number: arr2) {
            arr2NumberFrequency[number]++;
        }
        if (isTest) {
            System.out.println("arr1:                " + Arrays.toString(arr1));
            System.out.println("arr1NumberFrequency: " + Arrays.toString(arr1NumberFrequency));
            System.out.println("arr2:                " + Arrays.toString(arr2));
            System.out.println("arr2NumberFrequency: " + Arrays.toString(arr2NumberFrequency));
        }

        int j = 0;
        for (int i = 0; i < arr2.length; i++) {
            int currentElement = arr2[i];
            int count = arr1NumberFrequency[currentElement];
            while (count > 0) {
                arr1[j++] = currentElement;
                count--;
            }
        }
        if (isTest) {
            System.out.println("----------------------------------------------------------------------");
            System.out.println(" * so far, arr1:                " + Arrays.toString(arr1) + ", j: " + j);
        }

        for (int k = 0; k < arr1NumberFrequency.length; k++) {
            if (arr1NumberFrequency[k] > 0 && arr2NumberFrequency[k] == 0) {
                while (arr1NumberFrequency[k] > 0) {
                    arr1[j++] = k;
                    arr1NumberFrequency[k]--;
                }
            }
        }
        if (isTest) {
            System.out.println("final arr1:                " + Arrays.toString(arr1));
        }

        return arr1;
    }
}