import java.util.Scanner;

public class StartMenu {

    Scanner scanner = new Scanner(System.in);

    public void startMenu() {
        Hotel hotel = new Hotel();
        HotelServices hotelServices = new HotelServices(hotel.getRooms(), hotel.getServices());

        boolean loopMenu = true;
        while (loopMenu) {
            System.out.println();
            System.out.println("Booking system 3000");
            System.out.println("1: Book an available room");
            System.out.println("2: Check-out a booked room");
            System.out.println("3: List all rooms");
            System.out.println("4: Add/Remove roomservices to a room");
            System.out.println("5: Get total revenue from currently booked rooms");
            System.out.println("6: Exit");

            int menu = scanner.nextInt();
            switch (menu) {
                case 1 -> {
                    System.out.println("1.Booking room");
                    hotelServices.bookingRooms();
                }
                case 2 -> {
                    System.out.println("2.Checkout room");
                    hotelServices.checkOutRooms();
                }
                case 3 -> {
                    System.out.println("3.Listing rooms");
                    hotelServices.listingRooms();

                }
                case 4 -> {
                    System.out.println("4.Adding roomservices");
                    hotelServices.serviceARoom();
                }
                case 5 -> {
                    System.out.println("5.Total revenue");
                    hotelServices.countRevenue();
                }
                case 6 -> {
                    System.out.println("Exit system");
                    loopMenu = false;
                }
                default -> System.out.println("Try again from menu: 1-6");
            }
        }
    }
}
