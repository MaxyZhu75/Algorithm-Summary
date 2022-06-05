class Solution {
    StringBuilder sb;
	List<String> result;
	int n;
	
	public List<String> generateParenthesis(int n) { // 回溯解决！！！
		this.sb = new StringBuilder();
		this.result = new ArrayList<>();
        this.n = n;
		dfsBackTrack(0, 0);
        return result;
    }

    public void dfsBackTrack(int left, int right) { // 仅当序列仍然保持有效时才添加左括号和右括号；无效时递归会什么都不执行，返回原函数后回溯！！！
        if (sb.length() == n * 2) {
            result.add(sb.toString()); // 递归出口；合法结果加入result！！！
            return;
        }
        if (left < n) { // case1：如果左括号数量不大于n，则可以放一个左括号！！！
            sb.append('(');
            dfsBackTrack(left+1, right);
            sb.deleteCharAt(sb.length()-1);
        }
        if (right < left) { // case2：如果右括号数量小于左括号的数量，则可以放一个右括号！！！
            sb.append(')');
            dfsBackTrack(left, right+1);
            sb.deleteCharAt(sb.length()-1);
        }
    }
}