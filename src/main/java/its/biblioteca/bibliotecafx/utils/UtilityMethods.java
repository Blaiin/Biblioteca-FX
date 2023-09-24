package its.biblioteca.bibliotecafx.utils;

import java.time.LocalDate;

public class UtilityMethods {
    public static boolean isPhoneNumber(String phoneNumber) {
        return phoneNumber != null && phoneNumber.matches("\\d{10}");
    }

    public LocalDate toReturnDate(LocalDate start, Months month) {
        int numMonthsToAdd = month.getMonthNumber();
        return start.plusMonths(numMonthsToAdd);
    }
    public static boolean isValidEmail(String toCheckEmail) {
        return (toCheckEmail.contains("@") && 
                ((toCheckEmail.contains(".it") || toCheckEmail.contains(".com") || toCheckEmail.contains(".org"))));
    }
}
