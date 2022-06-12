class Solution {
	public boolean isStrobogrammatic(String num) { // 双指针！！！
		Map<Character, Character> hashRecord = new HashMap<>(){{ // 其他数字必不对称！！！
			put('6', '9');
			put('9', '6');
			put('0', '0');
			put('1', '1');
			put('8', '8');	
		}};
	   
		int left = 0, right = num.length()-1;
		while (left <= right) { // 单个数字也要检查反转时是否正确！！！
			if (!hashRecord.containsKey(num.charAt(left))) return false;
			if (hashRecord.get(num.charAt(left)) != num.charAt(right)) { // 反转180度：整个字符串头尾颠倒，单个数字上下颠倒！！！
				return false;
			}
			left++;
			right--;
		}
		return true;
	}
}