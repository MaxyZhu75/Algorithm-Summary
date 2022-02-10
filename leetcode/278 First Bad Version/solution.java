/* The isBadVersion API is defined in the parent class VersionControl.
      boolean isBadVersion(int version); */

public class Solution extends VersionControl { // 正确版本左边均为正确版本，错误版本，右边均为错误版本；利用这个性质故能进行二分查找！！！
    public int firstBadVersion(int n) {
        int low = 1;
        int high = n;

        while (low < high) {
            int mid = low + (high-low)/2;
            if (isBadVersion(mid)) {
                high = mid;
            } else {
                low = mid+1;
            }
        }

        return low;
    }
}