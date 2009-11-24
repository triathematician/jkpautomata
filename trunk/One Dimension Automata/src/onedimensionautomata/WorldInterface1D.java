package onedimensionautomata;

import java.util.List;

/**
 * WorldInterface1D.java
 * Created on Oct 1, 2009
 */


/**
 * <p>
 *   <code>WorldInterface1D</code> is an interface for 1D worlds.
 * </p>
 *
 * @author Elisha Peterson
 */
public interface WorldInterface1D {

    /** 
     * Returns array of states associated with this "world". 
     */
    public int[] getStates();

    /** 
     * Returns index of the maximum state, e.g. if there are two
     * options for the state it should return 1. If there are n options,
     * should return n-1.
     */
    public int getMaxState();

    public int getWorldSize();

    /**
     * Returns list describing neighbors
     */
    List<Integer> getNeighbors(int worldLocation);
}
