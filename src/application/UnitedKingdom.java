/**********************************************
Workshop # 7
Course:<> - Semester 4 JAC444ZBB
Last Name:Padilla 
First Name:Luis
ID:118613207
Section:ZBB
This assignment represents my own work in accordance with Seneca Academic Policy.
Signature
Date:<submission date>
**********************************************/
package application;

import java.util.ArrayList;

public class UnitedKingdom extends Country{

	// series name is collection of strings
	
	
	// variable string [] years 
	ArrayList <String>  years = new ArrayList(); 
	
	// constructor 
	
	UnitedKingdom () {
		
	}
	// 1 argument constructor
	UnitedKingdom (String [] arr) {
		countryName = arr[0];
		serieName = arr[1];
		int count = 0;
		for (int j = 2 ; j < 13 ; j++) {
			years.add(arr[j]);
			count++;
		}
	}
	
	
	String getName() {
		return countryName;
	}
	public void setName (String s ) {
		countryName = s;
	}
	
	String getSerieName () {
		return serieName;
	}
	
	public void setSerieName (String s) {
		serieName = s;
	}
	public String  display(String s_year ) {
		String item;
		String selectedYear = null;
		
		if (s_year== "2011") {
			selectedYear = years.get(0);
		}else if (s_year== "2012") {
			if (years.get(1).equals("..")) {
				selectedYear = "Info Not available";
			}else {
				selectedYear = years.get(1);}
			
		}else if (s_year== "2013") {
			if (years.get(2).equals("..")) {
				selectedYear = "Info Not available";
			}else {
				selectedYear = years.get(2);}
			
		}else if(s_year== "2014") {
			if (years.get(3).equals("..")) {
				selectedYear = "Info Not available";
			}else {
				selectedYear = years.get(3);}
			
		}else if(s_year== "2015") {
			if (years.get(4).equals("..")) {
				selectedYear = "Info Not available";
			}else {
				selectedYear = years.get(4);}
			
		}else if(s_year== "2016") {
			if (years.get(5).equals("..")) {
				selectedYear = "Info Not available";
			}else {
				selectedYear = years.get(5);}
			
		}else if(s_year== "2017") {
			if (years.get(6)=="..") {
				selectedYear = "Info Not available";
			}else {
				selectedYear = years.get(6);}

		}else if(s_year== "2018") {
			if (years.get(7).equals("..")) {
				selectedYear = "Info Not available";
			}else {
				selectedYear = years.get(7);}

		}else if(s_year== "2019") {
			if (years.get(8).equals("..")) {
				selectedYear = "Info Not available";
			}else {
				selectedYear = years.get(8);}
		
		}else if(s_year== "2020") {
			if (years.get(9).equals("..")) {
				selectedYear = "Info Not available";
			}else {
				selectedYear = years.get(9);}
			
		}else if(s_year== "2021") {
			if (years.get(10).equals("..")) {
				selectedYear = "Info Not available";
			}else {
				selectedYear = years.get(10);}

		}
		
		item =("\nCountry name: "+countryName+" "+ "Serie name: "+getSerieName()+" "+ s_year+": "+selectedYear);
				
		return item;
				
	}
}
