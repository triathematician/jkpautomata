/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package onedimensionautomata;

import java.util.ArrayList;
import java.util.Arrays;

/**
 *
 * @author x00875
 */
public class Main {

    public static void main(String[] args) {
        runSimulation(6, 20, new Rules());
    }

    public static ArrayList<World> runSimulation(int generations, int size, RuleInterface rules) {
        int state = 4;
        World newworld = new World(size, state);

        for (int i = 0; i < newworld.getWorldSize(); i++) {
            newworld.setWorldValue(i, (int) Math.round((state - 1) * Math.random()));
        }

        return run(newworld, generations, rules);
    }

    public static ArrayList<World> run(World newworld, int generations, RuleInterface rules) {
        int size = newworld.worldSize;
        int state = newworld.nstates;
        ArrayList<World> history = new ArrayList<World>();
        World oldworld;
        int[] neighborStates = new int[state + 1];

        for (int k = 1; k <= generations; k++) {
            System.out.println(newworld);
            history.add(newworld);
            newworld = new World(size, state);
            oldworld = history.get(history.size() - 1);

            for (int i = 0; i < newworld.getWorldSize(); i++) {
                neighborStates = oldworld.getNeighborStates(i, state);
                //System.out.print(neighbors[0]);
                //System.out.print(rules.applyRules(oldworld.getWorld()[i],neighbors));
                newworld.setWorldValue(i, rules.applyRules(neighborStates));
            }

        }
        return history;
    }
}
