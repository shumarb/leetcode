// Question: https://leetcode.com/problems/find-missing-elements/description/

class FindMissingElements {
    public List<Integer> findMissingElements(int[] nums) {
        List<Integer> result = new ArrayList<>();
        boolean[] isPresent;
        int largest = Integer.MIN_VALUE;
        int smallest = Integer.MAX_VALUE;

        for (int e: nums) {
            largest = Math.max(e, largest);
            smallest = Math.min(e, smallest);
        }
        isPresent = new boolean[largest + 1];

        for (int e: nums) {
            isPresent[e] = true;
        }
        for (int i = smallest; i <= largest; i++) {
            if (!isPresent[i]) {
                result.add(i);
            }
        }

        return result;
    }
}
