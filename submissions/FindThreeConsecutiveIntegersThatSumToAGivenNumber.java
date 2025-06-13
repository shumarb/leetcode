// Question: https://leetcode.com/problems/find-three-consecutive-integers-that-sum-to-a-given-number/description/

class FindThreeConsecutiveIntegersThatSumToAGivenNumber {
    public long[] sumOfThree(long num) {
        if (num % 3 != 0) {
            return new long[] {};
        }

        long middleElement = num / 3;

        return new long[] {middleElement - 1, middleElement, middleElement + 1};
    }
}