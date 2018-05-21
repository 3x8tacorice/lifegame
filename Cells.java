import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;
import java.util.Iterator;
import java.util.stream.Collectors;

class Cells {
    int size;
    ArrayList<Cell> cells = new ArrayList<>();

    public Cells(int size){
        this.size = size;
    }
    public int getSize(){
        return this.size;
    }
    public void addCell(Cell cell) {
        cells.add(cell);
    }
    public void setSurroundings() {
        Iterator it = cells.iterator();
        while (it.hasNext()) {
            Cell cell = (Cell) it.next();
            List<Cell> surd = new ArrayList<>();
            int dx_min = -1;
            int dy_min = -1;
            int dx_max = 1;
            int dy_max = 1;
            if (cell.pos_x == 0) {dx_min = 0;}
            if (cell.pos_y == 0) {dy_min = 0;}
            if (cell.pos_x == size - 1) {dx_max = 0;}
            if (cell.pos_y == size - 1) {dy_max = 0;}
            int dx_min_a = cell.pos_x + dx_min;
            int dx_max_a = cell.pos_x + dx_max;
            int dy_min_a = cell.pos_y + dy_min;
            int dy_max_a = cell.pos_y + dy_max;
            surd = this.cells.stream()
                            .filter(c ->
                                ((c.pos_x == (dx_min_a)) || (c.pos_x == (cell.pos_x)) || (c.pos_x == (dx_max_a))) 
                                && ((c.pos_y == (dy_min_a)) || (c.pos_y == (cell.pos_y)) || (c.pos_y == (dy_max_a)))
                                && !((c.pos_x == cell.pos_x) && (c.pos_y == cell.pos_y))
                            )
                            .collect(Collectors.toList());
            cell.setSurroundings(surd);
        }
    }
    public void checkCell() {
        Iterator it = cells.iterator();
        while (it.hasNext()) {
            int countAlive = 0;
            Cell cell = (Cell) it.next();
            cell.surroundings
                .stream()
                .filter(c -> c.getIsAlive())
                .count();
            if (cell.isAlive) {
                if (countAlive == 2 || countAlive == 3) {
                    cell.setNextAlive(true);
                } else {
                    cell.setNextAlive(false);
                }
            } else {
                if (countAlive == 3) {
                    cell.setNextAlive(true);
                } else {
                    cell.setNextAlive(false);
                }
            }
        }
    }
    public void update() {
        Iterator it = cells.iterator();
        while (it.hasNext()) {
            Cell cell = (Cell) it.next();
            cell.setIsAlive(cell.getNextAlive());
        }
    }
}