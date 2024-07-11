package case_study_module2.model;

public class Tablet extends Product {
    private boolean hasCellular;
    private int storageSize;
    public Tablet(){};

    public Tablet(String id, String name, String brand, double price , double screenSize, boolean hasCellular, int storageSize) {
        super(id, name, brand, price, screenSize);
        this.hasCellular = hasCellular;
        this.storageSize = storageSize;
    }

    public boolean getHasCellular() {
        return hasCellular;
    }

    public void setHasCellular(boolean hasCellular) {
        this.hasCellular = hasCellular;
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
                getHasCellular() + "," + getStorageSize();
    }

    @Override
    public void displayDetails() {
        System.out.println("Tablet [ID=" + id + ", Name=" + name + ", Brand=" + brand + ", Price=" + price +
                " VNĐ,  Screen Size= " + screenSize +" inch, Cellular=" + (getHasCellular() ? "Yes" : "No") + ", Storage Size=" + storageSize + "GB]");
    }

    @Override
    public String toString() {
        return "Tablet{" + super.toString() +
                "hasCellular=" + hasCellular +
                ", storageSize=" + storageSize +
                '}';
    }
}
