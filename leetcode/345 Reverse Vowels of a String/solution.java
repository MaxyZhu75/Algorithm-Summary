class Solution {
    public String reverseVowels(String s) {

        List<Character> vowels = Arrays.asList('a', 'e', 'i', 'o', 'u', 'A', 'E', 'I', 'O', 'U'); // ArraysתList������
        Set<Character> hashRecord = new HashSet<>(vowels); // ����List�����ʼ��HashSet������
        
        int p1 = 0;
        int p2 = s.length()-1;
        char[] splitString = s.toCharArray(); // java.lang.String.toCharArray()������
        
        while (p1 <= p2) { // ˫ָ�룻ע��ѭ�������Ͳ�ͬcase���߼����������׳�������
            char letter1 = s.charAt(p1);
            char letter2 = s.charAt(p2);
            if (!hashRecord.contains(letter1)) { // case1��������������Ԫ�����ƶ���ָ�루���۶�ָ��������ֻ��һ��ָ������һ��ѭ��ֻ�ƶ�һ��ָ�뼴�ɣ�������
                p1++;
            } else if (!hashRecord.contains(letter2)){
                p2--;
            } else { // case2�����ҽ�������ָ�붼ָ��Ԫ��ʱ�Ž�����ͬʱ�ƶ�������
                splitString[p1] = letter2;
                splitString[p2] = letter1;
                p1++;
                p2--;
            }
        }

        String result = new String(splitString); // ����char[]�����ʼ��String������
        return result;
    }
}