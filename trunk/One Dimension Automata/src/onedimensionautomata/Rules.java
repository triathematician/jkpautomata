/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package onedimensionautomata;

/**
 *
 * Describe the class
 */
public enum Rules implements RuleInterface {

    RULE1() {

        public int applyRules(int[] neighborStates) {
            int rsltState = 10;
            if (neighborStates[0] == 0 && neighborStates[2] > 0) {
                rsltState = 1;
            }
            return rsltState;
        }
    },
    RULE2() {

        public int applyRules(int[] neighborStates) {
            int rsltState = 10;
            if (neighborStates[0] == 0 && neighborStates[2] > 0) {
                rsltState = 1;
            } else if (neighborStates[0] == 1) {
                rsltState = 2;
            } else if (neighborStates[0] == 2) {
                rsltState = 2;
            }
            return rsltState;
        }
    };

//    int aboveBorn = 0;
//   int belowDie = 1;

    // public Rules() {
    // }
    /** Random
     *             int rsltState = 10;
    if (neighborStates[0] == 0 && neighborStates[2] > 0 && Math.random() < 0.5) {
    rsltState = 1;
    }
    else if (neighborStates[0] == 1 && Math.random() < 0.7) {
    rsltState = 0;
    }
     */
    /** SIR
     *             int rsltState = 10;
    if (neighborStates[0] == 0 && neighborStates[2] > 0) {
    rsltState = 1;
    }
    else if (neighborStates[0] == 1) {
    rsltState = 2;
    }
    else if (neighborStates[0] == 2) {
    rsltState = 2;
    }
     */
    /** Infectious Recovery Period

     *             int rsltState = 10;
    if (neighborStates[0] == 0 && neighborStates[2] > 0) {
    rsltState = 1;
    }
    else if (neighborStates[0] == 1){
    rsltState = 2;
    }
    else if (neighborStates[3] > 0 && neighborStates[0] != 1){
    rsltState = 1;
    }
    else if (neighborStates[0] == 2) {
    rsltState = 3;
    }
    else if (neighborStates[0] == 2){
    rsltState = 0;
    }
    return rsltState;
    }
     */
}