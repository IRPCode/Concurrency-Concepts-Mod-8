package concurrencyConcepts;

public class Concurrency {

	public static void main(String[] args) throws Exception {
		Multithread thread = new Multithread();
		Multithread thread2 = new Multithread();

		thread.start();
		try {
			thread.join();
		} catch (InterruptedException e) {
			// Errorthrower.throwErr();
			throw new Exception("Thread one failed to join. Program terminated.");
		}

		int x = Multithread.valGetter();
		System.out.println("Start value: " + x);

		thread2.start();
		try {
			thread2.join();
		} catch (InterruptedException e) {
			throw new Exception("Thread two failed to join. Program terminated.");
		}

		x = Multithread.valGetter();
		System.out.println("End value: " + x);
	}
}
