package com.sqli.train;

public class Cargo implements Wagon{
    private Status status=Status.EMPTY;
    @Override
    public String print() {
        return status==Status.EMPTY ? "|____|"
                : status==Status.LOADED ? "|^^^^|" : "";
    }
    public boolean isEmptyCargo() {
        return status==Status.EMPTY;
    }
    public void setLoadedCargo(){
        status=Status.LOADED;
    }
}
