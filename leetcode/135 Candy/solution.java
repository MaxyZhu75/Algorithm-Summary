class Solution {
    public int candy(int[] ratings) { // ���߶����Ʒ������������
        int n = ratings.length;
        int result = 1;
        int increase = 1, decrease = 0, rightmost = 1; // increase��ʾ�ϸ�������еĳ��ȣ�decrease��ʾ�ϸ�ݼ����еĳ��ȣ�rightmost��ʾ���¼����ǰһ�߶ȣ�����
        for (int i=1; i<n; i++) {
            if (ratings[i] >= ratings[i-1]) { // case1���ϸ�������ƽ������
                decrease = 0;
				rightmost = (ratings[i] == ratings[i-1]) ? 1 : rightmost+1; // ע���ƽ��Ҫ���±�Ϊ1�����Դ�ʱrightmost���ܴ���ǰ�߶ȣ�Ҳ�ܴ����ϸ�������еĳ��ȣ�����
				result += rightmost;
                increase = rightmost;
            } else { // case2���ϸ�ݼ�������
                decrease++;
                if (decrease == increase) { // ��ǰ����ͬѧ��������ֵͬѧ��Ҫ����+1������
                    decrease++;
                }
                result += decrease; // Ҫ�㣺����������ֵҪ�ӵ�ǰ����ͬѧ���ܺ�������������׼ȷ������ۼӵ�ǰ����������
                rightmost = 1;
            }
        }
        return result;
    }
}