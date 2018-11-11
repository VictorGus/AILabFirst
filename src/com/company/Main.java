package com.company;

import sun.reflect.generics.tree.Tree;

public class Main {

    public static void main(String[] args) {
        int[][] initialState = {{3, 6, 4}, {2, 5, 8}, {7, 1, 0}};
        State state = new State(initialState);
        State anotherState;
        CheckedStates.addNewStateToCheckedStates(state);
        /*int asIntForCheck = CommonFunctions.matrixToInt(initialState);
        state.printStateOfBoard(state.initialState);
        CheckedStates checkedStates = new CheckedStates();
        checkedStates.addNewStateToCheckedStates(state);
        System.out.println(checkedStates.isChecked(asIntForCheck));
        */
        TreeNode<State>[] nodes = new TreeNode[10000];
        TreeNode<State> initial = new TreeNode(state);
        nodes[0] = initial;
        boolean notDeadEnd = false;
        int k = 1;
        for (int i = 0; i < 10000; i++) {
            state = Movement.move(state);
            nodes[k] = nodes[k - 1].addChild(state);
            nodes[k].data.printStateOfBoard(nodes[k].data.initialState);
            System.out.println("Level is " + nodes[k].getLevel());
            System.out.println();
            if(CommonFunctions.isGoalState(nodes[k].data.initialState)) {
                System.out.println("GOAL!!!");
                break;
            }
            if (nodes[k].data.deadEnd == true ) {
                nodes[k] = nodes[k].findNotDeadEnd(nodes[k-1].parent);
                state = nodes[k].data;
            } else {
                k++;
            }
        }
//        for (int i = 0; i < 100; i++) {
//            state = Movement.move(state);
//            state.printStateOfBoard(state.initialState);
//            System.out.println();
//            if(state.isGoalState(state.initialState)) {
//                System.out.println("IT'S GOAL STAT");
//                state.printStateOfBoard(state.initialState);
//                System.out.println("IT'S GOAL STAT");
//            }
//        }

        /*String testString = "Root";
        String child = "First child";
        TreeNode<String> newTree = new TreeNode<>(testString);
        System.out.println(newTree.iterator().hasNext());
        TreeNode<String> childTree = newTree.addChild(child);
        System.out.println(newTree.data);
        System.out.println(childTree.data);
        System.out.println(childTree.parent.data);
        TreeNode<String> newNode = newTree.addChild("Second child");
        TreeNode<String> newNodeNewLevel = childTree.addChild("First child of the first child of the root");
        System.out.println(childTree.getLevel());
        System.out.println(newNode.getLevel());
        System.out.println(newNodeNewLevel.getLevel());
        System.out.println(newNodeNewLevel.parent.data);
        System.out.println(newNode.parent.data); */
    }

}
