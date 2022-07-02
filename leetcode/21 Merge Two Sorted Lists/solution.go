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
    var current *ListNode = nil
    if list1.Val < list2.Val {
        current = list1
        current.Next = mergeTwoLists(list1.Next, list2)  // recursion！！！
    } else {
        current = list2
        current.Next = mergeTwoLists(list1, list2.Next)
    }
    return current
}
