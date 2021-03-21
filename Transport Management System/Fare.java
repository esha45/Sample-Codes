package sample;

public class Fare {

    public float acCarFair(){
        ACCar a1 = new ACCar();
        return a1.fareCalculation();
    }

    public float nonAcCar(){
        NonAC a1 = new NonAC();
        return a1.fareCalculation();
    }

    public float withinCity(){
        WithinCity e1 = new WithinCity();
        return e1.fareCalculation();
    }

    public float anotherCity(){
        AnotherCity e1 = new AnotherCity();
        return e1.fareCalculation();
    }
}
