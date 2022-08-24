import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Hotel {

    private List<Room> rooms;
    private List<RoomService> roomServices;

    public Hotel() {
        //Rummen skapas och skickas till List när object skapas
        Room rum1 = new Room(1, "MusicRoom", 100, true, new ArrayList<>());
        Room rum2 = new Room(2, "HomeGym", 200, true, new ArrayList<>());
        Room rum3 = new Room(3, "PlayRoom", 400, true, new ArrayList<>());
        Room rum4 = new Room(4, "GuestRoom", 500, true, new ArrayList<>());
        Room rum5 = new Room(5, "HomeOffice", 560, true, new ArrayList<>());
        Room rum6 = new Room(6, "FamilyRoom", 750, true, new ArrayList<>());
        Room rum7 = new Room(7, "BachelorRoom", 900, true, new ArrayList<>());
        Room rum8 = new Room(8, "WeddingRoom", 1200, true, new ArrayList<>());
        Room rum9 = new Room(9, "MasterPCRoom", 1400, true, new ArrayList<>());
        Room rum10 = new Room(10, "SegaRoom", 2000, true, new ArrayList<>());
        Room rum11 = new Room(11, "VintageRoom", 2400, true, new ArrayList<>());
        Room rum12 = new Room(12, "CarRoom", 2600, true, new ArrayList<>());
        Room rum13 = new Room(13, "PirateRoom", 3000, true, new ArrayList<>());
        Room rum14 = new Room(14, "DisneyRoom", 3500, true, new ArrayList<>());
        Room rum15 = new Room(15, "GamingRoom1000", 5000, true, new ArrayList<>());
        Room rum16 = new Room(16, "GamingRoom2000", 5500, true, new ArrayList<>());

        rooms = Arrays.asList(rum1, rum2, rum3, rum4, rum5, rum10, rum6, rum7, rum8, rum9, rum11, rum12, rum13, rum14, rum15, rum16);

        //Hotelservicen skapas och skickas till list
        RoomService service1 = new RoomService(1, "Breakfast", 10);
        RoomService service2 = new RoomService(2, "Lunch", 20);
        RoomService service3 = new RoomService(3, "Dinner", 20);
        RoomService service4 = new RoomService(4, "Wine", 10);
        RoomService service5 = new RoomService(5, "Cleaning", 5);
        roomServices = Arrays.asList(service1, service2, service3, service4, service5);

    }

    public List<Room> getRooms() {
        return rooms;
    }

    public List<RoomService> getServices() {
        return roomServices;
    }
}