package mg.lab5.client;

import mg.lab5.client.commands.CommandReader;
import mg.lab5.client.objects.RoutesCollection;
import mg.lab5.client.xml.XMLParser;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;


public final class Client {
    private Client() {
        throw new UnsupportedOperationException("This is an utility class and can not be instantiated");
    }

    public static void main(String[] args) {
        RoutesCollection routes = new RoutesCollection();
        File file = new File(System.getenv("ROUTES"));
        try (FileInputStream inputStream = new FileInputStream(file); InputStreamReader reader = new InputStreamReader(inputStream)) {
            routes.setRoutes(XMLParser.parse(reader));
            CommandReader.work(routes);
        } catch (IOException e) {
            e.printStackTrace();
        }


    }
}
