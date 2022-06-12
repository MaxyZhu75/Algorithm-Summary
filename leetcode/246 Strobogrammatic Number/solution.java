class Solution {
	public boolean isStrobogrammatic(String num) { // ˫ָ�룡����
		Map<Character, Character> hashRecord = new HashMap<>(){{ // �������ֱز��Գƣ�����
			put('6', '9');
			put('9', '6');
			put('0', '0');
			put('1', '1');
			put('8', '8');	
		}};
	   
		int left = 0, right = num.length()-1;
		while (left <= right) { // ��������ҲҪ��鷴תʱ�Ƿ���ȷ������
			if (!hashRecord.containsKey(num.charAt(left))) return false;
			if (hashRecord.get(num.charAt(left)) != num.charAt(right)) { // ��ת180�ȣ������ַ���ͷβ�ߵ��������������µߵ�������
				return false;
			}
			left++;
			right--;
		}
		return true;
	}
}