package mg.lab5.client.commands.save;

import com.thoughtworks.xstream.XStream;
import mg.lab5.client.objects.Route;
import mg.lab5.client.objects.RoutesCollection;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;

public class XMLWriter {
    public void write(File file, RoutesCollection routes) throws IOException {
        XStream xStream = new XStream();
        xStream.alias("Route", Route.class);
        xStream.alias("list", RoutesCollection.class);
        xStream.addImplicitCollection(RoutesCollection.class, "routes");
        String xmlText = "<?xml version=\"1.0\" encoding=\"UTF-8\"?> \n" + xStream.toXML(new ArrayList<>(routes.getCollection()));

        try (FileOutputStream out = new FileOutputStream(file);
             BufferedOutputStream bos = new BufferedOutputStream(out)) {

            byte[] buffer = xmlText.getBytes();
            bos.write(buffer, 0, buffer.length);
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }


    }

}