class Solution {
    public int maxProduct(String[] words) {
        int n = words.length;
        int[] wordBits = new int[n]; // ע��˴���������洢������
        for (int i=0; i<n; i++){
            for(char letter : words[i].toCharArray()){ // ÿ������ΪString�ַ�����Ҫ�������������е���ĸ��Ҫʹ��toCharArray()������
                wordBits[i] |= 1<<(letter-'a'); // ���ɣ�Сд��ĸ-��a�����Ϊ���֣���ͬ��ĸ��1�����Ƹ�����ͬ�����á�|���������¼ÿ����ĸ�ĳ��֣�����
            }
        }

        int maxLen = 0;
        for (int i=0; i<n; i++){
            for(int j=i+1; j<n; j++){
                if ((wordBits[i]&wordBits[j]) == 0){ // ע�����������������������wordBits[j]==0�����������򱨴�����
                  maxLen = Math.max(maxLen, words[i].length()*words[j].length());  
                }
            }
        }
        return maxLen;
    }
}