package sample;

public class WithinCity extends Bus {

    @Override
    public float fareCalculation() {

        super.baseFair=40;
        super.perKM=8;
        super.perMinute=2;
        float total = baseFair+perKM+perMinute;
        return total;

    }

}
