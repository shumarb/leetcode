// Question: https://leetcode.com/problems/apply-discount-to-prices/description/

class ApplyDiscountToPrices {
    private boolean isTest;

    public String discountPrices(String sentence, int discount) {
        String[] tokens = sentence.split(" ");
        StringBuilder result = new StringBuilder();
        isTest = false;

        if (isTest) {
            System.out.println("discount: " + discount + "\nbefore, tokens: " + Arrays.toString(tokens));
            System.out.println("-------------------------");
        }
        for (int i = 0; i < tokens.length; i++) {
            String token = tokens[i];
            if (token.length() > 1 && isValid(token)) {
                tokens[i] = update(tokens[i], discount);
            }
        }
        if (isTest) {
            System.out.println("after,  tokens: " + Arrays.toString(tokens));
        }

        for (int i = 0; i < tokens.length - 1; i++) {
            result.append(tokens[i] + " ");
        }
        result.append(tokens[tokens.length - 1]);

        return result.toString();
    }

    private boolean isValid(String token) {
        if (token.indexOf('$') != 0) {
            return false;
        }

        int countDollar = 0;
        int countDigits = 0;

        for (char e: token.toCharArray()) {
            if (e == '$') {
                countDollar++;
            } else if (Character.isDigit(e)) {
                countDigits++;
            }
        }

        return countDollar == 1 && countDigits == token.length() - 1;
    }

    private String update(String token, int discount) {
        StringBuilder result = new StringBuilder();
        double value = 0;

        for (char e: token.toCharArray()) {
            if (Character.isDigit(e)) {
                value *= 10;
                value += (e - '0');
            }
        }

        value = value * (100.0 - discount) / 100.0;
        result.append('$');
        result.append(String.format("%.2f", value));

        return result.toString();
    }
}
