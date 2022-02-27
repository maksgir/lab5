package mg.lab5.client.commands.remove;

import mg.lab5.client.commands.CommandAbstract;
import mg.lab5.client.objects.Route;
import mg.lab5.client.objects.RoutesCollection;

public class RemoveLowerCommand extends CommandAbstract {
    public RemoveLowerCommand(Route route, RoutesCollection collection) {
        super(route, collection);
    }

    @Override
    public void execute(String... lines) {
        routes.remove_lower(route);

    }
}
