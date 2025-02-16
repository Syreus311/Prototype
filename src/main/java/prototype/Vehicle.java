package prototype;

public class Vehicle implements VehiclePrototype {
    private String brand;
    private String model;
    private String fuelType;
    private String color;
    private int mileage;

    public Vehicle(String brand, String model, String fuelType, int mileage, String color) {
        this.brand = brand;
        this.model = model;
        this.fuelType = fuelType;
        this.mileage = mileage;
        this.color = color;
    }

    // Implementamos el método clone()
    @Override
    public VehiclePrototype clone() {
        return new Vehicle(this.brand, this.model, this.fuelType, this.mileage, this.color);
    }

    // Métodos para modificar las propiedades después de clonar
    public void setBrand(String brand) {
        this.brand = brand;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public void setFuelType(String fuelType) {
        this.fuelType = fuelType;
    }

    public void setMileage(int mileage) {
        this.mileage = mileage;
    }

    public void setColor(String color) {
        this.color = color;
    }

    // Método para mostrar información del vehículo
    public void showInfo() {
        System.out.println("Marca: " + brand + ", Modelo: " + model +
                ", Combustible: " + fuelType + ", Kilometraje: " + mileage + ", Color: " + color);
    }
}
