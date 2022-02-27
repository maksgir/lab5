package mg.lab5.client.objects;

public class Coordinates {
    private final Integer MAX_X = 981;
    private Integer x; //Максимальное значение поля: 981, Поле не может быть null
    private Long y; //Поле не может быть null

    public Coordinates(Integer x, Long y) {
        this.x = x;
        this.y = y;
    }

    public void setX(Integer x) {
        if (x == null) {
            throw new IllegalArgumentException("Поле не может быть null");
        } else if (x > MAX_X) {
            throw new IllegalArgumentException("Введено значение х болшее максимально допустимого значения");
        } else {
            this.x = x;
        }
    }

    public int getMAX_X() {
        return this.MAX_X;
    }

    public Integer getX() {
        return this.x;
    }

    public void setY(Long y) {
        if (x == null) {
            throw new IllegalArgumentException("Поле не может быть null");
        } else {
            this.y = y;
        }
    }

    public Long getY() {
        return this.y;
    }

    @Override
    public String toString() {
        return "x: " + x + " y: " + y;
    }


}
