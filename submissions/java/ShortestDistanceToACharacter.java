// Question: https://leetcode.com/problems/shortest-distance-to-a-character/description/

class ShortestDistanceToACharacter {
    public int[] shortestToChar(String s, char c) {
        boolean isTest = false;
        int len = s.length();
        int previous = -1;
        int[] result = new int[len];
        int[] prefix = new int[len];
        int[] suffix = new int[len];

        for (int i = 0; i < len; i++) {
            if (s.charAt(i) == c) {
                previous = i;
                break;
            }
        }
        for (int i = 0; i < len; i++) {
            if (s.charAt(i) == c) {
                previous = i;
            }
            prefix[i] = Math.abs(i - previous);
        }
        for (int i = len - 1; i >= 0; i--) {
            if (s.charAt(i) == c) {
                previous = i;
                break;
            }
        }
        for (int i = len - 1; i >= 0; i--) {
            if (s.charAt(i) == c) {
                previous = i;
            }
            suffix[i] = Math.abs(i - previous);
        }
        if (isTest) {
            System.out.println("s: " + s + "\nc: " + c);
            System.out.println("prefix: " + Arrays.toString(prefix));
            System.out.println("suffix: " + Arrays.toString(suffix));
        }
        for (int i = 0; i < len; i++) {
            result[i] = Math.min(prefix[i], suffix[i]);
        }

        return result;
    }
}