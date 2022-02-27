package mg.lab5.client.commands.remove;

import mg.lab5.client.commands.CommandAbstract;
import mg.lab5.client.objects.RoutesCollection;

public class RemoveHeadCommand extends CommandAbstract {
    public RemoveHeadCommand(RoutesCollection collection) {
        super(collection);
    }

    @Override
    public void execute(String... lines) {
        routes.remove_head();
    }
}
