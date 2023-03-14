package com.sqli.train;

import java.util.ArrayList;
import java.util.List;

public class Train {
	List<Wagon> wagons=new ArrayList<>();
	private WagonFactory wagonFactory = new WagonFactory();

	public Train(String structure) {
		/**
		 loop throw the string structure
		 and for each character add the appropriate wagon
		 for example : H => add new instance of Head class ...etc
		 * */
		for(int i=0;i<structure.length();i++){
			wagons.add(wagonFactory.getWagon(structure.charAt(i),i));
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
