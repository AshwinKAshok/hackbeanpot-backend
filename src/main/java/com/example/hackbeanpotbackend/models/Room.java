package com.example.hackbeanpotbackend.models;

import java.util.ArrayList;

public class Room {
  private String name;
  private String admin;
  private String roomNumber;
  private ArrayList<Song> songList;
  private ArrayList<Song> currentTopVotedSongs;

  public Room(String name, String admin, String roomNumber, ArrayList<Song> songList, ArrayList<Song> currentTopVotedSongs) {
    this.name = name;
    this.admin = admin;
    this.roomNumber = roomNumber;
    this.songList = songList;
    this.currentTopVotedSongs = currentTopVotedSongs;
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

  public ArrayList<Song> getSongList() {
    return songList;
  }

  public void setSongList(ArrayList<Song> songList) {
    this.songList = songList;
  }

  public ArrayList<Song> getCurrentTopVotedSongs() {
    return currentTopVotedSongs;
  }

  public void setCurrentTopVotedSongs(ArrayList<Song> currentTopVotedSongs) {
    this.currentTopVotedSongs = currentTopVotedSongs;
  }
}
