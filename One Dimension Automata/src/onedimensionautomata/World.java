/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package onedimensionautomata;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 *
 * Describe the class
 */
public class World implements WorldInterface1D {

    int[] world;
    public int worldSize;
    int nstates;
    WorldConnectionMatrix topology = null;

    public World(int size, int state) {
        world = new int[size];
        setWorldSize(size);
        this.nstates=state;
    }

    public int[] getWorld() {
        return world;
    }

    public void setWorld(int[] world) {
        this.world = world;
    }

    public int getWorldSize() {
        return worldSize;
    }

    public void setWorldSize(int worldSize) {
        this.worldSize = worldSize;
    }
    
    public int[] setWorldValue(int worldLocation, int newWorldValue) {
        if (newWorldValue == 10){
            return world;
        }
        world[worldLocation] = newWorldValue;
        return world;
    }

    /**
     * Returns array describing location state and state counts of neighbors.
     * @param worldLocation location of interest
     * @param state number of states
     * @return array... first entry is location state; remaining 1 through n
     *   are state counts of each of these states
     */

    public List<Integer> getNeighbors(int worldLocation){
        if (topology == null) {
            List<Integer> list = new ArrayList<Integer>();
            list.add((worldLocation+1)%world.length);
            list.add((worldLocation+world.length-1)%world.length);
            return list;
        } else {
            return topology.getNeighbors(worldLocation);
        }
    }

    public int[] getNeighborStates(int worldLocation, int nstates) {
        int[] neighborStates;
        neighborStates = new int[nstates + 1];
        for (int i = 0; i <= nstates; i++) {
            neighborStates[i] = 0;
        }
        neighborStates[0] = world[worldLocation];
        for (Integer i : getNeighbors(worldLocation)) {
            int state = world[i];
            neighborStates[state + 1] = neighborStates[state + 1] + 1;
        }
        return neighborStates;
    }

    Integer[] countStates() {
        Integer[] stateCount = new Integer[nstates];
        Arrays.fill(stateCount, 0);
        for (int i = 0; i < worldSize; i++) {
            stateCount[world[i]]++;
        }
        return stateCount;
    }


    @Override
    public String toString() {
        return Arrays.toString(world);
    }

    public int[] getStates() {
        return world;
    }

    public int getMaxState() {
        return nstates;
    }


}
