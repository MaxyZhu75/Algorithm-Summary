class Solution {
    public int findMinFibonacciNumbers(int k) { // 对小于等于k的斐波那契依次取最大贪心；最难点在于证明贪心策略正确性！！！
        List<Integer> fibonacciNumbers = new ArrayList<>(); // 用List方便动态添加元素！！！
        fibonacciNumbers.add(1);
        fibonacciNumbers.add(1);
        int pre1 = 1;
        int pre2 = 1;
        while (pre1 + pre2 <= k) { // 用while及辅助变量填写小于k的斐波那契数！！！
            int current = pre1 + pre2;
            fibonacciNumbers.add(current);
            pre2 = pre1;
            pre1 = current;
        }

        int n = fibonacciNumbers.size();
        int count = 0;
        int left = k;
        for(int i=n-1; i>=0 && k>0; i--) {
            int greedyNum = fibonacciNumbers.get(i);
            if (left - greedyNum >= 0) {
                left -= greedyNum;
                count++;
            }
        }

        return count;
    }
}