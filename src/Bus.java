class Bus extends PublicTransport{
    int totalFare = 0; // 총 요금
    int fare = 1000;  // 요금

    // 버스 생성자
    public Bus(){
        this.state = state.운행;
        maxPassenger = 30;
        number += 1;
        this.number = number;
        startDriving();
    }

    public State state;  // 여기부터 어떤 메소드인지?....

    public enum State{
        운행,
        차고지행
    }


    // 위의 메소드의 연장선으로 질문...
    public void startDriving(){
        System.out.println(number + "번 버스의 운행을 시작합니다.");
    }

    public void endDriving(){
        System.out.println(number + "번 버스의 운행을 종료합니다.");;
    }



    protected void passengerBoarding(int passenger) {
        if(state != state.운행){
            return;
        }
        if(nowPassenger + passenger >= maxPassenger){
            System.out.println("최대 승객 수를 초과하였습니다!");
            return;
        }
        System.out.println("탑승 승객 수 = " + passenger);
        nowPassenger += passenger;
        System.out.println("잔여 승객 수 = " + (maxPassenger - nowPassenger) );
        System.out.println("요금 확인 = " + (passenger * fare));
    }

    public  void passengerQuite(int passenger){
        if(passenger>nowPassenger){
            return;
        }
        nowPassenger -= passenger;
    }

    public void useFuel(int fuel){
        if(fuel > fuelVolume){
            System.out.println("연료가 부족합니다.");
            return;
        }

        fuelVolume -= fuel;
        System.out.println("연료가 " + fuel + "만큼 소모되었습니다.");
        checkFuelVolume();
        this.state = state.운행;
    }

    public void gainFuel(int fuel){
        fuelVolume += fuel;
        System.out.println("상태 = " + state);
        System.out.println("연료가 " + fuel + "만큼 충전되었습니다." );
        checkFuelVolume();
        this.state = state.차고지행;
    }

    public void checkFuelVolume(){
        System.out.println("주유량 = " + fuelVolume);

        if(fuelVolume <10){
            System.out.println("주유가 필요합니다.");
            System.out.println("상태 = " + state.차고지행);
            this.state = state.차고지행;
        }
    }

    // 위의 메소드의 연장선으로 질문2...
    protected void stateChange(State state){
        this.state = state;
    }

    @Override
    protected void speedChange() {

    }

}
