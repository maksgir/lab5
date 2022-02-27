package mg.lab5.client.commands.save;

import mg.lab5.client.commands.CommandAbstract;
import mg.lab5.client.objects.RoutesCollection;

import java.io.File;
import java.io.IOException;

public class SaveCommand extends CommandAbstract {
    private static Integer id = 0;
    private final String path = "C:\\Users\\Maksim\\Desktop\\prog5\\lab5\\lab-client\\src\\main\\java\\mg\\lab5\\client\\commands\\save\\savedFiles\\saved";

    public SaveCommand(RoutesCollection collection) {
        super(collection);
    }

    @Override
    public void execute(String... lines) throws IOException {
        id++;
        new XMLWriter().write(new File(path + id.toString()), routes);
    }
}
