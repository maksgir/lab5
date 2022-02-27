package mg.lab5.client.commands.exit;

import mg.lab5.client.commands.CommandAbstract;

public class ExitCommand extends CommandAbstract {
    @Override
    public void execute(String... lines) {
        System.out.println("Завершение программы");
        System.exit(0);
    }
}
