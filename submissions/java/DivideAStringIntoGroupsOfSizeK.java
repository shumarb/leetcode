// Question: https://leetcode.com/problems/divide-a-string-into-groups-of-size-k/description/

class Solution {
    public String[] divideString(String s, int k, char fill) {
        String[] result;
        boolean isTest = false;
        int len = s.length();

        if (isTest) {
            System.out.println("s: " + s + "\nk: " + k + "\nfill: " + fill);
        }

        if (len % k == 0) {
            result = new String[len / k];
        } else {
            result = new String[len / k + 1];
        }

        int a = 0;
        int i = 0;
        for (; (i + k) < len; i += k) {
            result[a++] = s.substring(i, i + k);
        }
        if (isTest) {
            System.out.println("i: " + i + " | k: " + k);
        }

        if (i < len) {
            StringBuilder str = new StringBuilder();
            while (i < len) {
                str.append(s.charAt(i++));
            }
            while (str.length() < k) {
                str.append(fill);
            }
            result[a] = str.toString();
        }
        if (isTest) {
            System.out.println("---------------------------------------------------");
            System.out.println("result: " + Arrays.toString(result));
        }

        return result;
    }
}