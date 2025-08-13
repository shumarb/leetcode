// Question: https://leetcode.com/problems/reverse-bits/description/

class ReverseBits {
    public int reverseBits(int n) {
        List<Integer> list = new ArrayList<>();
        StringBuilder nBinary = new StringBuilder(Integer.toBinaryString(n));
        boolean isTest = false;
        char[] bits;
        int power = 0;
        int result = 0;

        while (nBinary.length() < 32) {
            nBinary.insert(0, '0');
        }
        bits = nBinary.toString().toCharArray();
        if (isTest) {
            System.out.println("nBinary: " + nBinary + "\nbefore, bits: " + Arrays.toString(bits));
        }

        int left = 0;
        int right = bits.length - 1;
        while (left < right) {
            char temp = bits[left];
            bits[left++] = bits[right];
            bits[right--] = temp;
        }

        for (int i = bits.length - 1; i >= 0; i--) {
            if (bits[i] == '1') {
                result += Math.pow(2.0, power);
            }
            power++;
        }
        if (isTest) {
            System.out.println("after, bits:  " + Arrays.toString(bits) + "\nresult: " + result);
        }

        return result;
    }
}