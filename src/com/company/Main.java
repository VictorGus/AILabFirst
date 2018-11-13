package com.company;

//import sun.reflect.generics.tree.Tree;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Scanner;

public class Main {
    static int[][] initialState = {{3, 6, 4}, {2, 5, 8}, {7, 1, 0}};
    static State state = new State(initialState);
    static TreeNode<State> nodes = new TreeNode(state);
    static final int deadWall = 10000;

    public static void main(String[] args) {
        //int[][] initialState = {{3, 1, 2}, {4, 0, 5}, {6, 7, 8}};
        CheckedStates.addNewStateToCheckedStates(state);
        /*int asIntForCheck = CommonFunctions.matrixToInt(initialState);
        state.printStateOfBoard(state.initialState);
        CheckedStates checkedStates = new CheckedStates();
        checkedStates.addNewStateToCheckedStates(state);
        System.out.println(checkedStates.isChecked(asIntForCheck));
        */
        //TreeNode<State>[] nodes = new TreeNode[100];


        Runnable run1 = new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                Main.runTask();

            }
        };
        Runnable run2 = new Runnable() {
            @Override
            public void run() {
                System.out.println("SECOND THREAD");
                //Scanner check = new Scanner(System.in);
                //check.nextInt();

                Main.runTask();
            }
        };

        Thread thread1 = new Thread(run1);
        Thread thread2 = new Thread(run2);

        thread1.run();
        thread2.run();

    }

    public static void runTask() {
        while (true) {
            if (CommonFunctions.isGoalState(nodes.data.initialState)) {
                System.out.println("GOAL!!!");
                break;
            }
            state = Movement.move(state);
            nodes = nodes.addChild(state);
            nodes.data.printStateOfBoard(nodes.data.initialState);
            System.out.println("Level is " + nodes.getLevel());
            System.out.println();
            if (nodes.getLevel() == deadWall) {
                nodes.data.deadEnd = true;
            }
            if ((nodes.data.deadEnd == true)) {
                if (nodes.parent.parent == null) {
                    state.printStateOfBoard(nodes.parent.data.initialState);
                    System.out.println("Ti pidor ya prishel, otkrivay");
                    break;
                }
                nodes = nodes.findNotDeadEnd(nodes.parent);
                state = nodes.data;
                System.out.println("NOT DEADEND");
                state.printStateOfBoard(nodes.data.initialState);
                System.out.println("NOT DEADEND");
            }
        }
    }
}
