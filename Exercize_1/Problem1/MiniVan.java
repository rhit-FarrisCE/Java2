public class MiniVan extends Vehicle {
    int numberOfSeats;
    boolean airConditionOn;
    boolean hasAutoDoor;

    public MiniVan (String modelName, String company, String owner, String engineType, double tankSize, double fuelConsumption, int numberOfSeats, boolean hasAutoDoor){
        super(modelName, company, owner, engineType, tankSize, fuelConsumption);
        this.numberOfSeats = numberOfSeats;
        this.airConditionOn = false;
        this.hasAutoDoor = hasAutoDoor;
    }

    public void setNumberOfSeat(int seats){
        this.numberOfSeats = seats;
    }

    public String toString(){
         return "ModelName: " + modelName + ", Company: " + company + ", Owner: " + owner + ", EngineType: " + engineType + ", TankSize: " + tankSize + ", FuelConsumption: " + fuelConsumption + ", NumberOfSeats: " + numberOfSeats + ", HasAutoDoor: " + hasAutoDoor;
    }

    public void setHasAutoDoor(boolean hasAutoDoor){
        this.hasAutoDoor = hasAutoDoor;
    }

    public double movableDistance(){
        return tankSize * fuelConsumption;
    }

    @Override
    double costFor100Km(PetroleumPrice pp) {
        if(engineType.equals("Gasoline")){
            return pp.getGasolineCost(100.0 / fuelConsumption);
        } else if(engineType.equals("Diesel")){
            return pp.getDieselCost(100.0 / fuelConsumption);
        }
        return 0.0;
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
