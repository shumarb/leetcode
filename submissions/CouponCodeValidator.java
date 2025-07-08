// Question: https://leetcode.com/problems/coupon-code-validator/description/

class CouponCodeValidator {
    public List<String> validateCoupons(String[] code, String[] businessLine, boolean[] isActive) {
        List<String[]> list = new ArrayList<>();
        List<String> result = new ArrayList<>();
        Map<String, Integer> map = new HashMap<>();
        String regex = "^[A-Za-z0-9_]+$";
        boolean isTest = false;

        map.put("electronics", 1);
        map.put("grocery", 2);
        map.put("pharmacy", 3);
        map.put("restaurant", 4);

        for (int i = 0; i < code.length; i++) {
            String word = code[i];
            if (isActive[i] && word.matches(regex) && map.containsKey(businessLine[i])) {
                list.add(new String[] {word, businessLine[i]});
            }
        }
        list.sort(
                (a, b) -> Integer.compare(map.get(a[1]), map.get(b[1])) == 0
                        ? a[0].compareTo(b[0])
                        : Integer.compare(map.get(a[1]), map.get(b[1]))
        );
        for (String[] e: list) {
            result.add(e[0]);
        }
        if (isTest) {
            System.out.println("list:");
            for (String[] e: list) {
                System.out.println(Arrays.toString(e));
            }
            System.out.println("---------------------------------------");
            System.out.println("result: " + result);
        }

        return result;
    }
}