package com.curso.loadrunner;
public class RaceConditionSincronizado {
	static int counter = 0;
	public synchronized String operacionAtomica()
	{
		String retornar = "El valor era "+ getCounter();
		incrementCounter();
		retornar = retornar + " despues de incrementar es " + getCounter();
		return retornar;
	}
	public void incrementCounter() {
		try {
			Thread.sleep(100); //Fuerza la salida del hilo de la CPU
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		counter++;
	}

	public int getCounter() {
		return counter;
	}

}