package sweeper;

public class Game {
    private Bomb bomb;
    private Flag flag;
    private GameState state;

    public Game(int cols, int rows, int bombs) {
        Ranges.setSize(new Coordinate(cols, rows));
        bomb = new Bomb(bombs);
        flag = new Flag();
    }

    public void start() {
        bomb.start();
        flag.start();
        state = GameState.PLAYED;
    }

    public GameState getState() {
        return state;
    }

    public Box getBox(Coordinate coordinate) {
        if (flag.get(coordinate) == Box.OPENED) {
            return bomb.get(coordinate);
        } else {
            return flag.get(coordinate);
        }
    }

    public void pressLeftButton(Coordinate coordinate) {
        if (gameOver()) {
            return;
        }
        openBox(coordinate);
        checkWinner();
    }

    private void checkWinner() {
        if (state == GameState.PLAYED) {
            if (flag.getCountOfClosedBoxes() == bomb.getTotalBombs()) {
                state = GameState.WINNER;
            }
        }
    }

    private void openBox(Coordinate coordinate) {
        switch (flag.get(coordinate)) {
            case OPENED -> setOpenedToClosedBoxesAroundNumber(coordinate);
            case FLAGED -> {
                return;
            }
            case CLOSED -> {
                switch (bomb.get(coordinate)) {
                    case ZERO -> openBoxesAround(coordinate);
                    case BOMB -> openBombs(coordinate);
                    default -> flag.setOpenedToBox(coordinate);
                }
            }
        }
    }

    void setOpenedToClosedBoxesAroundNumber(Coordinate coordinate) {
        if (bomb.get(coordinate) != Box.BOMB) {
            if (flag.getCountOfFlagedBoxesAround(coordinate) == bomb.get(coordinate).getNumber()) {
                for (Coordinate around : Ranges.getCoordinatesAround(coordinate)) {
                    if (flag.get(around) == Box.CLOSED) {
                        openBox(around);
                    }
                }
            }
        }
    }

    private void openBombs(Coordinate bombed) {
        state = GameState.BOMBED;
        flag.setBombedToBox(bombed);
        for (Coordinate coordinate : Ranges.getAllCoordinate()) {
            if (bomb.get(coordinate) == Box.BOMB) {
                flag.setOpenedToClosedBombBox(coordinate);
            } else {
                flag.setNoBombToFlagedSafeBox(coordinate);
            }
        }
    }

    private void openBoxesAround(Coordinate coordinate) {
        flag.setOpenedToBox(coordinate);
        for (Coordinate around : Ranges.getCoordinatesAround(coordinate)) {
            openBox(around);
        }
    }

    public void pressRightButton(Coordinate coordinate) {
        if (gameOver()) {
            return;
        }
        flag.toggleFlagedToBox(coordinate);
    }

    private boolean gameOver() {
        if (state == GameState.PLAYED) {
            return false;
        }
        start();
        return true;
    }
}
