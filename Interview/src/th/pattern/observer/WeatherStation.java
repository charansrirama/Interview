package th.pattern.observer;
/**
 * shijinliang
 * Feb 21, 2012
 * Interview
 **/
public class WeatherStation {

    /**
     * @param args
     */
    public static void main(String[] args) {
	WeatherDataDefault weatherData = new WeatherDataDefault();
	
//	CurrentConditionsDisplay currentDisplay = new CurrentConditionsDisplay(weatherData);
	CurrentConditionsDisplayDefault currentDisplay = new CurrentConditionsDisplayDefault(weatherData);
	weatherData.setMeasurements(80, 65, 30.4f); 
	weatherData.setMeasurements(82, 70, 29.2f); 
	weatherData.setMeasurements(78, 90, 29.2f);
    }

}
