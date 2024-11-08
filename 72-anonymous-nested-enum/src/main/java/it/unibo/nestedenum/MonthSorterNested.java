package it.unibo.nestedenum;

import java.util.Comparator;
// import java.util.Locale;
// import java.util.Objects;

/**
 * Implementation of {@link MonthSorter}.
 */
public final class MonthSorterNested implements MonthSorter {

    @Override
    public Comparator<String> sortByDays() {
        return new SortByDate();
    }

    @Override
    public Comparator<String> sortByOrder() {
        return new SortByMonthOrder();
    }

    public enum Month {
        JANUARY(31),
        FEBRUARY(28),
        MARCH(31),
        APRIL(30),
        MAY(31),
        JUNE(30),
        JULY(31),
        AUGUST(31),
        SEPTEMBER(30),
        OCTOBER(31),
        NOVEMBER(30),
        DECEMBER(31);

        private final int days;

        Month(int days) {
            this.days = days;
        }

        public static Month fromString(String input) {
            if (input == null) {
                throw new IllegalArgumentException("String is empty");
            }
            Month returnMonth = null;
            for (final Month candidate : Month.values()) {
                if (candidate.name().equalsIgnoreCase(input) || candidate.name().startsWith(input.toUpperCase())) {
                    if (returnMonth != null) {
                        throw new IllegalArgumentException("String is ambiguous");
                    }
                    returnMonth = candidate;
                }
            }
            if (returnMonth == null) {
                throw new IllegalArgumentException("String is not valid");
            }
            return returnMonth;
        }
    }

    private class SortByDate implements Comparator<String> {

        @Override
        public int compare(String arg0, String arg1) {
            return Integer.compare(Month.fromString(arg0).days, Month.fromString(arg1).days);
        }

    }

    private class SortByMonthOrder implements Comparator<String> {

        @Override
        public int compare(String arg0, String arg1) {
            return Month.fromString(arg0).compareTo(Month.fromString(arg1));
        }

    }
}
