package mg.lab5.client.commands.info;

import mg.lab5.client.commands.CommandAbstract;
import mg.lab5.client.objects.RoutesCollection;

public class InfoCommand extends CommandAbstract {
    public InfoCommand(RoutesCollection collection) {
        super(collection);
    }

    @Override
    public void execute(String... lines) {
        System.out.printf("Коллекция %s типа %s%n" +
                        "%s%n" +
                        "Количество элементов: %d%n", routes.getClass().getSimpleName(), this.getRoutes().getCollection().getClass().getSimpleName(),
                this.getRoutes().getCreationDate(), this.getRoutes().getSize());
    }
}
