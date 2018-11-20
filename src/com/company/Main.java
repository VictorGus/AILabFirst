package com.company;

//import sun.reflect.generics.tree.Tree;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Scanner;

public class Main {
    static int[][] initialState = {{0, 4, 3}, {6, 2, 1}, {7, 5, 8}};
    static State state = new State(initialState);
    static TreeNode<State> nodes = new TreeNode(state);
    static final int deadWall = 600000;
    static Thread thread1;
    static boolean goal = false;
    static TreeNode<State> goalNode;
    static int iteration = 0;
    static int amountOfDeadEndStates = 0;
    static int amountOfFoundGoals = 0;
    public static void main(String[] args) {
        //int[][] initialState = {{3, 1, 2}, {4, 0, 5}, {6, 7, 8}};
        CheckedStates.addNewStateToCheckedStates(state);
        /*int asIntForCheck = CommonFunctions.matrixToInt(initialState);
        state.printStateOfBoard(state.initialState);
        CheckedStates checkedStates = new CheckedStates();
        checkedStates.addNewStateToCheckedStates(state);
        System.out.println(checkedStates.isChecked(asIntForCheck));
        */
        Main.runTask();
        System.out.println("Amount of states "+iteration);
        System.out.println("Amount of fully revealed states "+amountOfDeadEndStates);
        if(goal) {
            System.out.println("The goal state has been found");
            state.printStateOfBoard(goalNode.data.initialState);
            System.out.println("Level is of goal state is "+ goalNode.getLevel());
            goalNode.showPathToState(goalNode);
            System.out.println("Amount of found goal states " + amountOfFoundGoals);
        }

    }

    public static void runTask() {
        while (true) {
            if (CommonFunctions.isGoalState(nodes.data.initialState)) {
                goal = true;
                goalNode = nodes;
                amountOfFoundGoals++;
            }
            state = Movement.move(state);
            nodes = nodes.addChild(state);
//            if (nodes.getLevel() == deadWall) {
//                nodes.data.deadEnd = true;
//            }
            iteration++;
            if ((nodes.data.deadEnd == true)) {
                amountOfDeadEndStates++;
                if (nodes.parent.parent == null) {
                    System.out.println("Last state:");
                    state.printStateOfBoard(nodes.parent.data.initialState);
                    if(!goal) {
                        System.out.println("The goal state hasn't been found");
                    }
                    break;
                }
                nodes = nodes.findNotDeadEnd(nodes.parent);
                state = nodes.data;
                //System.out.println("DEADEND OCCURED");
                //state.printStateOfBoard(nodes.data.initialState);
                //System.out.println("NOT DEADEND");
            }
        }
    }
}
