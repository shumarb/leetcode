// Question: https://leetcode.com/problems/count-k-th-roots-in-a-range/description/

class CountKthRootsInARange {
    public int countKthRoots(int l, int r, int k) {
        double lowerLimit = Math.pow(l, 1.0 / k);
        double upperLimit = Math.pow(r, 1.0 / k);

        int first = (int) Math.ceil(lowerLimit - 1e-9);
        int second = (int) Math.floor(upperLimit + 1e-9);

        return second - first + 1;
    }
}
