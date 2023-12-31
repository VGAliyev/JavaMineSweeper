package sweeper;

public class Coordinate {
    public int x;
    public int y;

    public Coordinate(int x, int y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof Coordinate c) {
            return c.x == x && c.y == y;
        }
        return super.equals(obj);
    }
}
