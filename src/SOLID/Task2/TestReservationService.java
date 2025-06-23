package SOLID.Task2;

public class TestReservationService {
    public static void main(String[] args) {
        ReservationService reservationService = new ReservationService();

        NotificationService notificationService = new NotificationService(new EmailNotificationService());

    }
}
