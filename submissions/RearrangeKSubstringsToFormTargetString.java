// Question: https://leetcode.com/problems/rearrange-k-substrings-to-form-target-string/description/

class RearrangeKSubstringsToFormTargetString {
    public boolean isPossibleToRearrange(String s, String t, int k) {
        Map<String, Integer> map = new HashMap<>();
        boolean isTest = false;
        int n = t.length();
        int substringLength = n / k;

        for (int i = 0; i < n; i += substringLength) {
            map.merge(t.substring(i, i + substringLength), 1, Integer::sum);
        }
        if (isTest) {
            System.out.println("s: " + s + "\nt: " + t + "\nk: " + k + "\nsubstringLength: " + substringLength + "\n\nbefore, map: " + map);
        }

        for (int i = 0; i < n; i += substringLength) {
            String substring = s.substring(i, i + substringLength);
            if (map.containsKey(substring)) {
                map.put(substring, map.get(substring) - 1);
                if (map.get(substring) == 0) {
                    map.remove(substring);
                }
            }
        }
        if (isTest) {
            System.out.println("\nafter, map: " + map);
        }

        return map.isEmpty();
    }
}
