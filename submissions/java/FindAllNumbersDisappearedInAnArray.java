// Question: https://leetcode.com/problems/find-all-numbers-disappeared-in-an-array/description/

class FindAllNumbersDisappearedInAnArray {
    public List<Integer> findDisappearedNumbers(int[] nums) {
        int n = nums.length;
        int[] freq = new int[n + 1];
        boolean t = false;
        List<Integer> missing = new ArrayList<> ();

        for (int i = 0; i < n; i++) {
            freq[nums[i]]++;
        }
        if (t) {
            System.out.println("nums: " + Arrays.toString(nums));
            System.out.println("freq: " + Arrays.toString(freq));
        }

        for (int i = 1; i <= n; i++) {
            if (freq[i] == 0) {
                missing.add(i);
            }
        }
        if (t) {
            System.out.println("missing: " + missing);
        }

        return missing;
    }
}