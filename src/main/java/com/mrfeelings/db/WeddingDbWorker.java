package com.mrfeelings.db;

import com.mrfeelings.db.entities.PageView;
import com.mrfeelings.db.entities.User;
import com.mrfeelings.db.enums.Page;

import org.conical.common.bbl.jpa.DbWorker;

public abstract class WeddingDbWorker extends DbWorker<WeddingDataManager> {

  @Override
  public WeddingDataManager getDataManager() {
    return new WeddingDataManager();
  }

  public static void addPageView(final Page page, final User currentUser) {
    try {
      new WeddingDbWorker(){
        @Override public void doDbTasks(WeddingDataManager dataMgr) {
          dataMgr.saveObject(new PageView(page, currentUser));
        }
      }.doWork();
    }
    catch (Exception e) {
      throw new DataException(e);
    }
  }
}
