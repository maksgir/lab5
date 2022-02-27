package mg.lab5.client.commands.executeScript;

import mg.lab5.client.commands.CommandAbstract;
import mg.lab5.client.objects.RoutesCollection;

import java.io.File;

public class ExecuteScriptCommand extends CommandAbstract {
    public ExecuteScriptCommand(File file, RoutesCollection collection) {
        super(file, collection);
    }

    @Override
    public void execute(String... lines) {
        try {
            ScriptReader.work(file, routes);
        } catch (Exception e) {
            System.out.println("Ошибка чтения файла");
            e.printStackTrace();
        }

    }
}
