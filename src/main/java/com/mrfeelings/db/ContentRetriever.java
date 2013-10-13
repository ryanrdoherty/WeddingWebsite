package com.mrfeelings.db;

import java.util.List;

import com.mrfeelings.db.entities.User;
import com.mrfeelings.db.enums.ContentType;

public class ContentRetriever {

  private String _data;
  private User _user;
  private List<User> _users;

  public String getContentData(final ContentType type) {
    try {
      new WeddingDbWorker(){
        @Override public void doDbTasks(WeddingDataManager dataMgr) {
          _data = dataMgr.getContentData(type);
        }
      }.doWork();
      return _data;
    }
    catch (Exception e) {
      throw new DataException(e);
    }
  }

  public User getUserByPasscode(final String passcode) {
    try {
      new WeddingDbWorker(){
        @Override public void doDbTasks(WeddingDataManager dataMgr) {
          String convertedPasscode = User.convertPasscode(passcode);
          _user = dataMgr.getUserByPasscode(convertedPasscode);
        }
      }.doWork();
      return _user;
    }
    catch (Exception e) {
      throw new DataException(e);
    }
  }

  public User getUserById(final Long id) {
    try {
      new WeddingDbWorker(){
        @Override public void doDbTasks(WeddingDataManager dataMgr) {
          _user = dataMgr.findById(User.class, id);
        }
      }.doWork();
      return _user;
    }
    catch (Exception e) {
      throw new DataException(e);
    }
  }
  
  public User updateUser(final User user) {
    try {
      new WeddingDbWorker(){
        @Override public void doDbTasks(WeddingDataManager dataMgr) {
          _user = dataMgr.saveObject(user);
        }
      }.doWork();
      return _user;
    }
    catch (Exception e) {
      throw new DataException(e);
    }
  }

  public List<User> getAllUsers() {
    try {
      new WeddingDbWorker() {
        @Override public void doDbTasks(WeddingDataManager dataMgr) {
          _users = dataMgr.getAllUsers();
        }
      }.doWork();
      return _users;
    }
    catch (Exception e) {
      throw new DataException(e);
    }
  }
}
