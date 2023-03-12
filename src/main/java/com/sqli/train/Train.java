package com.sqli.train;

public class Train {
	private String[] structure;

	public Train(String str) {
		this.structure=str.split("");
	}

	public String print(){
		String str="";
		for (int i = 0; i< structure.length; i++){
			switch(structure[i]){
				case "H":
					if(i==0) str+="<HHHH";
					else str+="HHHH>";
					break;
				case "R":
					str+="|hThT|";
					break;
				case "P":
					str+="|OOOO|";
					break;
				case "C":
					// here we have a problem
					// we should stock the information EMPTY or LOADED,
					// so we should create a class
					break;

			}

		}
		return "<HHHH::|OOOO|::|OOOO|";
	}

	public void detachEnd(){
		//throw new UnsupportedOperationException("Still to be implemented");
	}

	public void detachHead(){
		//throw new UnsupportedOperationException("Still to be implemented");
	}

	public boolean fill(){
        //throw new UnsupportedOperationException("Still to be implemented");
		return true;
	}
}
