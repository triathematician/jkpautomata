package onedimensionautomata;


import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.event.ComponentEvent;
import java.awt.event.ComponentListener;
import java.awt.event.MouseEvent;
import java.awt.geom.Rectangle2D;
import java.util.List;
import javax.swing.JPanel;
import javax.swing.Scrollable;
import javax.swing.event.MouseInputListener;

/**
 * WorldView.java
 * Created on Oct 1, 2009
 */

/**
 * <p>
 *   <code>WorldView</code> is a panel that displays a grid of squares, e.g. for use
 *   with cellular automata. Also maps mouse input to a row and column value.
 * </p>
 *
 * @author Elisha Peterson
 */
public class WorldView extends JPanel implements MouseInputListener, Scrollable {

    //
    //
    // PROPERTIES
    //
    //

    /** The margin between squares, and around the outside of the window. */
    int margin = 2;
    /** Default number of cells to display. */
    int n = 10;
    /** Default number of generations to display. */
    int gens = 10;
    /** Stores the data being represented. */
    private List<? extends WorldInterface1D> data;

    /** Stores the palette used for coloring. */
    StatePalette palette = StatePalette.DEFAULT;

    //
    //
    // CONSTRUCTORS
    //
    //

    /** Initializes with a sample world. */
    public WorldView() {
        this(SampleWorld.getSampleWorld(40, 15, 5));
    }

    /** Initializes with a custom world. */
    public WorldView(List<? extends WorldInterface1D> data) {
        this.data = data;
        addMouseListener(this);
        addMouseMotionListener(this);
        addComponentListener(new ComponentListener(){
            public void componentResized(ComponentEvent e) {
                updateDimensions();
            }
            public void componentMoved(ComponentEvent e) {
            }
            public void componentShown(ComponentEvent e) {
            }
            public void componentHidden(ComponentEvent e) {
            }
        });
    }

    //
    //
    // BEAN PATTERNS
    //
    //

    /** Retrieves current data. */
    public List<? extends WorldInterface1D> getData() {
        return data;
    }

    /** Sets current data. */
    public void setData(List<? extends WorldInterface1D> data) {
        this.data = data;
        gens = data.size();
        n = data.get(0).getStates().length;
        updateDimensions();
    }

    //
    //
    // PAINT METHODS
    //
    //

    /**
     * This method retrieves a customized color for the given state.
     *
     * @param state the state as an integer of value 0 or larger
     * @return Color associated with the state
     */

    transient float sqSize = 1f;

    /** Updates size of display */
    void updateDimensions() {
        sqSize = ((float) getBounds().getWidth() - margin) / n - margin;
        setPreferredSize(new Dimension((int) getBounds().getWidth(), (int) (gens * (margin + sqSize) + margin)));
        setSize(new Dimension((int) getBounds().getWidth(), (int) (gens * (margin + sqSize) + margin)));
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D) g;
        Rectangle2D.Float rect = new Rectangle2D.Float(0, 0, sqSize, sqSize);
        for (int i = 0; i < n; i++) {
            rect.x = margin + i * (sqSize + margin);
            for (int j = 0; j < gens; j++) {
                int state = data.get(j).getStates()[i];
                rect.y = margin + j * (sqSize + margin);
                g2.setColor(palette.getColorForState(state));
                g2.fill(rect);
                if (rowCol != null && rowCol.x == i && rowCol.y == j) {
                    if (pressed) {
                        g2.setColor(Color.RED);
                    } else {
                        g2.setColor(Color.YELLOW);
                    }
                } else {
                    g2.setColor(Color.BLACK);
                }
                g2.draw(rect);
            }
        }
    }

    /** Computes and returns row and column corresponding to a window coordinate (the closest only). */
    public Point getRowCol(Point wpt) {
        double ix = (wpt.getX() - margin - sqSize/2) / (sqSize + margin);
        double iy = (wpt.getY() - margin - sqSize/2) / (sqSize + margin);
        return new Point((int) Math.round(ix), (int) Math.round(iy));
    }


    //
    //
    // SCROLLABLE METHODS
    //
    //

    public Dimension getPreferredScrollableViewportSize() {
        return new Dimension(Math.min(10 * n, 400), 400);
    }

    public int getScrollableUnitIncrement(Rectangle visibleRect, int orientation, int direction) {
        return 10;
    }

    public int getScrollableBlockIncrement(Rectangle visibleRect, int orientation, int direction) {
        return 30;
    }

    public boolean getScrollableTracksViewportWidth() {
        return true;
    }

    public boolean getScrollableTracksViewportHeight() {
        return false;
    }

    //
    //
    // MOUSE METHODS
    //
    //

    transient boolean pressed = false;
    transient Point rowCol;

    public void mouseClicked(MouseEvent e) {
        rowCol = getRowCol(e.getPoint());
        repaint();
    }

    public void mousePressed(MouseEvent e) {
        pressed = true;
        repaint();
    }

    public void mouseReleased(MouseEvent e) {
        pressed = false;
        repaint();
    }

    public void mouseEntered(MouseEvent e) {
    }

    public void mouseExited(MouseEvent e) {
    }

    public void mouseDragged(MouseEvent e) {
    }

    public void mouseMoved(MouseEvent e) {
        rowCol = getRowCol(e.getPoint());
        repaint();
    }
}
