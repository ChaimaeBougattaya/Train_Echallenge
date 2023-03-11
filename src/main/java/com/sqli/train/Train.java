package com.sqli.train;

import java.util.ArrayList;
import java.util.List;

public class Train {
	List<Wagon> wagons;

	public Train(String structure) {
		wagons=new ArrayList<>();
		for(int i=0;i<structure.length();i++){
			switch(structure.charAt(i)){
				case 'H':
					if(i==0)
						wagons.add(new Head(Position.START));
					else
						wagons.add(new Head(Position.END));
					break;
				case 'P':
					wagons.add(new Passenger());
					break;
				case 'C':
					wagons.add(new Cargo());
					break;
				case 'R':
					wagons.add(new Restaurant());
					break;
				default:
					System.out.println("Type not supported");
					break;
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
