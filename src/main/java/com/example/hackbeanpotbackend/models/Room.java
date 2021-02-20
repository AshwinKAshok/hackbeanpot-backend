package com.example.hackbeanpotbackend.models;

public class Room {
  private String name;
  private String admin;
  private String room_number;

  public Room(String name, String admin, String room_number) {
    this.name = name;
    this.admin = admin;
    this.room_number = room_number;
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

  public String getRoom_number() {
    return room_number;
  }

  public void setRoom_number(String room_number) {
    this.room_number = room_number;
  }
}
