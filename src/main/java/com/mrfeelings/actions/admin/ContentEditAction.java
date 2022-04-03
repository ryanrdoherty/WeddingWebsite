package com.mrfeelings.actions.admin;

import java.util.Map;

import org.apache.commons.lang3.StringUtils;

import com.mrfeelings.actions.base.WeddingAdminAction;
import com.mrfeelings.db.WeddingDataManager;
import com.mrfeelings.db.WeddingDbWorker;
import com.mrfeelings.db.enums.ContentType;
import com.mrfeelings.db.enums.Page;

public class ContentEditAction extends WeddingAdminAction {

  private static final long serialVersionUID = 1L;

  private Map<String, String> _content;
  
  @Override
  protected String doWork() throws Exception {
    new WeddingDbWorker(){
      @Override public void doDbTasks(WeddingDataManager dataMgr) {
        _content = dataMgr.getContentData();
      }
    }.doWork();
    return SUCCESS;
  }
  
  @Override
  protected Page getPage() {
    return Page.CONTENT_EDIT;
  }

  private String getContent(String data) {
    if (StringUtils.isEmpty(data)) return " ";
    return data;
  }

  public String getCeremonyData() {
    return getContent(_content.get(ContentType.CEREMONY.name()));
  }

  public String getScheduleData() {
    return getContent(_content.get(ContentType.SCHEDULE.name()));
  }

  public String getHotelData() {
    return getContent(_content.get(ContentType.ACCOMMODATIONS.name()));
  }

  public String getAttractionData() {
    return getContent(_content.get(ContentType.ATTRACTIONS.name()));
  }

  public String getStoryData() {
    return getContent(_content.get(ContentType.STORY.name()));
  }

  public String getPhotoData() {
    return getContent(_content.get(ContentType.PHOTOS.name()));
  }
  
}
