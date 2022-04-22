class Solution {
    public boolean isNumber(String s) {
        int n = s.length();
        char[] letters = s.toCharArray();
        boolean result;
        int ePosition = -1;
		
        for (int i=0; i<n; i++) {
            if (letters[i] == 'e' || letters[i] == 'E') {
                if (ePosition == -1) {
                    ePosition = i; // 遍历扫描e的位置并记录！！！
                } else {
                    return false; // 不能重复出现e！！！
                }
            }
        }

        if (ePosition != -1) { // case1: 如果存在e，左侧可以是「整数」或「浮点数」，右侧必须是「整数」！！！
            result = check(letters, 0, ePosition-1, false) && check(letters, ePosition+1, n-1, true);
        } else {
            result = check(letters, 0, n-1, false); // case2: 如果不存在e ，整段可以是「整数」或「浮点数」！！！
        }
        
        return result;
    }
	
    public boolean check(char[] letters, int start, int end, boolean mustInteger) { // 用于判断是否是合法的「整数」或「浮点数」！！！
        if (start > end) return false;
        if (letters[start] == '+' || letters[start] == '-') { // 只有首位可以是符号位！！！
			start++;
		}
        
		boolean hasDot = false, hasDigit = false;
        for (int i=start; i<=end; i++) {
            if (letters[i] == '.') { // case1：小数点「.」最多出现一次，且不存在于整数！！！
                if (mustInteger || hasDot) {
					return false;
				}
                hasDot = true;
            } else if (letters[i] >= '0' && letters[i] <= '9') { // case2：数字「0~9」至少出现一次！！！
                hasDigit = true;
            } else {
                return false; // case3：若再次出现符号位则不是有效数字！！！
            }
        }
        return hasDigit; // 至少存在一个数字！！！
    }
}