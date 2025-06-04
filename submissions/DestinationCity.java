// Question: https://leetcode.com/problems/destination-city/description/

class DestinationCity {
    public String destCity(List<List<String>> paths) {
        Set<String> from = new HashSet<> ();
        boolean t = false;
        for (List<String> e: paths) {
            if (t) {
                System.out.println("e: " + e + "\t| from: " + e.get(0) + ", to: " + e.get(1));
            }
            from.add(e.get(0));
        }
        if (t) {
            System.out.println("from: " + from);
        }
        for (List<String> e: paths) {
            String dest = e.get(1);
            if (!from.contains(dest)) {
                return dest;
            }
        }

        return null;
    }
}