// Question: https://leetcode.com/problems/partition-string/description/

class PartitionString {
    public List<String> partitionString(String s) {
        List<String> result = new ArrayList<>();
        Set<String> seenSegments = new HashSet<>();
        StringBuilder currentSegment = new StringBuilder();
        boolean isTest = false;

        for (char c: s.toCharArray()) {
            currentSegment.append(c);
            if (isTest) {
                System.out.println("c: " + c + " -> currentSegment: " + currentSegment);
                System.out.println(" * before, seenSegments: " + seenSegments + ", result: " + result);
            }

            String key = currentSegment.toString();
            if (!seenSegments.contains(key)) {
                seenSegments.add(key);
                result.add(key);
                currentSegment = new StringBuilder();
            }

            if (isTest) {
                System.out.println(" * after, seenSegments: " + seenSegments + ", result: " + result);
                System.out.println("-------------------------------------------------");
            }
        }
        if (isTest) {
            System.out.println("final seenSegments: " + seenSegments + "\nfinal result: " + result);
        }

        return result;
    }
}