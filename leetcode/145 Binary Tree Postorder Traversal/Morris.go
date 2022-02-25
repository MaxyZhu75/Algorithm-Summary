/**
 * Definition for a binary tree node.
 * type TreeNode struct {
 *     Val int
 *     Left *TreeNode
 *     Right *TreeNode
 * }
 */
func postorderTraversal(root *TreeNode) []int { // Morris遍历在线性时间完成且空间复杂度为O(1)！！！
    result := []int{} // 后序遍历：左右根！！！
    if root == nil {
        return result // 由于前序遍历为“根左右”，我们基于前序遍历Morris的代码，对称调换左右的遍历顺序为“根右左”，最后再反转整个结果即可得到“左右根”！！！
    }

    var subtreeRoot, predecessor *TreeNode = root, nil // 核心思想即将每个节点视作子树根考虑，将相应的前驱节点predecessor指向该subtreeRoot，过程上分为下潜和上浮两个过程（其中要分为总体和局部两个视角）！！！

    for subtreeRoot != nil {
        if subtreeRoot.Right != nil { // case1：右边不为空时说明还未办手续，需要先对当前节点的右边办手续，总体上下潜！！！

            predecessor = subtreeRoot.Right // 要点：使用while循环找predecessor；在后续遍历对称反转时，前驱结点为右子树的最左子节点！！！
            for predecessor.Left != nil && predecessor.Left != subtreeRoot {
                predecessor = predecessor.Left
            }

            if predecessor.Left == nil { // 未连接：注意前序遍历需要先将当前subtreeRoot加入result；再将predecessor指向当前subtreeRoot后，subtreeRoot才继续往右边下潜！！！
                result = append(result, subtreeRoot.Val)
                predecessor.Left = subtreeRoot
                subtreeRoot = subtreeRoot.Right
            } else if predecessor.Left == subtreeRoot { // 已连接：总体上已下潜结束，总体来看进入上浮过程，需要断开连接；但上浮前需要先处理当前subtreeRoot的左边（又需要局部的下潜上浮）！！！
                predecessor.Left = nil
                subtreeRoot = subtreeRoot.Left
            }

        } else { // case2：右边为空，则将当前subtreeRoot加入结果后，向左边下潜！！！
            result = append(result, subtreeRoot.Val)
            subtreeRoot = subtreeRoot.Left
        }
    }

    reverse(result)
    return result
}

func reverse(array []int) {
    n := len(array)
    p1, p2 := 0, n-1
    for p1 < p2 {
        array[p1], array[p2] = array[p2], array[p1]
        p1++
        p2--
    }
}