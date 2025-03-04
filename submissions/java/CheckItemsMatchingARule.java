// Question: https://leetcode.com/problems/count-items-matching-a-rule/description/

class Solution {
    public int countMatches(List<List<String>> items, String ruleKey, String ruleValue) {
        boolean isTest = false;
        int count = 0;

        if (isTest) {
            display(items, ruleKey, ruleValue);
        }

        int index = 0; // 1. default index to check is 0 (ruleKey == type).
        if (ruleKey.equals("color")) {
            index = 1;
        } else if (ruleKey.equals("name")) {
            index = 2;
        }
        for (List<String> item: items) {
            if (item.get(index).equals(ruleValue)) {
                count++;
            }
        }

        return count;
    }

    private void display(List<List<String>> items, String ruleKey, String ruleValue) {
        System.out.println("items: ");
        for (List<String> item: items) {
            System.out.println(" * " + item);
        }
        System.out.println();
        System.out.println("ruleKey: " + ruleKey + "\nruleValue: " + ruleValue);
    }
}