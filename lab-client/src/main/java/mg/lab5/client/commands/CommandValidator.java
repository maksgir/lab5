package mg.lab5.client.commands;

import mg.lab5.client.objects.Route;

import java.util.List;

public class CommandValidator {

    private static final List<String> coms = List.of("help", "info", "show", "add", "update", "remove_by_id",
            "clear", "save", "execute_script", "exit", "remove_head",
            "add_if_min", "remove_lower", "remove_any_by_distance",
            "filter_by_distance", "filter_greater_than_distance");
    private static final List<String> commandsWithRoute = List.of("add", "update", "add_if_min", "remove_lower");
    private static final List<String> commandsWithID = List.of("update", "remove_by_id");
    private static final List<String> commandsWithFile = List.of("execute_script");
    private static final List<String> commandsWithDistance = List.of("remove_any_by_distance", "filter_by_distance", "filter_greater_than_distance");


    public static boolean isValid(String command) {
        String[] line = command.split(" ");
        String commandName = line[0];

        if (command.isBlank() || !coms.contains(commandName)) {
            System.out.println("Ошибка в названии команды");
            return false;
        }
        if (commandName.startsWith("add") || commandName.startsWith("update") || commandName.startsWith("add_if_min") || commandName.startsWith("remove_lower")) {
            return primitivesAreValid(line);
        }

        return true;
    }

    public static boolean RouteIsNeeded(String line) {
        return commandsWithRoute.contains(line.split(" ")[0]);
    }

    public static boolean IdIsNeeded(String line) {
        return commandsWithID.contains(line.split(" ")[0]);

    }

    public static boolean FileIsNeeded(String line) {
        return commandsWithFile.contains(line.split(" ")[0]);
    }

    public static boolean DistanceIsNeeded(String line) {
        return commandsWithDistance.contains(line.split(" ")[0]);
    }


    private static boolean primitivesAreValid(String... args) {
        int additionalParams = 1;
        String command = args[0];
        if (command.equals("update")) additionalParams++;
        if (args.length - additionalParams != Route.COUNT_OF_PRIMITIVE_ARGS) {
            System.out.println("Количество примитивных данных ожидалось другое");
            return false;
        }
        String name = args[additionalParams];
        if (name.equals("") || name == null) {
            System.out.println("Название не может быть null или пустым");
            return false;
        }

        long distance = Long.parseLong(args[additionalParams + 1]);
        if (distance <= 1) {
            System.out.println("Дистанция должна быть больше 1");
            return false;
        }
        return true;
    }

}
