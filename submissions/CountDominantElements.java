// Question: https://leetcode.com/problems/count-dominant-elements/description/

class CountDominantElements {
    public int countDominantElements(int[] nums) {
        boolean isTest = false;
        int n = nums.length;
        int result = 0;

        if (n == 1) {
            return 1;
        }

        if (isTest) {
            System.out.println("nums: " + Arrays.toString(nums) + "\n---------------------------");
        }
        for (int i = 0; i < n; i++) {
            double countNeighbours = 0;
            double current = nums[i];
            double last = i - 1 >= 0 ? nums[i - 1] : -1;
            double next = i + 1 < n ? nums[i + 1] : -1;
            double sum = 0;

            if (last != -1) {
                sum += last;
                countNeighbours++;
            }
            if (next != -1) {
                sum += next;
                countNeighbours++;
            }

            if (current >= sum / countNeighbours) {
                if (isTest) {
                    System.out.println(" * dominant: " + current);
                }

                result++;
            }
        }
        if (isTest) {
            System.out.println("---------------------------\nresult: " + result);
        }

        return result;
    }
}
