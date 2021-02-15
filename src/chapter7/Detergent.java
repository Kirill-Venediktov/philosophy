package chapter7;

class Cleanser{
    private String s = "Cleanser";
    public void append(String a){s +=a;}
    public void dilute(){append("dilute()");}
    public void apply(){append("apply()");}
    public void scrub(){append("scrub()");}

    @Override
    public String toString() {
        return s;
    }

    public static void main(String[] args) {
        Cleanser x = new Cleanser();
        x.dilute(); x.apply(); x.scrub();
        System.out.println(x);
    }
}

public class Detergent {
   Cleanser cleanser = new Cleanser();

   public void scrub(){
       cleanser.scrub();
   }
   public void dilute(){
       cleanser.dilute();
   }
   public void apply(){
       cleanser.apply();
   }
}
