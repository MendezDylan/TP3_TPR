package code;

import Structures.*;        

public class PointOfInterest {
    int coordX;
    int coordY;
    String name;
    String type;

    public PointOfInterest(int coordX, int coordY, String name, String type) {
        this.coordX = coordX;
        this.coordY = coordY;
        this.name = name;
        this.type = type;
    }

    public int getCoordX() {
        return coordX;
    }

    public int getCoordY() {
        return coordY;
    }

    public String getName() {
        return name;
    }

    public String getType() {
        return type;
    }
    
    public void setCoordX(int coordX) {
        this.coordX = coordX;
    }

    public void setCoordY(int coordY) {
        this.coordY = coordY;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setType(String type) {
        this.type = type;
    }
    
    @Override
    public String toString() {
        return this.name;
    }
    
}
