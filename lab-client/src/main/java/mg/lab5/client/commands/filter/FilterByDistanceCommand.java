package mg.lab5.client.commands.filter;

import mg.lab5.client.commands.CommandAbstract;
import mg.lab5.client.objects.RoutesCollection;

public class FilterByDistanceCommand extends CommandAbstract {
    public FilterByDistanceCommand(long distance, RoutesCollection collection) {
        super(distance, collection);
    }

    @Override
    public void execute(String... lines) {
        routes.filter_by_distance(distance);
    }
}
