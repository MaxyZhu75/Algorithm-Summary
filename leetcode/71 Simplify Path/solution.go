func simplifyPath(path string) string {
    myDeque := []string{}
    for _, name := range strings.Split(path, "/") { // import strings.Split(字符串，分隔符)！！！
        if name == ".." { // case1：“..” 不加入deque，且如果deque不为空则弹出栈顶！！！
            if len(myDeque) != 0 {
                myDeque = myDeque[:len(myDeque)-1]
            }
        } else if name != "." && name != "" { // case2：“.”与空字符（连续的“/”分割后即为空字符）不加入deque；其余元素压入栈顶！！！
            myDeque = append(myDeque, name)
        }
    }
    return "/" + strings.Join(myDeque, "/") // import.strings.Join(字符串数组，连接符)！！！
}