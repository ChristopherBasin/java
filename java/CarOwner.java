public class CarOwner extends Owner {
    private String plateNumber;

    public CarOwner(String plateNumber, String name, String address) {
        super(name, address);
        this.plateNumber = plateNumber;
    }

    public String getPlateNumber() {
        return plateNumber;
    }

    public void setPlateNumber(String plateNumber) {
        this.plateNumber = plateNumber;
    }

    @Override
    public String toString() {
        return "Plate: " + plateNumber + "\nName: " + getName() + "\nAddress: " + getAddress();
    }
}
