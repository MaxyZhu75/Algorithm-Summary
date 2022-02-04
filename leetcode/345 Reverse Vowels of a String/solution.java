class Solution {
    public String reverseVowels(String s) {

        List<Character> vowels = Arrays.asList('a', 'e', 'i', 'o', 'u', 'A', 'E', 'I', 'O', 'U'); // Arrays转List！！！
        Set<Character> hashRecord = new HashSet<>(vowels); // 传入List构造初始化HashSet！！！
        
        int p1 = 0;
        int p2 = s.length()-1;
        char[] splitString = s.toCharArray(); // java.lang.String.toCharArray()！！！
        
        while (p1 <= p2) { // 双指针；注意循环条件和不同case的逻辑，否则结果易出错！！！
            char letter1 = s.charAt(p1);
            char letter2 = s.charAt(p2);
            if (!hashRecord.contains(letter1)) { // case1：但凡遇见不是元音则移动该指针（无论都指向辅音还是只有一个指向辅音，一次循环只移动一个指针即可）！！！
                p1++;
            } else if (!hashRecord.contains(letter2)){
                p2--;
            } else { // case2：当且仅当两个指针都指向元音时才交换且同时移动！！！
                splitString[p1] = letter2;
                splitString[p2] = letter1;
                p1++;
                p2--;
            }
        }

        String result = new String(splitString); // 传入char[]构造初始化String！！！
        return result;
    }
}