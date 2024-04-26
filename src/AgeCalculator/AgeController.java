package AgeCalculator;
import java.time.LocalDate;

public class AgeController {
    public boolean validDate(int day, int month, int year) {
        LocalDate currentdate = LocalDate.now();
        int currentYear = currentdate.getYear();
        int currentMonth = currentdate.getMonthValue();
        int currentDay = currentdate.getDayOfMonth();
        if(currentYear<year) return false;
        if(currentYear==year) {
            if(currentMonth<month) return false;
            if(currentMonth==month){
                if(currentDay<day) return false;
            }
        }
        int[] nonLeapYear = { 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 };
        int[] leapYear = { 31, 29, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 };
        if (month > 12)
            return false;
        if (isLeapYear(year) && day <= leapYear[month - 1])
            return true;
        else if (!isLeapYear(year) && day <= nonLeapYear[month - 1])
            return true;
        else
            return false;
    }

    public boolean isLeapYear(int year) {
        if (year % 4 == 0 && year % 100 != 0)
            return true;
        if (year % 400 == 0)
            return true; // that mean it automatically divide 100 we dont have to check
        // if number divide 100 then check for 400
        return false;
    }

    public boolean validBothDates(UserData user) {
        if (user.getCurrentYear() > user.getBirthYear()) {
            return true;
        } else if (user.getCurrentYear() == user.getBirthYear()) {
            if (user.getCurrentMonth() > user.getBirthMOnth())
                return true;
            if (user.getCurrentMonth() == user.getBirthMOnth() && user.getCurrentDay() >= user.getBirthDay())
                return true;
        }
        return false;
    }   
    public int MyAge(int day, int month, int year) {
        LocalDate currentdate = LocalDate.now();
        int currentYear = currentdate.getYear();
        int currentMonth = currentdate.getMonthValue();
        int yearR = currentYear - year;
        int monthR = currentMonth - month;
        if (monthR < 0) yearR--;
        return yearR;
    }
}
