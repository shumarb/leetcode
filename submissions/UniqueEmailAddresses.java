// Question: https://leetcode.com/problems/unique-email-addresses/description/

class Solution {
    private boolean isTest;

    public int numUniqueEmails(String[] emails) {
        Set<String> set = new HashSet<>();
        isTest = false;

        if (isTest) {
            System.out.println("before, emails: " + Arrays.toString(emails));
            System.out.println("--------------------------------------------------------------------------");
        }
        for (int i = 0; i < emails.length; i++) {
            set.add(update(emails[i]));
        }
        if (isTest) {
            System.out.println("--------------------------------------------------------------------------");
            System.out.println("after, emails: " + Arrays.toString(emails));
            System.out.println("set: " + set);
        }

        return set.size();
    }

    private String update(String email) {
        StringBuilder result = new StringBuilder();
        String[] tokens = email.split("@");

        for (char c: tokens[0].toCharArray()) {
            if (c == '.') {
                continue;

            } else if (c == '+') {
                break;

            } else {
                result.append(c);
            }
        }
        result.append("@");
        result.append(tokens[1]);
        if (isTest) {
            System.out.println(" * " + email + " -> " + result.toString());
        }

        return result.toString();
    }
}