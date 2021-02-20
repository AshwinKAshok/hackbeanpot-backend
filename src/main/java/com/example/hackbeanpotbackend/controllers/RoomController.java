package com.example.hackbeanpotbackend.controllers;

import com.example.hackbeanpotbackend.models.Room;
import com.example.hackbeanpotbackend.services.RoomService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = "*")
public class RoomController {

  @Autowired
  RoomService roomService;

  @PostMapping("/room/name/{roomName}/admin/{adminName}")
  public Room createRoom(@PathVariable("roomName")String roomName, @PathVariable("adminName") String adminName) {
    return roomService.AddNewRoom(roomName, adminName);
  }


}
