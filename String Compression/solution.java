class Solution {
    public String compressString(String S) {
        int n = S.length();    
        if (n <= 1) {
            return S;
        }

        int count = 1;
        char previous = S.charAt(0);
        StringBuilder sb = new StringBuilder(); // java.lang.StringBuilder����Ϥ���ķ���������

        for (int i=1; i<n; i++) {
            if (S.charAt(i) == previous) {
                count++;
            } else {
                sb.append(previous); // append()�ǳ����ã���Ϊ�����ṩ�������͵���ӣ�����
                sb.append(count);
                count = 1;
                previous = S.charAt(i);
            }
        }

        sb.append(previous); // ���һ���ַ�ѭ����δ��ӣ�����
        sb.append(count);
        
        String result = sb.toString(); // StringBuilder�����ҪtoString()������

        return result.length() < n ? result : S;
    }
}