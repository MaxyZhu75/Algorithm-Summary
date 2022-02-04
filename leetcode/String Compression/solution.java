class Solution {
    public String compressString(String S) {
        int n = S.length();    
        if (n <= 1) {
            return S;
        }

        int count = 1;
        char previous = S.charAt(0);
        StringBuilder sb = new StringBuilder(); // java.lang.StringBuilder；熟悉他的方法！！！

        for (int i=1; i<n; i++) {
            if (S.charAt(i) == previous) {
                count++;
            } else {
                sb.append(previous); // append()非常好用，因为重载提供各种类型的添加！！！
                sb.append(count);
                count = 1;
                previous = S.charAt(i);
            }
        }

        sb.append(previous); // 最后一组字符循环中未添加！！！
        sb.append(count);
        
        String result = sb.toString(); // StringBuilder最后需要toString()！！！

        return result.length() < n ? result : S;
    }
}