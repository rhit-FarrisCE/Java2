public class PetroleumPrice{
    static double gasolinePrice = 128.7;
    static double dieselPrice = 105.7;
    
    public static getGasolineCost(double amountOfGas){
        return amountOfGas * gasolinePrice;
    }

    public static getDieselCost(double amountOfDiesel){
        return amountOfDiesel * dieselPrice;
    }
}