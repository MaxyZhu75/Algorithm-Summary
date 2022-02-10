func findDuplicate(nums []int) int { // 针对环形链表，Floyd判圈法的应用！！！
    slow, fast := 0, 0 // 要点一：快慢指针！！！
    for (true) { // 这里写while(true)和跳出条件更方便清晰！！！
        slow = nums[slow]
        fast = nums[nums[fast]]
        if slow == fast { // 设想慢指针在圈内走了n-m步停下，而快指针在圈内走了n-m+n步停下；也就是快指针从走n-m步位置开始，再走n步，且再次停在n-m步，在n步必是圈长倍数即 n%c = 0 ！！！
            break
        }
    }

    findEntry := 0 // 要点二：寻找圈入口的指针！！
    for (true) {
        findEntry = nums[findEntry] // 已知慢指针在圈内走了n-m步停下，则再走m步回到圈的入口，m的定义本身是起点到圈入口长度，故两个指针会相遇！！！
        slow = nums[slow]
        if findEntry == slow {
            break
        }
     }

    return findEntry
}