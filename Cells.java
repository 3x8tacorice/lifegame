class Cells extends Entry {
    int size;
    ArrayList cells = new ArrayList();

    public Cells(int size){
        this.size = size;
    }
    public int getSize(){
        return this.size;
    }
    public void checkCell() {
        Iterator it = cells.iterator();
        while (it.hasNext()) {
            Cell cell = (Cell) it.next();
            if (cell.nextAlive)
        }
        int countAlive = 0;
        for(int ci = 0; ci < this.size; ci++){
            Cell cell = cells.get(ci)
            
        }
    }
}