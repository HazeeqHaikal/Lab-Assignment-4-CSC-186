import java.util.Scanner;

public class Main {
        public static void main(String[] args) {
                Scanner input = new Scanner(System.in);
                int count = 0;
                int choice = 0;
                String bookingCode;
                String customerName;
                String phoneNo;
                char promotionType;
                int day;
                double deposit;
                String block;
                String level;
                String no;
                System.out.println("Welcome to Hotel Reservation System");
                System.out.print("\nEnter the amount of array: ");
                int size = input.nextInt();
                // Creating an array of objects of type HotelPromotion
                HotelPromotion[] promo = new HotelPromotion[size];
                input.nextLine();
                System.out.println();
                for (int i = 0; i < size; i++) {
                        System.out.print("Enter booking code: ");
                        bookingCode = input.nextLine();
                        System.out.print("Enter customer name: ");
                        customerName = input.nextLine();
                        System.out.print("Enter phone number: ");
                        phoneNo = input.nextLine();
                        System.out.print(
                                        "L - Luxury (RM 4,000.00 / Day)\nB - Budget (RM 1,500.00 / Day)\nS - SweetEscape (RM 3,300.00 / Day)\n\nEnter the type of promotion: ");
                        promotionType = input.next().charAt(0);
                        promotionType = Character.toUpperCase(promotionType);
                        input.nextLine();
                        System.out.print("Enter the amount of day: ");
                        day = input.nextInt();
                        input.nextLine();
                        System.out.print("Enter the block (e.g. A): ");
                        block = input.nextLine();
                        System.out.print("Enter the level: ");
                        level = input.nextLine();
                        System.out.print("Enter the room code (e.g. " + level + "01): ");
                        no = input.nextLine();
                        System.out.print("Enter the deposit (RM): ");
                        deposit = input.nextDouble();
                        input.nextLine();
                        // Creating an object of type HotelPromotion using constructor
                        promo[i] = new HotelPromotion(bookingCode, customerName, phoneNo,
                                        promotionType, day, deposit, block, level,
                                        no);
                        System.out.println();
                }
                while (choice != 3) {
                        System.out.println(
                                        "1. Count and display the booking code of customers who already paid for booking.");
                        System.out.println("2. Find the customer check-in based on booking code entered by the user.");
                        System.out.println("3. Exit");
                        System.out.print("\nEnter your choice: ");
                        choice = input.nextInt();
                        input.nextLine();
                        System.out.println();
                        switch (choice) {
                                case 1:
                                        for (int i = 0; i < promo.length; i++) {
                                                if (promo[i].getDeposit() > 0) {
                                                        count++;
                                                }
                                        }
                                        System.out.println("The number of customers who already paid for booking: "
                                                        + count);
                                        break;
                                case 2:
                                        boolean found = false;
                                        double originalPrice = 0;
                                        System.out.print("Enter the booking code (e.g. " +
                                                        promo[0].getBookingCode() + "): ");
                                        bookingCode = input.nextLine();
                                        System.out.println();
                                        for (int i = 0; i < promo.length; i++) {
                                                if (promo[i].getBookingCode().equals(bookingCode)) {
                                                        // Using getters to access the object's attributes
                                                        System.out.println("Customer name: " +
                                                                        promo[i].getCustomerName());
                                                        System.out.println("Phone number: " +
                                                                        promo[i].getPhoneNo());
                                                        System.out.println("Promotion type: " +
                                                                        promo[i].getpromotionType());
                                                        System.out.println("Day: " + promo[i].getDay());
                                                        // Using composition to access the Room object inside
                                                        // HotelPromotion object
                                                        System.out.println("Room block: " +
                                                                        promo[i].getRoomReserve().getBlock());
                                                        System.out.println("Room level: " +
                                                                        promo[i].getRoomReserve().getLevel());
                                                        System.out.println("Room number: " +
                                                                        promo[i].getRoomReserve().getNo());
                                                        switch (promo[i].getpromotionType()) {
                                                                case 'L':
                                                                        originalPrice = 4000.00 *
                                                                                        promo[i].getDay();
                                                                        break;
                                                                case 'B':
                                                                        originalPrice = 1500.00 *
                                                                                        promo[i].getDay();
                                                                        break;
                                                                case 'S':
                                                                        originalPrice = 3300.00 *
                                                                                        promo[i].getDay();
                                                                        break;
                                                        }
                                                        // Using methods to perform calculations
                                                        System.out.printf("Original price: RM %,.2f\n",
                                                                        originalPrice);
                                                        System.out.printf("Discount deducted : RM %,.2f\n",
                                                                        promo[i].calculatePromotion());
                                                        System.out.printf("Total price after discount: RM %,.2f\n",
                                                                        originalPrice -
                                                                                        promo[i].calculatePromotion());
                                                        System.out.printf("Deposit: RM %,.2f\n",
                                                                        promo[i].getDeposit());
                                                        System.out.printf("Balance left to be paid: RM %,.2f\n",
                                                                        originalPrice - promo[i].getDeposit() -
                                                                                        promo[i].calculatePromotion());
                                                        found = true;
                                                }
                                        }
                                        if (!found) {
                                                System.out.println("Booking code not found.");
                                        }
                                        break;
                                case 3:
                                        System.out.println("Thank you for using Hotel Reservation System");
                                        break;
                                default:
                                        System.out.println("Invalid choice.");
                                        break;
                        }
                        System.out.println();
                }
                input.close();
        }
}