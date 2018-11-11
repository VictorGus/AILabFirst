package com.company;

public class State implements CommonFunctions {

    int [][] initialState = new int[3][3];
    int [] gap = new int[2];
    //PreviousMovement previousMovement;
    int stateAsInt;
    boolean deadEnd;
    State(int[][] initializingState) {
        for(int i = 0; i < 3; i++) {
            for(int j = 0; j < 3; j++) {
               initialState[i][j] = initializingState[i][j];
                if(initializingState[i][j] == 0) {
                    gap[0] = i;
                    gap[1] = j;
                }
            }
        }
        deadEnd = false;
        stateAsInt = CommonFunctions.matrixToInt(initialState);
        //this.previousMovement = previousMovement;
    }

}
