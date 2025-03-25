// Question: https://leetcode.com/problems/adding-spaces-to-a-string/description/

class AddingSpacesToAString {
    public String addSpaces(String s, int[] spaces) {
        StringBuilder result = new StringBuilder();
        boolean isTest = false;
        boolean[] isSpaceIndex = populate(s, spaces);

        for (int i = 0; i < s.length(); i++) {
            if (isSpaceIndex[i]) {
                result.append(" ");
            }
            result.append(s.charAt(i));
        }
        if (isTest) {
            System.out.println("s: " + s + "\nspaces: " + Arrays.toString(spaces));
            System.out.println("isSpaceIndex: " + Arrays.toString(isSpaceIndex));
            System.out.println("result: " + result.toString());
        }

        return result.toString();
    }

    private boolean[] populate(String s, int[] spaces) {
        boolean[] isSpaceIndex = new boolean[s.length()];
        for (int index: spaces) {
            isSpaceIndex[index] = true;
        }
        return isSpaceIndex;
    }
}