class Station {
    String name;
    int toNext;
    private boolean isFirst;
    private boolean isLast;

    Station(String name,  int toNext, boolean isFirst, boolean isLast) {
        this.name = name;
        this.toNext = toNext;
        this.isFirst = isFirst;
        this.isLast = isLast;
    }


    void info(){
        System.out.print(name+" ");
    }

    int dist() {
        return toNext;
    }

    String getName() { return name; }
}
