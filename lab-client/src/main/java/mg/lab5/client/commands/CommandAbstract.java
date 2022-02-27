package mg.lab5.client.commands;

import mg.lab5.client.objects.Route;
import mg.lab5.client.objects.RoutesCollection;

import java.io.File;


public abstract class CommandAbstract implements CommandInterface {
    protected RoutesCollection routes;
    protected Integer id;
    protected Route route;
    protected File file;
    protected long distance;

    protected CommandAbstract() {
    }

    protected CommandAbstract(RoutesCollection routes) {
        this.routes = routes;

    }

    protected CommandAbstract(long distance, RoutesCollection routes) {
        this.routes = routes;
        this.distance = distance;
    }

    protected CommandAbstract(File file, RoutesCollection routes) {
        this.routes = routes;
        this.file = file;

    }

    protected CommandAbstract(Route route, RoutesCollection routes) {
        this.route = route;
        this.routes = routes;
    }

    protected CommandAbstract(Integer id, RoutesCollection routes) {
        this.id = id;
        this.routes = routes;
    }

    protected CommandAbstract(Integer id, Route route, RoutesCollection routes) {
        this.id = id;
        this.route = route;
        this.routes = routes;
    }

    public RoutesCollection getRoutes() {
        return this.routes;
    }
}
