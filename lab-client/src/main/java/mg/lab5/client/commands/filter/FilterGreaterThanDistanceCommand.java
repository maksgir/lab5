package mg.lab5.client.commands.filter;

import mg.lab5.client.commands.CommandAbstract;
import mg.lab5.client.objects.RoutesCollection;

public class FilterGreaterThanDistanceCommand extends CommandAbstract {
    public FilterGreaterThanDistanceCommand(long distance, RoutesCollection collection) {
        super(distance, collection);
    }

    @Override
    public void execute(String... lines) {
        routes.filter_greater_than_distance(distance);
    }
}
