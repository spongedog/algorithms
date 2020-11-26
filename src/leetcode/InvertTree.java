package leetcode;

/**
 * @author 郑凯努
 * @version 1.0
 * @date 2020/10/28
 */
public class InvertTree {

    public TreeNode invertTree(TreeNode root) {
        if (root == null || (root.left == null && root.right == null)) {
            return root;
        }

        invertTree(root.left);
        invertTree(root.right);

        TreeNode left = root.left;
        root.left = root.right;
        root.right = left;

        return root;
    }

}
