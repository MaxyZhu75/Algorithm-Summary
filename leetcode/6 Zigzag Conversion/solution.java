class Solution {
    public String convert(String s, int numRows) {
        if (numRows == 1) return s;
        List<StringBuilder> rows = new ArrayList<>();
        for (int i=0; i<Math.min(numRows, s.length()); i++) { // 每行各一个sb！！！
            rows.add(new StringBuilder());
		}
        int curRow = 0;
        boolean down = false; // 确定当前方向！！！
        for (char letter : s.toCharArray()) {
            rows.get(curRow).append(letter);
            if (curRow == 0 || curRow == numRows - 1) { // 第一排和最后一排转向！！！
				down = !down;	
			}
            curRow += (down) ? 1 : -1; // 根据方向移动！！！
        }

        StringBuilder sb = new StringBuilder();
        for (StringBuilder row : rows) { // 逐行添加到结果sb！！！
			sb.append(row);	
		}
        return sb.toString();
    }
}