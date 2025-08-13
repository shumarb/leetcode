// Question: https://leetcode.com/problems/remove-digit-from-number-to-maximize-result/description/

class RemoveDigitFromNumberToMaximizeResult {
    public String removeDigit(String number, char digit) {
        List<Integer> digitIndices = new ArrayList<>();
        List<String> newNumbers = new ArrayList<>();
        String result = "";
        boolean isTest = false;

        for (int i = 0; i < number.length(); i++) {
            if (number.charAt(i) == digit) {
                digitIndices.add(i);
            }
        }
        for (int index: digitIndices) {
            String firstPart = number.substring(0, index);
            String secondPart = number.substring(index + 1, number.length());
            newNumbers.add(firstPart + secondPart);
        }
        Collections.sort(newNumbers);
        result = newNumbers.get(newNumbers.size() - 1);
        if (isTest) {
            System.out.println("digitIndices: " + digitIndices);
            System.out.println("newNumbers: " + newNumbers + "\nresult: " + result);
        }

        return result;
    }
}