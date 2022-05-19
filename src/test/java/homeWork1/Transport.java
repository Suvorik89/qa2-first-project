package homeWork1;

public class Transport {
    private String transportName;
    private int distance;
    private int mileage;
    private Double fuelConsumption;
    private Double fuelOnCargo;

    private Double factorMileage = 0.01;
    private int cargo = 1;
    private Double fuelPrice = 1.82;
    private int distanceForCargo = 90;
    private Double fuelUsedOnDistance;
    private Double fuelPriceWithCargo;


    public Transport(
            String transportName,
            int distance,
            int mileage,
            Double fuelConsumption,
            Double fuelOnCargo
    ) {
        this.transportName = transportName;
        this.distance = distance;
        this.mileage = mileage;
        this.fuelConsumption = fuelConsumption;
        this.fuelOnCargo = fuelOnCargo;
    }

    public Double calculateFUOD() {
        return this.fuelUsedOnDistance = this.distance / 100 * this.fuelConsumption;
    }

    public Double calculateWithCargo() {
        if (this.mileage >= 150000) {
            this.fuelPriceWithCargo = this.fuelPrice * (((this.fuelConsumption * this.distance + (this.fuelOnCargo * this.cargo * this.distanceForCargo)) / 100) * (1 + factorMileage));
        } else {
            this.fuelPriceWithCargo = this.fuelPrice * this.calculateFUOD();
        }
        return this.fuelPriceWithCargo;
    }

    //----------setters and getters-----
    public int getDistance() {
        return distance;
    }

    public void setDistance(int distance) {
        this.distance = distance;
    }

    public String getTransportName() {
        return transportName;
    }

    public void setTransportName(String transportName) {
        this.transportName = transportName;
    }

    public int getMileage() {
        return mileage;
    }

    public void setMileage(int mileage) {
        this.mileage = mileage;
    }

    public Double getFuelConsumption() {
        return fuelConsumption;
    }

    public void setFuelConsumption(Double fuelConsumption) {
        this.fuelConsumption = fuelConsumption;
    }

    public int getCargo() {
        return cargo;
    }

    public void setCargo(int cargo) {
        this.cargo = cargo;
    }

    public Double getFuelOnCargo() {
        return fuelOnCargo;
    }

    public void setFuelOnCargo(Double fuelOnCargo) {
        this.fuelOnCargo = fuelOnCargo;
    }

    public Double getFactorMileage() {
        return factorMileage;
    }

    public void setFactorMileage(Double factorMileage) {
        this.factorMileage = factorMileage;
    }
}
