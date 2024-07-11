package case_study_module2.model;

public class Laptop extends Product {
    private int ramSize;
    private int storageSize;

    public Laptop() {
    }

    public Laptop(String id, String name, String brand, double price , double screenSize, int ramSize, int storageSize) {
        super(id, name, brand, price, screenSize);
        this.ramSize = ramSize;
        this.storageSize = storageSize;
    }

    public int getRamSize() {
        return ramSize;
    }

    public void setRamSize(int ramSize) {
        this.ramSize = ramSize;
    }

    public int getStorageSize() {
        return storageSize;
    }

    public void setStorageSize(int storageSize) {
        this.storageSize = storageSize;
    }

    @Override
    public String getInfoToFile() {
        return getId() + "," + getName() + "," + getBrand() + "," + getPrice() + "," + getScreenSize() + "," +
                getRamSize() + "," + getStorageSize();
    }

    @Override
    public void displayDetails() {
        System.out.println("Laptop [ID=" + id + ", Name=" + name + ", Brand=" + brand + ", Price=" + price + " VNĐ, Screen= " + screenSize +
                " inch, RAM Size=" + ramSize + "GB, Storage Size=" + storageSize + "GB]");
    }

    @Override
    public String toString() {
        return "Laptop{" + super.toString() +
                "ramSize=" + ramSize +
                ", storageSize=" + storageSize +
                '}';
    }
}
