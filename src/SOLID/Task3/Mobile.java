package SOLID.Task3;

public abstract class Mobile {

    public abstract void sendSMS();

    public abstract void call();

    public abstract void playMusic(String fileName);

    public abstract void playVideo(String videoFileName);
}

class Ipod extends Mobile {

    @Override
    public void sendSMS() {
        // not applicable
    }

    @Override
    public void call() {
        // nota applicable

    }

    @Override
    public void playMusic(String fileName) {
        System.out.println("Playing music " + fileName);

    }

    @Override
    public void playVideo(String videoFileName) {
        // not applicable
    }

}

class SmartPhone extends Mobile {

    @Override
    public void sendSMS() {
        System.out.println("sending sms..");

    }

    @Override
    public void call() {
        System.out.println("calling");

    }

    @Override
    public void playMusic(String fileName) {
        System.out.println("Playing music " + fileName);

    }

    @Override
    public void playVideo(String videoFileName) {
        System.out.println("Playing video " + videoFileName);

    }

}


