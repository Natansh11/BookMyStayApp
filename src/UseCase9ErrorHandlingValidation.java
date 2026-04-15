class InvalidBookingException extends Exception {
    public InvalidBookingException(String msg) {
        super(msg);
    }
}

class ReservationValidator {
    public void validate(String name, String roomType) throws InvalidBookingException {
        if (name == null || name.isEmpty()) {
            throw new InvalidBookingException("Invalid Name");
        }
        if (!(roomType.equals("Standard") || roomType.equals("Deluxe"))) {
            throw new InvalidBookingException("Invalid Room Type");
        }
    }
}

public class UseCase9ErrorHandlingValidation {
    public static void main(String[] args) {
        ReservationValidator validator = new ReservationValidator();

        try {
            validator.validate("Natansh", "VIP");
        } catch (InvalidBookingException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}