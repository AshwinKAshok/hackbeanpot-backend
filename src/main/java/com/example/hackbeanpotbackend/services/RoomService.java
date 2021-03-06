package com.example.hackbeanpotbackend.services;

import com.example.hackbeanpotbackend.models.Room;
import com.example.hackbeanpotbackend.models.Song;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;

@Service
public class RoomService {
  HashMap<Integer, Room> roomMap = new HashMap<>();

  public Room getRoomByRoomNumber(String roomNumber) {
    if(!roomMap.containsKey(Integer.parseInt(roomNumber)))
      return null;
    else
      return roomMap.get(Integer.parseInt(roomNumber));
  }

  public Room AddNewRoom(String roomName, String adminName) {
    Random rand = new Random(); //instance of random class
    int upperbound = 9999;
    //generate random values from 0-24
    int random_room_number = rand.nextInt(upperbound);

    // getting a random room key that wasn't previously used
    while(roomMap.containsKey(random_room_number)) {
      random_room_number = rand.nextInt(upperbound);
    }

    Room newRoom = new Room(roomName, adminName, String.valueOf(random_room_number), new ArrayList<Song>(), new ArrayList<Song>(), new ArrayList<Integer>());
    roomMap.put(random_room_number, newRoom);

    return newRoom;
  }

  public boolean AddSongToRoom(int roomNumber, Song song) {
    if(!roomMap.containsKey(roomNumber))
      return false;

    roomMap.get(roomNumber).getSongList().add(song);
    return true;
  }

  public boolean AddSongToCurrentTopVotedList(int roomNumber, Song song) {
    if(!roomMap.containsKey(roomNumber))
      return false;

    roomMap.get(roomNumber).getCurrentTopVotedSongs().add(song);
    return true;
  }

  public ArrayList<Song> getRoomSongList(int roomNumber) {
    return roomMap.get(roomNumber).getSongList();
  }

  public ArrayList<Song> getRoomCurrentTopSongs(int roomNumber) {
    return roomMap.get(roomNumber).getCurrentTopVotedSongs();
  }

  public HashMap<Integer, Room> getAllRooms() {
    return this.roomMap;
  }

  public boolean clearSongsFromVotedList(String roomNumber) {
    if(!roomMap.containsKey(Integer.parseInt(roomNumber)))
      return false;

    roomMap.get(Integer.parseInt(roomNumber)).getCurrentTopVotedSongs().clear();
    return true;
  }

  public ArrayList<Song> createVoteOfRandomSongs(String roomNumber) {
    ArrayList<Song> listOfSongs = roomMap.get(Integer.parseInt(roomNumber)).getSongList();
    Random rand = new Random(); //instance of random class
    int upperbound = listOfSongs.size()-1;
    //generate random values from 0-24
    ArrayList<Integer> random_index_till_now = new ArrayList<>();

    ArrayList<Integer> newVotesArray = new ArrayList<>();
    ArrayList<Song> newVotedSongList = new ArrayList<>();

    for(int i=0; i<3; i++) {
      int random_indx = rand.nextInt(upperbound);
      while(random_index_till_now.contains(random_indx))
        random_indx = rand.nextInt(upperbound);

      random_index_till_now.add(random_indx);
      newVotedSongList.add(listOfSongs.get(random_indx));
      newVotesArray.add(0);
    }

    roomMap.get(Integer.parseInt(roomNumber)).setCurrentTopVotedSongs(newVotedSongList);
    roomMap.get(Integer.parseInt(roomNumber)).setVotesForThreeSongs(newVotesArray);
    return newVotedSongList;
  }

  public boolean updateVote(String roomNumber, String voteIndex) {
    int currentVoteValue = roomMap.get(Integer.parseInt(roomNumber)).getVotesForThreeSongs().get(Integer.parseInt(voteIndex));
    roomMap.get(Integer.parseInt(roomNumber)).getVotesForThreeSongs().set(Integer.parseInt(voteIndex), currentVoteValue + 1);

    return true;
  }
}
