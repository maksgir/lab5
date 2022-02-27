package mg.lab5.client.commands.show;

import mg.lab5.client.commands.CommandAbstract;
import mg.lab5.client.objects.RoutesCollection;

public class ShowCommand extends CommandAbstract {
    public ShowCommand(RoutesCollection collection) {
        super(collection);
    }

    @Override
    public void execute(String... lines) {
        var collection = this.getRoutes().getCollection();
        for (var route : collection) {
            System.out.println(route);
        }
    }
}
