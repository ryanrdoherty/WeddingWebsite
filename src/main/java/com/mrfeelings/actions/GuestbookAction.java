package com.mrfeelings.actions;

import java.util.List;

import com.mrfeelings.actions.base.WeddingAction;
import com.mrfeelings.db.DataException;
import com.mrfeelings.db.WeddingDataManager;
import com.mrfeelings.db.WeddingDbWorker;
import com.mrfeelings.db.entities.GuestbookEntry;
import com.mrfeelings.db.entities.User;
import com.mrfeelings.db.enums.Page;

public class GuestbookAction extends WeddingAction {

  private static final long serialVersionUID = 1L;

  private List<GuestbookEntry> _entries;
  private GuestbookEntry _guestbookEntry = new GuestbookEntry();
  
  @Override
  protected String doWork() throws Exception {
    try {
      new WeddingDbWorker(){
        @Override public void doDbTasks(WeddingDataManager dataMgr) {
          _entries = dataMgr.getGuestbookEntries();
        }
      }.doWork();
    }
    catch (Exception e) {
      throw new DataException(e);
    }
    return SUCCESS;
  }

  @Override
  protected Page getPage() {
    return Page.GUESTBOOK;
  }
  
  public GuestbookEntry getNewEntry() {
    _guestbookEntry.setUser(getCurrentUser());
    return _guestbookEntry;
  }
  
  public User getUser() {
    return getCurrentUser();
  }
  
  public List<GuestbookEntry> getEntries() {
    return _entries;
  }

}
