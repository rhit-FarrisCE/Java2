public class MiniVan extends Vehicle {
    private int numberOfSeats;
    private boolean hasAutoDoor;
    private boolean airConditionOn;

    public MiniVan(String modelName, String company, String owner, String engineType, 
                   double tankSize, double fuelConsumption, int numberOfSeats, boolean hasAutoDoor) {
        super(modelName, company, owner, engineType, tankSize, fuelConsumption);
        this.numberOfSeats = numberOfSeats;
        this.hasAutoDoor = hasAutoDoor;
        this.airConditionOn = false;
    }

    public int getNumberOfSeats() {
        return numberOfSeats;
    }

    public void setNumberOfSeats(int numberOfSeats) {
        this.numberOfSeats = numberOfSeats;
    }

    public boolean hasAutoDoor() {
        return hasAutoDoor;
    }

    public void setHasAutoDoor(boolean hasAutoDoor) {
        this.hasAutoDoor = hasAutoDoor;
    }

    public boolean isAirConditionOn() {
        return airConditionOn;
    }

    @Override
    public String toString() {
        return super.toString() + ", NumberOfSeat: " + numberOfSeats + 
               ", HasAutoDoor: " + hasAutoDoor + ", AirCondition: " + (airConditionOn ? "ON" : "OFF");
    }

    @Override
    double costFor100Km(PetroleumPrice price) {
        if (engineType.equals("Gasoline")) {
            return (100.0 / fuelConsumption) * price.getGasolinePrice();
        } else if (engineType.equals("Diesel")) {
            return (100.0 / fuelConsumption) * price.getDieselPrice();
        }
        return 0.0;
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
