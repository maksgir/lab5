package mg.lab5.client.objects;

public class Location {
    private Double x; //Поле не может быть null
    private long y;
    private String name; //Поле не может быть null

    public Location(Double x, long y, String name) {
        this.x = x;
        this.y = y;
        this.name = name;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        if (x == null) {
            throw new IllegalArgumentException("Имя не может быть null");
        } else {
            this.name = name;
        }
    }

    public long getY() {
        return y;
    }

    public void setY(long y) {
        this.y = y;
    }

    public Double getX() {
        return x;
    }

    public void setX(Double x) {
        if (x == null) {
            throw new IllegalArgumentException("Поле не может быть null");
        } else {
            this.x = x;
        }

    }

    @Override
    public String toString() {
        return name + " x: " + x + " y: " + y;
    }
}
