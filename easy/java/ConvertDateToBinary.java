// Question: https://leetcode.com/problems/convert-date-to-binary/description/

class ConvertDateToBinary {
    private boolean isTest = false;

    public String convertDateToBinary(String date) {
        StringBuilder convertedDate = new StringBuilder();
        String[] numbers = date.split("-");
        if (isTest) {
            System.out.println("numbers: " + Arrays.toString(numbers));
        }
        int count = 0;
        for (String number: numbers) {
            count++;
            convert(Integer.parseInt(number), convertedDate);
            if (isTest) {
                System.out.println("convertedDate so far: " + convertedDate);
            }
            if (count != numbers.length) {
                convertedDate.append("-");
            }
        }
        return convertedDate.toString();
    }

    private void convert(int number, StringBuilder convertedDate) {
        Stack<Integer> bits = new Stack<>();
        while (number != 0) {
            bits.push(number % 2);
            number /= 2;
        }
        while (!bits.isEmpty()) {
            convertedDate.append(bits.pop());
        }
    }
}