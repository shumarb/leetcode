// Question: https://leetcode.com/problems/shortest-distance-to-target-string-in-a-circular-array/description/

class ShortestDistanceToTargetStringInACircularArray {
    public int closestTarget(String[] words, String target, int startIndex) {
        int closestTarget = Integer.MAX_VALUE;
        int len = words.length;

        for (int i = 0; i < len; i++) {
            if (words[i].equals(target)) {
                int distance = Math.abs(i - startIndex);
                closestTarget = Math.min(distance, closestTarget);
                closestTarget = Math.min(len - distance, closestTarget);
            }
        }

        return closestTarget == Integer.MAX_VALUE ? -1 : closestTarget;
    }
}