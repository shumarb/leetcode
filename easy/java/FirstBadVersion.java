// Question: https://leetcode.com/problems/first-bad-version/description/

/* The isBadVersion API is defined in the parent class VersionControl.
      boolean isBadVersion(int version); */

public class FirstBadVersion extends VersionControl {
    public int firstBadVersion(int n) {
        int low = 1;
        int high = n;
        while (low < high) {
            int mid = low + (high - low) / 2;
            if (isBadVersion(mid)) {
                high = mid;
            } else {
                low = mid + 1;
            }
        }
        return low;
    }
}