abstract class PublicTransport {
    static int number = 0; // 번호(각각의 번호에 대해 값이 출력될 수 있게 static을 사용)
    int fuelVolume = 100; // 주유량
    int speed = 0; // 속도
    int speedChange; // 속도 변경
    int maxPassenger; // 최대 승객 수
    int nowPassenger; // 현재 승객 수

    /* 초기화 할 수 있는 생성자

    public PublicTransport(int number, int fuelVolume, int speed, int maxNumberOfPassengers, int nowNumberOfPassengers) {
        this.number = number;
        this.fuelVolume = fuelVolume;
        this.speed = speed;
        this.speedChange = speedChange;
        this.maxNumberOfPassengers = this.maxNumberOfPassengers;
        this.nowNumberOfPassengers = this.nowNumberOfPassengers;
    }


    // 초기값을 제외한 생성자
    public PublicTransport(int number, int speedChange, int maxNumberOfPassengers, int nowNumberOfPassengers) {
        this(number, 100, 0, maxNumberOfPassengers, nowNumberOfPassengers);
    }
    */

    // 운행 시작
    abstract protected void startDriving();

    // 운행 마침
    abstract protected void endDriving();

    // 속도 변경
    abstract protected void speedChange();

    // 상태 변경
    protected void stateChange() {

    }
}
