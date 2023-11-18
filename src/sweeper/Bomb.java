package sweeper;

class Bomb {
    private Matrix bombMap;
    private int totalBombs;

    Bomb(int totalBombs) {
        this.totalBombs = totalBombs;
    }

    void start() {
        bombMap = new Matrix(Box.ZERO);
        for (int i = 0; i < totalBombs; i++) {
            placeBomb();
        }
    }

    Box get(Coordinate coordinate) {
        return bombMap.get(coordinate);
    }

    private void placeBomb() {
        Coordinate coordinate = Ranges.getRandomeCoordinate();
        bombMap.set(coordinate, Box.BOMB);
        incNumbersAroundBomb(coordinate);
    }

    private void incNumbersAroundBomb(Coordinate coordinate) {
        for (Coordinate around :
                Ranges.getCoordinatesAround(coordinate)) {
            if (Box.BOMB != bombMap.get(around)) {
                bombMap.set(around, bombMap.get(around).getNextNumberBox());
            }
        }
    }
}
