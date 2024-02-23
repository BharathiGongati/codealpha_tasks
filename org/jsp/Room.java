package org.jsp;

import java.util.*;

class Room {
    private int roomNumber;
    private String type;
    private boolean available;
    private double price;

    public Room(int roomNumber, String type, double price) {
        this.roomNumber = roomNumber;
        this.type = type;
        this.price = price;
        this.available = true;
    }

    public int getRoomNumber() {
        return roomNumber;
    }

    public String getType() {
        return type;
    }

    public boolean isAvailable() {
        return available;
    }

    public void book() {
        available = false;
    }

    public void release() {
        available = true;
    }

    public double getPrice() {
        return price;
    }
}

class Hotel {
    private List<Room> rooms;

    public Hotel() {
        rooms = new ArrayList<>();
    }

    public void addRoom(Room room) {
        rooms.add(room);
    }

    public List<Room> getAvailableRooms(String type) {
        List<Room> availableRooms = new ArrayList<>();
        for (Room room : rooms) {
            if (room.isAvailable() && room.getType().equalsIgnoreCase(type)) {
                availableRooms.add(room);
            }
        }
        return availableRooms;
    }
}

 class HotelReservationSystem {
    private static Scanner scanner = new Scanner(System.in);
    private static Hotel hotel = new Hotel();

    public static void main(String[] args) {
        initializeRooms();
        boolean running = true;
        while (running) {
            System.out.println("1. Search for available rooms");
            System.out.println("2. Make a reservation");
            System.out.println("3. Exit");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();
            switch (choice) {
                case 1:
                    searchRooms();
                    break;
                case 2:
                    makeReservation();
                    break;
                case 3:
                    running = false;
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    private static void initializeRooms() {
        // Adding sample rooms to the hotel
        hotel.addRoom(new Room(101, "Single", 50.0));
        hotel.addRoom(new Room(102, "Single", 50.0));
        hotel.addRoom(new Room(201, "Double", 80.0));
        hotel.addRoom(new Room(202, "Double", 80.0));
    }

    private static void searchRooms() {
        System.out.print("Enter room type (Single/Double): ");
        String type = scanner.next();
        List<Room> availableRooms = hotel.getAvailableRooms(type);
        if (availableRooms.isEmpty()) {
            System.out.println("No available rooms of type " + type);
        } else {
            System.out.println("Available rooms:");
            for (Room room : availableRooms) {
                System.out.println("Room Number: " + room.getRoomNumber() + ", Price: $" + room.getPrice());
            }
        }
    }

    private static void makeReservation() {
        System.out.print("Enter room number: ");
        int roomNumber = scanner.nextInt();
        for (Room room : hotel.getAvailableRooms("")) {
            if (room.getRoomNumber() == roomNumber) {
                room.book();
                System.out.println("Reservation successful. Room booked.");
                return;
            }
        }
        System.out.println("Room number " + roomNumber + " not available.");
    }
}



