class Taxi extends PublicTransport{
    String destination; // 목적지
    int destinationDistance;    // 목적지까지의 거리
    int basicDistance = 1;  // 기본 거리
    int basicFare = 3000;   // 기본 요금
    int destinationFare = 1000; // 거리당 요금
    int totalFare = 0;  // 총 요금
    int paymentFare = 0; // 지불할 요금
    int accumulateFare = 0; // 누적 요금

    // 택시 생성자
    public Taxi(){
        this.state = state.일반;
        maxPassenger = 4;
        number += 1;
        this.number = number;
        startDriving();
    }


    public State state;

    public enum State{
        일반,
        운행중,
        운행불가
    }

    protected void startDriving() {
        System.out.println(number + "번 택시의 운행을 시작합니다.");
        System.out.println("주유량 = " + fuelVolume);
        System.out.println("상태 = " + state.일반);
    }

    @Override
    protected void endDriving() {
        System.out.println(number + "번 택시의 운행을 종료합니다.");
    }


    protected void passengerBoarding(int passenger, String dest, int dis ) {
        if(state != state.일반 ){
            return;
        }
        if(passenger+nowPassenger >= maxPassenger){
            System.out.println("최대 승객 수를 초과하였습니다!");
            return;
        }
        System.out.println("탑승 승객 수 = " + passenger);
        nowPassenger += passenger;
        System.out.println("잔여 승객 수 = " + (maxPassenger - nowPassenger) );
        System.out.println("기본 요금 확인 = " + basicFare);
        destination = dest;
        System.out.println("목적지 = " + destination);
        destinationDistance = dis;
        System.out.println("목적지까지 거리 = " + destinationDistance + "km");
        paymentFare(); // 지불할 요금
        System.out.println("상태 = " + state.운행중);

    }

    public  void passengerQuite(int passenger){
        if(passenger>nowPassenger){
            return;
        }
        nowPassenger -= passenger;
    }

    public void paymentFare(){
        if(destinationDistance > 1){
        paymentFare = basicFare + ((destinationDistance-1)*destinationFare);
            System.out.println("지불할 요금 = " + paymentFare);
        }
    }

    public void accumulateFare(){
        accumulateFare += paymentFare;
        System.out.println("누적 요금 = " + accumulateFare + "원");
    }

    public void useFuel(int fuel){
        if(fuel > fuelVolume){
            System.out.println("연료가 부족합니다.");
            return;
        }

        fuelVolume -= fuel;
        System.out.println("연료가 " + fuel + "만큼 소모되었습니다.");
        checkFuelVolume();
        accumulateFare();
        this.state = state.운행중;
    }

    public void gainFuel(int fuel){
        fuelVolume += fuel;
        System.out.println("상태 = " + state);
        System.out.println("연료가 " + fuel + "만큼 충전되었습니다." );
        checkFuelVolume();
        this.state = state.운행불가;
    }

    public void checkFuelVolume(){
        System.out.println("주유량 = " + fuelVolume);

        if(fuelVolume <10){
            System.out.println("주유가 필요합니다.");
            System.out.println("상태 = " + state.운행불가);
            this.state = state.운행불가;
        }
    }

    protected void stateChange(State state){
        this.state = state;
    }

    @Override
    protected void speedChange() {

    }


}
