package ua.aptasinskij.customerrental;

/**
 * Created by andrew on 02.01.17.
 */
public class Rental {

    private int kind;
    private int days;

    public Rental(int kind, int days) {
        this.kind = kind;
        this.days = days;
    }

    /*
    * Метод повинен знаходитись в даному класі, так як він використовує дані цього класу
    * і зовсім не використовує дані класу Customer. Переміщення методу означає що параметр rental не потрібний.
    * Також метод варто переіменувати. В даному випадку конструкцію if варто замінити на switch.
    * Останній if можна замінити тернарним оператором. Значення kind варто винести в окремий клас
    * та оформити його в якості констант класу.
    * Так як даний метод використовується для обрахунків в класі Customer,
    * варто змінити модифікатор доступу на protected. */
    protected double getAmount() {
        double result = days * getBasePrice();
        switch (kind){
            case 1:
                result *= 1.5;
                break;
            case 2:
                result *= 2;
                break;
            case 3:
                result *= 2.5;
                break;
        }
        return getDays() > 7 ? result * 3 : result;
    }

    public int getKind() {
        return kind;
    }

    public void setKind(int kind) {
        this.kind = kind;
    }

    public int getDays() {
        return days;
    }

    public void setDays(int days) {
        this.days = days;
    }

    public double getBasePrice(){
        return 0;
    }

}
