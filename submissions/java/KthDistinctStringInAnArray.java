// Question: https://leetcode.com/problems/kth-distinct-string-in-an-array/description/

class KthDistinctStringInAnArray {
    public String kthDistinct(String[] arr, int k) {
        boolean isTest = false;
        Map<String, Integer> stringFrequencyMap = new HashMap<>();
        for (String word: arr) {
            stringFrequencyMap.put(word, 1 + stringFrequencyMap.getOrDefault(word, 0));
        }
        if (isTest) {
            System.out.println("arr: " + Arrays.toString(arr) + ", k: " + k + "\nstringFrequencyMap: " + stringFrequencyMap);
        }

        int count = 0;
        for (String word: arr) {
            if (stringFrequencyMap.get(word) == 1) {
                count++;
                if (isTest) {
                    System.out.println("kth distinct string so far: " + word + ", count: " + count + ", k: " + k);
                }
                if (count == k) {
                    if (isTest) {
                        System.out.println("kth distinct: " + word + ", count: " + count + ", k: " + k);
                    }
                    return word;
                }
            }
        }
        return "";
    }
}