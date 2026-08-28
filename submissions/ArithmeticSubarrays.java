// Question:

class ArithmeticSubarrays {
    public List<Boolean> checkArithmeticSubarrays(int[] nums, int[] l, int[] r) {
        List<Boolean> result = new ArrayList<>();
        boolean isTest = false;
        int m = l.length;

        if (isTest) {
            System.out.println("nums: " + Arrays.toString(nums));
            System.out.println("------------------------------------------------------------");
        }
        for (int i = 0; i < m; i++) {
            int j = 0;
            int left = l[i];
            int right = r[i];
            int totalElements = right - left + 1;
            int[] values = new int[totalElements];

            if (totalElements == 1) {
                result.add(false);
                continue;
            }

            for (int k = left; k <= right; k++) {
                values[j++] = nums[k];
            }

            Arrays.sort(values);
            boolean isArithmetic = true;
            int difference = values[1] - values[0];

            if (isTest) {
                System.out.print(" * indices range: [" + left + ", " + right + "] | values: " + Arrays.toString(values));
            }
            for (j = 1; j < totalElements; j++) {
                if (values[j] - values[j - 1] != difference) {
                    isArithmetic = false;
                    break;
                }
            }

            result.add(isArithmetic);
        }
        if (isTest) {
            System.out.println("------------------------------------------------------------\nresult: " + result);
        }

        return result;
    }
}
