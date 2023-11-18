package sweeper;

import java.util.ArrayList;

public class Ranges {
    private static Coordinate size;
    private static ArrayList<Coordinate> allCoordinate;

    static void setSize(Coordinate _size) {
        size = _size;
        allCoordinate = new ArrayList<Coordinate>();
        for (int y = 0; y < size.y; y++) {
            for (int x = 0; x < size.x; x++) {
                allCoordinate.add(new Coordinate(x, y));
            }
        }
    }

    public static Coordinate getSize() {
        return size;
    }

    public static ArrayList<Coordinate> getAllCoordinate() {
        return allCoordinate;
    }

    static boolean inRange(Coordinate coordinate) {
        return coordinate.x >= 0 && coordinate.x < size.x && coordinate.y >= 0 && coordinate.y < size.y;
    }
}
