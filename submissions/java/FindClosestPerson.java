// Question: https://leetcode.com/problems/find-closest-person/description/

class FindClosestPerson {
    public int findClosest(int x, int y, int z) {
        int firstDistance = Math.abs(x - z);
        int secondDistance = Math.abs(y - z);
        if (firstDistance == secondDistance) {
            return 0;
        }
        return firstDistance < secondDistance ? 1 : 2;
    }
}