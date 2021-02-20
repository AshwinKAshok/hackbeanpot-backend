package com.example.hackbeanpotbackend.models;

public class Songs {
  private String songName;;
  private String songUrl;

  public Songs(String songName, String songUrl) {
    this.songName = songName;
    this.songUrl = songUrl;
  }

  public String getSongName() {
    return songName;
  }

  public void setSongName(String songName) {
    this.songName = songName;
  }

  public String getSongUrl() {
    return songUrl;
  }

  public void setSongUrl(String songUrl) {
    this.songUrl = songUrl;
  }
}
