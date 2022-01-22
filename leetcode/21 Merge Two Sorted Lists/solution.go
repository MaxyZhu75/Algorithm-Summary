/**
 * Definition for singly-linked list.
 * type ListNode struct {
 *     Val int
 *     Next *ListNode
 * }
 */
func mergeTwoLists(list1 *ListNode, list2 *ListNode) *ListNode {
    if list1 == nil {  // 左右边界！！！
        return list2
    }
    if list2 == nil {
        return list1
    }
    var mergedList *ListNode = nil  // 定义新的合并后的链表！！！
    if list1.Val < list2.Val {  // 注意ListNode可以视作指针指的首地址内容！！！
        mergedList = list1  // 根据不同情况初始化！！！
        mergedList.Next = mergeTwoLists(list1.Next, list2)  // recursion！！！
    } else {
        mergedList = list2
        mergedList.Next = mergeTwoLists(list1, list2.Next)
    }
    return mergedList
}