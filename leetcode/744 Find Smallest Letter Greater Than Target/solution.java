class Solution {
    public char nextGreatestLetter(char[] letters, char target) { // 对于已经排好序的数组，应该联想到二分查找的思想！！！
        int low = 0;
        int high = letters.length-1; // 该题二分查找的框架与69题求开方类似，具体细节应具体问题具体分析！！！
        int resultIndex = 0;
        if (letters[high] - target <= 0) { // 若数组中最大的字母不大于target，由题目所述的循环可知，直接返回头部元素！！！
            return letters[0];
        }
        while (low <= high) {
            int mid = low + (high-low)/2;
            if (letters[mid] - target > 0) {
                resultIndex = mid; // 此处在字母大于target的情况下皆需要更新resultIndex，直至low等于high时，result从上方最逼近目标，即一定符合答案所述比目标字母大的最小字母！！！
                high = mid-1;
            } else {
                low = mid+1;
            }
        }
        return letters[resultIndex];
    }
}