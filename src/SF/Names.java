package SF;

/**
 * How do I print my name (李明) 1000 times in Java without looping?
 */
/*public class Names {

    public void p1000() { p300(); p300(); p300(); p100(); }
    public void p300()  { p100(); p100(); p100();         }
    public void p100()  { p30();  p30();  p30();  p10();  }
    public void p30()   { p10();  p10();  p10();          }
    public void p10()   { p3();   p3();   p3();   p1();   }
    public void p3()    { p1();   p1();   p1();           }
    public void p1()    { System.out.println("李明"); }

    public static void main(String [] args) {
        new Names().p1000();
    }

}*/

/*public class Names {
    public static void main(String [] args) {
        String s1    = "李明\n";
        String s3    = s1   +   s1 +   s1;
        String s10   = s3   +   s3 +   s3  + s1;
        String s30   = s10  +  s10 +  s10;
        String s100  = s30  +  s30 +  s30  + s10;
        String s300  = s100 + s100 + s100;
        String s1000 = s300 + s300 + s300  + s100;
        System.out.print(s1000);
    }
}*/

public class Names {
    public static void main(String [] args) {
        System.out.print(String.format("%01000d",0).replace("0","李明\n"));
    }
}

