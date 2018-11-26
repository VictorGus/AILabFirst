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
        }
        return stateAfterMovement;
    }

    public static State smartMoveh1(State state) {
        State stateAfterMovement;
        int h1RightValue = 8;
        int h1LeftValue = 8;
        int h1UpValue = 8;
        int h1DownValue = 8;
        int[][] afterUp = null;
        int[][] afterDown = null;
        int[][] afterRight = null;
        int[][] afterLeft = null;
        boolean check = false;
        boolean checkUp = false;
        boolean checkDown = false;
        boolean checkLeft = false;
        boolean checkRight = false;
        if (state.deadEnd != true) {
            if ((state.gap[0] == 1 || state.gap[0] == 2) && !(CheckedStates.isChecked(CommonFunctions.matrixToInt(state.moveDown(state))))) {
                afterDown = state.moveDown(state);
                h1DownValue = state.h1(afterDown);
                checkDown = true;
                check = true;
            }
            if ((state.gap[0] == 1 || state.gap[0] == 0) && !(CheckedStates.isChecked(CommonFunctions.matrixToInt(state.moveUp(state))))) {
                afterUp = state.moveUp(state);
                h1UpValue = state.h1(afterUp);
                checkUp = true;
                check = true;
            }
            if ((state.gap[1] == 1 || state.gap[1] == 2) && !(CheckedStates.isChecked(CommonFunctions.matrixToInt(state.moveRight(state))))) {
                afterRight = state.moveRight(state);
                h1RightValue = state.h1(afterRight);
                checkRight = true;
                check = true;
            }
            if ((state.gap[1] == 1 || state.gap[1] == 0) && !(CheckedStates.isChecked(CommonFunctions.matrixToInt(state.moveLeft(state))))) {
                afterLeft = state.moveLeft(state);
                h1LeftValue = state.h1(afterLeft);
                checkLeft = true;
                check = true;
            }
            if (!check) {
                stateAfterMovement = state;
                stateAfterMovement.deadEnd = true;
                return stateAfterMovement;
            } else {
                if (h1DownValue <= h1UpValue && h1DownValue <= h1LeftValue && h1DownValue <= h1RightValue && checkDown) {
                    stateAfterMovement = new State(afterDown);
                    CheckedStates.addNewStateToCheckedStates(stateAfterMovement);
                    return stateAfterMovement;
                } else if (h1UpValue <= h1DownValue && h1UpValue <= h1LeftValue && h1UpValue <= h1RightValue && checkUp) {
                    stateAfterMovement = new State(afterUp);
                    CheckedStates.addNewStateToCheckedStates(stateAfterMovement);
                    return stateAfterMovement;
                } else if (h1LeftValue <= h1UpValue && h1LeftValue <= h1DownValue && h1LeftValue <= h1RightValue && checkLeft) {
                    stateAfterMovement = new State(afterLeft);
                    CheckedStates.addNewStateToCheckedStates(stateAfterMovement);
                    return stateAfterMovement;
                } else if (h1RightValue <= h1UpValue && h1RightValue <= h1LeftValue && h1RightValue <= h1DownValue && checkRight) {
                    stateAfterMovement = new State(afterRight);
                    CheckedStates.addNewStateToCheckedStates(stateAfterMovement);
                    return stateAfterMovement;
                }
            }
        } else {
            stateAfterMovement = state;
            return stateAfterMovement;
        }
     throw new IllegalArgumentException("This state cannot be moved");
    }

    public static State smartMoveh2(State state) {
        State stateAfterMovement;
        int h1RightValue = 1000;
        int h1LeftValue = 1000;
        int h1UpValue = 1000;
        int h1DownValue = 1000;
        int[][] afterUp = null;
        int[][] afterDown = null;
        int[][] afterRight = null;
        int[][] afterLeft = null;
        boolean check = false;
        boolean checkUp = false;
        boolean checkDown = false;
        boolean checkLeft = false;
        boolean checkRight = false;
        if (state.deadEnd != true) {
            if ((state.gap[0] == 1 || state.gap[0] == 2) && !(CheckedStates.isChecked(CommonFunctions.matrixToInt(state.moveDown(state))))) {
                afterDown = state.moveDown(state);
                h1DownValue = state.h2(afterDown);
                checkDown = true;
                check = true;
            }
            if ((state.gap[0] == 1 || state.gap[0] == 0) && !(CheckedStates.isChecked(CommonFunctions.matrixToInt(state.moveUp(state))))) {
                afterUp = state.moveUp(state);
                h1UpValue = state.h2(afterUp);
                checkUp = true;
                check = true;
            }
            if ((state.gap[1] == 1 || state.gap[1] == 2) && !(CheckedStates.isChecked(CommonFunctions.matrixToInt(state.moveRight(state))))) {
                afterRight = state.moveRight(state);
                h1RightValue = state.h2(afterRight);
                checkRight = true;
                check = true;
            }
            if ((state.gap[1] == 1 || state.gap[1] == 0) && !(CheckedStates.isChecked(CommonFunctions.matrixToInt(state.moveLeft(state))))) {
                afterLeft = state.moveLeft(state);
                h1LeftValue = state.h2(afterLeft);
                checkLeft = true;
                check = true;
            }
            if (!check) {
                stateAfterMovement = state;
                stateAfterMovement.deadEnd = true;
                return stateAfterMovement;
            } else {
                if (h1DownValue <= h1UpValue && h1DownValue <= h1LeftValue && h1DownValue <= h1RightValue && checkDown) {
                    stateAfterMovement = new State(afterDown);
                    CheckedStates.addNewStateToCheckedStates(stateAfterMovement);
                    return stateAfterMovement;
                } else if (h1UpValue <= h1DownValue && h1UpValue <= h1LeftValue && h1UpValue <= h1RightValue && checkUp) {
                    stateAfterMovement = new State(afterUp);
                    CheckedStates.addNewStateToCheckedStates(stateAfterMovement);
                    return stateAfterMovement;
                } else if (h1LeftValue <= h1UpValue && h1LeftValue <= h1DownValue && h1LeftValue <= h1RightValue && checkLeft) {
                    stateAfterMovement = new State(afterLeft);
                    CheckedStates.addNewStateToCheckedStates(stateAfterMovement);
                    return stateAfterMovement;
                } else if (h1RightValue <= h1UpValue && h1RightValue <= h1LeftValue && h1RightValue <= h1DownValue && checkRight) {
                    stateAfterMovement = new State(afterRight);
                    CheckedStates.addNewStateToCheckedStates(stateAfterMovement);
                    return stateAfterMovement;
                }
            }
        } else {
            stateAfterMovement = state;
            return stateAfterMovement;
        }
        throw new IllegalArgumentException("This state cannot be moved");
    }
}
