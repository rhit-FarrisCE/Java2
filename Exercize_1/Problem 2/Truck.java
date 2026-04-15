public class Truck extends Vehicle {
    private int numberOfSeats;
    private int power;
    private boolean airConditionOn;

    public Truck(String modelName, String company, String owner, String engineType, 
                 double tankSize, double fuelConsumption, int numberOfSeats, int power) {
        super(modelName, company, owner, engineType, tankSize, fuelConsumption);
        this.numberOfSeats = numberOfSeats;
        this.power = power;
        this.airConditionOn = false;
    }

    public int getNumberOfSeats() {
        return numberOfSeats;
    }

    public void setNumberOfSeats(int numberOfSeats) {
        this.numberOfSeats = numberOfSeats;
    }

    public int getPower() {
        return power;
    }

    public void setPower(int power) {
        this.power = power;
    }

    public boolean isAirConditionOn() {
        return airConditionOn;
    }

    @Override
    public String toString() {
        return super.toString() + ", NumberOfSeat: " + numberOfSeats + 
               ", HorsePower: " + power + ", AirCondition: " + (airConditionOn ? "ON" : "OFF");
    }

    @Override
    double costFor100Km(PetroleumPrice price) {
        return (100.0 / fuelConsumption) * price.getDieselPrice();
    }

    @Override
    void setAirConditionON() {
        if (!airConditionOn) {
            airConditionOn = true;
            fuelConsumption = originalFuelConsumption * 0.75;
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
