/**
 * Definition for singly-linked list.
 * type ListNode struct {
 *     Val int
 *     Next *ListNode
 * }
 */
func mergeKLists(lists []*ListNode) *ListNode { // 分治合并！！！
    k := len(lists)
    if (k == 0) {
        return nil
    }
    return merge(lists, 0, k-1)
}

func merge(lists []*ListNode, low int, high int) *ListNode { // 分治后，返回合并！！！
    if (low == high) {
        return lists[low] // 分治边界！！！
    }
    mid := low + (high-low)/2
    list1 := merge(lists, low, mid) 
    list2 := merge(lists, mid+1, high)
    return mergeTwoLists(list1, list2)
}

func mergeTwoLists(list1 *ListNode, list2 *ListNode) *ListNode { // 递归实现两两合并；见LeetCode第21题解答！！！
    if list1 == nil {
        return list2
    }
    if list2 == nil {
        return list1
    }
    var mergedList *ListNode = nil 
    if list1.Val < list2.Val {
        mergedList = list1
        mergedList.Next = mergeTwoLists(list1.Next, list2)
    } else {
        mergedList = list2
        mergedList.Next = mergeTwoLists(list1, list2.Next)
    }
    return mergedList
}