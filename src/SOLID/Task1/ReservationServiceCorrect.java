package SOLID.Task1;

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
        return 576;
    }
}

class NotificationService {
    public void sendOTP(String medium) {
        if (medium.equals("email")) {
            // write email related logic
        } else if (medium.equals("phone")) {

        }
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

    public void sendOTP(String medium) {
        this.notificationService.sendOTP(medium);
    }
}
