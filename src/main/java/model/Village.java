package model;

import java.util.ArrayList;

public class Village {
    private int id;
    private String name;
    private boolean isLeft;


    private ArrayList<Building> buildings = new ArrayList<Building>();

    public Village() {
    }

    public Village(int id, String name, boolean isLeft) {
        this.id = id;
        this.name = name;
        this.isLeft = isLeft;
    }

    public void setID(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getID() {
        return id;
    }

    public String getName() {
        return name;
    }


    public ArrayList<Building> getBuildings() {
        return buildings;
    }


    public void setBuildings(ArrayList<Building> buildings) {
        this.buildings = buildings;
    }

    public boolean isLeft() {
        return isLeft;
    }

    public void setLeft(boolean left) {
        isLeft = left;
    }

}
