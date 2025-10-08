// Question: https://leetcode.com/problems/frequency-tracker/description/

class FrequencyTracker {
    private boolean isTest = false;
    private int[] frequencies;
    private int[] numbers;

    public FrequencyTracker() {
        frequencies = new int[100001];
        numbers = new int[100001];
    }

    private void display(String s) {
        System.out.println(s);
        System.out.println(" * frequencies: " + Arrays.toString(frequencies));
        System.out.println(" * numbers: " + Arrays.toString(numbers));
    }

    public void add(int number) {
        if (isTest) {
            System.out.println("-------------------------------------------------------------\nadd | number: " + number);
            display("before");
        }
        int previous = numbers[number];
        int updated = 1 + previous;
        numbers[number]++;

        if (frequencies[previous] > 0) {
            frequencies[previous]--;
        }
        frequencies[updated]++;
        if (isTest) {
            display("\nafter");
        }
    }

    public void deleteOne(int number) {
        if (isTest) {
            System.out.println("-------------------------------------------------------------\ndeleteOne | number: " + number);
            display("before");
        }
        if (numbers[number] > 0) {
            int previous = numbers[number]--;
            frequencies[previous]--;
            frequencies[previous - 1]++;
        }
        if (isTest) {
            display("\nafter");
        }
    }

    public boolean hasFrequency(int frequency) {
        if (isTest) {
            System.out.println("-------------------------------------------------------------\nhasFrequency | frequency: " + frequency);
            System.out.println(" * frequencies[frequency]: " + frequencies[frequency] + " --> result: " + (frequencies[frequency] > 0));
        }
        return frequencies[frequency] > 0;
    }
}

/**
 * Your FrequencyTracker object will be instantiated and called as such:
 * FrequencyTracker obj = new FrequencyTracker();
 * obj.add(number);
 * obj.deleteOne(number);
 * boolean param_3 = obj.hasFrequency(frequency);
 */