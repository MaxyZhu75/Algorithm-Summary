/** 
 * Forward declaration of isBadVersion API.
 * @param   version   your guess about first bad version
 * @return 	 	      true if current version is bad 
 *			          false if current version is good
 * func isBadVersion(version int) bool;
 */

func firstBadVersion(n int) int { // 正确版本左边均为正确版本，错误版本，右边均为错误版本；利用这个性质故能进行二分查找！！！
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