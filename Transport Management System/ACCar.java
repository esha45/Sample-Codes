package sample;

public class ACCar extends Car{

    @Override
    public float fareCalculation(){
        super.baseFair=80;
        super.perKM = 10;
        super.perMinute = 5;
        super.waitingCharges = 10;
        float total = baseFair+perKM+perMinute+waitingCharges;
        return total;
    }

}
