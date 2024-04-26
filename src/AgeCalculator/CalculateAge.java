package AgeCalculator;
import java.util.*;
import java.time.LocalDate;

// 25-05-2002 13-02-2024
// 2024-2002 = 22
// 05<02 = then decrease year 21 and 12-3 = 9 month
// 13 days remaining and 6 days from birth month then 13+6 = 19
// 31-25 = 6
// +13 = 19

public class CalculateAge {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int birthDay, birthMonth, birthYear;
        int currentDay, currentMonth, currentYear;
        UserData user = new UserData();
        AgeController ageController = new AgeController();

        System.out.print("Enter birth day,month and year respectively: ");
        birthDay = sc.nextInt();
        birthMonth = sc.nextInt();
        birthYear = sc.nextInt();
        if (!ageController.validDate(birthDay, birthMonth, birthYear)) {
            System.out.println("You entered birth wrong date");
            sc.close();
            return;
        }
        System.out.print("\nEnter Current day,month and year respectively: ");
        currentDay = sc.nextInt();
        currentMonth = sc.nextInt();
        currentYear = sc.nextInt();
        if (!ageController.validDate(currentDay, currentMonth, currentYear)) {
            System.out.println("You entered current wrong date");
            sc.close();
            return;
        }
        user.setBirthDate(birthDay, birthMonth, birthYear);
        user.setCurrentDate(currentDay, currentMonth, currentYear);

        boolean checkBothDate = ageController.validBothDates(user);

        if (checkBothDate) {
            user.MyAge();
        } else {
            System.out.println("You entered current wrong date");
        }
        sc.close();
        return;
    }
}