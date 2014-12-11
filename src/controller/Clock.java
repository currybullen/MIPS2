package controller ;

/**
 * Created by c12arr on 2014-12-11.
 */
public class Clock {
   private int clock;

   public Clock(){
        clock = 0;
    }

   public void tick() {
        clock++;
   }

   public int getCykle() {
       return clock%5;
   }

}
