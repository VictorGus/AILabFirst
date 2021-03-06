package com.company;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class TreeNode<T> implements Iterable<TreeNode<T>> {

    public T data;
    public TreeNode<T> parent;
    public List<TreeNode<T>> children;
    private int level = -1;

    public boolean isRoot() {
        return parent == null;
    }

    public boolean isLeaf() {
        return children.size() == 0;
    }

    private List<TreeNode<T>> elementsIndex;

    public TreeNode(T data) {
        this.data = data;
        //this.children = new LinkedList<TreeNode<T>>();
        //this.elementsIndex = new LinkedList<TreeNode<T>>();
        //this.elementsIndex.add(this);
    }

    public TreeNode<T> addChild(T child) {
        TreeNode<T> childNode = new TreeNode<T>(child);
        childNode.parent = this;
        //this.children.add(childNode);
        //this.registerChildForSearch(childNode);
        return childNode;
    }

    public int getLevel() {
        if (this.isRoot())
            return 0;
        else
            return parent.getLevel() + 1;
    }

    private void registerChildForSearch(TreeNode<T> node) {
        elementsIndex.add(node);
        if (parent != null)
            parent.registerChildForSearch(node);
    }

    public TreeNode<T> findTreeNode(Comparable<T> cmp) {
        for (TreeNode<T> element : this.elementsIndex) {
            T elData = element.data;
            if (cmp.compareTo(elData) == 0)
                return element;
        }

        return null;
    }

    public TreeNode<State> findNotDeadEnd(TreeNode<State> node) {
        if (node.data.deadEnd == false) {
            return node;
        } else {
            return this.findNotDeadEnd(node.parent);
        }
    }

    public void showPathToState(TreeNode<State> node) {
        while(node.parent!=null) {
            node.data.printStateOfBoard(node.data.initialState);
            System.out.println();
            node = node.parent;
        }
    }

    @Override
    public String toString() {
        return data != null ? data.toString() : "[data null]";
    }

    @Override
    public Iterator<TreeNode<T>> iterator() {
        TreeNodeIterator<T> iter = new TreeNodeIterator<T>(this);
        return iter;
    }

//    public int getLevel() {
//        if (this.isRoot())
//            return 0;
//        else if (this.level == -1)
//            this.setLevel();
//        return this.level;
//    }
//
//    public void setLevel() {
//        this.level = this.parent.getLevel() + 1;
//    }
}
