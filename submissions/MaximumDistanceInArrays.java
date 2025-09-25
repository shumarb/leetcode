// Question: https://leetcode.com/problems/maximum-distance-in-arrays/description/

class MaximumDistanceInArrays {
    public int maxDistance(List<List<Integer>> arrays) {
        int largest = arrays.get(0).get(arrays.get(0).size() - 1);
        int maximumDistance = 0;
        int smallest = arrays.get(0).get(0);

        for (int i = 1; i < arrays.size(); i++) {
            List<Integer> array = arrays.get(i);
            int first = array.get(0);
            int last = array.get(array.size() - 1);

            maximumDistance = Math.max(maximumDistance, Math.abs(last - smallest));
            maximumDistance = Math.max(maximumDistance, Math.abs(largest - first));

            largest = Math.max(largest, last);
            smallest = Math.min(first, smallest);
        }

        return maximumDistance;
    }
}