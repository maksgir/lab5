package mg.lab5.client.commands.clear;

import mg.lab5.client.commands.CommandAbstract;
import mg.lab5.client.objects.RoutesCollection;

public class ClearCommand extends CommandAbstract {
    public ClearCommand(RoutesCollection collection) {
        super(collection);
    }

    @Override
    public void execute(String... lines) {
        routes.clear();
    }
}
