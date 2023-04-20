package models;

public class CarDTO implements InterfaceCarDTO {

    Integer id;
    String make;
    String model;
    String color;
    Integer year;
    String vin;

    public CarDTO(Integer id, String make, String model, String color, Integer year, String vin) {
        this.id = id;
        this.make = make;
        this.model = model;
        this.color = color;
        this.year = year;
        this.vin = vin;
    }

    public CarDTO() {
    }

    @Override
    public int getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getMake() {
        return make;
    }

    public void setMake(String make) {
        this.make = make;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public Integer getYear() {
        return year;
    }

    public void setYear(Integer year) {
        this.year = year;
    }

    public String getVin() {
        return vin;
    }

    public void setVin(String vin) {
        this.vin = vin;
    }

    @Override
    public String toString() {
        return "CarDTO [id=" + id + ", make=" + make + ", model=" + model + ", color=" + color + ", year=" + year
                + ", vin=" + vin + "]";
    }

}