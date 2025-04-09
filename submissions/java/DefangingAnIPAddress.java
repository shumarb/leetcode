// Question: https://leetcode.com/problems/defanging-an-ip-address/description/

class DefangingAnIPAddress {
    public String defangIPaddr(String address) {
        StringBuilder result = new StringBuilder();

        for (char c: address.toCharArray()) {
            if (c == '.') {
                result.append("[.]");
            } else {
                result.append(c);
            }
        }

        return result.toString();
    }
}