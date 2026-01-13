// Question: https://leetcode.com/problems/make-three-strings-equal/description/

class MakeThreeStringsEqual {
    public int findMinimumOperations(String s1, String s2, String s3) {
        int count = 0;
        int i1 = 0;
        int i2 = 0;
        int i3 = 0;
        int n1 = s1.length();
        int n2 = s2.length();
        int n3 = s3.length();

        while (i1 < n1 && i2 < n2 && i3 < n3 && s1.charAt(i1) == s2.charAt(i2) && s2.charAt(i2) == s3.charAt(i3)) {
            i1++;
            i2++;
            i3++;
            count++;
        }

        return count == 0 ? -1 : (n1 - i1) + (n2 - i2) + (n3 - i3);
    }
}