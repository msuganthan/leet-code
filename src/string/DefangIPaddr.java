package string;

/**
 * 1108. Defanging an IP Address
 * https://leetcode.com/problems/defanging-an-ip-address/
 *
 * Given a valid (IPv4) IP address, return a defanged version of that IP address.
 *
 * A defanged IP address replaces every period "." with "[.]".
 */
public class DefangIPaddr {
    public String defangIPaddr(String address) {
        return address.replaceAll("\\.", "[.]");
    }
}
