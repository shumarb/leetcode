// Question: https://leetcode.com/problems/find-the-length-of-the-longest-common-prefix/description/

class FindTheLengthOfTheLongestCommonPrefix  {
    public int longestCommonPrefix(int[] arr1, int[] arr2) {
        Set<Integer> prefix1 = getPrefixes(arr1);
        Set<Integer> prefix2 = getPrefixes(arr2);
        boolean isTest = false;
        int longestPrefix = 0;

        for (int key: prefix2) {
            if (prefix1.contains(key)) {
                longestPrefix = Math.max(key, longestPrefix);
            }
        }
        if (isTest) {
            System.out.println("prefix1: " + prefix1 + "\nprefix2: " + prefix2);
            System.out.println("longestPrefix: " + longestPrefix);
        }

        return longestPrefix == 0 ? longestPrefix : getLength(longestPrefix);
    }

    private int getLength(int n) {
        int result = 0;
        while (n > 0) {
            result++;
            n /= 10;

        }

        return result;
    }

    private Set<Integer> getPrefixes(int[] arr) {
        Set<Integer> result = new HashSet<>();
        for (int e: arr) {
            while (e > 0) {
                result.add(e);
                e /= 10;
            }
        }

        return result;
    }
}
