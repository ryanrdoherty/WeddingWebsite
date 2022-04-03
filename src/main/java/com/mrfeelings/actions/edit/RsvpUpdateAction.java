package com.mrfeelings.actions.edit;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.mrfeelings.Config;
import com.mrfeelings.MailUtil;
import com.mrfeelings.Config.PropKey;
import com.mrfeelings.actions.base.WeddingAction;
import com.mrfeelings.db.ContentRetriever;
import com.mrfeelings.db.entities.User;
import com.mrfeelings.db.enums.Page;
import com.mrfeelings.db.enums.RsvpType;

public class RsvpUpdateAction extends WeddingAction {

  private static final Logger LOG = LogManager.getLogger(RsvpUpdateAction.class);

  private static final long serialVersionUID = 1L;

  public User _user;
  
  @Override
  protected String doWork() throws Exception {
    if (!_user.getAttending().equals(RsvpType.YES)) {
      _user.setNumAdults(0);
      _user.setNumKids(0);
    }
    if (_user.getAttending().equals(RsvpType.YES) &&
        _user.getMaxAdults().intValue() == 1) {
      _user.setNumAdults(1);
    }
    _user = new ContentRetriever().updateUser(_user);
    User guestbookUser = new User();
    guestbookUser.setEmail(Config.getValue(PropKey.rsvpEmail));
    MailUtil.sendMail(guestbookUser, "New RSVP information from " + _user.getName(),
        _user.getName() + " has recorded a response of " + _user.getAttending().getDescription() +
        ".\n\n  Number of adults: " + _user.getNumAdults() + ", Number of children: " +
        _user.getNumKids() + "\n\nComment:\n" + _user.getRsvpComment());
    LOG.info("New RSVP info: " + _user.getName() + " set to " + _user.getAttending());
    return SUCCESS;
  }

  @Override
  protected boolean requiresLogin() {
    return true;
  }

  @Override
  protected Page getPage() {
    return Page.GUESTBOOK_UPDATE;
  }
  
  public User getUser() {
    if (_user == null) {
      _user = getCurrentUser().clone();
    }
    return _user;
  }

}
