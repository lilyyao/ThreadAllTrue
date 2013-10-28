public class ThreadAllTrue implements Runnable{

	boolean[] rtn;
	int idx = 0;
	
	public void run() {
		System.out.println("I am running. My index is: " + idx);
		
		try {	
			Thread.sleep(1000); // put a thread to sleep
		} catch (InterruptedException e) {}
		
		rtn[idx] = true;      // when the thread done, set to true
	}
	
	public static void main(String[] args) {
		int num_thread = 5;
		boolean[] rtn = new boolean[num_thread];

		for (int i = 0; i< num_thread; i++)
		{
			ThreadAllTrue tat = new ThreadAllTrue(); // the runner
			tat.idx = i;    // link the i in main to the index of each thread
			tat.rtn = rtn;  // pass the array reference to each thread
			new Thread(tat).start();
		}
		
		for (int i = 0; i< num_thread; i++) {
			if (!rtn[i])
			{
		 	   try {	
					Thread.sleep(1000); // put main sleep
				} catch (InterruptedException e) { 	}

			i--;  // go back to the same index again.
			continue;
			}
		}
		
		System.out.println("All thread finished!!");
					
	}
}