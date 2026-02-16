// Question: https://leetcode.com/problems/masking-personal-information/description/

class MaskingPersonalInformation {
    private StringBuilder result;
    private boolean isTest;

    public String maskPII(String s) {
        isTest = false;
        result = new StringBuilder();

        return s.indexOf("@") >= 0 ? maskEmailAddress(s) : maskPhoneNumber(s);
    }

    private String maskEmailAddress(String s) {
        int index = s.indexOf("@");

        result.append(Character.toLowerCase(s.charAt(0)));
        result.append("*****");
        result.append(Character.toLowerCase(s.charAt(index - 1)));

        for (int i = index; i < s.length(); i++) {
            char c = s.charAt(i);
            if (Character.isLetter(c)) {
                result.append(Character.toLowerCase(c));
            } else {
                result.append(c);
            }
        }
        if (isTest) {
            System.out.println("before, email address: " + s + "\n * index of @: " + index);
            System.out.println("after, email address: " + result.toString());
        }

        return result.toString();
    }

    private String maskPhoneNumber(String s) {
        StringBuilder digits = new StringBuilder();
        StringBuilder localNumber;
        String firstPart;
        String lastFour;
        String lastTen;
        int n;

        for (char c: s.toCharArray()) {
            if (Character.isDigit(c)) {
                digits.append(c);
            }
        }
        n = digits.length();
        firstPart = digits.substring(0, n - 10);
        lastFour = digits.substring(n - 4, n);
        lastTen = digits.substring(n - 10, n);

        if (firstPart.length() == 0) {
            result.append("***-***-");
        } else if (firstPart.length() == 1) {
            result.append("+*-***-***-");
        } else if (firstPart.length() == 2) {
            result.append("+**-***-***-");
        } else if (firstPart.length() == 3) {
            result.append("+***-***-***-");
        }
        result.append(lastFour);
        if (isTest) {
            System.out.println("before, phone number: " + s + "\n * digits: " + digits);
            System.out.println(" * firstPart: " + firstPart + "\n * lastFour: " + lastFour + "\n * lastTen: " + lastTen);
            System.out.println("after, phone number: " + result.toString());
        }

        return result.toString();
    }
}