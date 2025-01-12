class KthMissingPositiveNumber {
    public int findKthPositive(int[] arr, int k) {
        int last = arr[arr.length - 1];
        boolean t = false;
        boolean[] missingInArr = new boolean[last + 1];
        Arrays.fill(missingInArr, true);
        for (int i = 0; i < arr.length; i++) {
            missingInArr[arr[i]] = false;
        }
        if (t) {
            System.out.println("arr: " + Arrays.toString(arr));
            System.out.println("missingInArr: " + Arrays.toString(missingInArr));
        }

        int count = 0;
        int kthMissing = 0;
        for (int i = 1; i <= last; i++) {
            if (missingInArr[i]) {
                count++;
            }
            if (count == k) {
                kthMissing = i;
                break;
            }
        }

        int start = last + 1;
        while (count != k) {
            kthMissing = start;
            count += 1;
            if (count == k) {
                break;
            }
            start += 1;
        }

        return kthMissing;
    }
}