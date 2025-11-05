// Question:

class RepeatedStringMatch {
    public int repeatedStringMatch(String a, String b) {
        StringBuilder current = new StringBuilder();
        boolean isTest = false;
        int count = 0;

        while (current.length() < a.length() + b.length()) {
            if (isTest) {
                System.out.println("--------------------------\nbefore:\n * current: " + current + "\n * count: " + count);
            }
            count++;
            current.append(a);
            if (isTest) {
                System.out.println("\nafter\n * current: " + current + "\n * count: " + count);
            }
            if (current.toString().indexOf(b) >= 0) {
                return count;
            }
        }

        return -1;
    }
}