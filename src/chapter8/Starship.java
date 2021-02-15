package chapter8;

class AlertStatus {
    public void showInfo(){
        System.out.println("Info");
    }
}

class BadAlertStatus extends AlertStatus{
    @Override
    public void showInfo() {
        System.out.println("Все плохо");
    }
}

class GoodAlertStatus extends AlertStatus {
    @Override
    public void showInfo() {
        System.out.println("Все хорошо");
    }
}

public class Starship {
    private AlertStatus alertStatus = new AlertStatus();
    public void changeStatus(int i){
        switch (i){
            case 0: alertStatus = new BadAlertStatus();
            break;
            case 1: alertStatus = new GoodAlertStatus();
            break;
            default: break;
        }
    }
    public void showStatus(){
        alertStatus.showInfo();
    }

    public static void main(String[] args) {
        Starship starship = new Starship();
        starship.showStatus();
        starship.changeStatus(1);
        starship.showStatus();
        starship.changeStatus(0);
        starship.showStatus();
    }
}
