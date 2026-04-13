public abstract class Vehicle {
    String modelName, company, owner, engineType;
    double tankSize;
    double fuelConsumption;

    public Vehicle (String modelName, String company, String owner, String engineType, double tankSize, double fuelConsuption){
        this.modelName = modelName;
        this.company = company;
        this.owner = owner;
        this.engineType = engineType;
        this.tankSize = tankSize;
        this.fuelConsumption = fuelConsumption;
    }

    public String toString(){
        return "";
    }

    public int MovibleDistance(){
        return tankSize / fuelConsumption;
    }

    abstract double costFor100Km(PetroleumPrice pp);

    abstract setAirConditionON();
}