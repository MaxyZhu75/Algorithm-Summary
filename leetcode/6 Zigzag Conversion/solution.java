class Solution {
    public String convert(String s, int numRows) {
        if (numRows == 1) return s;
        List<StringBuilder> rows = new ArrayList<>();
        for (int i=0; i<Math.min(numRows, s.length()); i++) { // ÿ�и�һ��sb������
            rows.add(new StringBuilder());
		}
        int curRow = 0;
        boolean down = false; // ȷ����ǰ���򣡣���
        for (char letter : s.toCharArray()) {
            rows.get(curRow).append(letter);
            if (curRow == 0 || curRow == numRows - 1) { // ��һ�ź����һ��ת�򣡣���
				down = !down;	
			}
            curRow += (down) ? 1 : -1; // ���ݷ����ƶ�������
        }

        StringBuilder sb = new StringBuilder();
        for (StringBuilder row : rows) { // ������ӵ����sb������
			sb.append(row);	
		}
        return sb.toString();
    }
}