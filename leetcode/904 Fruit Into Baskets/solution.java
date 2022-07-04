class Solution {
    public int totalFruit(int[] fruits) { // 滑动窗口虫取法！！！
        Map<Integer, Integer> hashRecord = new HashMap<>();
        int k = 2;
        int left = 0, right = 0;
        while (right < fruits.length) {
            hashRecord.put(fruits[right], hashRecord.getOrDefault(fruits[right], 0)+1);
            if (hashRecord.size() > k) {
                hashRecord.put(fruits[left], hashRecord.get(fruits[left])-1);
                if (hashRecord.get(fruits[left]) == 0) hashRecord.remove(fruits[left]);
                left++;
            }
            right++;
        }
        return right-left;
    }
}