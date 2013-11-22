package gui;

/**
 * This class is the container class for each of the three types of control panels needed in the application
 * 1) New Person Panel
 * 2) Current Person Panel
 * 3) Current Building Panel
 * @author Tanner Zigrang
 */

import java.awt.Dimension;

import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.JTextField;

public class ControlPanel extends JTabbedPane {
	
	CreatePersonPanel newPersonPanel;
	CurrentPersonPanel currentPersonPanel;
	BuildingPanel currentBuildingPanel;
	public ControlPanel()
	{
		//This is all placeholder code just to get the panels into tabs.  Each tab will have its own class eventually.
		newPersonPanel = new CreatePersonPanel();
		currentPersonPanel = new CurrentPersonPanel();
		currentBuildingPanel = null;
//		this.currentBuildingPanel = currentBuildingPanel;
		this.addTab("Current Person", null, currentPersonPanel, "Info about the currently selected person.");
		this.addTab("Current Building", null, currentBuildingPanel, "Info about the currently selected building.");
		this.addTab("New Person", null, newPersonPanel, "Create a new citizen of SimCity201.");
		this.setPreferredSize(new Dimension(1024/3, 720));
	}
	
	public void displayCurrentBuildingInfo(BuildingPanel currentBuildingPanel){
		this.currentBuildingPanel = currentBuildingPanel;
		
	}
}
