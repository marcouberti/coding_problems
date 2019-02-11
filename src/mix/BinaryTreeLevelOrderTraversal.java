package mix;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class BinaryTreeLevelOrderTraversal {

    HashMap<Integer, List<Integer>> map = new HashMap<>();

    public List<List<Integer>> levelOrder(TreeNode root) {
        int level = 0;
        levelOrder(root, level);

        int levels = map.size();
        List<List<Integer>> output = new ArrayList<>();
        for(int i=0; i<levels; i++) output.add(map.get(i));
        return output;
    }

    public void levelOrder(TreeNode node, int level) {
        map.computeIfAbsent(level, k -> new ArrayList<>());
        map.get(level).add(node.val);

        if(node.left != null) levelOrder(node.left, level+1);
        if(node.right != null) levelOrder(node.right, level+1);
    }


    public class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }
    }
}
