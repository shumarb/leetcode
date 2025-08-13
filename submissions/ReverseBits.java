// Question: https://leetcode.com/problems/reverse-bits/description/

class ReverseBits {
    public int reverseBits(int n) {
        List<Integer> list = new ArrayList<>();
        String nBinary = Integer.toBinaryString(n);
        boolean isTest = false;
        int[] bits = new int[32];

        for (char digit: nBinary.toCharArray()) {
            if (digit == '1') {
                list.add(1);
            } else {
                list.add(0);
            }
        }
        while (list.size() < 32) {
            list.add(0, 0);
        }

        for (int i = 0; i < list.size(); i++) {
            bits[i] = (list.get(i) == 1) ? 1 : 0;
        }
        if (isTest) {
            System.out.println("n: " + n + "\nnBinary: " + nBinary + "\nlist: " + list + "\nbefore swap, bits: " + Arrays.toString(bits));
        }

        int left = 0;
        int right = bits.length - 1;
        while (left < right) {
            int temp = bits[left];
            bits[left++] = bits[right];
            bits[right--] = temp;
        }
        if (isTest) {
            System.out.println("after swap, bits:  " + Arrays.toString(bits));
        }

        double power = 0;
        int result = 0;
        for (int i = bits.length - 1; i >= 0; i--) {
            if (bits[i] == 1) {
                result += Math.pow(2.0, power);
            }
            power++;
        }
        if (isTest) {
            System.out.println("result:  " + result);
        }

        return result;
    }
}