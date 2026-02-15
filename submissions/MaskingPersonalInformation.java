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
        int n = s.length();
        StringBuilder digits = new StringBuilder();
        StringBuilder localNumber;
        String lastFour;
        String lastTen;
        String firstPart;

        for (char c: s.toCharArray()) {
            if (Character.isDigit(c)) {
                digits.append(c);
            }
        }
        firstPart = digits.substring(0, digits.length() - 10);
        lastFour = digits.substring(digits.length() - 4, digits.length());
        lastTen = digits.substring(digits.length() - 10, digits.length());

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
            System.out.println("before, phone number: " + s + "\n * firstPart: " + firstPart);
            System.out.println(" * digits: " + digits + "\n * lastFour: " + lastFour + "\n * lastTen: " + lastTen);
            System.out.println("after, phone number: " + result.toString());
        }

        return result.toString();
    }
}