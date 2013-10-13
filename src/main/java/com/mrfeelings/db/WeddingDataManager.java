package com.mrfeelings.db;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.sql.DataSource;

import com.mrfeelings.db.entities.GuestbookEntry;
import com.mrfeelings.db.entities.PageView;
import com.mrfeelings.db.entities.PageStat;
import com.mrfeelings.db.entities.User;
import com.mrfeelings.db.enums.ContentType;

import edu.upenn.bbl.common.db.DbUtil;
import edu.upenn.bbl.common.jpa.JpaDataManager;

public class WeddingDataManager extends JpaDataManager {
  
  private static EntityManagerFactory _emf = 
    Persistence.createEntityManagerFactory("WEDDING_PERSISTENCE");

  private static DataSource _ds;
  
  static {
    try {
      _ds = (DataSource)new InitialContext().lookup("java:/comp/env/jdbc/WeddingDS");
    }
    catch (NamingException ne) {
      throw new DataException(ne);
    }
  }
  
  @Override
  protected EntityManagerFactory getEmf() {
    return _emf;
  }
  
  public String getContentData(ContentType type) throws DataException {
    return getContentDataMap(type.name()).get(type.name());
  }

  public Map<String, String> getContentData() throws DataException {
    return getContentDataMap(null);
  }    

  private Map<String, String> getContentDataMap(String name) {
    Connection conn = null;
    PreparedStatement stmt = null;
    ResultSet rs = null;
    try {
      String query = "select key, value from content";
      if (name != null) query += " where key = ?";
      conn = _ds.getConnection();
      stmt = conn.prepareStatement(query);
      if (name != null) stmt.setString(1, name);
      rs = stmt.executeQuery();
      Map<String, String> map = new HashMap<String, String>();
      while (rs.next()) {
        map.put(rs.getString(1), rs.getString(2));
      }
      return map;
    }
    catch (SQLException sqle) {
      throw new DataException(sqle);
    }
    finally {
      DbUtil.close(rs, stmt, conn);
    }
  }

  public void setContentData(Map<String, String> content) throws DataException {
    Connection conn = null;
    PreparedStatement insertStmt = null;
    PreparedStatement updateStmt = null;
    try {
      conn = _ds.getConnection();
      insertStmt = conn.prepareStatement("insert into content (key, value) values (?, ?)");
      updateStmt = conn.prepareStatement("update content set value = ? where key = ?");
      Map<String, String> currentValues = getContentData();
      for (String key : content.keySet()) {
        if (currentValues.containsKey(key)) {
          if (!currentValues.get(key).equals(content.get(key))) {
            updateStmt.setString(1, content.get(key));
            updateStmt.setString(2, key);
            updateStmt.executeUpdate();
          }
        }
        else {
          insertStmt.setString(1, key);
          insertStmt.setString(2, content.get(key));
          insertStmt.executeUpdate();
        }
      }
    }
    catch (SQLException sqle) {
      throw new DataException(sqle);
    }
    finally {
      DbUtil.close(updateStmt, insertStmt, conn);
    }
  }

  public User getUserByPasscode(String passcode) {
    return (User)getEm()
      .createNamedQuery(User.GET_USER_BY_PASSCODE)
      .setParameter("passcode", passcode)
      .getSingleResult();
  }

  @SuppressWarnings("unchecked")
  public List<User> getAllUsers() {
    return getEm().createNamedQuery(User.GET_ALL_USERS).getResultList();
  }

  @SuppressWarnings("unchecked")
  public List<GuestbookEntry> getGuestbookEntries() {
    return getEm().createNamedQuery(GuestbookEntry.GET_ALL_ENTRIES).getResultList();
  }
  
  @SuppressWarnings("unchecked")
  public List<PageView> getPageViews() {
    return getEm().createNamedQuery(PageView.GET_ALL_VIEWS).getResultList();
  }
  
  @SuppressWarnings("unchecked")
  public List<PageView> getPageViewsByUserId(long userId) {
    return getEm().createNamedQuery(PageView.GET_VIEWS_BY_USERID).setParameter("userId", userId).getResultList();
  }
  
  @SuppressWarnings("unchecked")
  public List<PageStat> getPageStats() {
    return getEm().createNamedQuery(PageStat.GET_PAGE_STATS).getResultList();
  }
  
  @SuppressWarnings("unchecked")
  public List<PageStat> getPageStatsByUserId(long userId) {
    return getEm().createNamedQuery(PageStat.GET_PAGE_STATS_BY_USERID).setParameter("userId", userId).getResultList();

  }
}
