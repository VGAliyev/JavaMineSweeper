package sweeper;

class Bomb {
    private Matrix bombMap;
    private int totalBombs;

    Bomb(int totalBombs) {
        this.totalBombs = totalBombs;
    }

    void start() {
        bombMap = new Matrix(Box.ZERO);
        placeBomb();
    }

    Box get(Coordinate coordinate) {
        return bombMap.get(coordinate);
    }

    private void placeBomb() {
        bombMap.set(new Coordinate(4, 4), Box.BOMB);
    }
}
