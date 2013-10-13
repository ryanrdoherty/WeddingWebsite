package com.mrfeelings.actions.admin;

import java.util.List;

import com.mrfeelings.actions.base.WeddingAdminAction;
import com.mrfeelings.db.WeddingDataManager;
import com.mrfeelings.db.WeddingDbWorker;
import com.mrfeelings.db.entities.PageView;
import com.mrfeelings.db.entities.PageStat;
import com.mrfeelings.db.entities.User;
import com.mrfeelings.db.enums.Page;

public class UserStatsAction extends WeddingAdminAction {

  private static final long serialVersionUID = 20111025L;

  private Long _userId;
  private User _user;
  private List<PageView> _pageViews;
  private List<PageStat> _pageStats;
  
  @Override
  protected String doWork() throws Exception {
    new WeddingDbWorker() { @Override public void doDbTasks(WeddingDataManager dataMgr) {
      if (_userId == null) {
        _pageViews = dataMgr.getPageViews();
        _pageStats = dataMgr.getPageStats();
      } else {
        _user = dataMgr.findById(User.class, _userId);
        _pageViews = dataMgr.getPageViewsByUserId(_userId);
        _pageStats = dataMgr.getPageStatsByUserId(_userId);
      }
    }}.doWork();
    return SUCCESS;
  }
  
  @Override
  protected Page getPage() {
    return Page.USER_STATS;
  }

  public void setUserId(Long userId) {
    _userId = userId;
  }

  public Long getUserId() {
    return _userId;
  }
  
  public User getUser() {
    return _user;
  }
  
  public List<PageView> getPageViews() {
    return _pageViews;
  }
  
  public List<PageStat> getPageStats() {
    return _pageStats;
  }
}
