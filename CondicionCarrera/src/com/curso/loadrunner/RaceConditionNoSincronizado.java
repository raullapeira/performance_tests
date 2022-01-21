package com.curso.loadrunner;
public class RaceConditionNoSincronizado {
	static int counter = 0;
	public String operacionNoAtomica()
	{
		String retornar = "El valor era "+ getCounter();
		incrementCounter();
		retornar = retornar + " despues de incrementar es " + getCounter();
		return retornar;
	}
	public void incrementCounter() {
		try {
			Thread.sleep(100);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		counter++;
	}

	public int getCounter() {
		return counter;
	}

}