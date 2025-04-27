// Question: https://leetcode.com/problems/shortest-distance-to-a-character/description/

class ShortestDistanceToACharacter {
    public int[] shortestToChar(String s, char c) {
        boolean isTest = false;
        int len = s.length();
        int previous = Integer.MIN_VALUE / 2;
        int[] result = new int[len];

        for (int i = 0; i < len; i++) {
            if (s.charAt(i) == c) {
                previous = i;
            }
            result[i] = i - previous;
        }

        previous = Integer.MAX_VALUE / 2;
        for (int i = len - 1; i >= 0; i--) {
            if (s.charAt(i) == c) {
                previous = i;
            }
            result[i] = Math.min(result[i], Math.abs(previous - i));
        }
        if (isTest) {
            System.out.println("s: " + s + "\nc: " + c);
            System.out.println("result: " + Arrays.toString(result));
        }

        return result;
    }
}