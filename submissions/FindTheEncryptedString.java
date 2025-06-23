// Question: https://leetcode.com/problems/find-the-encrypted-string/description/

class FindTheEncryptedString {
    public String getEncryptedString(String s, int k) {
        boolean isTest = false;
        int len = s.length();
        char[] result = new char[len];

        for (int i = 0; i < len; i++) {
            result[i] = s.charAt((i + k) % len);
        }
        if (isTest) {
            System.out.println("s: " + s + "\nk: " + k + "\nresult: " + Arrays.toString(result));
        }

        return new String(result);
    }
}