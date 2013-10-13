package com.mrfeelings.actions.edit;

import java.util.Date;

import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.mrfeelings.Config;
import com.mrfeelings.MailUtil;
import com.mrfeelings.Config.PropKey;
import com.mrfeelings.actions.base.WeddingAction;
import com.mrfeelings.db.DataException;
import com.mrfeelings.db.WeddingDataManager;
import com.mrfeelings.db.WeddingDbWorker;
import com.mrfeelings.db.entities.GuestbookEntry;
import com.mrfeelings.db.entities.User;
import com.mrfeelings.db.enums.Page;

public class GuestbookPostAction extends WeddingAction {

  private static final long serialVersionUID = 1L;

  private static final Logger LOG = LoggerFactory.getLogger(GuestbookPostAction.class.getName());
  
  private GuestbookEntry _entry = new GuestbookEntry();
  
  @Override
  protected String doWork() throws Exception {
    _entry.setDate(new Date());
    _entry.setUser(getCurrentUser());
    LOG.info("Got the following entry: " + _entry);
    if (!StringUtils.isEmpty(_entry.getSubject()) || !StringUtils.isEmpty(_entry.getMessage())) {
      try {
        new WeddingDbWorker(){
          @Override public void doDbTasks(WeddingDataManager dataMgr) {
            dataMgr.saveObject(_entry);
          }
        }.doWork();
        User guestbookUser = new User();
        guestbookUser.setEmail(Config.getValue(PropKey.guestbookEmail));
        MailUtil.sendMail(guestbookUser, "Guestbook entry from " + _entry.getUser().getName(),
            "Subject: " + _entry.getSubject() + "\nMessage:\n" + _entry.getMessage());
      }
      catch (Exception e) {
        throw new DataException(e);
      }
    }
    return SUCCESS;
  }

  @Override
  protected boolean requiresLogin() {
    return true;
  }
  
  @Override
  protected Page getPage() {
    return Page.GUESTBOOK_POST;
  }
  
  public GuestbookEntry getNewEntry() {
    return _entry;
  }

}
