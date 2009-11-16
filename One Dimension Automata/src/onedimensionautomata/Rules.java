/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package onedimensionautomata;

/**
 *
 * Describe the class
 */
public class Rules implements RuleInterface {

    int aboveBorn = 0;
    int belowDie = 1;

    public Rules() {
    }



        public int applyRules(int[] neighbors){
            int rsltState = 10;
            if (neighbors[2] > aboveBorn) {
                    rsltState = 1;
            }
            else if (neighbors[1] < belowDie){
                    rsltState = 0;
            }
            else if (neighbors[3] >= 1 && neighbors[0] == 1) {
                rsltState = 2;
            }
            return rsltState;
        }


}