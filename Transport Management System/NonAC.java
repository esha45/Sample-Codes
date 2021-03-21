package sample;

public class NonAC extends Car{

    @Override
    public float fareCalculation(){
        super.baseFair=70;
        super.perKM = 8;
        super.perMinute = 3;
        super.waitingCharges = 8;
        float total = baseFair+perKM+perMinute+waitingCharges;
        return total;
    }
}
