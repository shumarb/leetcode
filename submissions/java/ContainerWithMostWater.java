class ContainerWithMostWater {
    public int maxArea(int[] height) {
        int l = 0;
        int r = height.length - 1;
        int maxArea = 0;
        while (l < r) {
            int lHeight = height[l];
            int rHeight = height[r];
            int currArea = Math.min(lHeight, rHeight) * (r - l);
            maxArea = Math.max(currArea, maxArea);
            if (lHeight < rHeight) {
                l++;
            } else {
                r--;
            }
        }
        return maxArea;
    }
    
}
