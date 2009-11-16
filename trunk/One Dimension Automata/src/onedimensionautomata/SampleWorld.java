package onedimensionautomata;


import java.util.ArrayList;
import java.util.List;


/**
 * SampleWorld.java
 * Created on Oct 1, 2009
 */
/**
 * <p>
 *   <code>SampleWorld</code> is a sample implementation of <code>WorldInterface1D</code>
 *   for testing purposes. Cells are filled randomly.
 * </p>
 *
 * @author Elisha Peterson
 */
public class SampleWorld implements WorldInterface1D {

    /** Stores number of cells in the world. */
    int n;
    /** Stores number of different states. */
    int max;
    /** Stores cell states. */
    int[] states;

    /** Set up a sample world with specified number of cells.
     *
     * @param n number of cells
     * @param max number of different states
     */
    public SampleWorld(int n, int max) {
        this.n = n;
        this.max = max;
        states = new int[n];
        for (int i = 0; i < states.length; i++) {
            states[i] = (int) Math.floor(max * Math.random());
        }
    }

    public int[] getStates() {
        return states;
    }


    //
    //
    // STATIC METHODS
    //
    //

    /** Retrieves a sample "world history" (randomly filled)
     * @param gens number of generations
     * @param n number of cells in each generation
     * @param max number of states
     * @return list of worlds
     */
    public static List<WorldInterface1D> getSampleWorld(int gens, int n, int max) {
        List<WorldInterface1D> result = new ArrayList<WorldInterface1D>();
        for (int i = 0; i < gens; i++) {
            result.add(new SampleWorld(n, max));
        }
        return result;
    }

    public int getMaxState() {
        return max;
    }
}
