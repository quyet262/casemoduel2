package thi_thuc_hanh_module2.model;

public class HandedSmartPhone extends SmartPhone {
    private String portableCountry;
    private String status;
    public HandedSmartPhone(){}
    public HandedSmartPhone(String portableCountry, String status){
        this.portableCountry = portableCountry;
        this.status = status;
    }
    public HandedSmartPhone(int id, String name, double price, int quantity, String brand, String portableCountry, String status){
        super(id, name, price, quantity, brand);
        this.portableCountry = portableCountry;
        this.status = status;
    }

    public String getPortableCountry() {
        return portableCountry;
    }

    public void setPortableCountry(String portableCountry) {
        this.portableCountry = portableCountry;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override

    public String getInfoToFile() {
        return getId() + "," + getName() + "," + getPrice() + "," + getQuantity() + "," + getBrand() + "," + getPortableCountry() + "," + getStatus() + "\n";
    }

    @Override
    public String toString() {
        return "HandedSmartPhone.csv{" + super.toString() +
                ", portableCountry='" + portableCountry + '\'' +
                ", status='" + status + '\'' +
                '}';
    }
}
