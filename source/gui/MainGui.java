package gui;

/**
 * This is the class is the main window for the project.  This is also where the main function is.
 * @author Tanner Zigrang
 */

import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.util.ArrayList;
import java.util.List;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JFrame;
import javax.swing.JPanel;

import city.Directory;
import city.restaurant.yixin.YixinRestaurant;

public class MainGui extends JFrame 
{
	private static int FRAMEX = 1024;
	private static int FRAMEY = 720;
	
     BuildingCardLayoutPanel _buildingCardLayoutPanel;
     ControlPanel cPanel;
     
     List<BuildingInteriorAnimationPanel> _buildingInteriorAnimationPanels = new ArrayList<BuildingInteriorAnimationPanel>();
     
     WorldView _worldView;
	/**
	 * Constructor for the MainGui window
	 */
	public MainGui()
	{
		//The code below is for setting up the default window settings
		this.setSize(FRAMEX, FRAMEY);
		this.setLocationRelativeTo(null);
		this.setTitle("SimCity201 - Team 18");
		this.setResizable(false);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setLayout(new BoxLayout(this.getContentPane(), BoxLayout.X_AXIS));
		
		//Building View
		_buildingCardLayoutPanel = new BuildingCardLayoutPanel();
	    
	    //World View
	    _worldView = new WorldView();
	    
	    //Control Panel
	    cPanel = new ControlPanel(this);
	        
		//The code below will add an area for the two gui areas to go. BuildingView + WorldView
		JPanel animationArea = new JPanel();
		animationArea.setLayout(new BoxLayout(animationArea, BoxLayout.Y_AXIS));
		animationArea.setPreferredSize(new Dimension(2048/3, 720));
		animationArea.add(_worldView);
		animationArea.add(_buildingCardLayoutPanel);
		this.add(animationArea, Component.LEFT_ALIGNMENT);
		
		// Hard-coded instantiation of all the buildings in the city:
		// Yixin's Restaurant:
		WorldViewBuilding b = _worldView.addBuilding(0, 1, 30);
		BuildingInteriorAnimationPanel bp = new BuildingInteriorAnimationPanel(this, "Yixin's Restaurant", new city.restaurant.yixin.gui.YixinAnimationPanel());
		b.setBuildingPanel(bp);
		YixinRestaurant yr = new YixinRestaurant(bp, "Yixin's Restaurant");
		//yr.setName("Yixin's Restaurant");
		Directory.addPlace(yr);	
		cPanel.currentBuildingPanel.addBuilding(yr.getName());
        _buildingCardLayoutPanel.add( bp, bp.getName() );
        _buildingInteriorAnimationPanels.add(bp);
        
        
        
        /*
        //Create the BuildingPanel for each Building object
        ArrayList<WorldViewBuilding> worldViewBuildings = _worldView.getBuildings();
        for ( int i=0; i<worldViewBuildings.size(); i++ )
        {
                WorldViewBuilding b = worldViewBuildings.get(i);
                BuildingInteriorAnimationPanel bp = new BuildingInteriorAnimationPanel(this,i);
                b.setBuildingPanel( bp );
                _buildingCardLayoutPanel.add( bp, "Building " + i );
        }
        
        
		 for (int i = 3; i < 6; i++) {
			WorldViewBuilding b = new WorldViewBuilding( i, 1, 40 );
			
			worldViewBuildings.add( b );
		 }
		 for ( int i=0; i<2; i++ ) {
			 for ( int j=0; j<5; j++ ) {
				 if(i == 1 && j == 2) continue;
				 WorldViewBuilding b = new WorldViewBuilding( i, j, 30 );
				 
				 worldViewBuildings.add( b );
			 }
		 }
		 */
        
      //The code below will add a tabbed panel to hold all the control panels.  Should take the right third of the window
  	  
  	  this.add(cPanel, Component.RIGHT_ALIGNMENT);
  	  this.pack();		
  	  this.setVisible(true);
	
	}
	
	public WorldView getWorldView() { return _worldView; }
	
	 public void displayBuildingPanel(BuildingInteriorAnimationPanel bp ) {
         System.out.println( bp.getName() );
         ((CardLayout) _buildingCardLayoutPanel.getLayout()).show(_buildingCardLayoutPanel, bp.getName());
         cPanel.updateBuildingInfo(bp);
	 }
	
	/**
	 * Main routine to create an instance of the MainGui window
	 */
	public static void main(String[] args)
	{
		@SuppressWarnings("unused")
		MainGui gui = new MainGui();
	}
}
