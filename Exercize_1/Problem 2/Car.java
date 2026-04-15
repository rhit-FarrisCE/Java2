public class Car extends Vehicle {
    private int numberOfSeats;
    private boolean airConditionOn;

    public Car(String modelName, String company, String owner, String engineType, 
               double tankSize, double fuelConsumption, int numberOfSeats) {
        super(modelName, company, owner, engineType, tankSize, fuelConsumption);
        this.numberOfSeats = numberOfSeats;
        this.airConditionOn = false;
    }

    public int getNumberOfSeats() {
        return numberOfSeats;
    }

    public void setNumberOfSeats(int numberOfSeats) {
        this.numberOfSeats = numberOfSeats;
    }

    public boolean isAirConditionOn() {
        return airConditionOn;
    }

    @Override
    public String toString() {
        return super.toString() + ", NumberOfSeat: " + numberOfSeats + 
               ", AirCondition: " + (airConditionOn ? "ON" : "OFF");
    }

    @Override
    double costFor100Km(PetroleumPrice price) {
        return (100.0 / fuelConsumption) * price.getGasolinePrice();
    }

    @Override
    void setAirConditionON() {
        if (!airConditionOn) {
            airConditionOn = true;
            fuelConsumption = originalFuelConsumption * 0.85;
        }
    }

    @Override
    void setAirConditionOFF() {
        if (airConditionOn) {
            airConditionOn = false;
            fuelConsumption = originalFuelConsumption;
        }
    }
}
