package com.company;

public class Movement {

    public static State move(State state) {
        State stateAfterMovement;
        if (state.deadEnd != true) {
            if ((state.gap[0] == 1 || state.gap[0] == 2) && !(CheckedStates.isChecked(CommonFunctions.matrixToInt(state.moveDown(state))))) {
                stateAfterMovement = new State(state.moveDown(state));
                CheckedStates.addNewStateToCheckedStates(stateAfterMovement);
            } else if ((state.gap[0] == 1 || state.gap[0] == 0) && !(CheckedStates.isChecked(CommonFunctions.matrixToInt(state.moveUp(state))))) {
                stateAfterMovement = new State(state.moveUp(state));
                CheckedStates.addNewStateToCheckedStates(stateAfterMovement);
            } else if ((state.gap[1] == 1 || state.gap[1] == 2) && !(CheckedStates.isChecked(CommonFunctions.matrixToInt(state.moveRight(state))))) {
                stateAfterMovement = new State(state.moveRight(state));
                CheckedStates.addNewStateToCheckedStates(stateAfterMovement);
            } else if ((state.gap[1] == 1 || state.gap[1] == 0) && !(CheckedStates.isChecked(CommonFunctions.matrixToInt(state.moveLeft(state))))) {
                stateAfterMovement = new State(state.moveLeft(state));
                CheckedStates.addNewStateToCheckedStates(stateAfterMovement);
            } else {
                stateAfterMovement = state;
                stateAfterMovement.deadEnd = true;
            }
            return stateAfterMovement;
        } else {
            stateAfterMovement = state;
            System.out.println("It's deadend");
        }
        return stateAfterMovement;
    }
}
