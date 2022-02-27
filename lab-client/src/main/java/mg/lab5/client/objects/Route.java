package mg.lab5.client.objects;

import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Comparator;

public class Route implements Comparable<Route> {
    private static int idCounter = 4;
    private int id; //Значение поля должно быть больше 0, Значение этого поля должно быть уникальным, Значение этого поля должно генерироваться автоматически
    private String name; //Поле не может быть null, Строка не может быть пустой
    private Coordinates coordinates; //Поле не может быть null
    private ZonedDateTime creationDate; //Поле не может быть null, Значение этого поля должно генерироваться автоматически
    private Location from; //Поле не может быть null
    private Location to; //Поле не может быть null
    private long distance; //Значение поля должно быть больше 1
    public static final int COUNT_OF_PRIMITIVE_ARGS = 2; //примитивные типы, классы-оболочки, String, классы для хранения дат

    public Route(String name, Coordinates coordinates, Location from, Location to, long distance) {
        try {
            setId();
            setDt();
            this.name = name;
            this.coordinates = coordinates;
            this.from = from;
            this.to = to;
            this.distance = distance;
        } catch (IllegalArgumentException e) {
            System.out.println("Некорректные параметры маршрута: " + e.getMessage());
        }

    }

    private void setId() {
        this.id = idCounter++;
    }

    public void setUpdatedId(Integer id) {
        this.id = id;
    }

    private void setDt() {
        ZoneId defaultZoneId = ZoneId.systemDefault();
        this.creationDate = ZonedDateTime.now(defaultZoneId);
    }

    public int getId() {
        return id;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        if (name.equals("") || name == null) {
            throw new IllegalArgumentException("Название не может быть null или пустым");
        } else {
            this.name = name;
        }
    }

    public Coordinates getCoordinates() {
        return coordinates;
    }

    public void setCoordinates(Coordinates coordinates) {
        if (coordinates == null) {
            throw new IllegalArgumentException("Передайте координаты, а не null пж");
        } else {
            this.coordinates = coordinates;
        }
    }

    public String getCreationDate() {
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd-MMMM-yyyy HH ч mm мин");
        return String.format("Дата создания: %s", dtf.format(creationDate));
    }


    public Location getFrom() {
        return from;
    }

    public void setFrom(Location from) {
        if (coordinates == null) {
            throw new IllegalArgumentException("Передайте локацию, а не null пж");
        } else {
            this.from = from;
        }

    }

    public Location getTo() {
        return to;
    }

    public void setTo(Location to) {
        if (coordinates == null) {
            throw new IllegalArgumentException("Передайте локацию, а не null пж");
        } else {
            this.to = to;
        }

    }

    public long getDistance() {
        return distance;
    }

    public void setDistance(long distance) {
        if (distance <= 1) {
            throw new IllegalArgumentException("Дистанция должна быть больше 1");
        } else {
            this.distance = distance;
        }

    }

    @Override
    public int compareTo(Route o) {
        return Comparator.comparing(Route::getDistance).thenComparing(Route::getName).thenComparing(Route::getCreationDate).compare(this, o);
    }

    @Override
    public String toString() {
        return String.format("Route %s #%d %n Coordinates: %s %n Creation Date: %s %n From: %s %n To: %s %n Distance: %d",
                this.name, this.id, this.coordinates.toString(),
                getCreationDate(), this.from.toString(), this.to.toString(), this.distance);
    }
}
