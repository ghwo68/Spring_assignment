public class Main {
    public static void main(String[] args) {
        /*
        Bus bus1 = new Bus();
        Bus bus2 = new Bus();

        bus1.passengerBoarding(2);
        bus1.useFuel(50);
        bus1.passengerQuite(2);
        bus1.stateChange(bus1.state.차고지행);
        bus1.gainFuel(10);
        bus1.stateChange(bus1.state.운행);
        bus1.passengerBoarding(45);
        bus1.passengerBoarding(5);
        bus1.useFuel(55);
        */

        Taxi taxi1 = new Taxi();
        Taxi taxi2 = new Taxi();

        taxi1.passengerBoarding(2,"서울역",2);
        taxi1.useFuel(80);
        taxi1.passengerQuite(2);
        taxi1.stateChange(taxi1.state.일반);
        taxi1.passengerBoarding(5,"",1);
        taxi1.passengerBoarding(3,"구로디지털단지역",12);
        taxi1.useFuel(20);

    }
}