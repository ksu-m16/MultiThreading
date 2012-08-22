package test;

import java.util.logging.Level;
import java.util.logging.Logger;

public class BTest {
	int counter = 0;

    public static void main(String[] args) {
    	BTest btest = new BTest();
        btest.test();
    }
    
    class CountThread extends Thread{
    	public void run() {
            for (int i = 0; i < 10*1000*1000; ++i) {       
            	synchronized(BTest.this) {
                counter++;    
            	}
            }
        }
    }
    
    public void test() {
        try {
            Thread th1 = new CountThread();
            Thread th2 = new CountThread();
            th1.start();
            th2.start();
            th1.join();
            th2.join();
            System.out.println(counter);
        } catch (InterruptedException ex) {
            Logger.getLogger(BTest.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

       
}

















