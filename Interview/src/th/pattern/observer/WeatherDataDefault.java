package th.pattern.observer;

import java.util.Observable;

/**
 * shijinliang Feb 21, 2012 Interview
 **/
public class WeatherDataDefault extends Observable {
	private float temperature;
	private float humidity;
	private float pressure;

	public WeatherDataDefault() {
	}

	public void measurementsChanged() {
		setChanged();
		notifyObservers();
	}

	public void setMeasurements(float temperature, float humidity,
			float pressure) {
		this.temperature = temperature;
		this.humidity = humidity;
		this.pressure = pressure;
		measurementsChanged();
	}

	public float getTemperature() {
		return temperature;
	}

	public float getHumidity() {
		return humidity;
	}

	public float getPressure() {
		return pressure;
	}
}
