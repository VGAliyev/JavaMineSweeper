package sweeper;

class Flag {
    private Matrix flagMap;
    private int totalFlags;
    private int countOfClosedBoxes;

    void start() {
        flagMap = new Matrix(Box.CLOSED);
        for (Coordinate around : Ranges.getCoordinatesAround(new Coordinate(4, 4))) {
            flagMap.set(around, Box.OPENED);
        }
    }

    Box get (Coordinate coordinate) {
        return flagMap.get(coordinate);
    }
}
