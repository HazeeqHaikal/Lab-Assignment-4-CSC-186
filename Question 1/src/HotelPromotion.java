public class HotelPromotion {
    // Declaring private instance variables
    private String bookingCode;
    private String customerName;
    private String phoneNo;
    private char promotionType;
    private int day;
    // Declaring a private object of type Room using composition
    private Room roomReserve;
    private double deposit;

    // Defining a constructor with parameters
    public HotelPromotion(String bookingCode, String customerName, String phoneNo, char promotionType, int day,
            double deposit, String block, String level, String no) {
        this.bookingCode = bookingCode;
        this.customerName = customerName;
        this.phoneNo = phoneNo;
        this.promotionType = promotionType;
        this.day = day;
        // Creating a new object of type Room using new keyword
        this.roomReserve = new Room(block, level, no);
        this.deposit = deposit;
    }

    // Defining a setter method to update the object's state
    public void setHotelPromotion(String bookingCode, String customerName,
            String phoneNo, char promotionType, int day,
            double deposit) {
        this.bookingCode = bookingCode;
        this.customerName = customerName;
        this.phoneNo = phoneNo;
        this.promotionType = promotionType;
        this.day = day;
        this.deposit = deposit;
    }

    // Defining getter methods to access the object's state
    public String getCustomerName() {
        return customerName;
    }

    public String getPhoneNo() {
        return phoneNo;
    }

    public char getpromotionType() {
        return promotionType;
    }

    public int getDay() {
        return day;
    }

    // Defining a getter method to access the Room object
    public Room getRoomReserve() {
        return roomReserve;
    }

    public double getDeposit() {
        return deposit;
    }

    public String getBookingCode() {
        return bookingCode;
    }

    // Defining a method to calculate the promotion based on the promotion type
    public double calculatePromotion() {
        char promoType = getpromotionType();
        promoType = Character.toUpperCase(promoType);
        double promotion = 0;
        double price = 0;
        switch (promoType) {
            case 'L':
                price = 4000.00;
                promotion = price * 0.25 * getDay();
                break;
            case 'B':
                price = 1500.00;
                promotion = price * 0.20 * getDay();
                break;
            case 'S':
                price = 3300.00;
                promotion = price * 0.15 * getDay();
                break;
        }
        return promotion;
    }

    // Defining a method to compare two objects based on their block attribute
    public boolean isSameBlock(HotelPromotion hotelPromotion) {
        String block1 = getRoomReserve().getBlock();
        String block2 = hotelPromotion.getRoomReserve().getBlock();
        if (block1.equals(block2)) {
            return true;
        } else {
            return false;
        }
    }

    // Overriding the toString method to return a string representation of the
    // object
    @Override
    public String toString() {
        return "Booking Code: " + bookingCode + "\nCustomer Name: " +
                customerName + "\nNumber Phone: " + phoneNo
                + "\nPromotion Type: " + promotionType + "\nAmount of day: " +
                day + "\nRoom Reserve: " + roomReserve
                + "\nDeposit: RM " + deposit;
    }

    public boolean equals(HotelPromotion hotelPromotion) {
        if (bookingCode.equals(hotelPromotion.bookingCode) &&
                customerName.equals(hotelPromotion.customerName)
                && phoneNo.equals(hotelPromotion.phoneNo) && promotionType == hotelPromotion.promotionType
                && day == hotelPromotion.day &&
                roomReserve.equals(hotelPromotion.roomReserve)
                && deposit == hotelPromotion.deposit) {
            return true;
        } else {
            return false;
        }
    }
}