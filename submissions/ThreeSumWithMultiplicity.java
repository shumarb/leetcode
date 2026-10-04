// Question: https://leetcode.com/problems/3sum-with-multiplicity/description/

class ThreeSumWithMultiplicity {
    private int[] arr;

    public int threeSumMulti(int[] arr, int target) {
        boolean isTest = false;
        int[] count = new int[101];
        int largest = 0;
        int n = arr.length;
        long mod = 1000000007;
        long result = 0;
        this.arr = arr;

        sort();
        for (int e: arr) {
            count[e]++;
            largest = Math.max(e, largest);
        }
        if (isTest) {
            System.out.println("target: " + target + "\narr: " + Arrays.toString(arr) + "\ncount: " + Arrays.toString(Arrays.copyOfRange(arr, 0, largest + 1)));
            System.out.println("----------------------------------------------------------------");
        }

        for (int i = 0; i <= n - 3; i++) {
            if (i > 0 && arr[i] == arr[i - 1]) {
                continue;
            }

            int j = i + 1;
            int k = n - 1;
            int key = target - arr[i];

            while (j < k) {
                int sum = arr[j] + arr[k];

                if (sum == key) {
                    int[] triplet = new int[3];
                    triplet[0] = arr[i];
                    triplet[1] = arr[j];
                    triplet[2] = arr[k];

                    long totalTuples = countTuples(count, triplet);
                    result = (result + totalTuples) % mod;
                    if (isTest) {
                        System.out.println(" * indices: [" + i + ", " + j + ", " + k + "] | triplet: " + Arrays.toString(triplet) + " | totalTuples: " + totalTuples);
                    }

                    // 1. Get to last and duplicates of j-th and k-th elements respectively, then increment and decrement each for new pair of numbers for next search. eg: [-5, 1, 4] found, so next valid j-th and k-th pairs is 2 & 3 respectively so that [-5 2 3] is valid 3Sum.
                    while (j < k && arr[j] == arr[j + 1]) {
                        j++;
                    }

                    while (j < k && arr[k] == arr[k - 1]) {
                        k--;
                    }

                    j++;
                    k--;

                } else if (sum < key) {
                    j++;

                } else {
                    k--;
                }
            }
        }
        if (isTest) {
            System.out.println("----------------------------------------------------------------\nresult: " + result);
        }

        return (int) result;
    }

    private long countTuples(int[] count, int[] triplet) {
        int first = triplet[0];
        int second = triplet[1];
        int third = triplet[2];
        long n;

        if (first == second && second == third) {
            n = count[first];
            return (n * (n - 1) * (n - 2)) / 6l;
        }

        if (first == second) {
            n = count[first];
            return ((long) count[third] * n * (n - 1)) / 2l;
        }

        if (second == third) {
            n = count[second];
            return ((long) count[first] * n * (n - 1)) / 2l;
        }

        return count[first] * count[second] * count[third];
    }

    private void sort() {
        int[] count = new int[101];
        int j = 0;

        for (int e: arr) {
            count[e]++;
        }
        for (int i = 0; i < count.length; i++) {
            while (count[i]-- > 0) {
                arr[j++] = i;
            }
        }
    }
}
