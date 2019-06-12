package code;

import Structures.Vertex;
import java.util.*;

public class TravelRoute {
    private List<Vertex<Object>> pointsInTravelRoute;
    String routeName;

    public TravelRoute(String routeName){
        this.pointsInTravelRoute = new ArrayList<Vertex<Object>>();
        this.routeName = routeName;
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

    public void addPointInTravelRoute(Vertex poi){
        pointsInTravelRoute.add(poi);
    }
}
