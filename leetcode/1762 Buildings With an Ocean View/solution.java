class Solution {
    public int[] findBuildings(int[] heights) { // �Ӻ���ǰ������̰�ĵؼ��뺣�������ɣ�ע�������˳����Ҫ������ʹ��Stack���ݽṹ������
        int n = heights.length;
        int highest = heights[n-1];
        Stack<Integer> myStack = new Stack<>();
        myStack.push(n-1);
        for (int i=n-2; i>=0; i--) {
            if (heights[i] > highest) {
                myStack.push(i);
                highest = heights[i];
            }
        }
        
        int j = 0;
        int[] result = new int[myStack.size()];
        while (!myStack.isEmpty()) {
            result[j++] = myStack.pop();
        }
        return result;
    }
}