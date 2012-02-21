package th.pattern.observer;

import java.util.Observable;
import java.util.Observer;
/**
 * shijinliang
 * Feb 21, 2012
 * Interview
 **/
public class CurrentConditionsDisplayDefault implements DisplayElement,
	Observer {

    Observable observable;
    private float temperature;
    private float humidity;
  
    public CurrentConditionsDisplayDefault(Observable observable) {
	this.observable = observable;
	observable.addObserver(this);
    }

    @Override
    public void display() {
	System.out.println("Current conditions: " + temperature
		+ "F degrees and " + humidity + "% humidity");
    }

    @Override
    public void update(Observable obs, Object arg) {
	if(obs instanceof WeatherDataDefault) {
	    WeatherDataDefault weatherData = (WeatherDataDefault)obs;
	    this.temperature = weatherData.getTemperature();
	    this.humidity    = weatherData.getHumidity();
	    display();
	}
    }

}
