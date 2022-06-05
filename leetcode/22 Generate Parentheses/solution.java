class Solution {
    StringBuilder sb;
	List<String> result;
	int n;
	
	public List<String> generateParenthesis(int n) { // ���ݽ��������
		this.sb = new StringBuilder();
		this.result = new ArrayList<>();
        this.n = n;
		dfsBackTrack(0, 0);
        return result;
    }

    public void dfsBackTrack(int left, int right) { // ����������Ȼ������Чʱ����������ź������ţ���Чʱ�ݹ��ʲô����ִ�У�����ԭ��������ݣ�����
        if (sb.length() == n * 2) {
            result.add(sb.toString()); // �ݹ���ڣ��Ϸ��������result������
            return;
        }
        if (left < n) { // case1���������������������n������Է�һ�������ţ�����
            sb.append('(');
            dfsBackTrack(left+1, right);
            sb.deleteCharAt(sb.length()-1);
        }
        if (right < left) { // case2���������������С�������ŵ�����������Է�һ�������ţ�����
            sb.append(')');
            dfsBackTrack(left, right+1);
            sb.deleteCharAt(sb.length()-1);
        }
    }
}