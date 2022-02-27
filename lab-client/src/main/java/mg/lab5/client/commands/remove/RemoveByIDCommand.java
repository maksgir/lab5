package mg.lab5.client.commands.remove;

import mg.lab5.client.commands.CommandAbstract;
import mg.lab5.client.objects.RoutesCollection;

public class RemoveByIDCommand extends CommandAbstract {
    public RemoveByIDCommand(Integer id, RoutesCollection collection) {
        super(id, collection);
    }

    @Override
    public void execute(String... lines) {
        routes.remove(id);
    }
}
