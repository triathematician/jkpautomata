/**
 * StatePalette.java
 * Created on Nov 24, 2009
 */
package onedimensionautomata;

import java.awt.Color;

/**
 * <p>
 *    This class contains some basic color palettes mapping states to colors.
 * </p>
 * @author Elisha Peterson
 */
public enum StatePalette {
    DEFAULT(5) {
        public Color getColorForState(int state) {
            return getCol(state, COLOR_DEFAULT);
        }
    },
    REDS(5) {
        public Color getColorForState(int state) {
            return getCol(state, COLOR_RED);
        }
    },
    GREENS(5) {
        public Color getColorForState(int state) {
            return getCol(state, COLOR_GREEN);
        }
    },
    BLUES(5) {
        public Color getColorForState(int state) {
            return getCol(state, COLOR_BLUE);
        }
    };
    
    final static Color[] COLOR_DEFAULT = {Color.WHITE, Color.BLACK, Color.BLUE, Color.RED, Color.GREEN, Color.GRAY};
    final static Color[] COLOR_RED = {Color.WHITE, new Color(255, 128, 128), Color.RED, new Color(128, 0, 0), Color.BLACK, Color.GRAY};
    final static Color[] COLOR_BLUE = {Color.WHITE, new Color(128, 128, 255), Color.BLUE, new Color(0, 0, 128), Color.BLACK, Color.GRAY};
    final static Color[] COLOR_GREEN = {Color.WHITE, new Color(128, 255, 128), Color.GREEN, new Color(0, 128, 0), Color.BLACK, Color.GRAY};
    int maxStates = 4;

    StatePalette(int maxStates) {
        this.maxStates = maxStates;
    }

    public abstract Color getColorForState(int state);

    private static Color getCol(int state, Color[] arr) {
        return (state < 0 || state >= arr.length) ? arr[arr.length - 1] : arr[state];
    }
}
