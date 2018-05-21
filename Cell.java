import java.util.ArrayList;
import java.util.List;

class Cell {
    boolean isAlive = true;
    boolean nextAlive = true;
    int pos_x = 0, pos_y = 0;
    List<Cell> surroundings = new ArrayList<>();

    Cell(boolean isAlive, int x, int y){
        this.setIsAlive(isAlive);
        this.pos_x = x;
        this.pos_y = y;
    }
    public void setIsAlive(boolean isAlive){
        this.isAlive = isAlive;
    }
    public boolean getIsAlive(){
        return this.isAlive;
    }
    public void setNextAlive(boolean isAlive){
        this.nextAlive = isAlive;
    }
    public boolean getNextAlive(){
        return this.nextAlive;
    }
    public void setSurroundings(List<Cell> surroundings) {
        this.surroundings = surroundings;
    }
    public void state() {
        if (this.isAlive) {
            System.out.println("cell(" + this.pos_x +", " + this.pos_y + ") is Alive!!");
        } else {
            System.out.println("cell(" + this.pos_x +", " + this.pos_y + ") is Dead!!");
        }
    }
    public void ofSurroundings(){
        System.out.print("cell(" + this.pos_x +", " + this.pos_y + "):");
        this.surroundings.stream().map(c -> "("+c.pos_x+", "+c.pos_y+")").forEach(System.out::print);
        System.out.println();
    }
}