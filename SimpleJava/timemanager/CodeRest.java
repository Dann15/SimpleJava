package com.leftindust.SimpleJava.timemanager;

/**
 * @author Daniel Shirvani
 * @version 1.0
 */
public class CodeRest {
	Thread t;
	
	/**
	 * Once called, will start to rest code for a set amount of milliseconds.
	 * @param millis Time in milliseconds code shall rest.
	 */
	@SuppressWarnings("static-access")
	public CodeRest(long millis) {
		t = new Thread();
		t.start();
		try {
			t.sleep(millis);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	

}
