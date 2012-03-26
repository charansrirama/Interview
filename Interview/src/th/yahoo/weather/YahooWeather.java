package th.yahoo.weather;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Scanner;
import java.util.regex.MatchResult;

import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import org.xml.sax.Attributes;
import org.xml.sax.helpers.DefaultHandler;

public class YahooWeather {
	
	LinkedList<String> URLList = new LinkedList<String>();
	String zipcodePath;
	
	public YahooWeather(String zipcodePath) {
		this.zipcodePath = zipcodePath;
	}
	
	public void generateURLList() {
		Scanner scanner;
		try {
			scanner = new Scanner(new File(zipcodePath));
			while(scanner.hasNext()) {
				scanner.findInLine(",(\\d+),(\\w+),(\\D+),");
				MatchResult resultSet = scanner.match();
				String URL = "http://weather.yahooapis.com/forecastrss?w="+ resultSet.group(1) + "&u=f";
				this.URLList.add(URL);
				//System.out.println(resultSet.group(1));
				scanner.nextLine();
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
	}
	
	public void printURLList() {
		Iterator<String> it = URLList.iterator();
		while(it.hasNext()) {
			String URL = it.next();
			System.out.println(URL);
		}
	}
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
//		YahooWeather yw = new YahooWeather("/Developer/workspace/Interview/Interview/src/th/yahoo/weather/initial_zipcode.txt");
//		yw.generateURLList();
//		yw.printURLList();
		try{
			SAXParserFactory factory = SAXParserFactory.newInstance();
			SAXParser parser = factory.newSAXParser();
			
			WeatherHandler handler = new WeatherHandler();
			parser.parse("http://weather.yahooapis.com/forecastrss?w=14261&u=f", handler);
			System.out.println(handler.date);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}

class WeatherHandler extends DefaultHandler{
	boolean d;
	boolean l;
	boolean h;
	
	String date = "empty";
	String low  = "";
	String high = "";
	public void startDocument(){}
	public void endDocument(){
//		System.out.println("Date: " + date);
//		System.out.println("Low: " + low);
//		System.out.println("High: " + high);
	}
	
	public void startElement(String uri, String localName, String qName, Attributes attributes) {
		if(qName.equals("yweather:forecast") && date.equals("empty")) {
			for(int i = 0; i < attributes.getLength(); i++) {
				if(attributes.getQName(i).equals("date")) {
					this.date = attributes.getValue(i);
				} else if(attributes.getQName(i).equals("low")) {
					this.low = attributes.getValue(i);
				} else if(attributes.getQName(i).equals("high")) {
					this.high = attributes.getValue(i);
				}
			}
		}
	}
	public void endElement(String uri, String localName, String qName) {}
	public void characters(char[] ch, int start, int length){
//		String value = new String(ch, start, length);
//		if(d) {
//			date = value;
//			d = false;
//		}
//		else if(l) {
//			low = value;
//			l = false;
//		}
//		else if(h) {
//			high = value;
//			h = false;
//		}
	}
}