package com.sqli.train;

import java.util.ArrayList;
import java.util.List;

public class Train {
	List<Wagon> wagons=new ArrayList<>();

	public Train(String structure) {
		/**
		 loop throw the string structure
		 and for each character add the appropriate wagon
		 for example : H => add new instance of Head class ...etc
		 * */
		for(int i=0;i<structure.length();i++){
			switch(structure.charAt(i)){
				case 'H': // head
					if(i==0)
						wagons.add(new Head(Position.START));
					else
						wagons.add(new Head(Position.END));
					break;
				case 'P': // Passenger
					wagons.add(new Passenger());break;
				case 'C': // Cargo
					wagons.add(new Cargo());break;
				case 'R': // Restaurant
					wagons.add(new Restaurant());break;
				default:
					System.out.println("Type not supported");break;
			}
		}
	}

	public String print(){
		String str="";
		for(int i=0;i<wagons.size();i++){
			str+=wagons.get(i).print();
			if(i!= wagons.size()-1)
				str+="::";
		}
		return str;
	}

	public void detachEnd(){
		//remove the last wagon
		wagons.remove(wagons.size()-1);
	}

	public void detachHead(){
		//remove the first wagon
		if(!wagons.isEmpty())wagons.remove(0);
	}

	public boolean fill(){
		/** change the first wagon type Cargo found
		 who has the status empty to loaded */
		for(Wagon wagon : wagons){
			if(wagon instanceof Cargo){
				if( ((Cargo)wagon).isEmptyCargo()){
					((Cargo) wagon).setLoadedCargo();
					return true;
				}
			}
		}
		return false ;
	}
}
