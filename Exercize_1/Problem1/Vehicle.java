public abstract class Vehicle {
    String modelName, company, owner, engineType;
    double tankSize;
    double fuelConsumption;

    public Vehicle (String modelName, String company, String owner, String engineType, double tankSize, double fuelConsumption){
        this.modelName = modelName;
        this.company = company;
        this.owner = owner;
        this.engineType = engineType;
        this.tankSize = tankSize;
        this.fuelConsumption = fuelConsumption;
    }

    public String toString(){
        return "ModelName: " + modelName + ", Company: " + company + ", Owner: " + owner + ", EngineType: " + engineType + ", TankSize: " + tankSize + ", FuelConsumption: " + fuelConsumption;
    }

    public double movableDistance(){
        return tankSize * fuelConsumption;
    }

    abstract double costFor100Km(PetroleumPrice pp);

    abstract void setAirConditionON();

    abstract void setAirConditionOFF();
}