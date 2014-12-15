package controller;

/**
 * Created by c12arr on 2014-12-11.
 */
public class Add {

    private int result;

    public Add() {
        result = 0;
    }

    public void add(int a,int b) {
        result = a+b;
    }

    public int getResult(){
        return result;
    }
}
