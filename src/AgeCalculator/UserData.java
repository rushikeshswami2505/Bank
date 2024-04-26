package AgeCalculator;
public class UserData {
    private int birthDay, birthMOnth, birthYear;
    private int currentDay, currentMonth, currentYear;

    private int[] nonLeapYear = { 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 };
    private int[] leapYear = { 31, 29, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 };

    // setter
    public void setCureentDay(int cureentDay) {
        this.currentDay = cureentDay;
    }

    public void setCurrentMonth(int currentMonth) {
        this.currentMonth = currentMonth;
    }

    public void setCurrentYear(int currentYear) {
        this.currentYear = currentYear;
    }

    public void setBirthDay(int birthDay) {
        this.birthDay = birthDay;
    }

    public void setBirthMOnth(int birthMOnth) {
        this.birthMOnth = birthMOnth;
    }

    public void setBirthYear(int birthYear) {
        this.birthYear = birthYear;
    }

    public int getBirthDay() {
        return birthDay;
    }

    public int getBirthMOnth() {
        return birthMOnth;
    }

    public int getBirthYear() {
        return birthYear;
    }

    public int getCurrentDay() {
        return currentDay;
    }

    public int getCurrentMonth() {
        return currentMonth;
    }

    public int getCurrentYear() {
        return currentYear;
    }

    public void setBirthDate(int birthDay, int birthMOnth, int birthYear) {
        this.birthDay = birthDay;
        this.birthMOnth = birthMOnth;
        this.birthYear = birthYear;
    }

    public void setCurrentDate(int currentDay, int currentMonth, int currentYear) {
        this.currentDay = currentDay;
        this.currentMonth = currentMonth;
        this.currentYear = currentYear;
    }

    public void MyAge() {
        int year = currentYear - birthYear;
        int month = currentMonth - birthMOnth;
        int day = currentDay - birthDay;
        boolean isLeap = isLeapYear(birthYear);
        int temp;

        if (month < 0) {
            year--;
            month = 12 - Math.abs(month);

        }
        if (day < 0) {
            month--;
            if (isLeap)
                temp = leapYear[birthMOnth - 1] - birthDay;
            else
                temp = nonLeapYear[birthMOnth - 1] - birthDay;

            day = temp + currentDay;
        }
        if (currentDay == birthDay && currentMonth == birthMOnth)
            System.out.println("\t\t\t!!!!!!!!!!HAPPY BIRTHDAY TO YOU DEAR USER!!!!!!!!!");
        if (isLeap)
            System.out.print("\nYou born in LEAP year ---> ");
        else
            System.out.print("\nYou born in NON LEAP year ---> ");
        System.out.println(day + " Day " + month + " Month " + year + " Year !!!\n");
    }

    private boolean isLeapYear(int year) {
        if (year % 4 == 0 && year % 100 != 0)
            return true;
        if (year % 400 == 0)
            return true; // that mean it automatically divide 100 we dont have to check
        // if number divide 100 then check for 400
        return false;
    }
}