package com.example.hackbeanpotbackend.models;

import java.util.ArrayList;

public class Room {
  private String name;
  private String admin;
  private String roomNumber;
  private ArrayList<Songs> songsList;

  public Room(String name, String admin, String roomNumber, ArrayList<Songs> songsList) {
    this.name = name;
    this.admin = admin;
    this.roomNumber = roomNumber;
    this.songsList = songsList;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getAdmin() {
    return admin;
  }

  public void setAdmin(String admin) {
    this.admin = admin;
  }

  public String getRoomNumber() {
    return roomNumber;
  }

  public void setRoomNumber(String roomNumber) {
    this.roomNumber = roomNumber;
  }

  public ArrayList<Songs> getSongsList() {
    return songsList;
  }

  public void setSongsList(ArrayList<Songs> songsList) {
    this.songsList = songsList;
  }
}
