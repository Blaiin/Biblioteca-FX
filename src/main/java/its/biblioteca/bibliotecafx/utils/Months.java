package its.biblioteca.bibliotecafx.utils;

public enum Months {
        ONE("1 month"),
        TWO("2 months"),
        THREE("3 months"),
        FOUR("4 months"),
        FIVE("5 months"),
        SIX("6 months"),
        SEVEN("7 months"),
        EIGHT("8 months"),
        NINE("9 months"),
        TEN("10 months"),
        ELEVEN("11 months"),
        TWELVE("12 months");

    private final String display;
    Months(String display){
        this.display = display;
    }


    public String getDisplay() {
        return display;
    }
     public int getMonthNumber() {
         return switch (this) {
             case ONE -> 1;
             case TWO -> 2;
             case THREE -> 3;
             case FOUR -> 4;
             case FIVE -> 5;
             case SIX -> 6;
             case SEVEN -> 7;
             case EIGHT -> 8;
             case NINE -> 9;
             case TEN -> 10;
             case ELEVEN -> 11;
             case TWELVE -> 12;
         };
     }



}
