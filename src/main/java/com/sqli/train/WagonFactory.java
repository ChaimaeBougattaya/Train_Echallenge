package com.sqli.train;
public class WagonFactory {
    public Wagon getWagon(char type,int i){

        switch(type){
            case 'H': // head
                if(i==0) return new Head(Position.START);
                return new Head(Position.END);
            case 'P': // Passenger
                return new Passenger();
            case 'C': // Cargo
                return new Cargo();
            case 'R': // Restaurant
                return new Restaurant();
            default:
                System.out.println("Type not supported");return null;
        }
    }
}
