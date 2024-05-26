package банкОнлайн;
import java.io.*;
import java.util.*;

public class BankOnline {

    public void send(String cardNumber, Double money) throws BankOnlineException {
        if (cardNumber == null || money == null) {
            throw new IllegalArgumentException("Card number or money cannot be null");
        }

        if (!isValidCardNumber(cardNumber)) {
            throw new InvalidCardNumberException("Invalid card number");
        }

        if (isBlockedCard(cardNumber)) {
            throw new BlockedCardException("Card is blocked");
        }

        if (money < 0) {
            throw new NegativeAmountException("Amount cannot be negative");
        }

        if (money > 50000) {
            throw new ExceedsLimitException("Amount exceeds limit of 50,000");
        }

        // Code to perform the transaction would go here.
    }

    private boolean isValidCardNumber(String cardNumber) {
        if (cardNumber.length() != 16 || !cardNumber.matches("\\d+")) {
            return false;
        }
        return luhnCheck(cardNumber);
    }

    private boolean luhnCheck(String cardNumber) {
        int nDigits = cardNumber.length();
        int sum = 0;
        boolean isSecond = false;

        for (int i = nDigits - 1; i >= 0; i--) {
            int d = cardNumber.charAt(i) - '0';

            if (isSecond) {
                d = d * 2;
            }

            sum += d / 10;
            sum += d % 10;

            isSecond = !isSecond;
        }
        return (sum % 10 == 0);
    }

    private boolean isBlockedCard(String cardNumber) throws BankOnlineException {
        Set<String> blockedCards = getBlockedCards();
        return blockedCards.contains(cardNumber);
    }

    private Set<String> getBlockedCards() throws BankOnlineException {
        Set<String> blockedCards = new HashSet<>();
        try (BufferedReader reader = new BufferedReader(new FileReader("blocked_cards.txt"))) {
            String line;
            while ((line = reader.readLine()) != null) {
                blockedCards.add(line.replaceAll("\\s", ""));
            }
        } catch (IOException e) {
            throw new BankOnlineException("Error reading blocked cards file", e);
        }
        return blockedCards;
    }

    public static void main(String[] args) {
        // Testing the implementation
        BankOnline bankOnline = new BankOnline();
        try {
            bankOnline.send("1234567890123456", 1000.0);
        } catch (BankOnlineException e) {
            e.printStackTrace();
        }
    }
}

// Custom exception classes
class BankOnlineException extends Exception {
    public BankOnlineException(String message) {
        super(message);
    }

    public BankOnlineException(String message, Throwable cause) {
        super(message, cause);
    }
}

class InvalidCardNumberException extends BankOnlineException {
    public InvalidCardNumberException(String message) {
        super(message);
    }
}

class BlockedCardException extends BankOnlineException {
    public BlockedCardException(String message) {
        super(message);
    }
}

class NegativeAmountException extends BankOnlineException {
    public NegativeAmountException(String message) {
        super(message);
    }
}

class ExceedsLimitException extends BankOnlineException {
    public ExceedsLimitException(String message) {
        super(message);
    }
}
