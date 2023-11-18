package sweeper;

class Flag {
    private Matrix flagMap;
    private int totalFlags;
    private int countOfClosedBoxes;

    void start() {
        flagMap = new Matrix(Box.CLOSED);
    }

    Box get (Coordinate coordinate) {
        return flagMap.get(coordinate);
    }

    void setOpenedToBox(Coordinate coordinate) {
        flagMap.set(coordinate, Box.OPENED);
    }

    public void toggleFlagedToBox(Coordinate coordinate) {
        switch (flagMap.get(coordinate)) {
            case FLAGED -> setClosedToBox(coordinate);
            case CLOSED -> setFlagedToBox(coordinate);
        }
    }

    private void setFlagedToBox(Coordinate coordinate) {
        flagMap.set(coordinate, Box.FLAGED);
    }

    private void setClosedToBox(Coordinate coordinate) {
        flagMap.set(coordinate, Box.CLOSED);
    }
}
