package SOLID.Task3;

interface PlayMusic {
    void playMusic(String fileName);
}

interface PlayVideo {
    void playVideo(String videoFileName);
}

interface SendSMS {
    void sendSMS();
}

interface CallingService {
    void call();
}

class Ipod1 implements PlayMusic {

    @Override
    public void playMusic(String fileName) {
        System.out.println("Playing music " + fileName);
    }

}

class SmartPhone1 implements PlayMusic, PlayVideo, SendSMS, CallingService {

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

public class TestMobile {
}
