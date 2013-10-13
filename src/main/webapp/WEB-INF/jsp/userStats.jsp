<jsp:root xmlns:jsp="http://java.sun.com/JSP/Page"
  xmlns:c="http://java.sun.com/jsp/jstl/core"
  xmlns:s="/struts-tags"
  version="2.1">
<jsp:directive.page contentType="text/html" />
<html>
  <head>
    <title>Page Stats Page</title>
    <link rel="stylesheet" type="text/css" href="css/backend.css"/>
  </head>
  <body>
    <c:if test="${not empty userId}">
      <h2>Page Stats for ${user.displayName} (#${userId})</h2>
    </c:if>
    <c:if test="${empty userId}">
      <h2>Page Stats for All Users</h2>
    </c:if>
    <div style="float:right;">
      <a href="Edit">Back to Admin Home</a>
      <c:if test="${not empty userId}">
        <br/><a href="Users">Back to Invitees</a>
        <br/><a href="ViewUser?userId=${userId}">View this user</a>
      </c:if>
    </div>
    <h3>Counts by Page</h3>
    <table class="summary-table">
      <tr>
        <th>Page ID</th>
        <th># Views</th>
      </tr>
      <c:forEach var="stat" items="${pageStats}">
        <tr>
          <td>${stat.page}</td>
          <td>${stat.numViews}</td>
        </tr>
      </c:forEach>
    </table>
    <h3>Listing of All Page Views</h3>
    <table class="summary-table">
      <tr>
        <th>Date</th>
        <th>Page ID</th>
        <th>User</th>
        <th>User ID</th>
      </tr>
      <c:forEach var="view" items="${pageViews}">
        <tr>
          <td>${view.date}</td>
          <td>${view.page}</td>
          <c:if test="${empty view.user}">
            <td colspan="2">No Login</td>
          </c:if>
          <c:if test="${not empty view.user}">
            <td>${view.user.displayName}</td>
            <td>${view.user.id}</td>
          </c:if>
        </tr>
      </c:forEach>
    </table>
  </body>
</html>
</jsp:root>
