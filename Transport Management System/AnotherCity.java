package sample;

public class AnotherCity extends Bus {

    @Override
    public float fareCalculation() {

        super.baseFair=1000;
        super.perKM=5;
        float total = baseFair+perKM;
        return total;

    }

}
