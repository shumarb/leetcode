// Question: https://leetcode.com/problems/rearrange-k-substrings-to-form-target-string/description/

class RearrangeKSubstringsToFormTargetString class Solution {
    public boolean isPossibleToRearrange(String s, String t, int k) {
        Map<String, Integer> map = new HashMap<>();
        boolean isTest = false;
        int n = t.length();
        int substringLength = n / k;

        if (s.equals(t)) {
            return true;
        }

        for (int i = 0; i < n; i += substringLength) {
            map.merge(t.substring(i, i + substringLength), 1, Integer::sum);
        }
        if (isTest) {
            System.out.println("s: " + s + "\nt: " + t + "\nk: " + k + "\nsubstringLength: " + substringLength + "\n\nbefore, map: " + map);
        }

        for (int i = 0; i < n; i += substringLength) {
            String key = s.substring(i, i + substringLength);
            int value = map.getOrDefault(key, 0);

            if (value == 1) {
                map.remove(key);

            } else if (value > 1) {
                map.put(key, value - 1);
            }
        }
        if (isTest) {
            System.out.println("\nafter, map: " + map);
        }

        return map.isEmpty();
    }
}
