package concurrencyConcepts;

import java.util.concurrent.locks.ReentrantLock;

public class Multithread extends Thread {
	private static int x = 0; //scope locked by class
	private ReentrantLock mutex = new ReentrantLock();

	@Override
	public void run() {
		mutex.lock(); //locks method
		System.out.print(x + " "); // to ensure that the program prints the first value

		try {
			if (x == 0) {
				while (x < 20) { // counts up
					x++;
					System.out.print(x + " ");
				}
			} else {
				while (x > 0) { // counts down
					x--;
					System.out.print(x + " ");
				}
			}
		}

		catch (Exception e) {
			throw new RuntimeException("Thread two failed to join. Program terminated.");
		}

		finally {
			mutex.unlock(); // unlocks the method
		}
	}

	public static int valGetter() { // gets the value, no setter needed
		return x;
	}

}