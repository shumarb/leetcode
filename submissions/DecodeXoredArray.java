// Question: https://leetcode.com/problems/decode-xored-array/description/

class DecodeXoredArray {
    public int[] decode(int[] encoded, int first) {
        boolean isTest = false;
        int j = 0;
        int len = encoded.length;
        int[] result = new int[len + 1];

        result[j++] = first;
        for (int i = 0; i < len; i++) {
            result[j++] = encoded[i] ^ result[i];
        }
        if (isTest) {
            System.out.println("first: " + first + "\nencoded: " + Arrays.toString(encoded));
            System.out.println("result:  " + Arrays.toString(result));
        }

        return result;
    }
}