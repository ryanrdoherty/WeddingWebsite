package com.mrfeelings.db.entities;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.mrfeelings.db.enums.Page;

import edu.upenn.bbl.common.jpa.Identifiable;

@Entity
@Table(name="PAGE_VIEWS")
@NamedQueries(value = {
    @NamedQuery(
        name=PageView.GET_ALL_VIEWS,
        query="select v from PageView v order by v.date desc"),
    @NamedQuery(
        name=PageView.GET_VIEWS_BY_USERID,
        query="select v from PageView v where v.user.id = :userId order by v.date desc")
})
public class PageView implements Identifiable {

  public static final String GET_ALL_VIEWS = "PageView.getAllViews";
  public static final String GET_VIEWS_BY_USERID = "PageView.getViewByUser";
  
  private Long _id;
  private Date _date;
  private Page _page;
  private User _user;
  
  @SuppressWarnings("unused")
  private PageView() { }
  
  public PageView(Page page, User currentUser) {
    _date = new Date();
    _page = page;
    _user = currentUser;
  }
  
  @Id
  @Column(name="VIEW_ID")
  @GeneratedValue
  @Override
  public Long getId() {
    return _id;
  }
  @Override
  public void setId(Long id) {
    _id = id;
  }
  
  @Column(name="VIEW_DATE")
  @Temporal(TemporalType.TIMESTAMP)
  public Date getDate() {
    return _date;
  }
  public void setDate(Date date) {
    _date = date;
  }
  
  @Column(name="PAGE")
  @Enumerated(EnumType.STRING)
  public Page getPage() {
    return _page;
  }
  public void setPage(Page page) {
    _page = page;
  }
  
  @ManyToOne
  @JoinColumn(name="USER_ID")
  public User getUser() {
    return _user;
  }
  public void setUser(User user) {
    _user = user;
  }

}
