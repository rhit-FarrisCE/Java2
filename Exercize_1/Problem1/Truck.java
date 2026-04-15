public class Truck extends Vehicle {
    int numberOfSeats;
    double power;
    boolean airConditionOn;

    public Truck (String modelName, String company, String owner, String engineType, double tankSize, double fuelConsumption, int numberOfSeats, double power){
        super(modelName, company, owner, engineType, tankSize, fuelConsumption);
        this.numberOfSeats = numberOfSeats;
        this.power = power;
        this.airConditionOn = false;
    }

    public String toString(){
        return "ModelName: " + modelName + ", Company: " + company + ", Owner: " + owner + ", EngineType: " + engineType + ", TankSize: " + tankSize + ", FuelConsumption: " + fuelConsumption + ", NumberOfSeat: " + numberOfSeats  + ", HorsePower: " + power;
    }

    public double movableDistance(){
        return tankSize * fuelConsumption;
    }

    @Override
    double costFor100Km(PetroleumPrice pp) {
        return pp.getDieselCost(100.0 / fuelConsumption);
    }

    @Override
    void setAirConditionON() {
        if(!airConditionOn){
            airConditionOn = true;
            fuelConsumption *= 0.75;
        }
    }

    @Override
    void setAirConditionOFF() {
        if(airConditionOn){
            airConditionOn = false;
            fuelConsumption /= 0.75;
        }
    }
    
}
