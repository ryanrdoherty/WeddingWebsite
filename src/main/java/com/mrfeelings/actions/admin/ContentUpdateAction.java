package com.mrfeelings.actions.admin;

import java.util.HashMap;
import java.util.Map;

import com.mrfeelings.actions.base.WeddingAdminAction;
import com.mrfeelings.db.WeddingDataManager;
import com.mrfeelings.db.WeddingDbWorker;
import com.mrfeelings.db.enums.ContentType;
import com.mrfeelings.db.enums.Page;

public class ContentUpdateAction extends WeddingAdminAction {

  private static final long serialVersionUID = 1L;

  private Map<String, String> _content = new HashMap<String, String>();
  
  @Override
  protected String doWork() throws Exception {
    new WeddingDbWorker(){
      @Override public void doDbTasks(WeddingDataManager dataMgr) {
        dataMgr.setContentData(_content);
      }
    }.doWork();
    return SUCCESS;
  }

  @Override
  protected Page getPage() {
    return Page.CONTENT_UPDATE;
  }

  public void setCeremonyData(String data) {
    _content.put(ContentType.CEREMONY.name(), data.trim());
  }

  public void setScheduleData(String data) {
    _content.put(ContentType.SCHEDULE.name(), data.trim());
  }

  public void setHotelData(String data) {
    _content.put(ContentType.ACCOMMODATIONS.name(), data.trim());
  }

  public void setAttractionData(String data) {
    _content.put(ContentType.ATTRACTIONS.name(), data.trim());
  }

  public void setStoryData(String data) {
    _content.put(ContentType.STORY.name(), data.trim());
  }

  public void setPhotoData(String data) {
    _content.put(ContentType.PHOTOS.name(), data.trim());
  }
  
}
