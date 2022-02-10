/** 
 * Forward declaration of isBadVersion API.
 * @param   version   your guess about first bad version
 * @return 	 	      true if current version is bad 
 *			          false if current version is good
 * func isBadVersion(version int) bool;
 */

func firstBadVersion(n int) int { // ��ȷ�汾��߾�Ϊ��ȷ�汾������汾���ұ߾�Ϊ����汾������������ʹ��ܽ��ж��ֲ��ң�����
    low, high := 1, n

    for (low < high) {
        mid := low + (high-low)/2
        if isBadVersion(mid) {
            high = mid
        } else {
            low = mid+1
        }
    }

    return low
}