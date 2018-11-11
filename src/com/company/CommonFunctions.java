package com.company;

import java.util.Arrays;


public interface CommonFunctions {

    static boolean isGoalState(int[][] currentState) {
        if (currentState == null) {
            throw new IllegalArgumentException("The state cannot be empty");
        }
        int[][] goalState = {{0, 1, 2}, {3, 4, 5}, {6, 7, 8}};
        int count = 0;
        for (int i = 0; i < 3; i++) {
            if (Arrays.equals(goalState[i], currentState[i])) {
                count++;
            }
        }
        if (count == 3) {
            return true;
        } else {
            return false;
        }
    }

    default void printStateOfBoard(int[][] stateToPrint) {
        if (stateToPrint == null) {
            throw new IllegalArgumentException("State cannot be empty");
        }
        for (int i = 0; i < stateToPrint.length; i++) {
            for (int j = 0; j < stateToPrint[0].length; j++) {
                System.out.print(stateToPrint[i][j]);
            }
            System.out.println();
        }
    }

    default int[][] moveUp(State state) {
        int[][] newState = state.copyState(state.initialState);
        newState[state.gap[0]][state.gap[1]] = newState[state.gap[0] + 1][state.gap[1]];
        newState[state.gap[0] + 1][state.gap[1]] = 0;
        return newState;
    }

    default int[][] moveDown(State state) {
        int[][] newState = state.copyState(state.initialState);
        newState[state.gap[0]][state.gap[1]] = newState[state.gap[0] - 1][state.gap[1]];
        newState[state.gap[0] - 1][state.gap[1]] = 0;
        return newState;
    }

    default int[][] moveRight(State state) {
        int[][] newState = state.copyState(state.initialState);
        newState[state.gap[0]][state.gap[1]] = newState[state.gap[0]][state.gap[1] - 1];
        newState[state.gap[0]][state.gap[1] - 1] = 0;
        return newState;
    }

    default int[][] moveLeft(State state) {
        int[][] newState = state.copyState(state.initialState);
        newState[state.gap[0]][state.gap[1]] = newState[state.gap[0]][state.gap[1] + 1];
        newState[state.gap[0]][state.gap[1] + 1] = 0;
        return newState;
    }

    default int[][] copyState(int[][] state) {
        int[][] newState = new int[3][3];
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                newState[i][j] = state[i][j];
            }
        }
        return newState;
    }

    static public int matrixToInt(int[][] matrix) {
        char[] matrixToCharArray = new char[9];
        matrixToCharArray[0] = Character.forDigit(matrix[0][0], 10);
        matrixToCharArray[1] = Character.forDigit(matrix[0][1], 10);
        matrixToCharArray[2] = Character.forDigit(matrix[0][2], 10);
        matrixToCharArray[3] = Character.forDigit(matrix[1][0], 10);
        matrixToCharArray[4] = Character.forDigit(matrix[1][1], 10);
        matrixToCharArray[5] = Character.forDigit(matrix[1][2], 10);
        matrixToCharArray[6] = Character.forDigit(matrix[2][0], 10);
        matrixToCharArray[7] = Character.forDigit(matrix[2][1], 10);
        matrixToCharArray[8] = Character.forDigit(matrix[2][2], 10);
        String stringMatrix = new String(matrixToCharArray);
        int matrixInt = Integer.parseInt(stringMatrix);
        return matrixInt;
    }
}
