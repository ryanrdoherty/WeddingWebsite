package com.mrfeelings.db.entities;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Transient;

import com.mrfeelings.db.enums.RsvpType;

import edu.upenn.bbl.common.enums.State;
import edu.upenn.bbl.common.jpa.Identifiable;

@Entity
@Table(name="WEDDING_USER")
@NamedQueries(value = {
    @NamedQuery(
        name=User.GET_ALL_USERS,
        query="select u from User u order by u.id asc"),
    @NamedQuery(
        name=User.GET_USER_BY_PASSCODE,
        query="select u from User u where u.passCode = :passcode")
})
public class User implements Identifiable {

  public static final String GET_USER_BY_PASSCODE = "getUserByPassCode";
  public static final String GET_ALL_USERS = "getAllUsers";
  
  private Long _id;
  private String _passCode;
  private String _name;
  private String _displayName;
  private String _email;
  private String _address;
  private String _city;
  private State _state;
  private String _zip;
  private RsvpType _attending = RsvpType.UNKNOWN;
  private Integer _numAdults = 0;
  private Integer _maxAdults = 0;
  private Integer _numKids = 0;
  private Integer _maxKids = 0;
  private String _rsvpComment = "";
  private Boolean _writeAccess = false;
  private String _gift;
  private Boolean _thankyou = false;
  
  public User(){ }
  
  @Id
  @Column(name="USER_ID")
  @GeneratedValue
  @Override
  public Long getId() {
    return _id;
  }
  @Override
  public void setId(Long id) {
    _id = id;
  }
  
  @Column(name="PASSCODE")
  public String getPassCode() {
    return _passCode;
  }
  public void setPassCode(String passCode) {
    _passCode = convertPasscode(passCode);
  }
  
  @Column(name="NAME")
  public String getName() {
    return _name;
  }
  public void setName(String name) {
    _name = name;
  }

  @Column(name="DISPLAY_NAME")
  public String getDisplayName() {
    return _displayName;
  }
  public void setDisplayName(String displayName) {
    _displayName = displayName;
  }
  
  @Column(name="EMAIL")
  public String getEmail() {
    return _email;
  }
  public void setEmail(String email) {
    _email = email;
  }
  
  @Column(name="ADDRESS")
  public String getAddress() {
    return _address;
  }
  public void setAddress(String address) {
    _address = address;
  }

  @Column(name="CITY")
  public String getCity() {
    return _city;
  }
  public void setCity(String city) {
    _city = city;
  }
  
  @Column(name="STATE")
  @Enumerated(EnumType.STRING)
  public State getState() {
    return _state;
  }
  public void setState(State state) {
    _state = state;
  }
  
  @Column(name="ZIP")
  public String getZip() {
    return _zip;
  }
  public void setZip(String zip) {
    _zip = zip;
  }
  
  @Column(name="RSVP")
  @Enumerated(EnumType.STRING)
  public RsvpType getAttending() {
    return _attending;
  }
  public void setAttending(RsvpType attending) {
    _attending = attending;
  }
  
  @Transient
  public boolean getHasRsvped() {
    return _attending != null && !_attending.equals(RsvpType.UNKNOWN);
  }
  
  @Column(name="MAX_ADULTS")
  public Integer getMaxAdults() {
    return _maxAdults;
  }
  public void setMaxAdults(Integer maxAdults) {
    _maxAdults = maxAdults;
  }
  
  @Transient
  public List<Integer> getAdultList() {
    return createIntList(0, _maxAdults);
  }

  @Column(name="MAX_KIDS")
  public Integer getMaxKids() {
    return _maxKids;
  }
  public void setMaxKids(Integer maxKids) {
    _maxKids = maxKids;
  }
  
  @Transient
  public List<Integer> getKidList() {
    return createIntList(0, _maxKids);
  }
  
  private List<Integer> createIntList(int start, int end) {
    List<Integer> list = new ArrayList<Integer>();
    for (int i = start; i <= end; i++) {
      list.add(i);
    }
    return list;
  }
  
  @Column(name="NUM_ADULTS")
  public Integer getNumAdults() {
    return _numAdults;
  }
  public void setNumAdults(Integer numAdults) {
    _numAdults = numAdults;
  }
  
  @Column(name="NUM_KIDS")
  public Integer getNumKids() {
    return _numKids;
  }
  public void setNumKids(Integer numKids) {
    _numKids = numKids;
  }
  
  @Column(name="COMMENT")
  public String getRsvpComment() {
    return _rsvpComment;
  }
  public void setRsvpComment(String rsvpComment) {
    _rsvpComment = rsvpComment;
  }
  
  @Column(name="WRITE_ACCESS")
  public Boolean getWriteAccess() {
    return _writeAccess;
  }
  public void setWriteAccess(Boolean writeAccess) {
    _writeAccess = writeAccess;
  }

  @Column(name="GIFT_DESC")
  public String getGift() {
    return _gift;
  }
  public void setGift(String gift) {
    _gift = gift;
  }

  @Column(name="THANKYOU")
  public Boolean getThankyou() {
    return _thankyou;
  }
  public void setThankyou(Boolean thankyou) {
    _thankyou = thankyou;
  }
  
  @Override
  public User clone() {
    User u = new User();
    u._id = _id;
    u._passCode = _passCode;
    u._name = _name;
    u._displayName = _displayName;
    u._email = _email;
    u._address = _address;
    u._city = _city;
    u._state = _state;
    u._zip = _zip;
    u._attending = _attending;
    u._numAdults = _numAdults;
    u._maxAdults = _maxAdults;
    u._numKids = _numKids;
    u._maxKids = _maxKids;
    u._rsvpComment = _rsvpComment;
    u._writeAccess = _writeAccess;
    u._gift = _gift;
    u._thankyou = _thankyou;
    return u;
  }

  public static String convertPasscode(String passcode) {
    return passcode.replaceAll(" ", "").toLowerCase();
  }
  
}
