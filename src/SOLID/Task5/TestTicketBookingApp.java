package SOLID.Task5;

/*public class TicketBookingApp {

    private DebitCard debitCard;

    public TicketBookingApp(DebitCard debitCard) {
        this.debitCard = debitCard;
    }

    public void doPayment(int noOfTickets, int amount) {
        debitCard.doTransaction(amount);
    }

    public static void main(String[] args) {
        DebitCard debitCard = new DebitCard();
        TicketBookingApp ticketApp = new TicketBookingApp(debitCard);
        ticketApp.doPayment(4,5000);
    }
}

public class DebitCard {
    public void doTransaction(int amount) {
        System.out.println("tx done with DebitCard");
    }
}
public class CreditCard {
    public void doTransaction(int amount) {
        System.out.println("tx done with CreditCard");
    }
}*/

interface PaymentService {
    public void doTransaction(int amount);
}

class DebitCard implements PaymentService {
    @Override
    public void doTransaction(int amount) {
        System.out.println("tx done with DebitCard");
    }
}

class CreditCard implements PaymentService {
    @Override
    public void doTransaction(int amount) {
        System.out.println("tx done with CreditCard");
    }
}

class TicketBookingApp {

    private PaymentService paymentService;

    public TicketBookingApp(PaymentService paymentService) {
        this.paymentService = paymentService;
    }

    public void doPayment(int noOfTickets, int amount) {
        paymentService.doTransaction(amount);
    }

    public static void main(String[] args) {
        /*DebitCard debitCard = new DebitCard();
        TicketBookingApp ticketApp = new TicketBookingApp(debitCard);
        ticketApp.doPayment(4,5000);*/

        // Payment via DebitCard
        PaymentService debitCard = new DebitCard();
        TicketBookingApp ticketAppWithDebit = new TicketBookingApp(debitCard);
        ticketAppWithDebit.doPayment(4, 5000);

        // Payment via CreditCard
        PaymentService creditCard = new CreditCard();
        TicketBookingApp ticketAppWithCredit = new TicketBookingApp(creditCard);
        ticketAppWithCredit.doPayment(2, 3000);
    }
}


public class TestTicketBookingApp {
}
