package model;

/**
 * Created by c12arr on 2014-12-09.
 */
public class PC {

    private int counter;

    public PC() {
        counter = 0;
    }

    public void addPC(int count) {
        counter +=count;
    }

    public int getPC() {
        return counter;
    }
}
