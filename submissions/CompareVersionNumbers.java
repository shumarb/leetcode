// Question: https://leetcode.com/problems/compare-version-numbers/description/

class CompareVersionNumbers {
    public int compareVersion(String version1, String version2) {
        int i = 0;
        int j = 0;
        int m = version1.length();
        int n = version2.length();

        while (i < m || j < n) {
            int num1 = 0;
            int num2 = 0;

            while (i < m && version1.charAt(i) != '.') {
                num1 *= 10;
                num1 += version1.charAt(i) - '0';
                i++;
            }
            while (j < n && version2.charAt(j) != '.') {
                num2 *= 10;
                num2 += version2.charAt(j) - '0';
                j++;
            }

            if (num1 < num2) {
                return -1;
            } else if (num1 > num2) {
                return 1;
            }

            i++;
            j++;

        }

        return 0;
    }
}