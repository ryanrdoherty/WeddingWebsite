package com.mrfeelings.actions.admin;

import java.util.List;

import com.mrfeelings.actions.base.WeddingAdminAction;
import com.mrfeelings.db.ContentRetriever;
import com.mrfeelings.db.entities.User;
import com.mrfeelings.db.enums.Page;

public class ShowUsersAction extends WeddingAdminAction {

  private static final long serialVersionUID = 1L;

  private List<User> _users;
  private int _maxAdults = 0;
  private int _maxKids = 0;
  private int _numAdults = 0;
  private int _numKids = 0;
  private int _potentialAdults = 0;
  private int _potentialKids = 0;
  
  @Override
  protected String doWork() throws Exception {
    _users = new ContentRetriever().getAllUsers();
    for (User user : _users) {
      _maxAdults += nullToZero(user.getMaxAdults());
      _maxKids += nullToZero(user.getMaxKids());
      _numAdults += nullToZero(user.getNumAdults());
      _numKids += nullToZero(user.getNumKids());
      if (!user.getHasRsvped()) {
        _potentialAdults += nullToZero(user.getMaxAdults());
        _potentialKids += nullToZero(user.getMaxKids());
      }
    }
    _potentialAdults += _numAdults;
    _potentialKids += _numKids;
    return SUCCESS;
  }
  
  private int nullToZero(Integer integer) {
    return (integer == null ? 0 : integer);
  }

  @Override
  protected Page getPage() {
    return Page.VIEW_USERS;
  }
  
  public List<User> getUsers() {
    return _users;
  }

  public int getMaxAdults() {
    return _maxAdults;
  }

  public int getMaxKids() {
    return _maxKids;
  }

  public int getNumAdults() {
    return _numAdults;
  }

  public int getNumKids() {
    return _numKids;
  }

  public int getPotentialAdults() {
    return _potentialAdults;
  }

  public int getPotentialKids() {
    return _potentialKids;
  }
  
}
