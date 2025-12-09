// Question: https://leetcode.com/problems/sort-integers-by-binary-reflection/description/

class SortIntegersByBinaryReflection {
    public int[] sortByReflection(int[] nums) {
        int[][] map = new int[nums.length][2];
        boolean isTest = false;

        for (int i = 0; i < nums.length; i++) {
            map[i][0] = nums[i];
            map[i][1] = getBinaryReflection(nums[i]);
        }
        Arrays.sort(map,
                (a, b) -> Integer.compare(a[1], b[1]) == 0
                        ? Integer.compare(a[0], b[0])
                        : Integer.compare(a[1], b[1])
        );
        if (isTest) {
            System.out.println("before, nums: " + Arrays.toString(nums) + "\nmap:");
            for (int[] e: map) {
                System.out.println(Arrays.toString(e));
            }
        }
        for (int i = 0; i < nums.length; i++) {
            nums[i] = map[i][0];
        }
        if (isTest) {
            System.out.println("------------------------------------\nafter, nums: " + Arrays.toString(nums));
        }

        return nums;
    }

    private int getBinaryReflection(int n) {
        char[] bits = Integer.toBinaryString(n).toCharArray();
        int left = 0;
        int right = bits.length - 1;

        while (left < right) {
            char temp = bits[left];
            bits[left++] = bits[right];
            bits[right--] = temp;
        }

        return Integer.parseInt(new String(bits), 2);
    }
}