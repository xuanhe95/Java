package module5;

import java.util.List;

import de.fhpotsdam.unfolding.UnfoldingMap;
import de.fhpotsdam.unfolding.data.PointFeature;
import de.fhpotsdam.unfolding.marker.Marker;
import de.fhpotsdam.unfolding.utils.ScreenPosition;
import processing.core.PGraphics;

/** Implements a visual marker for ocean earthquakes on an earthquake map
 * 
 * @author UC San Diego Intermediate Software Development MOOC team
 * @author Your name here
 *
 */


public class OceanQuakeMarker extends EarthquakeMarker {
	private UnfoldingMap myMap;
	private List<Marker> myCities;
	public OceanQuakeMarker(PointFeature quake) {
		super(quake);
		
		// setting field in earthquake marker
		isOnLand = false;
	}
	
	
	public void setMap(UnfoldingMap map) {
		myMap = map;
	}
	
	public void setCities(List<Marker> cities) {
		myCities = cities;
	}
	

	/** Draw the earthquake as a square */
	@Override
	public void drawEarthquake(PGraphics pg, float x, float y) {
		pg.rect(x-radius, y-radius, 2*radius, 2*radius);
		
		if(clicked) {
			ScreenPosition point = getScreenPosition(myMap);
			for(Marker city : myCities) {
				if(((CommonMarker) city).getClicked()) {
					ScreenPosition pointOfCity = ((CityMarker) city).getScreenPosition(myMap);
					pg.pushStyle();
					pg.strokeWeight(4);
					pg.stroke(255);
					pg.line(point.x-200,point.y-50,pointOfCity.x-200,pointOfCity.y-50);
					pg.popStyle();

				}
			}
		}
	}
	

	

}
