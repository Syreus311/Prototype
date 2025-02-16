package prototype;

public class Vehicle implements VehiclePrototype {
    private String bodywork;
    private String model;
    private String fuelType;
    private String color;
    private String wheels;

    public Vehicle(String bodywork, String model, String fuelType, String wheels, String color) {
        this.bodywork = bodywork;
        this.model = model;
        this.fuelType = fuelType;
        this.wheels = wheels;
        this.color = color;
    }

    // Implementamos el método clone()
    @Override
    public VehiclePrototype clone() {
        return new Vehicle(this.bodywork, this.model, this.fuelType, this.wheels, this.color);
    }

    // Métodos para modificar las propiedades después de clonar
    public void setBodywork(String bodywork) {
        this.bodywork = bodywork;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public void setFuelType(String fuelType) {
        this.fuelType = fuelType;
    }

    public void setwheels(String wheels) {
        this.wheels = wheels;
    }

    public void setColor(String color) {
        this.color = color;
    }

    // Método para mostrar información del vehículo
    public void showInfo() {
        System.out.println("Marca: " + bodywork + ", Modelo: " + model +
                ", Combustible: " + fuelType + ", Kilometraje: " + wheels + ", Color: " + color);
    }
}
