// Question: https://leetcode.com/problems/longest-common-prefix/description/

class LongestCommonPrefix {
    private boolean t = false;

    public String longestCommonPrefix(String[] strs) {
        StringBuilder sb = new StringBuilder();
        String shortest = findShortest(strs);
        if (t) {
            System.out.println("strs: " + Arrays.toString(strs));
            System.out.println("shortest: " + shortest);
        }
        for (int i = 0; i < shortest.length(); i++) {
            boolean result = update(shortest, i, strs);
            if (!result) {
                break;
            } else {
                sb.append(shortest.charAt(i));
            }
        }
        if (t) {
            System.out.println("final result: " + sb.toString());
        }
        return sb.toString();
    }

    private boolean update(String shortest, int i, String[] strs) {
        for (String word: strs) {
            if (word.charAt(i) != shortest.charAt(i)) {
                return false;
            }
        }
        return true;
    }

    private String findShortest(String[] strs) {
        String shortest = strs[0];
        for (String x: strs) {
            if (x.length() < shortest.length()) {
                shortest = x;
            }
        }
        return shortest;
    }
}