import java.util.List;
import java.util.Scanner;

public class HotelServices {

    Scanner scanner = new Scanner(System.in);

    private List<Room> roomsList;
    private List<RoomService> serviceList;


    private int serviceSumRoom;
    private int serviceSumTotal;


    public HotelServices(List<Room> roomsList, List<RoomService> serviceList) {
        this.roomsList = roomsList;
        this.serviceList = serviceList;

    }

    // Bokar rummen
    public void bookingRooms() {
        int choice;
        System.out.println("Available rooms");
        availableRooms();
        System.out.print("Book room number: ");
        choice = scanner.nextInt();
        for (Room room : roomsList) {
            if (room.getId() == choice) {
                System.out.println("Booking room " + room.getId() + ": " + room.getName());
                room.setAvailable(false);
            }
        }
    }

    // Checkar ut rummen
    public void checkOutRooms() {
        int choice;
        System.out.println("Booked rooms");
        bookedRooms();
        System.out.print("Checkout room number: ");
        choice = scanner.nextInt();
        for (Room room : roomsList) {
            if (room.getId() == choice) {
                System.out.println("Checking out room " + room.getId() + ": " + room.getName());
                room.setAvailable(true);
                room.clearRoomservices();
            }
        }
    }

    // Printar lediga och bokade rum
    public void listingRooms() {
        System.out.println("Available rooms");
        availableRooms();
        System.out.println();
        System.out.println("Booked rooms");
        bookedRooms();
    }

    // Printar lediga rum
    public void availableRooms() {
        for (Room room : roomsList) {
            if (room.isAvailable()) {
                System.out.println(room.getId() + ": " + room.getName());
            }
        }
    }

    // Printar bokade rum
    public void bookedRooms() {
        for (Room room : roomsList) {
            if (!room.isAvailable()) {
                System.out.println(room.getId() + ": " + room.getName());
            }
        }

    }

    // Val av rum för att ge service till
    public void serviceARoom() {
        int choice;
        System.out.println("Choose a booked room to handle roomservice:");
        bookedRooms();
        choice = scanner.nextInt();

        for (Room room : roomsList) {
            if (room.getId() == choice && !room.isAvailable()) {
                serviceMenu(room);
            }
        }
    }


    // Navigerar service meny för valt rum
    public void serviceMenu(Room oneRoom) {
        boolean bool = true;
        while (bool) {
            System.out.println();
            System.out.println("You have chosen " + oneRoom.getName());
            System.out.print("Current roomservices: ");
            for (RoomService s : oneRoom.getRoomServices()) {
                System.out.print(s.getName() + ", ");
            }
            System.out.println();
            System.out.println("1: Add a roomservice");
            System.out.println("2: Remove a roomservice");
            System.out.println("3: Exit to startmenu");
            int menu = scanner.nextInt();
            switch (menu) {
                case 1 -> addService(oneRoom);
                case 2 -> deleteService(oneRoom);
                case 3 -> {
                    System.out.println("Going back to startmenu");
                    bool = false;
                }
                default -> System.out.println("Try again fron menu: 1-3");
            }
        }
    }

    // Addar service till rummen
    public void addService(Room oneRoom) {
        System.out.println("VILKEN SERVICE VILL DU HA");
        int i = 0;
        for (RoomService s : serviceList) {
            i++;
            System.out.print(i + ": " + s.getName() + ", ");
        }
        System.out.println();
        System.out.print("Select a roomservice to add: ");
        int choice = scanner.nextInt();

        for (RoomService roomService : serviceList) {
            if (roomService.getId() == choice) {
                oneRoom.addRoomServices(roomService);
            }
        }
        if (choice > serviceList.size()) {
            System.out.println("\nMenu is not available try again");
        }

    }

    // Tar bort service
    public void deleteService(Room oneRoom) {
        System.out.println("VILKEN SERVICE VILL DU TA BORT");
        int i = 0;
        for (RoomService s : oneRoom.getRoomServices()) {
            i++;
            System.out.print(i + ": " + s.getName() + ", ");
        }
        System.out.println();
        System.out.print("Select a roomservice to remove: ");
        int choice = scanner.nextInt();
        oneRoom.removeRoomServices(choice);
    }

    // Räknar priset per rum
    public void countRevenue() {


        for (Room room : roomsList) {

            if (!room.isAvailable()) {
                System.out.println();
                System.out.println(room.getName());
                System.out.println("base price is: " + room.getCost());
                // Printar varje hotelservice
                for (RoomService s : room.getRoomServices()) {
                    serviceSumRoom = serviceSumRoom + s.getCost();
                    System.out.println(s.getName() + ": " + s.getCost());
                }
                System.out.println("The total price for this room is: " + (room.getCost() + serviceSumRoom));
                serviceSumTotal = serviceSumTotal + room.getCost() + serviceSumRoom;
                serviceSumRoom = 0;
            }
        }
        //Printar totala priset
        System.out.println();
        System.out.println("Total revenue for all rooms: " + serviceSumTotal);
        serviceSumTotal = 0;
    }
}

