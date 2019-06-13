package code;

import Structures.Vertex;
import java.util.*;

public class TravelRoute {
    private List<Vertex<Object>> pointsInTravelRoute;
    String routeName;
    int totalDistance;
    int totalTime;

    public TravelRoute(String routeName, int totalDistance, int totalTime) {
        pointsInTravelRoute = new ArrayList<Vertex<Object>>();
        this.routeName = routeName;
        this.totalDistance = totalDistance;
        this.totalTime = totalTime;
    }

    public List<Vertex<Object>> getPointsInTravelRoute() {
        return pointsInTravelRoute;
    }

    public void setPointsInTravelRoute(List<Vertex<Object>> pointsInTravelRoute) {
        this.pointsInTravelRoute = pointsInTravelRoute;
    }

    public String getRouteName() {
        return routeName;
    }

    public void setRouteName(String routeName) {
        this.routeName = routeName;
    }

    public int getTotalDistance() {
        return totalDistance;
    }

    public void setTotalDistance(int totalDistance) {
        this.totalDistance = totalDistance;
    }

    public int getTotalTime() {
        return totalTime;
    }

    public void setTotalTime(int totalTime) {
        this.totalTime = totalTime;
    }
    //Adds a point of interest into the list
    public void addPointInTravelRoute(Vertex poi){
        pointsInTravelRoute.add(poi);
    }
    
    @Override
    public String toString(){
        return routeName;
    }
}
