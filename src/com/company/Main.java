package com.company;

import sun.reflect.generics.tree.Tree;

public class Main {

    public static void main(String[] args) {
        int[][] initialState = {{3, 6, 4}, {2, 5, 8}, {7, 1, 0}};
        //int[][] initialState = {{3, 1, 2}, {4, 0, 5}, {6, 7, 8}};
        State state = new State(initialState);
        State anotherState;
        CheckedStates.addNewStateToCheckedStates(state);
        /*int asIntForCheck = CommonFunctions.matrixToInt(initialState);
        state.printStateOfBoard(state.initialState);
        CheckedStates checkedStates = new CheckedStates();
        checkedStates.addNewStateToCheckedStates(state);
        System.out.println(checkedStates.isChecked(asIntForCheck));
        */
        //TreeNode<State>[] nodes = new TreeNode[100];
        TreeNode<State> nodes = new TreeNode(state);
        while(true) {
            if (CommonFunctions.isGoalState(nodes.data.initialState)) {
                System.out.println("GOAL!!!");
                break;
            }
            state = Movement.move(state);
            nodes = nodes.addChild(state);
            nodes.data.printStateOfBoard(nodes.data.initialState);
            System.out.println("Level is " + nodes.getLevel());
            System.out.println();
            if (nodes.data.deadEnd == true) {
                nodes = nodes.findNotDeadEnd(nodes.parent);
                state = nodes.data;
                System.out.println("NOT DEADEND");
                state.printStateOfBoard(nodes.data.initialState);
                System.out.println("NOT DEADEND");
            }
        }
    }
}
