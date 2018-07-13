public class Station {
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


    public void info(){
        System.out.print(name+" ");
    }

    public int dist() {
        return toNext;
    }

//    public int distance(int count){
//        int distance=0;
//        for (int i=0; i<count-1; i++){
//            distance += toNext;
//        }
//        return distance;
//    }


}
