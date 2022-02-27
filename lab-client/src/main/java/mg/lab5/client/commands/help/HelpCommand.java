package mg.lab5.client.commands.help;

import mg.lab5.client.commands.CommandAbstract;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

public class HelpCommand extends CommandAbstract {

    public HelpCommand() {
    }

    @Override
    public void execute(String... lines) {
        try (InputStreamReader input = new InputStreamReader(new FileInputStream("C:\\Users\\Maksim\\Desktop\\prog5\\lab5\\lab-client\\src\\main\\java\\mg\\lab5\\client\\commands\\help\\help.txt"));) {
            BufferedReader reader = new BufferedReader(input);
            while (reader.ready()) {
                System.out.println(reader.readLine());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
