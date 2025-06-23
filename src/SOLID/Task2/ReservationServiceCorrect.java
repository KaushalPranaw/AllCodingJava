package SOLID.Task2;

class BusService {
    public String search(String source, String destination) {
        // do searchBuses
        return "Buses Found";
    }
}

class TicketService {
    public String bookTicket(int numberOfSeats) {
        // booking the ticket
        return "Ticket Booked";
    }

    public void printTickect() {        // printing the Ticket
    }
}

class TravelInsuranceService {
    public int getTravelInsuranceInfo(int ticketId) {
        // getting the Travel Insurance info
        return 6578;
    }
}

interface NotificationSender {
    void sendOTP(String message);
}

class EmailNotificationService implements NotificationSender {
    @Override
    public void sendOTP(String message) {
        System.out.println("Sending via email:" + message);
    }
}

class PhoneNotificationService implements NotificationSender {
    @Override
    public void sendOTP(String message) {
        System.out.println("Sending via phone: " + message);
    }
}

class NotificationService {
    private NotificationSender notificationSender;

    public NotificationService(NotificationSender notificationSender) {
        this.notificationSender = notificationSender;
    }

    public void sendOTP(String message) {
        notificationSender.sendOTP(message);
    }
}

public class ReservationServiceCorrect {
    private final BusService busService;
    private final TicketService ticketService;
    private final TravelInsuranceService travelInsuranceService;
    private final NotificationService notificationService;

    public ReservationServiceCorrect(
            BusService busService,
            TicketService ticketService,
            TravelInsuranceService travelInsuranceService,
            NotificationService notificationService) {
        this.busService = busService;
        this.ticketService = ticketService;
        this.travelInsuranceService = travelInsuranceService;
        this.notificationService = notificationService;
    }

    public String search(String source, String destination) {
        return this.busService.search(source, destination);
    }

    public String bookTicket(int numberOfSeats) {
        return this.ticketService.bookTicket(numberOfSeats);
    }

    public void printTickect() {        // printing the Ticket
        this.ticketService.printTickect();
    }

    public int getTravelInsuranceInfo(int ticketId) {
        // getting the Travel Insurance info
        return this.travelInsuranceService.getTravelInsuranceInfo(ticketId);
    }

    public void sendOTP(String message) {
        this.notificationService.sendOTP(message);
    }
}
