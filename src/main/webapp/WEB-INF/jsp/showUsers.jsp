<jsp:root xmlns:jsp="http://java.sun.com/JSP/Page"
  xmlns:c="http://java.sun.com/jsp/jstl/core"
  xmlns:s="/struts-tags"
  version="2.1">
<jsp:directive.page contentType="text/html" />
<html>
  <head>
    <title>View Users Page</title>
    <link rel="stylesheet" type="text/css" href="css/backend.css"/>
  </head>
  <body>
    <h2>Current Users</h2>
    <div style="float:right;"><a href="Edit">Back to Admin Home</a></div>
    <p>
      <a href="ViewUser">Add a New User</a><br/>
      <a href="ExportUsers">Export All as Excel</a>
    </p>
    <table class="summary-table">
      <tr><th>Adults Invited:</th><td>${maxAdults}</td></tr>
      <tr><th>Kids Invited:</th><td>${maxKids}</td></tr>
      <tr><th>Adults Coming:</th><td>${numAdults}</td></tr>
      <tr><th>Kids Coming:</th><td>${numKids}</td></tr>
      <tr><th>Potential Adults:</th><td>${potentialAdults}</td></tr>
      <tr><th>Potential Kids:</th><td>${potentialKids}</td></tr>
    </table>
    <table class="user-table" border="1">
      <c:forEach var="user" items="${users}" varStatus="status">
        <c:choose>
          <c:when test="${user.attending.isYes}">
            <c:set var="rowClass" value="reply-yes"/>
          </c:when>
          <c:when test="${user.attending.isNo}">
            <c:set var="rowClass" value="reply-no"/>
          </c:when>
          <c:otherwise>
            <c:remove var="rowClass"/>
          </c:otherwise>
        </c:choose>
        <c:if test="${(status.count - 1) mod 10 == 0}">
		      <tr>
            <th>Id</th>
		        <th>Action</th>
            <th>Stats</th>
		        <th>Name</th>
		        <th>Display Name</th>
		        <th>Passcode</th>
		        <th>Admin</th>
		        <th>Attending</th>
		        <th>Max Adults</th>
		        <th>Max Kids</th>
		        <th>Num Adults</th>
		        <th>Num Kids</th>
		        <th>Email</th>
		        <th>Address</th>
		        <th>City</th>
		        <th>State</th>
		        <th>Zip</th>
		        <th>Comment</th>
		        <th>Gift</th>
		        <th>Thankyou?</th>
		      </tr>
        </c:if>
        <tr class="${rowClass}">
          <td>${user.id}</td>
          <td><a href="ViewUser?userId=${user.id}">Edit</a></td>
          <td><a href="ViewUserStats?userId=${user.id}">Stats</a></td>
          <td>${user.name}</td>
          <td>${user.displayName}</td>
          <td>${user.passCode}</td>
          <td>${user.writeAccess}</td>
          <td>${user.attending.description}</td>
          <td>${user.maxAdults}</td>
          <td>${user.maxKids}</td>
          <td>${user.numAdults}</td>
          <td>${user.numKids}</td>
          <td>${user.email}</td>
          <td>${user.address}</td>
          <td>${user.city}</td>
          <td>${user.state}</td>
          <td>${user.zip}</td>
          <td>${user.rsvpComment}</td>
          <td>${user.gift}</td>
          <td>${user.thankyou}</td>
        </tr>
      </c:forEach>
    </table>
  </body>
</html>
</jsp:root>
