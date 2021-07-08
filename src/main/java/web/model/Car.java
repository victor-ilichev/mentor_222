package web.model;

public class Car {
    private String title;
    private String color;
    private int year;

    public Car(String title, String color, int year) {
        this.title = title;
        this.color = color;
        this.year = year;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }
}
