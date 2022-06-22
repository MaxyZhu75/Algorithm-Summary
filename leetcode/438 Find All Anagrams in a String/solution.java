class Solution {
	public List<Integer> findAnagrams(String s, String p) { // �������ڣ�����
		List<Integer> result = new ArrayList();
		if (s.length() < p.length()) return result;
		int [] pCount = new int[26];
		int [] sCount = new int[26];
		for (char c : p.toCharArray()) { // �洢��p��������ĸ������������
			pCount[(int)(c-'a')]++;
		}

		int k = p.length();
		for (int i=0; i<s.length(); i++) { // ͳ�ƴ�СΪ��k���Ļ��������ڣ���s��������ĸ������������
			sCount[(int)(s.charAt(i)-'a')]++;
			if (i >= k) {
				sCount[(int)(s.charAt(i-k)-'a')]--;
			}
			if (Arrays.equals(pCount, sCount)) { // �Ƚ������������Ƿ���ͬ���ɣ�����
				result.add(i-k+1);
			}
		}
		return result;
	}
}