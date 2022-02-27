package mg.lab5.client.objects;

import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class RoutesCollection {
    private ArrayDeque<Route> routes;
    private ZonedDateTime creationDate;

    public RoutesCollection() {
        this.routes = new ArrayDeque<>();
        setCreationDate();
    }

    public void add(Route newRoute) {
        routes.add(newRoute);
    }

    public void add_if_min(Route route) {
        System.out.println("Сравним введенный маршрут с самым маленьким из имеющихся...");
        System.out.println(route);
        System.out.println(routes.peek());
        if (route.compareTo(routes.peek()) < 0) {
            routes.add(route);
        }
    }

    public void update(Integer id, Route newRoute) {
        List<Route> routeList = new ArrayList<>(routes);
        routeList = routeList.stream().sorted().collect(Collectors.toList());
        newRoute.setUpdatedId(id);
        for (var oldRoute : routeList) {
            if (oldRoute.getId() == id) {
                routeList.set(routeList.indexOf(oldRoute), newRoute);
                System.out.printf("Меняю маршрут с ID=%d%nСтарый маршрут:" +
                        " %n%s%nНовый маршрут маршрут: %n%s%n", id, oldRoute, newRoute);

            }
        }
        this.routes = new ArrayDeque<>(routeList);


    }

    public void remove(int id) {
        System.out.printf("Удаляю маршрут с ID=%d", id);
        routes.removeIf(route -> route.getId() == id);
    }

    public void remove_head() {
        System.out.println(routes.pollFirst());
    }

    public void remove_lower(Route route) {
        routes.removeIf(r -> r.compareTo(route) < 0);
    }

    public void remove_any_by_distance(long distance) {
        System.out.println("Ищем маршрут с длинной " + distance);
        for (var r : routes) {
            if (r.getDistance() == distance) {
                System.out.println("Удаляем маршрут " + r.getName());
                routes.remove(r);

                break;
            }
        }
    }

    public void clear() {
        System.out.println("Очищаю коллекцию...");
        routes.clear();
    }

    public void sort() {
        List<Route> routeList = new ArrayList<>(routes);
        routeList = routeList.stream().sorted().collect(Collectors.toList());
        this.routes = new ArrayDeque<>(routeList);
    }

    public void filter_by_distance(long distance) {
        routes.stream().filter(x -> x.getDistance() == distance).collect(Collectors.toList()).forEach(System.out::println);
    }

    public void filter_greater_than_distance(long distance) {
        routes.stream().filter(x -> x.getDistance() > distance).collect(Collectors.toList()).forEach(System.out::println);
    }

    private void setCreationDate() {
        ZoneId defaultZoneId = ZoneId.systemDefault();
        this.creationDate = ZonedDateTime.now(defaultZoneId);
    }

    public int getSize() {
        return this.routes.size();
    }

    public String getCollectionElemsNames() {
        return this.routes.toString();
    }

    public String getCreationDate() {
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd-MMMM-yyyy HH ч mm мин");
        return String.format("Дата создания: %s", dtf.format(creationDate));
    }

    public ArrayDeque<Route> getCollection() {
        return routes;
    }

    public void setRoutes(ArrayDeque<Route> routes) {
        this.routes = routes;
    }
}
