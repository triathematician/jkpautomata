package onedimensionautomata;

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

    /** Returns array of states associated with this "world". */
    public int[] getStates();

    /** Returns maximum state. */
    public int getMaxState();
}
