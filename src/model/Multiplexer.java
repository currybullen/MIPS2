package model;

/**
 * Created by c12arr on 2014-12-11.
 */
public class Multiplexer {

    private Object a;
    private Object b;
    private boolean sig;
    public Multiplexer() {

    }


    public void setInput(Object a, Object b) {
        if(a != null) {
            this.a = a;
        }
        if(b != null) {
            this.b = b;
        }

    }

    public void setSignal(boolean sig) {
        this.sig = sig;
    }

    public Object getOutput() {
        if(sig) {
            return b;
        }

        return a;
    }
}
