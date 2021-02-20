package com.example.hackbeanpotbackend.services;

import com.example.hackbeanpotbackend.models.Room;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;

@Service
public class RoomService {
  HashMap<Integer, Room> roomMap = new HashMap<>();

  public Integer AddRoom(Room room) {
    Random rand = new Random(); //instance of random class
    int upperbound = 9999;
    //generate random values from 0-24
    int random_room_number = rand.nextInt(upperbound);

    // getting a random room key that wasn't previously used
    while(roomMap.containsKey(random_room_number)) {
      random_room_number = rand.nextInt(upperbound);
    }

    roomMap.put(random_room_number, room);

    return random_room_number;
  }

}
