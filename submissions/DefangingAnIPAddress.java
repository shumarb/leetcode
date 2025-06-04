// Question: https://leetcode.com/problems/defanging-an-ip-address/description/

class DefangingAnIPAddress {
    public String defangIPaddr(String address) {
        return address.replace(".", "[.]");
    }
}