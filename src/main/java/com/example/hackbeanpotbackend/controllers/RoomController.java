package com.example.hackbeanpotbackend.controllers;

import com.example.hackbeanpotbackend.models.Room;
import com.example.hackbeanpotbackend.models.Song;
import com.example.hackbeanpotbackend.services.RoomService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.HashMap;

@RestController
@CrossOrigin(origins = "*")
public class RoomController {

  @Autowired
  RoomService roomService;

  @PostMapping("/room/name/{roomName}/admin/{adminName}")
  public Room createRoom(@PathVariable("roomName")String roomName, @PathVariable("adminName") String adminName) {
    return roomService.AddNewRoom(roomName, adminName);
  }

  @PostMapping("/song/list/room/{roomNumber}")
  public boolean addSongToRoom(@PathVariable("roomNumber") String roomNumber, @RequestBody Song song) {
    return roomService.AddSongToRoom(Integer.parseInt(roomNumber), song);
  }

  @PostMapping("/song/votedlist/room/{roomNumber}")
  public boolean addSongToTopVotedList(@PathVariable("roomNumber") String roomNumber, @RequestBody Song song) {
    return roomService.AddSongToCurrentTopVotedList(Integer.parseInt(roomNumber), song);
  }

  @GetMapping("/room/{roomNumber}")
  public Room getRoomData(@PathVariable("roomNumber") String roomNumber) {
    return roomService.getRoomByRoomNumber(roomNumber);
  }

  @GetMapping("/room/all")
  public HashMap<Integer, Room> getAllRooms() {
    return roomService.getAllRooms();
  }

  @GetMapping("/room/{roomNumber}/songs/clearVotedSongs")
  public boolean clearSongsFromVotedList(@PathVariable("roomNumber") String roomNumber) {
    return roomService.clearSongsFromVotedList(roomNumber);
  }


  @GetMapping("/room/{roomNumber}/createvote")
  public ArrayList<Song> createVoteOfRandomSongs(@PathVariable("roomNumber") String roomNumber) {
        return roomService.createVoteOfRandomSongs(roomNumber);
  }

  @PostMapping("/room/{roomNumber}/vote/{voteIndex}")
  public boolean updateVote(@PathVariable("roomNumber") String roomNumber, @PathVariable("voteIndex") String voteIndex) {
    return roomService.updateVote(roomNumber, voteIndex);
  }
}
