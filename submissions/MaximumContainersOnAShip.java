// Question: https://leetcode.com/problems/maximum-containers-on-a-ship/description/

class MaximumContainersOnAShip {
    public int maxContainers(int n, int w, int maxWeight) {
        return Math.min(n * n, maxWeight / w);
    }
}