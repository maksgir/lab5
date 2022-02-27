package mg.lab5.client.commands.remove;

import mg.lab5.client.commands.CommandAbstract;
import mg.lab5.client.objects.RoutesCollection;

public class RemoveAnyByDistanceCommand extends CommandAbstract {
    public RemoveAnyByDistanceCommand(long distance, RoutesCollection collection) {
        super(distance, collection);
    }

    @Override
    public void execute(String... lines) {
        routes.remove_any_by_distance(distance);
    }
}
