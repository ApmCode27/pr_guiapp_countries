/**********************************************
Workshop # 7
Course:<> - Semester 4 JAC444ZBB
Last Name:Padilla 
First Name:Luis
ID:
Section:ZBB
This assignment represents my own work in accordance with Seneca Academic Policy.
Signature
Date:<submission date>
**********************************************/
package application;
	

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javafx.application.Application;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.stage.Stage;

import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;

import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;


public class Main extends Application {
	
	
	
	//reading file 
	String path = "C:\\Users\\capad\\eclipse-workspace\\lab7\\src\\WDI.csv";
	String line = "";
	ArrayList <String>serieCountries = new ArrayList() ; // Canada
	List <Country> listOfCountries = new ArrayList <Country>();
	//String [] values = line.split(",");
	
	
	
	
	ComboBox <String> cBoxCountry = new ComboBox<>();
	ComboBox <String> cBoxSerie = new ComboBox<>();
	ComboBox <String> cBoxYear = new ComboBox<>();
	private TextField countryInfo = new TextField();
	private Button btGetInfo = new Button("Get Information");
	
	@Override
	public void start(Stage stage) {
		try {
			
			int count= 0;
			
			
			// setting lines to read 
			BufferedReader cl = new BufferedReader(new FileReader (path));
			while((line = cl.readLine()) != null ) {
				count ++;
			}
			
			System.out.println(count);
			// extracting and setting values 
			BufferedReader br = new BufferedReader(new FileReader (path));
			int lineNumber = 0;
		
			while((line = br.readLine()) != null ) {
				if (lineNumber == 0) {
					lineNumber++;
					continue;
				}
				else if (lineNumber < count-5 ){
					serieCountries.add(line);
				}
				lineNumber++;
			}

			Set <String> mainCountries= new HashSet<String>();
			Set <String> serieName = new HashSet<String>();
			String values []; 
			String sCa = "Canada";
			String sCn = "China";
			String sJp = "Japan";
			String sUk = "United Kingdom";
			String sUs = "United States";
			String sRu = "Russian Federation";
			String sAu = "Australia";
			
			
		
			
			for (String textLine : serieCountries) {
				values = textLine.split(",");

				if(values[0].equalsIgnoreCase(sCa) ) {
					Canada Ca = new Canada(values);
					listOfCountries.add(Ca);
					mainCountries.add(values[0]);
					serieName.add(values[1]);
				}else if ( values[0].equalsIgnoreCase(sCn) ) {
					China Cn = new China(values);
					listOfCountries.add(Cn);
					mainCountries.add(values[0]);
					serieName.add(values[1]);
				}else if (values[0].equalsIgnoreCase(sJp) ) {
					Japan Jp = new Japan(values);
					listOfCountries.add(Jp);
					mainCountries.add(values[0]);
					serieName.add(values[1]);
				}else if (values[0].equalsIgnoreCase(sUk)){
					UnitedKingdom Uk = new UnitedKingdom(values);
					listOfCountries.add(Uk);
					mainCountries.add(values[0]);
					serieName.add(values[1]);
				}else if (values[0].equalsIgnoreCase(sUs)) {
					UnitedStates Us = new UnitedStates(values);
					listOfCountries.add(Us);
					mainCountries.add(values[0]);
					serieName.add(values[1]);
				}else if (values[0].equalsIgnoreCase(sRu)) {
					RussianFederation Ru = new RussianFederation(values);
					listOfCountries.add(Ru);
					mainCountries.add(values[0]);
					serieName.add(values[1]);
				}else if (values [0].equalsIgnoreCase(sAu)) {
					Australia Au = new Australia(values);
					listOfCountries.add(Au);
					mainCountries.add(values[0]);
					serieName.add(values[1]);
				}
			
			}
			
			
			
			//--------------------------------------------------------------------------------------
			//Creating user interface 
			
			String lapseYears[] = {"2011", "2012", "2013", "2014","2015", "2016", "2017", "2018", "2019","2020", "2021" };
		
			//setting combo boxes 
			GridPane gridPane = new GridPane();
			gridPane.setPadding(new Insets(25,25,25,25));
			gridPane.setHgap(5);
		    gridPane.setVgap(10);
		
			
			// coutries 
			cBoxCountry.getItems().addAll(mainCountries);
			cBoxCountry.setPromptText("Select Country");
			
			// series names
			cBoxSerie.getItems().addAll(serieName);
			cBoxSerie.setPromptText("Select Serie");

			// year 
			cBoxYear.getItems().addAll(lapseYears);
			cBoxYear.setPromptText("Select Year");
			
			
			//setting on the gridpane and width of combobox 
			gridPane.add(cBoxCountry, 0, 0);
			cBoxCountry.setPrefWidth(600);  

			gridPane.add(cBoxSerie, 0, 1);
			cBoxSerie.setPrefWidth(600); 
			    
			gridPane.add(cBoxYear, 0, 2);
			cBoxYear.setPrefWidth(600); 
			
			//setting gridpan button  getInfo
		
			gridPane.add(btGetInfo, 0, 3);
			
			//Setting gridpane
			gridPane.add(countryInfo, 0, 4);
			countryInfo.setEditable(false);
			 
			 //--------------------------------------------------------------------------------------
			 //Handling events 
			btGetInfo.setOnAction(e-> getCountryInfo());
			
			 			
			Scene scene = new Scene(gridPane);
			stage.setTitle("Countries");
			stage.setScene(scene);
			stage.show();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	//Function that check if required data is available or not in the system according with the year country and serie Name
	  private void getCountryInfo() {
		    // Get values from text fields
		   String m_country = cBoxCountry.getValue();
		   String m_serie  =cBoxSerie.getValue();
		   String m_year = cBoxYear.getValue();
		   for ( Country countryItem : listOfCountries) {
			   if (countryItem.getName().equals(m_country) && countryItem.getSerieName().equals(m_serie)) {
				   
				   countryInfo.setText(countryItem.display(m_year));
			   }
		   }
	
		   
		  }  
	public static void main(String[] args) {
		launch(args);
	}
}
