package module6;

import java.util.ArrayList;
import java.util.List;

import de.fhpotsdam.unfolding.UnfoldingMap;
import de.fhpotsdam.unfolding.data.Feature;
import de.fhpotsdam.unfolding.data.PointFeature;
import de.fhpotsdam.unfolding.geo.Location;
import de.fhpotsdam.unfolding.marker.SimpleLinesMarker;
import de.fhpotsdam.unfolding.marker.SimplePointMarker;
import de.fhpotsdam.unfolding.utils.ScreenPosition;
import processing.core.PConstants;
import processing.core.PGraphics;

/** 
 * A class to represent AirportMarkers on a world map.
 *   
 * @author Adam Setters and the UC San Diego Intermediate Software Development
 * MOOC team
 *
 */
public class AirportMarker extends CommonMarker {
	public static List<SimpleLinesMarker> myRoutes;
	UnfoldingMap myMap;
	
	public AirportMarker(Feature city) {
		super(((PointFeature)city).getLocation(), city.getProperties());
	}
	
	public void setRoutes(List<SimpleLinesMarker> routes) {
		myRoutes = routes;
	}
	
	public void setMap(UnfoldingMap map) {
		myMap = map;
	}
	
	@Override
	public void drawMarker(PGraphics pg, float x, float y) {
		pg.fill(200,100,100);
		pg.ellipse(x, y, 5, 5);
		
		
	}
	
	private void drawRoute(PGraphics pg, float x, float y, Location city) {
		SimplePointMarker point = new SimplePointMarker(city);
		ScreenPosition position = point.getScreenPosition(myMap);
		pg.line(x, y, position.x-50, position.y-50);
		pg.pushStyle();
		pg.fill(200,50,50);
		pg.ellipse(position.x-50, position.y-50, 10, 10);
		pg.popStyle();
	}
	
	public void showRoutes(PGraphics pg, float x, float y) {

		for(SimpleLinesMarker route : myRoutes) {
			if(route.getLocations().contains(getLocation())) {
				List<Location> cities = route.getLocations();
				for(Location city : cities) {
					drawRoute(pg,x,y,city);
				}
			}
		}
		pg.pushStyle();
		pg.fill(250,250,0);
		pg.ellipse(x, y, 15, 15);
		pg.popStyle();
		
	}

	

	@Override
	public void showTitle(PGraphics pg, float x, float y) {
		 // show rectangle with title
		String name = getName();
		String country = getCountry();
		String city = getCity();
		String code = getCode();
		float altitude = getAltitude();
		
		String info = code + "  " + name + "  " + country + "  " + city + "  " + altitude;
		
		pg.pushStyle();
		
		pg.rectMode(PConstants.CORNER);
		
		pg.stroke(110);
		pg.fill(255,255,255);
		pg.rect(x, y + 15, pg.textWidth(info) +6, 18, 5);
		
		pg.textAlign(PConstants.LEFT, PConstants.TOP);
		pg.fill(0);
		pg.text(info, x + 3 , y +18);
		
		
		pg.popStyle();
		// show routes
		
		
	}
	
	@Override
	public void draw(PGraphics pg, float x, float y) {
		// For starter code just drawMaker(...)
		if (!hidden) {
			drawMarker(pg, x, y);
			if (selected) {
				showTitle(pg, x, y);
			}
		}
		
		if(clicked) {
			showRoutes(pg, x, y);
		}
		
		
	}
	
	
	
	
	
	public float getAltitude() {
		return Float.parseFloat(getProperty("altitude").toString());
	}
	
	public String getCode() {
		if(!getStringProperty("code") .equals( "\"\"") ) {
			return getStringProperty("code").replace("\"", "");
		}
		
		return "---";
	}
	
	public String getName() {
		return getStringProperty("name").replace("\"", "");
		
	}
	public String getCountry() {
		return getStringProperty("country").replace("\"", "");
	}
	
	public String getCity() {
		return getStringProperty("city").replace("\"", "");
	}
	
}
