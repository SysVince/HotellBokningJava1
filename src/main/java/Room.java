import java.util.List;

public class Room {

    private int id;
    private String name;
    private int cost;
    private boolean available;
    private List<RoomService> roomServices;

    public Room(int id, String name, int cost, boolean available, List<RoomService> roomServices) {
        this.id = id;
        this.name = name;
        this.cost = cost;
        this.available = available;
        this.roomServices = roomServices;

    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getCost() {
        return cost;
    }

    public boolean isAvailable() {
        return available;
    }

    public List<RoomService> getRoomServices() {
        return roomServices;
    }

    public void setAvailable(boolean available) {
        this.available = available;
    }

    public void addRoomServices(RoomService roomService) {
        roomServices.add(roomService);
    }

    public void removeRoomServices(int index) {
        roomServices.remove(index - 1);
    }

    public void clearRoomservices() {
        roomServices.clear();
    }


}