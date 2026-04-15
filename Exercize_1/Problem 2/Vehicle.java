public abstract class Vehicle {
    protected String modelName;
    protected String company;
    protected String owner;
    protected String engineType;
    protected double tankSize;
    protected double fuelConsumption;
    protected double originalFuelConsumption;

    public Vehicle(String modelName, String company, String owner, String engineType, 
                   double tankSize, double fuelConsumption) {
        this.modelName = modelName;
        this.company = company;
        this.owner = owner;
        this.engineType = engineType;
        this.tankSize = tankSize;
        this.fuelConsumption = fuelConsumption;
        this.originalFuelConsumption = fuelConsumption;
    }

    public double movableDistance() {
        return tankSize * fuelConsumption;
    }

    public String toString() {
        return "ModelName: " + modelName + ", Company: " + company + ", Owner: " + owner + 
               ", EngineType: " + engineType + ", TankSize: " + tankSize + 
               ", FuelConsumption: " + fuelConsumption;
    }

    abstract double costFor100Km(PetroleumPrice price);

    abstract void setAirConditionON();

    abstract void setAirConditionOFF();
}