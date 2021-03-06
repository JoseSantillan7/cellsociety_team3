package cellsociety.cells;

/**
 * author: Cynthia France, Jose Santillan
 */
public class LifeCell extends Cell {

  public static final int DEAD = 0;
  public static final int ALIVE = 1;

  private int nextState;

  public LifeCell(int x, int y, int initState) {
    super(x, y, initState);

  }

  @Override
  public int getNextState() {
    int numAlive = numNeighborsAlive();

    if (numAlive == 2 && isAlive()) {nextState = ALIVE; return ALIVE;}
    else if (numAlive == 3) {nextState = ALIVE; return ALIVE;}
    else {nextState = DEAD; return DEAD;}
  }

  private int numNeighborsAlive() {
    int numAlive = 0;
    for (Cell myNeighbor : myNeighbors) {
      LifeCell cell = (LifeCell) myNeighbor;
      if (cell.getMyCurrentState() == ALIVE) numAlive++;
    }
    return numAlive;
  }

  public boolean isAlive() {return currentState == 1;}

  public void update() {
    currentState = nextState;
  }

}
