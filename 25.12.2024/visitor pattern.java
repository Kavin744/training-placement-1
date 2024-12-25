import java.io.*;
import java.util.*;

enum Color {
    RED, GREEN;
}

abstract class Tree {
    private int value;
    private Color color;
    private int depth;

    public Tree(int value, Color color, int depth) {
        this.value = value;
        this.color = color;
        this.depth = depth;
    }

    public int getValue() {
        return value;
    }

    public Color getColor() {
        return color;
    }

    public int getDepth() {
        return depth;
    }

    public abstract void accept(TreeVis visitor);
}

class TreeNode extends Tree {
    private List<Tree> children = new ArrayList<>();

    public TreeNode(int value, Color color, int depth) {
        super(value, color, depth);
    }

    public void addChild(Tree child) {
        children.add(child);
    }

    public List<Tree> getChildren() {
        return children;
    }

    @Override
    public void accept(TreeVis visitor) {
        visitor.visitNode(this);
        for (Tree child : children) {
            child.accept(visitor);
        }
    }
}

class TreeLeaf extends Tree {
    public TreeLeaf(int value, Color color, int depth) {
        super(value, color, depth);
    }

    @Override
    public void accept(TreeVis visitor) {
        visitor.visitLeaf(this);
    }
}

abstract class TreeVis {
    public abstract int getResult();
    public abstract void visitNode(TreeNode node);
    public abstract void visitLeaf(TreeLeaf leaf);
}

class SumInLeavesVisitor extends TreeVis {
    private int result = 0;

    @Override
    public int getResult() {
        return result;
    }

    @Override
    public void visitNode(TreeNode node) {
    }

    @Override
    public void visitLeaf(TreeLeaf leaf) {
        result += leaf.getValue();
    }
}

class ProductOfRedNodesVisitor extends TreeVis {
    private static final int MOD = 1000000007;
    private long result = 1;

    @Override
    public int getResult() {
        return (int) result;
    }

    @Override
    public void visitNode(TreeNode node) {
        if (node.getColor() == Color.RED) {
            result = (result * node.getValue()) % MOD;
        }
    }

    @Override
    public void visitLeaf(TreeLeaf leaf) {
        if (leaf.getColor() == Color.RED) {
            result = (result * leaf.getValue()) % MOD;
        }
    }
}

class FancyVisitor extends TreeVis {
    private int sumEvenDepthNonLeaf = 0;
    private int sumGreenLeaf = 0;

    @Override
    public int getResult() {
        return Math.abs(sumEvenDepthNonLeaf - sumGreenLeaf);
    }

    @Override
    public void visitNode(TreeNode node) {
        if (node.getDepth() % 2 == 0) {
            sumEvenDepthNonLeaf += node.getValue();
        }
    }

    @Override
    public void visitLeaf(TreeLeaf leaf) {
        if (leaf.getColor() == Color.GREEN) {
            sumGreenLeaf += leaf.getValue();
        }
    }
}

public class Solution {

    public static Tree solve() {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] values = new int[n];
        for (int i = 0; i < n; i++) {
            values[i] = scanner.nextInt();
        }

        Color[] colors = new Color[n];
        for (int i = 0; i < n; i++) {
            colors[i] = scanner.nextInt() == 0 ? Color.RED : Color.GREEN;
        }

        Map<Integer, List<Integer>> edges = new HashMap<>();
        for (int i = 0; i < n - 1; i++) {
            int u = scanner.nextInt() - 1;
            int v = scanner.nextInt() - 1;
            edges.computeIfAbsent(u, k -> new ArrayList<>()).add(v);
            edges.computeIfAbsent(v, k -> new ArrayList<>()).add(u);
        }

        Tree root = buildTree(0, -1, 0, values, colors, edges);
        scanner.close();
        return root;
    }

    private static Tree buildTree(int node, int parent, int depth, int[] values, Color[] colors, Map<Integer, List<Integer>> edges) {
        List<Integer> children = edges.getOrDefault(node, new ArrayList<>());
        if (children.isEmpty() || (children.size() == 1 && children.get(0) == parent)) {
            return new TreeLeaf(values[node], colors[node], depth);
        }

        TreeNode treeNode = new TreeNode(values[node], colors[node], depth);
        for (int child : children) {
            if (child != parent) {
                treeNode.addChild(buildTree(child, node, depth + 1, values, colors, edges));
            }
        }
        return treeNode;
    }
}
