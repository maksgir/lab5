package mg.lab5.client.commands;

import mg.lab5.client.commands.help.HelpCommand;
import mg.lab5.client.objects.Coordinates;
import mg.lab5.client.objects.Location;
import mg.lab5.client.objects.Route;
import mg.lab5.client.objects.RoutesCollection;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;

public class CommandReader {
    private static RoutesCollection collection;
    private static Route route;
    private static int id;
    private static File file;
    private static long distance;

    public static void work(RoutesCollection routes) throws IOException {
        collection = routes;
        InputStreamReader input = new InputStreamReader(System.in);
        BufferedReader reader = new BufferedReader(input);

        var run = true;
        while (run) {
            collection.sort();
            System.out.println("\nВведите команду\n");
            String inputLine = reader.readLine();
            while (true) {
                if (CommandValidator.isValid(inputLine))
                    break;

                incorrectInputWarning();
                inputLine = reader.readLine();
            }
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


        }

    }

    public static void incorrectInputWarning() {
        System.out.println("Введенная строка не соответствует правилам\n" +
                "Напомним правила ввода команды\n");
        new HelpCommand().execute();
    }

    private static File FileNameReader(String line) {
        String[] data = line.split(" ");
        return new File(data[1]);
    }

    private static Long DistanceReader(String line) {
        String[] data = line.split(" ");
        Long dis = 0L;
        boolean valid = false;
        while (!valid) {
            try {
                dis = Long.parseLong(data[1]);
                valid = true;
            } catch (Exception e) {
                e.printStackTrace();
            }

        }

        return dis;
    }

    private static int idReader(String inputLine) {
        boolean valid = false;
        String[] data = inputLine.split(" ");
        var id = Integer.parseInt(data[1]);
        while (!valid) {
            try {
                boolean idIsFound = false;
                for (var ids : collection.getCollection()) {
                    if (ids.getId() == id) {
                        idIsFound = true;
                        break;
                    }
                }
                if (!idIsFound) {
                    System.out.println("В коллекции нет маршрута с указанным ID\nВведите его еще раз просто числом");
                    InputStreamReader input = new InputStreamReader(System.in);
                    BufferedReader reader = new BufferedReader(input);
                    id = Integer.parseInt(reader.readLine());
                } else {
                    valid = true;

                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        return id;
    }

    private static Route routeReader(String inputLine) throws IOException {
        InputStreamReader input = new InputStreamReader(System.in);
        BufferedReader reader = new BufferedReader(input);

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


        System.out.printf("Создается новый маршрут...%nНазвание маршрута: %s%n" +
                "Длина маршрута %d км%n", name, distance);
        boolean valid = false;
        Coordinates coord = new Coordinates(0, 0L);
        while (!valid) {
            try {
                System.out.println("Введите через пробел координаты маршрута x и y :");
                String[] coordinates = reader.readLine().split(" ");
                Integer x = Integer.parseInt(coordinates[0]);
                Long y = Long.parseLong(coordinates[1]);

                if (x >= 981) {
                    System.out.println("Координата х не может быть больше 981");
                } else {
                    coord.setX(x);
                    coord.setY(y);
                    valid = true;
                }
            } catch (Exception e) {
                e.printStackTrace();
            }


        }
        boolean valid1 = false;
        Location from = new Location((double) 0, 0, "");

        while (!valid1) {
            try {
                System.out.println("Введите через пробел координаты локации откуда выезжаете x и y :");
                String[] coordinates = reader.readLine().split(" ");
                Double x = Double.parseDouble(coordinates[0]);
                Long y = Long.parseLong(coordinates[1]);
                System.out.println("Введите название локации откуда выезжаете");
                String nameFrom = reader.readLine();
                if (x == null || y == null || nameFrom == null) {
                    System.out.println("Поле не может быть null");
                } else {
                    from.setName(nameFrom);
                    from.setX(x);
                    from.setY(y);
                    valid1 = true;
                }
            } catch (Exception e) {
                e.printStackTrace();
            }

        }
        boolean valid2 = false;
        Location to = new Location((double) 0, 0, "");
        while (!valid2) {
            try {
                System.out.println("Введите через пробел координаты локации куда едете x и y :");
                String[] coordinates = reader.readLine().split(" ");
                Double x = Double.parseDouble(coordinates[0]);
                Long y = Long.parseLong(coordinates[1]);
                System.out.println("Введите название локации куда едете");
                String nameFrom = reader.readLine();
                if (x == null || y == null || nameFrom == null) {
                    System.out.println("Поле не может быть null");
                } else {
                    to.setName(nameFrom);
                    to.setX(x);
                    to.setY(y);
                    valid2 = true;
                }
            } catch (Exception e) {
                e.printStackTrace();
            }

        }


        return new Route(name, coord, from, to, distance);
    }


}
