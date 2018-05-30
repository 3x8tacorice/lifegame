class CellTest {
    public static void main(String[] args) {
        Cells cellList = new Cells(25);
        for (int x = 0; x < 5; x++){
            for (int y = 0; y < 5; y++){
                cellList.addCell(new Cell(Math.random()<0.5, x, y));
            }
        }
        cellList.setSurroundings();
        cellList.cells.stream().forEach(c -> c.ofSurroundings());
    }
}