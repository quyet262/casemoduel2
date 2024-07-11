package case_study_module2.model;

public abstract class Product {
    protected String id;
    protected String name;
    protected String brand;
    protected double price;
    protected double screenSize;

    public Product() {
    }

    public Product(String id, String name, String brand, double price, double screenSize) {
        this.id = id;
        this.name = name;
        this.brand = brand;
        this.price = price;
        this.screenSize = screenSize;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public double getScreenSize() {
        return screenSize;
    }

    public void setScreenSize(double screenSize) {
        this.screenSize = screenSize;
    }

    public abstract void displayDetails();
    public abstract String getInfoToFile();

    @Override
    public String toString() {
        return "Product{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", brand='" + brand + '\'' +
                ", price=" + price +
                ", screenSize=" + screenSize +
                '}';
    }
}
