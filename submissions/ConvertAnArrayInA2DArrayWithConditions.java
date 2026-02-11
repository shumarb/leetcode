// Question: https://leetcode.com/problems/convert-an-array-into-a-2d-array-with-conditions/description/

class ConvertAnArrayInA2DArrayWithConditions {
    public List<List<Integer>> findMatrix(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        boolean isTest = false;
        int[] count;
        int largest = 0;

        for (int e: nums) {
            largest = Math.max(e, largest);
        }
        count = new int[largest + 1];
        for (int e: nums) {
            count[e]++;
        }

        while (isValid(count)) {
            List<Integer> newRow = new ArrayList<>();
            for (int i = 1; i <= largest; i++) {
                if (count[i] > 0) {
                    newRow.add(i);
                    count[i]--;
                }
            }
            result.add(newRow);
        }
        if (isTest) {
            System.out.println("result:");
            for (List<Integer> e: result) {
                System.out.println(" * " + e);
            }
        }

        return result;
    }

    private boolean isValid(int[] count) {
        for (int i = 1; i < count.length; i++) {
            if (count[i] > 0) {
                return true;
            }
        }
        return false;
    }
}