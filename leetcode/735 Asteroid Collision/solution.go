func asteroidCollision(asteroids []int) []int { // 判断爆炸发生条件及栈的使用！！！
    n := len(asteroids)
    myStack := []int{}
    myStack = append(myStack, asteroids[0]) // 若在一排处于稳定的小行星右边增加一个新的，若再次稳定前发生碰撞，这些碰撞会自右向左依次发生！！！

    i := 1
    for i < n {
        if len(myStack) > 0 && myStack[len(myStack)-1] > 0 && asteroids[i] < 0 { // 爆炸条件：当前仅当原先存在小行星且向右移动，新来的向左移动！！！
            if myStack[len(myStack)-1] < (-1 * asteroids[i]) { // case1：原先的爆炸；注意新来的可能引起多个原先的爆炸，故在确定稳定前，不能入栈和移动i！！！
                myStack = myStack[:len(myStack)-1]
            } else if myStack[len(myStack)-1] > (-1 * asteroids[i]) { // case2：新来的爆炸！！！
                i++
            } else { // case3：双方爆炸！！！
                myStack = myStack[:len(myStack)-1]
                i++
            }
        } else { // 不符合爆炸条件，稳定！！！
            myStack = append(myStack, asteroids[i])
            i++
        }
    }

    return myStack;
}