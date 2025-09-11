// Question: https://leetcode.com/problems/find-the-k-or-of-an-array/description/

class FindTheKOrOfAnArray {
    public int findKOr(int[] nums, int k) {
        boolean isTest = false;
        int[][] binary;
        int longest = 0;
        int power = 0;
        int result = 0;

        for (int number: nums) {
            longest = Math.max(longest, Integer.toBinaryString(number).length());
        }
        binary = new int[nums.length][longest];
        for (int i = 0; i < nums.length; i++) {
            binary[i] = formsBinary(nums[i], longest);
        }

        for (int j = longest - 1; j >= 0; j--) {
            int count = 0;
            for (int i = 0; i < binary.length; i++) {
                if (binary[i][j] == 1) {
                    count++;
                }
            }
            if (count >= k) {
                result += Math.pow(2.0, power);
            }
            power++;
        }

        if (isTest) {
            System.out.println("--------------------------------------");
            System.out.println("binary:");
            for (int[] row: binary) {
                System.out.println(Arrays.toString(row));
            }
            System.out.println("--------------------------------------");
            System.out.println("result: " + result);
        }

        return result;
    }

    private int[] formsBinary(int number, int longest) {
        int[] result = new int[longest];
        int i = longest - 1;
        int numberCopy = number;

        while (i >= 0) {
            result[i--] = number % 2;
            number /= 2;
        }

        return result;
    }
}