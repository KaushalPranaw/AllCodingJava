package SOLID.Task4;

/*public interface UPIPayments {

    void payMoney();

    void getScratchCard();

    void getCashBackAsCreditBalance();
}*/

interface PayMoneyService {
    void payMoney();
}

interface ScratchCardService {
    void getScratchCard();
}

interface CashBack {
    void getCashBackAsCreditBalance();
}

class GooglePay implements PayMoneyService, ScratchCardService, CashBack {

    @Override
    public void payMoney() {

    }

    @Override
    public void getScratchCard() {

    }

    @Override
    public void getCashBackAsCreditBalance() {

    }
}

class ABCUPIApp implements ScratchCardService, PayMoneyService {

    @Override
    public void payMoney() {

    }

    @Override
    public void getScratchCard() {

    }
}


public class UPIPayments {
    public static void main(String[] args) {
        GooglePay googlePay = new GooglePay();
        googlePay.payMoney();
        googlePay.getScratchCard();
        googlePay.getCashBackAsCreditBalance();

        // Using ABC UPI App
        ABCUPIApp abcUpiApp = new ABCUPIApp();
        abcUpiApp.payMoney();
        abcUpiApp.getScratchCard();
    }
}
