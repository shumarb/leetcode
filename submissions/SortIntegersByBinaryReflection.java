// Question: https://leetcode.com/problems/sort-integers-by-binary-reflection/description/

class SortIntegersByBinaryReflection {
    public int[] sortByReflection(int[] nums) {
        List<Integer> list = new ArrayList<>();
        Map<Integer, Integer> map = new HashMap<>();
        boolean isTest = false;

        for (int e: nums) {
            list.add(e);
            map.put(e, getBinaryReflection(e));
        }
        list.sort(
                (a, b) -> Integer.compare(map.get(a), map.get(b)) == 0
                        ? Integer.compare(a, b)
                        : Integer.compare(map.get(a), map.get(b))
        );
        if (isTest) {
            System.out.println("before, nums: " + Arrays.toString(nums) + "\nmap: " + map);
        }
        for (int i = 0; i < list.size(); i++) {
            nums[i] = list.get(i);
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