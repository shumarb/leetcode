// Question: https://leetcode.com/problems/number-of-different-integers-in-a-string/description/

class NumberOfDifferentIntegersInAString {
    public int numDifferentIntegers(String word) {
        Set<String> uniqueIntegers = new HashSet<>();
        StringBuilder currentInteger = new StringBuilder();

        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            if (Character.isDigit(c)) {
                currentInteger.append(c);
            } else {
                // 1. Check on integer if it is not empty.
                if (currentInteger.length() > 0) {
                    update(currentInteger.toString(), uniqueIntegers);
                }
                currentInteger = new StringBuilder();
            }
        }

        // 2. Check on last-formed integer if it is not empty.
        if (currentInteger.length() > 0) {
            update(currentInteger.toString(), uniqueIntegers);
        }
        return uniqueIntegers.size();
    }

    private void update(String currentInteger, Set<String> uniqueIntegers) {
        boolean isTest = false;
        if (isTest) {
            System.out.println("currentInteger: " + currentInteger);
            System.out.println("before | uniqueIntegers: " + uniqueIntegers);
        }

        int len = currentInteger.length();
        int i = 0;
        while (i < len && currentInteger.charAt(i) == '0') {
            i++;
        }

        // 3. Current string comprises of 0s, so value to be added to set is 0.
        if (i == len) {
            uniqueIntegers.add("0");
        } else {
            StringBuilder value = new StringBuilder();
            for (int j = i; j < len; j++) {
                value.append(currentInteger.charAt(j));
            }
            uniqueIntegers.add(value.toString());
        }

        if (isTest) {
            System.out.println("after | uniqueIntegers: " + uniqueIntegers);
        }
    }
}