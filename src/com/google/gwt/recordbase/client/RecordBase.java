package com.google.gwt.recordbase.client;

import com.google.gwt.recordbase.shared.FieldVerifier;
import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.core.client.GWT;
import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.FlexTable;
import com.google.gwt.user.client.ui.HorizontalPanel;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.TextBox;
import com.google.gwt.user.client.ui.VerticalPanel;
import java.util.ArrayList;
import com.google.gwt.user.client.ui.RootPanel;
import com.google.gwt.user.client.ui.HasHorizontalAlignment;
import com.google.gwt.user.client.ui.HasVerticalAlignment;

/**
 * Entry point classes define <code>onModuleLoad()</code>.
 */
public class RecordBase implements EntryPoint {
	
	private VerticalPanel mainPanel = new VerticalPanel();
	private FlexTable baseTable = new FlexTable();
	private HorizontalPanel addPanel = new HorizontalPanel();
	private TextBox txBox = new TextBox();
	private Button addButton = new Button("Add");
	private Label lastUpdateLabel = new Label();
	private ArrayList<String> record = new ArrayList<String>();
	
  /**
   * The message displayed to the user when the server cannot be reached or
   * returns an error.
   */
  private static final String SERVER_ERROR = "An error occurred while "
      + "attempting to contact the server. Please check your network "
      + "connection and try again.";

  /**
   * Create a remote service proxy to talk to the server-side Greeting service.
   */
  private final GreetingServiceAsync greetingService = GWT.create(GreetingService.class);

  /**
   * This is the entry point method.
   */
  public void onModuleLoad() {
	userInterfaceSetup();
	
	loadRecordDatabase();
  }
  
  /**
   * On load Setup of the GUI
   */
  public void userInterfaceSetup(){
	  // Create table for stock data.
    baseTable.setText(0, 0, "Artist");
    baseTable.setText(0, 1, "EP Name");
    baseTable.setText(0, 2, "Release Date");
    baseTable.setText(0, 3, "Remove");
	
	//Adding style names to the Table
	baseTable.getRowFormatter().addStyleName(0, "watchListHeader");
	baseTable.addStyleName("watchList");
	
	//Adding style names to the price and change header fields
	baseTable.getCellFormatter().addStyleName(0, 0, "watchListNumericColumn");
	baseTable.getCellFormatter().addStyleName(0, 1, "watchListNumericColumn");
	baseTable.getCellFormatter().addStyleName(0, 2, "watchListNumericColumn");
	
	
	//Assemble AddPanel
	addPanel.add(txBox);
	addPanel.add(addButton);
	addPanel.addStyleName("addPanel");
	
	
	//Centering the mainPanel on the page 
	mainPanel.setWidth("100%");
    mainPanel.setHeight("100%");
    mainPanel.setHorizontalAlignment(HasHorizontalAlignment.ALIGN_CENTER);
    mainPanel.setVerticalAlignment(HasVerticalAlignment.ALIGN_MIDDLE);
    
	//Adding widgets to the mainPanel
	mainPanel.add(baseTable);
	mainPanel.add(addPanel);
	mainPanel.add(lastUpdateLabel);
	
	
	//Association the Widgets with the HTML page
	RootPanel.get("recordBase").add(mainPanel); 
  }
  
  
  /**
   * Loads the Record data out of a local database (TODO)
   */
  public void loadRecordDatabase(){
	
	//MOCKUP
	baseTable.setText(1, 0, "Stevie Wonder");
    baseTable.setText(1, 1, "Hotter Than July");
    baseTable.setText(1, 2, "29.9.1980");
    baseTable.setText(1, 3, "Remove");
	
	baseTable.getCellFormatter().addStyleName(1, 0, "watchListNumericColumn");
	baseTable.getCellFormatter().addStyleName(1, 1, "watchListNumericColumn");
	baseTable.getCellFormatter().addStyleName(1, 2, "watchListNumericColumn");
	baseTable.getCellFormatter().addStyleName(1, 3, "watchListRemoveColumn");
	
	// Add a button to remove this stock from the table.
	Button rmButton = new Button("x");
	rmButton.addStyleDependentName("remove");
	/*
	rmButton.addClickHandler(new ClickHandler(){
		public void onClick(ClickEvent event){
			int removeIndex = stock.indexOf(symbol);
			record.remove(removeIndex);
			baseTable.remove1(removeIndex +1);
		}
	});*/
	baseTable.setWidget(1, 3, rmButton);
  }
}

	