// Question: https://leetcode.com/problems/unique-email-addresses/description/

class UniqueEmailAddresses {
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
        int atIndex = email.indexOf('@');

        for (int i = 0; i < atIndex; i++) {
            char c = email.charAt(i);
            if (c == '+') {
                break;

            } else if (Character.isLetter(c)) {
                result.append(c);
            }
        }
        result.append(email.substring(atIndex, email.length()));
        if (isTest) {
            System.out.println(" * " + email + " -> " + result.toString());
        }

        return result.toString();
    }
}