package QueueNumbers;

public final class QueueNumbers {
    private static final Object lock = new Object();
    private static boolean isTurnForOne = true;

    public static void main(String[] args) {
        final Thread thread1 = new Thread(() -> {
            while (true) {
                synchronized (lock) {
                    while (!isTurnForOne) {
                        try {
                            lock.wait(); 
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                    System.out.print("1 ");                    
                    try { 
                    	Thread.sleep(200); 
                    	} 
                    catch (InterruptedException e) {
                    	
                    }
                    isTurnForOne = false;
                    lock.notify();
                }
            }
        });

        final Thread thread2 = new Thread(() -> {
            while (true) {
                synchronized (lock) {
                    while (isTurnForOne) {
                        try {
                            lock.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                    System.out.print("2 ");                    
                    try { 
                    	Thread.sleep(200); 
                    	} 
                    catch (InterruptedException e) {
                    	
                    }
                    isTurnForOne = true;
                    lock.notify();
                }
            }
        });
        thread1.start();
        thread2.start();
    }
}