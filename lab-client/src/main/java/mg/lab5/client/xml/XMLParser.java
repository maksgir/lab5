package mg.lab5.client.xml;

import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.security.AnyTypePermission;
import mg.lab5.client.objects.Route;
import mg.lab5.client.objects.RoutesCollection;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;

public class XMLParser {
    public static ArrayDeque<Route> parse(InputStreamReader reader) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(reader);
        StringBuilder builder = new StringBuilder();
        while (bufferedReader.ready()) {
            builder.append(bufferedReader.readLine().trim());
        }
        XStream xStream = new XStream();
        xStream.addPermission(AnyTypePermission.ANY);
        xStream.alias("Route", Route.class);
        xStream.alias("list", RoutesCollection.class);
        xStream.addImplicitCollection(RoutesCollection.class, "routes");
        RoutesCollection routes = (RoutesCollection) xStream.fromXML(builder.toString());
        return routes.getCollection();
    }
}
