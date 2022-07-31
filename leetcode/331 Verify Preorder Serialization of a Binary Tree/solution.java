class Solution {
    public boolean isValidSerialization(String preorder) {
        int n = preorder.length();
        int i = 0;
        int slots = 1;
        while (i < n) {
            if (slots == 0) return false; // 还没遍历完就没slot了，无法继续填充！！！
            if (preorder.charAt(i) == ',') {
                i++;
            } else if (preorder.charAt(i) == '#'){ // 空结点消耗1个slot！！！
                slots--;
                i++;
            } else {
                while (i < n && preorder.charAt(i) != ',') { // 把数字读完，不关心具体值！！！
                    i++;
                }
                slots++; // 非空节点消耗1个slot，但左右会多提供2个slot，故2-1=1！！！
            }
        }
        return slots == 0;
    }
}