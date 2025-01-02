class MoveZeroes {
    public void moveZeroes(int[] nums) {
        int i = 0;
        for (int x: nums) {
            if (x != 0) {
                nums[i++] = x;
            }
        }
        for (; i < nums.length; i++) {
            nums[i] = 0;
        }
    }
    
}