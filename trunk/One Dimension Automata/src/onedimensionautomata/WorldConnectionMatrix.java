/*
 * WorldConnectionMatrix.java
 * Created on Nov 22, 2009
 */

package onedimensionautomata;

import java.util.AbstractList;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Elisha Peterson
 */
public class WorldConnectionMatrix {

    int[][] connection;
    int curRow;

    public WorldConnectionMatrix(int n) {
        connection = new int[n][n];
    }

    /** Toggles state associated with the ith row and jth column */
    public void toggleConnection(int i, int j) {
        if (connection[i][j] != 0) {
            connection[i][j] = 0;
        } else {
            connection[i][j] = 1;
        }
    }

    /** Returns neighbor(s) associated with ith row and jth column */
    public List<Integer> getNeighbors(int index) {
        ArrayList<Integer> result = new ArrayList<Integer>();
        for (int k = 0; k < connection.length; k++) {
            if (connection[index][k] != 0) {
                result.add(k);
            }
        }
        return result;
    }

    /** Returns list of interfaces as a representation of the data describing the connections. */
    public List<? extends WorldInterface1D> getData() {
        return new AbstractList<WorldConnect>(){
            @Override
            public WorldConnect get(int index) {
                return new WorldConnect(index);
            }
            @Override
            public int size() {
                return connection.length;
            }
        };
    }

    /** Class used to access a row of the connection matrix, as a WorldInterface1D */
    public class WorldConnect implements WorldInterface1D {
        int index;
        private WorldConnect(int index) {
            this.index = index;
        }
        public int[] getStates() {
            return connection[index];
        }
        public int getMaxState() {
            return 1;
        }
    }

}
