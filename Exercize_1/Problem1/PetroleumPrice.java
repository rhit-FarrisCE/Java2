public class PetroleumPrice{
    static double gasolinePrice = 128.7;
    static double dieselPrice = 105.7;

    public PetroleumPrice(double gasolinePrice, double dieselPrice){
        this.gasolinePrice = gasolinePrice;
        this.dieselPrice = dieselPrice;
    }
    
    public double getGasolineCost(double amountOfGas){
        return amountOfGas * gasolinePrice;
    }

    public double getDieselCost(double amountOfDiesel){
        return amountOfDiesel * dieselPrice;
    }
}