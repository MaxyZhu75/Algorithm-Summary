/* The isBadVersion API is defined in the parent class VersionControl.
      boolean isBadVersion(int version); */

public class Solution extends VersionControl { // ��ȷ�汾��߾�Ϊ��ȷ�汾������汾���ұ߾�Ϊ����汾������������ʹ��ܽ��ж��ֲ��ң�����
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