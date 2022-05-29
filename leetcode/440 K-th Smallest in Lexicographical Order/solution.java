class Solution {
    public int findKthNumber(int n, int k) {
        int root = 1; // ������Ŀ���ص���[1, n]���ֵ����kС�����֣�����ȴ�����ڵ�Ϊ 1 ���ֵ���������
        k--;
        while (k > 0) {
            int count = countNodes(root, n);
            if (count <= k) { // case1�����ֵ����µĽڵ���Ҫȫ����������ʱ�ֵ���root��ͬ��ڵ��У���1��9���Һ����ƶ�������
                k -= count;
                root++;
            } else { // case2�����ֵ����°�������ĵ�kС�ڵ㣻��ʱ�ֵ���root��[1, 9]�е�ĳһ����Ϊ��㣬ͨ����10���������ƶ�������
                k--;
				root = root * 10;
            }
        }
        return root;
    }

    public int countNodes(int root, long n) { // ���㵱ǰ�ֵ����½ڵ�������ע����ͳ�Ƹ�����������root��������
        int count = 0;
        long firstChild = root;
        long lastChild = root;
        while (firstChild <= n) { // �����·�ʽչ����������С��n�������ǵ�ǰ�ֵ����µĽڵ㣡����
            count += Math.min(lastChild, n) - firstChild + 1; // ʹ��min()����ֹͳ�Ƴ���n�Ľڵ㣡����
            firstChild = firstChild * 10; // չ����һ���ӽڵ㣨��10����������
            lastChild = lastChild * 10 + 9;
        }
        return count;
    }
}