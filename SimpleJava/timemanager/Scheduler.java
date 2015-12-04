package com.leftindust.timemanager;

/**
 * @author Daniel Shirvani
 * @version 1.0
 */
public class Scheduler {
	public enum RunnableType { REPEATING,WAIT }
	
	private Thread t;
	private long millis;
	private Runnable run;
	private RunnableType type;
	private boolean functional;
	private boolean isOn;
	private boolean didAlready;
	private int timesToPlay;
	private int done;
	
	/**
	* The purpose of the Scheduler is to run some code with
	* an interval between them. You should create a variable for
	* this as you can control the scheduler with methods like start, stop
	* etc.
	*/
	public Scheduler(RunnableType type, Runnable runnable, long millis){
		timesToPlay = -1;
		functional = true;
		didAlready = false;
		isOn = false;
		this.type = type;
		this.run = runnable;
		this.millis = millis;
	}
	
	/**
	* The purpose of the Scheduler is to run some code with
	* an interval between them. You should create a variable for
	* this as you can control the scheduler with methods like start, stop
	* etc.
	*/
	public Scheduler(RunnableType type, int timesToPlay ,Runnable runnable, long millis){
		this.timesToPlay = timesToPlay;
		functional = true;
		didAlready = false;
		isOn = false;
		this.type = type;
		this.run = runnable;
		this.millis = millis;
	}
	
	public int getTimesToPlay(){
		if(timesToPlay == -1){
			return -1;
		}
		return timesToPlay;
	}
	
	public void setTimesToPlay(int times){
		this.timesToPlay = times;
	}
	
	public void start(){
		if(isOn == true){
			try {
				throw new Exception("Cannot Start Scheduler: functional = " +functional+" isOn = "+isOn);
			} catch (Exception e) {
				e.printStackTrace();
			}
			return;
		}
		isOn = true;
		
		if(type == RunnableType.WAIT){
			t = new Thread(new Runnable() {
				public void run() {
					while(functional){
						if(didAlready==true){
							functional=false;
							break;
						}
						new CodeSleeper(millis);
						run.run();
						didAlready=true;
					}
				}
			});
			t.start();
			isOn = true;
			return;
		} 
		
		t = new Thread(new Runnable() {
			public void run() {
				while(functional){
					if(done == timesToPlay){
						functional=false;
						return;
					}
					done=done+1;
					run.run();
					try {
						Thread.sleep(millis);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
			}
		});
		t.start();
		isOn = true;
	}
	
	public void stop(){
		pause();
		t = null;
	}
	
	public void pause(){
		didAlready = false;
		isOn = false;
		functional = false;
	}
	
	public void resume(){
		isOn = true;
		functional = true;
		didAlready = false;
	}
	
}
