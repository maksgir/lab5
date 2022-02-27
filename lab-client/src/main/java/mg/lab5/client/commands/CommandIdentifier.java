package mg.lab5.client.commands;

import mg.lab5.client.commands.add.AddCommand;
import mg.lab5.client.commands.add.AddIfMinCommand;
import mg.lab5.client.commands.clear.ClearCommand;
import mg.lab5.client.commands.executeScript.ExecuteScriptCommand;
import mg.lab5.client.commands.exit.ExitCommand;
import mg.lab5.client.commands.filter.FilterByDistanceCommand;
import mg.lab5.client.commands.filter.FilterGreaterThanDistanceCommand;
import mg.lab5.client.commands.help.HelpCommand;
import mg.lab5.client.commands.info.InfoCommand;
import mg.lab5.client.commands.remove.RemoveAnyByDistanceCommand;
import mg.lab5.client.commands.remove.RemoveByIDCommand;
import mg.lab5.client.commands.remove.RemoveHeadCommand;
import mg.lab5.client.commands.remove.RemoveLowerCommand;
import mg.lab5.client.commands.save.SaveCommand;
import mg.lab5.client.commands.show.ShowCommand;
import mg.lab5.client.commands.update.UpdateCommand;
import mg.lab5.client.objects.Route;
import mg.lab5.client.objects.RoutesCollection;

import java.io.File;

public class CommandIdentifier {
    private RoutesCollection collection;
    private Route route;
    private int id;
    private File file;
    private long distance;

    public CommandIdentifier(RoutesCollection collection, Route route, int id, File file, long distance) {
        this.collection = collection;
        this.route = route;
        this.id = id;
        this.file = file;
        this.distance = distance;
    }


    public CommandInterface identify(String... commands) {
        if (commands[0].equals("help")) return new HelpCommand();
        if (commands[0].equals("info")) return new InfoCommand(collection);
        if (commands[0].equals("show")) return new ShowCommand(collection);
        if (commands[0].equals("add")) return new AddCommand(route, collection);
        if (commands[0].equals("update")) return new UpdateCommand(id, route, collection);
        if (commands[0].equals("remove_by_id")) return new RemoveByIDCommand(id, collection);
        if (commands[0].equals("clear")) return new ClearCommand(collection);
        if (commands[0].equals("save")) return new SaveCommand(collection);
        if (commands[0].equals("execute_script")) return new ExecuteScriptCommand(file, collection);
        if (commands[0].equals("exit")) return new ExitCommand();
        if (commands[0].equals("remove_head")) return new RemoveHeadCommand(collection);
        if (commands[0].equals("add_if_min")) return new AddIfMinCommand(route, collection);
        if (commands[0].equals("remove_lower")) return new RemoveLowerCommand(route, collection);
        if (commands[0].equals("remove_any_by_distance")) return new RemoveAnyByDistanceCommand(distance, collection);
        if (commands[0].equals("filter_by_distance")) return new FilterByDistanceCommand(distance, collection);
        if (commands[0].equals("filter_greater_than_distance"))
            return new FilterGreaterThanDistanceCommand(distance, collection);
        else return new HelpCommand();

    }
}
