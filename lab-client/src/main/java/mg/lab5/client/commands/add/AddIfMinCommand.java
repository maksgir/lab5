package mg.lab5.client.commands.add;

import mg.lab5.client.commands.CommandAbstract;
import mg.lab5.client.objects.Route;
import mg.lab5.client.objects.RoutesCollection;

public class AddIfMinCommand extends CommandAbstract {
    public AddIfMinCommand(Route route, RoutesCollection collection) {
        super(route, collection);
    }

    @Override
    public void execute(String... lines) {
        routes.add_if_min(route);
    }
}
