package mg.lab5.client.commands.executeScript;

import mg.lab5.client.commands.CommandIdentifier;
import mg.lab5.client.commands.CommandInterface;
import mg.lab5.client.commands.CommandValidator;
import mg.lab5.client.objects.Coordinates;
import mg.lab5.client.objects.Location;
import mg.lab5.client.objects.Route;
import mg.lab5.client.objects.RoutesCollection;

import java.io.*;

public class ScriptReader {
    private static RoutesCollection collection;
    private static Route route;
    private static int id;
    private static BufferedReader reader;
    private static long distance;
    private static File file;

    public static void work(File file, RoutesCollection routes) throws IOException {
        collection = routes;
        System.out.printf("Начинаю чтение из файла%s%n", file.getName());
        InputStreamReader inputStreamReader = new InputStreamReader(new FileInputStream(file));
        reader = new BufferedReader(inputStreamReader);

        var run = true;
        String inputLine = reader.readLine();
        while (run) {
            System.out.println("\nВыполняю команду: " + inputLine + "\n");
            if (CommandValidator.IdIsNeeded(inputLine)) {
                id = idReader(inputLine);

            }
            if (CommandValidator.RouteIsNeeded(inputLine)) {
                route = routeReader(inputLine);
            }

            if (CommandValidator.FileIsNeeded(inputLine)) {
                file = FileNameReader(inputLine);
            }
            if (CommandValidator.DistanceIsNeeded(inputLine)) {
                distance = DistanceReader(inputLine);
            }
            CommandIdentifier identifier = new CommandIdentifier(collection, route, id, file, distance);
            CommandInterface command = identifier.identify(inputLine.split(" "));
            command.execute();
            collection.sort();
            inputLine = reader.readLine();


        }
    }

    private static int idReader(String inputLine) {
        String[] data = inputLine.split(" ");
        return Integer.parseInt(data[1]);
    }

    private static Long DistanceReader(String line) {
        String[] data = line.split(" ");
        return Long.parseLong(data[1]);
    }

    private static File FileNameReader(String line) {
        String[] data = line.split(" ");
        return new File(data[1]);
    }

    private static Route routeReader(String inputLine) throws IOException {
        String[] data = inputLine.split(" ");
        String command = data[0];
        String name;
        long distance;
        if (!command.equals("update")) {
            name = data[1];
            distance = Long.parseLong(data[2]);
        } else {
            name = data[2];
            distance = Long.parseLong(data[3]);
        }

        String[] coordinateData = reader.readLine().split(" ");
        Integer x_coord = Integer.parseInt(coordinateData[0]);
        Long y_coord = Long.parseLong(coordinateData[1]);
        Coordinates coord = new Coordinates(x_coord, y_coord);

        String[] locationFromData = reader.readLine().split(" ");
        Double x_from = Double.parseDouble(locationFromData[0]);
        Long y_from = Long.parseLong(locationFromData[1]);
        String name_from = locationFromData[2];
        Location from = new Location(x_from, y_from, name_from);


        String[] locationToData = reader.readLine().split(" ");
        Double x_to = Double.parseDouble(locationFromData[0]);
        Long y_to = Long.parseLong(locationFromData[1]);
        String name_to = locationFromData[2];
        Location to = new Location(x_to, y_to, name_to);

        return new Route(name, coord, from, to, distance);

    }
}
