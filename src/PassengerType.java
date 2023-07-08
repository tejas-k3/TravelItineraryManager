package src;
// Passenger Type enum
public enum PassengerType {
    STANDARD {
        @Override
        public boolean isBalanceExceeded(int balance, int price) {
            return balance - price < 0;
        }
    },
    GOLD {
        @Override
        public boolean isBalanceExceeded(int balance, int price) {
            double discountedPrice = price*0.9;
            int priceToPay = (int)discountedPrice;
            return balance - priceToPay < 0;
        }
    },
    PREMIUM {
        @Override
        public boolean isBalanceExceeded(int balance, int price) {
            // NO PRICE INVOLVED!
            return false;
        }
    };

    public abstract boolean isBalanceExceeded(int balance, int price);
}