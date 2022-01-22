/**
 * Definition for singly-linked list.
 * type ListNode struct {
 *     Val int
 *     Next *ListNode
 * }
 */
func getIntersectionNode(headA, headB *ListNode) *ListNode {
    var p1, p2 *ListNode = headA, headB // ˫ָ��˼�룬�ѶԷ��߹���·��һ�飡����
    for (p1 != p2) {
        if p1 == nil { // Go������û����Ԫ���������if-else�ṹ���ɣ�����
            p1 = headB
        } else {
            p1 = p1.Next
        }
        if p2 == nil { // Go�����п�Ϊnil������null������
            p2 = headA
        } else {
            p2 = p2.Next
        }
    }
    return p1
}