class Solution {
    public int findMinFibonacciNumbers(int k) { // ��С�ڵ���k��쳲���������ȡ���̰�ģ����ѵ�����֤��̰�Ĳ�����ȷ�ԣ�����
        List<Integer> fibonacciNumbers = new ArrayList<>(); // ��List���㶯̬���Ԫ�أ�����
        fibonacciNumbers.add(1);
        fibonacciNumbers.add(1);
        int pre1 = 1;
        int pre2 = 1;
        while (pre1 + pre2 <= k) { // ��while������������дС��k��쳲�������������
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