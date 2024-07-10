package case_study_module2.model;

public class Smartphone extends Product {
    private String operatingSystem;
    private int batteryCapacity;

    public Smartphone() {
    }

    public Smartphone(String operatingSystem, int batteryCapacity) {
        this.operatingSystem = operatingSystem;
        this.batteryCapacity = batteryCapacity;
    }

    public Smartphone(String id, String name, String brand, double price, double screenSize, String operatingSystem, int batteryCapacity) {
        super(id, name, brand, price, screenSize);
        this.operatingSystem = operatingSystem;
        this.batteryCapacity = batteryCapacity;
    }

    public String getOperatingSystem() {
        return operatingSystem;
    }

    public void setOperatingSystem(String operatingSystem) {
        this.operatingSystem = operatingSystem;
    }


    public int getBatteryCapacity() {
        return batteryCapacity;
    }

    public void setBatteryCapacity(int batteryCapacity) {
        this.batteryCapacity = batteryCapacity;
    }

    @Override
    public String getInfoToFile() {
        return getId() + "," + getName() + "," + getBrand() + "," + getPrice() + "," + getScreenSize() + "," +
                getOperatingSystem() + "," + getBatteryCapacity();
    }

    @Override
    public void displayDetails() {
        System.out.println("Smartphone [ID=" + id + ", Name=" + name + ", Brand=" + brand + ", Price=" + price +
                " VNĐ, Screen Size=  " + screenSize +" inch, Operating System=" + operatingSystem + ", Battery Capacity=" + batteryCapacity + "mAh]");
    }
}

