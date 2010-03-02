/*
 * WorldConnectionMatrix.java
 * Created on Nov 22, 2009
 */
package onedimensionautomata;

import java.util.AbstractList;
import java.util.ArrayList;
import java.util.List;

/**
 * This class stores the topology of a world in matrix form.
 *
 * @author Elisha Peterson
 */
public class WorldConnectionMatrix {

    int[][] connection;
    int curRow;

    public WorldConnectionMatrix(int n) {
        connection = new int[n][n];
    }

    public WorldConnectionMatrix(WorldInterface1D world) {
        int n = world.getWorldSize();
        connection = new int[n][n];
      //  for (int i = 0; i < n; i++) {
      //      for (Integer j : world.getNeighbors(i)) {
     //           connection[i][j] = 1;
    //        }
      //  }

        for (int i = 0; i < (0.02*n*n); i++)
        {
        int eye = (int) Math.round(Math.random()*(n-1));
        int jay = (int) Math.round(Math.random()*(n-1));
           connection[eye][jay] = 1;
            connection[jay][eye] = 1;
        }
    }

    /** 
     * Toggles state associated with the ith row and jth column.
     * @param symmetric if true, toggles both the i-j connection and the j-i connection
     */
    public void toggleConnection(int i, int j, boolean symmetric) {
        if (connection[i][j] != 0) {
            connection[i][j] = 0;
        } else {
            connection[i][j] = 1;
        }
        if (symmetric) {
            connection[j][i] = connection[i][j];
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
        return new AbstractList<WorldConnect>() {
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

        public List<Integer> getNeighbors(int worldLocation) {
            return java.util.Collections.EMPTY_LIST;
        }

        public int getWorldSize() {
            return connection.length;
        }
    }
}
