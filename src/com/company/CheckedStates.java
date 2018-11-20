package com.company;

import java.util.HashMap;
import java.util.Map;

public class CheckedStates {
    static Map checkedStates = new HashMap();

    static void addNewStateToCheckedStates (State state) {
        checkedStates.put(state.stateAsInt,null);
    }

    static boolean isChecked(long stateAsInt) {
        return checkedStates.containsKey(stateAsInt);
    }
}
