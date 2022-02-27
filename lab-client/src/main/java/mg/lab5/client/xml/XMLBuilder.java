package mg.lab5.client.xml;

import com.thoughtworks.xstream.XStream;
import mg.lab5.client.objects.Coordinates;
import mg.lab5.client.objects.Location;
import mg.lab5.client.objects.Route;

import java.util.ArrayList;
import java.util.List;

public class XMLBuilder {
    public static void build() {
        List<Route> routeList = new ArrayList<>();
        routeList.add(new Route("Поездка домой", new Coordinates(100, 200L),
                new Location(15.5, 100L, "Санкт-Петербург"),
                new Location(10.7, 50L, "Калининград"), 1079));
        routeList.add(new Route("Поездка на работу", new Coordinates(75, 3000L),
                new Location(15.5, 100L, "Санкт-Петербург"),
                new Location(20.1, 600L, "Москва"), 807));

        routeList.add(new Route("Поездка на отдых", new Coordinates(75, 3000L),
                new Location(15.5, 100L, "Санкт-Петербург"),
                new Location(609D, 600L, "Сочи"), 6000));

        XStream xstream = new XStream();
        xstream.alias("Route", Route.class);
        System.out.println(xstream.toXML(routeList));

    }
}
