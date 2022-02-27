package mg.lab5.client.commands.update;

import mg.lab5.client.commands.CommandAbstract;
import mg.lab5.client.objects.Route;
import mg.lab5.client.objects.RoutesCollection;

public class UpdateCommand extends CommandAbstract {
    public UpdateCommand(Integer id, Route route, RoutesCollection collection) {
        super(id, route, collection);
    }

    @Override
    public void execute(String... lines) {
        routes.update(id, route);
    }
}
