// Question: https://leetcode.com/problems/split-strings-by-separator/description/

class SplitStringsBySeparator {
    public List<String> splitWordsBySeparator(List<String> words, char separator) {
        List<String> result = new ArrayList<>();
        boolean isTest = false;

        if (isTest) {
            System.out.println("words: " + words + "\nseparator: " + separator);
            System.out.println("----------------------------------------------------------------");
        }
        for (String word: words) {
            StringBuilder toAdd = new StringBuilder();
            for (int i = 0; i < word.length(); i++) {
                char c = word.charAt(i);
                if (c != separator) {
                    toAdd.append(c);
                } else {
                    if (toAdd.length() > 0) {
                        result.add(toAdd.toString());
                    }
                    if (isTest) {
                        System.out.println(" * toAdd: " + toAdd.toString());
                    }
                    toAdd.setLength(0);
                }
            }
            if (toAdd.length() > 0 && toAdd.toString().indexOf(separator) == -1) {
                result.add(toAdd.toString());
            }
            if (isTest) {
                System.out.println(" * toAdd: " + toAdd.toString());
            }
            toAdd = new StringBuilder();
        }
        if (isTest) {
            System.out.println("----------------------------------------------------------------");
            System.out.println("result: " + result);
        }

        return result;
    }
}