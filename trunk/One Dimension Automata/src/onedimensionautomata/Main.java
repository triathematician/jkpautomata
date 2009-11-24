/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package onedimensionautomata;

import java.util.ArrayList;

/**
 * This class runs a 1d-automata simulation.
 *
 * @author Steve Kinney
 */
public class Main {

    public static void main(String[] args) {
        World w = new World(6, 20);
        randomizeWorld(w);
        run(w, 6, new Rules());
    }

    public static void randomizeWorld(World world) {
        // randomize states
        for (int i = 0; i < world.getWorldSize(); i++) {
            world.setWorldValue(i, (int) Math.round((world.nstates - 1) * Math.random()));
        }
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
            newworld.topology = oldworld.topology;

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
