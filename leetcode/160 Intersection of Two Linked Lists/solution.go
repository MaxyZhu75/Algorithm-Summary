/**
 * Definition for singly-linked list.
 * type ListNode struct {
 *     Val int
 *     Next *ListNode
 * }
 */
func getIntersectionNode(headA, headB *ListNode) *ListNode {
    var p1, p2 *ListNode = headA, headB // 双指针思想，把对方走过的路走一遍！！！
    for (p1 != p2) {
        if p1 == nil { // Go语言中没有三元运算符，用if-else结构即可！！！
            p1 = headB
        } else {
            p1 = p1.Next
        }
        if p2 == nil { // Go语言中空为nil，不是null！！！
            p2 = headA
        } else {
            p2 = p2.Next
        }
    }
    return p1
}