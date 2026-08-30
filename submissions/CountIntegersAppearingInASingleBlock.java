// Question: https://leetcode.com/problems/count-integers-appearing-in-a-single-block/description/

class CountIntegersAppearingInASingleBlock {
    public int countSpecialIntegers(int[] nums) {
        boolean isTest = false;
        int largest = 0;
        int n = nums.length;
        int result = 0;
        List<Integer>[] elementIndices;

        if (n == 1) {
            return n;
        }

        for (int e: nums) {
            largest = Math.max(e, largest);
        }
        elementIndices = new ArrayList[largest + 1];
        for (int i = 0; i <= largest; i++) {
            elementIndices[i] = new ArrayList<>();
        }
        for (int i = 0; i < n; i++) {
            elementIndices[nums[i]].add(i);
        }

        if (isTest) {
            System.out.println("nums: " + Arrays.toString(nums) + "\n\nelementIndices:");
            for (int i = 0; i <= largest; i++) {
                System.out.println(" * " + i + ": " + elementIndices[i]);
            }
            System.out.println("----------------------------------------------");
        }
        for (int i = 1; i <= largest; i++) {
            List<Integer> list = elementIndices[i];
            boolean isSpecial = true;
            int k = list.size();

            if (list.isEmpty()) {
                continue;
            }

            for (int j = 1; j < list.size(); j++) {
                if (list.get(j) - list.get(j - 1) != 1) {
                    isSpecial = false;
                    break;
                }
            }
            if (isSpecial) {
                if (isTest) {
                    System.out.println(" * special: " + i);
                }

                result++;
            }
        }
        if (isTest) {
            System.out.println("----------------------------------------------\nresult: " + result);
        }

        return result;
    }
}
