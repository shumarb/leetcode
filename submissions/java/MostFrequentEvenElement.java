// Question: https://leetcode.com/problems/most-frequent-even-element/description/

class MostFrequentEvenElement {
    public int mostFrequentEven(int[] nums) {
        int frequency = 0;
        int mostFrequentEvenNumber = -1;

        int[] evenNumberFrequency = new int[100001];
        for (int number: nums) {
            if (number % 2 == 0) {
                evenNumberFrequency[number]++;
                if (evenNumberFrequency[number] > frequency) {
                    mostFrequentEvenNumber = number;
                    frequency = evenNumberFrequency[number];
                } else if (evenNumberFrequency[number] == frequency) {
                    mostFrequentEvenNumber = Math.min(mostFrequentEvenNumber, number);
                }
            }
        }

        return mostFrequentEvenNumber == -1 ? -1 : mostFrequentEvenNumber;
    }
}