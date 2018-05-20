class Cell {
    boolean isAlive = true;
    boolean nextAlive = true;
    int pos_i = 0, pos_j = 0;

    Cell(boolean isAlive, int i, int j){
        this.setIsAlive(isAlive);
        this.pos_i = i;
        this.pos_j = j;
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
}