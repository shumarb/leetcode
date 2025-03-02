// Question: https://leetcode.com/problems/distribute-candies/description/

class DistributeCandies {
    public int distributeCandies(int[] candyType) {
        Set<Integer> set = new HashSet<>();
        for (int number: candyType) {
            set.add(number);
        }
        return Math.min(set.size(), candyType.length / 2);
    }
}
