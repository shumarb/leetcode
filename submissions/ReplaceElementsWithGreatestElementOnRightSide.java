// Question: https://leetcode.com/problems/replace-elements-with-greatest-element-on-right-side/description/

class ReplaceElementsWithGreatestElementOnRightSide {
    public int[] replaceElements(int[] arr) {
        if (arr.length == 1) {
            return new int[] {-1};
        }

        boolean isTest = false;
        int n = arr.length;
        int[] suffix = new int[n];
        suffix[n - 1] = -1;

        for (int i = n - 2; i >= 0; i--) {
            suffix[i] = Math.max(arr[i + 1], suffix[i + 1]);
        }
        if (isTest) {
            System.out.println("arr: " + Arrays.toString(arr) + "\nsuffix: " + Arrays.toString(suffix));
        }

        return suffix;
    }
}