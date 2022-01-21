package com.curso.loadrunner;

public class RaceConditionDemo {
	int counter = 0;

	public void incrementCounter() {
		try {
			Thread.sleep(100);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		counter++;
	}

	public int getCounter() {
		return counter;
	}

	public static void main(String[] args) {
		RaceConditionDemo rc = new RaceConditionDemo();
		for (int i = 0; i < 10; i++) {
			new Thread(new Runnable() {
				@Override
				public void run() {
					rc.incrementCounter();
					System.out.println("value for " + Thread.currentThread().getName() + " - " + rc.getCounter());
				}
			}).start();
		}
	}
}