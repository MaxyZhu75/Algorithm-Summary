func isValidSerialization(preorder string) bool {
    n, i, slots := len(preorder), 0, 1
    for i < n {
        if (slots == 0) {
            return false // 还没遍历完就没slot了，无法继续填充！！！
        }
        if preorder[i] == ',' {
            i++
        } else if preorder[i] == '#' { // 空结点消耗1个slot！！！
            slots--
            i++
        } else {
            for i < n && preorder[i] != ',' { // 把数字读完，不关心具体值！！！
                i++
            }
            slots++ // 非空节点消耗1个slot，但左右会多提供2个slot，故2-1=1！！！
        }
    }
    return slots == 0
}