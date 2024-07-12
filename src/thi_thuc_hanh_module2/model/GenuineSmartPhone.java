package thi_thuc_hanh_module2.model;

public class GenuineSmartPhone extends SmartPhone {
    private String warrantyPeriod;
    private String warrantyScope;
    public GenuineSmartPhone() {}
    public GenuineSmartPhone(String warrantyPeriod, String warrantyScope) {
        this.warrantyPeriod = warrantyPeriod;
        this.warrantyScope = warrantyScope;
    }
    public GenuineSmartPhone(int id, String name, double price, int quantity, String brand, String warrantyPeriod, String warrantyScope) {
        super(id, name, price, quantity, brand);
        this.warrantyPeriod = warrantyPeriod;
        this.warrantyScope = warrantyScope;
    }

    public String getWarrantyPeriod() {
        return warrantyPeriod;
    }

    public void setWarrantyPeriod(String warrantyPeriod) {
        this.warrantyPeriod = warrantyPeriod;
    }

    public String getWarrantyScope() {
        return warrantyScope;
    }

    public void setWarrantyScope(String warrantyScope) {
        this.warrantyScope = warrantyScope;
    }

    @Override
    public String getInfoToFile() {
        return getId() + "," + getName() + "," + getPrice() + "," + getQuantity() + "," + getBrand() + "," +
                getWarrantyPeriod() + "," + getWarrantyScope();
    }

    @Override
    public String toString() {
        return "GenuineSmartPhone{" + super.toString() +
                ", warrantyPeriod='" + warrantyPeriod + '\'' +
                ", warrantyScope='" + warrantyScope + '\'' +
                '}';
    }
}
