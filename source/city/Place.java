package city;

import gui.Building;
import gui.BuildingPanel;

/**
 * This class embodies a logical location; it could be a restaurant, a bank, a market, a house, an apartment building, a city park, etc.
 * The Restaurant, Bank, Market, House, Apartment classes should extend this.
 */
public abstract class Place {
	
	String type;
	Building building;
	BuildingPanel buildingPanel;
	
	public Place(String type, Building building, BuildingPanel buildingPanel){
		this.type = type;
		this.building = building;
		this.buildingPanel = buildingPanel;
	}
}
