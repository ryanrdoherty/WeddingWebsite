package com.mrfeelings.db.enums;

public enum ContentType {
  CEREMONY("Ceremony Information"),
  SCHEDULE("Event Schedule"),
  ACCOMMODATIONS("Suggested Accommodations"),
  ATTRACTIONS("Suggested Attractions"),
  STORY("Our Story"),
  PHOTOS("Photo Galleries");

  private String _title;
  
  private ContentType(String title) {
    _title = title;
  }
  
  public String getTitle() {
    return _title;
  }
}
