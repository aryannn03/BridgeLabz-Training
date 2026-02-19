import java.time.*;
import java.util.*;

class PaymentDeclinedException extends Exception {
    public PaymentDeclinedException(String message) {
        super(message);
    }
}

interface DiscountStrategy {
    double applyDiscount(double amount);
}

class NoDiscount implements DiscountStrategy {
    public double applyDiscount(double amount) {
        return amount;
    }
}

class SeasonalDiscount implements DiscountStrategy {
    public double applyDiscount(double amount) {
        return amount * 0.8;
    }
}

class User {
    private String name;
    private LocalDate expiryDate;
    private boolean active;
    private DiscountStrategy discountStrategy;

    public User(String name, LocalDate expiryDate, boolean active, DiscountStrategy discountStrategy) {
        this.name = name;
        this.expiryDate = expiryDate;
        this.active = active;
        this.discountStrategy = discountStrategy;
    }

    public boolean isExpired() {
        return LocalDate.now().isAfter(expiryDate);
    }

    public boolean isActive() {
        return active;
    }

    public void renew(double amount) throws PaymentDeclinedException {
        if (!active) {
            throw new PaymentDeclinedException("Payment declined for " + name);
        }
        double finalAmount = discountStrategy.applyDiscount(amount);
        expiryDate = expiryDate.plusMonths(1);
        System.out.println(name + " renewed with payment " + finalAmount);
    }

    public String getName() {
        return name;
    }
}

public class DigitalSubscriptionRenewalSystem {
    public static void main(String[] args) {
        List<User> users = new ArrayList<>();

        users.add(new User("Amit", LocalDate.now().minusDays(1), true, new SeasonalDiscount()));
        users.add(new User("Riya", LocalDate.now().plusDays(5), true, new NoDiscount()));
        users.add(new User("Karan", LocalDate.now().minusDays(2), false, new NoDiscount()));

        double subscriptionAmount = 1000;

        for (User user : users) {
            if (user.isExpired()) {
                try {
                    user.renew(subscriptionAmount);
                } catch (PaymentDeclinedException e) {
                    System.out.println(e.getMessage());
                }
            }
        }

        users.stream()
                .filter(User::isExpired)
                .forEach(u -> System.out.println("Expired: " + u.getName()));
    }
}
