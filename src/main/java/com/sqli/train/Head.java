package com.sqli.train;

public class Head implements Wagon{
    private Position position;
    public Head(Position position) {
        this.position = position;
    }
    @Override
    public String print() {
        return position == Position.START ? "<HHHH"
                : position == Position.END ? "HHHH>" : "";
    }
}
