/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package onedimensionautomata;

import java.util.Arrays;

/**
 *
 * Describe the class
 */
public class World implements WorldInterface1D {

    int[] world;
    public int worldSize;
    int state;

    public World(int size, int state) {
        world = new int[size];
        setWorldSize(size);
        this.state=state;
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
    public int[] getNeighbors(int worldLocation, int state) {
        int[] neighbor;
        neighbor = new int[state+1];
        for (int i=0; i<=state; i++){
            neighbor[i]=0;
        }

        if (worldLocation == 0){
            neighbor[0] = world[worldLocation];
            for ( int i = 0; i<state; i++)
            {
                if (world[worldLocation+1]==i){
                    neighbor[i+1]= neighbor[i+1]+1;
                }
                if (world[worldSize-1]==i){
                    neighbor[i+1]= neighbor[i+1]+1;
                }
            }
            return neighbor;
        } else if (worldLocation == worldSize-1){
            neighbor[0] = world[worldLocation];
            for ( int i = 0; i<state; i++)
            {
                if (world[worldLocation-1]==i){
                    neighbor[i+1]= neighbor[i+1]+1;
                }
                if (world[0]==i){
                    neighbor[i+1]= neighbor[i+1]+1;
                }
            }
            return neighbor;
        } else
        {
                        neighbor[0] = world[worldLocation];
            for ( int i = 0; i<state; i++)
            {
                if (world[worldLocation-1]==i){
                    neighbor[i+1]= neighbor[i+1]+1;
                }
                if (world[worldLocation+1]==i){
                    neighbor[i+1]= neighbor[i+1]+1;
                }
            }
        return neighbor;
        }
    }
    Integer[] countStates(){
        Integer [] stateCount = new Integer[state];
        Arrays.fill(stateCount, 0);
        for (int i = 0; i<worldSize; i++){
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
        return state;
    }


}
