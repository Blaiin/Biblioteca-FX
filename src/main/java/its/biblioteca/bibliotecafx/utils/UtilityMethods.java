package its.biblioteca.bibliotecafx.utils;

import java.time.LocalDate;

public class UtilityMethods {
    public LocalDate toReturnDate(LocalDate start, Months month) {
        int numMonthsToAdd = month.getMonthNumber();
        return start.plusMonths(numMonthsToAdd);
    }
}
