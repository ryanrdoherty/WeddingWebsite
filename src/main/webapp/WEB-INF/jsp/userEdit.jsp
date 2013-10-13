<jsp:root xmlns:jsp="http://java.sun.com/JSP/Page"
  xmlns:c="http://java.sun.com/jsp/jstl/core"
  xmlns:s="/struts-tags"
  version="2.1">
<jsp:directive.page contentType="text/html" />
<html>
  <head>
    <title>Edit User Page</title>
    <link rel="stylesheet" type="text/css" href="css/backend.css"/>
  </head>
  <body>
    <h2>Edit User</h2>
    <div style="float:right;"><a href="Edit">Back to Admin Home</a></div>
    <form action="UpdateUser" method="post">
	    <table class="user-table">
	      <tr>
	        <th>Id</th>
	        <td><s:hidden key="user.id"/>${user.id}</td>
	      </tr>
	      <tr>
	        <th>Name</th>
	        <td><s:textfield width="50" key="user.name"/></td>
	      </tr>
	      <tr>
	        <th>Display Name</th>
	        <td><s:textfield width="50" key="user.displayName"/></td>
	      </tr>
	      <tr>
	        <th>Passcode</th>
	        <td><s:textfield width="50" key="user.passCode"/></td>
	      </tr>
	      <tr>
	        <th>Admin</th>
	        <td><s:checkbox key="user.writeAccess"/></td>
	      </tr>
	      <tr>
	        <th>Attending</th>
          <td><s:select key="user.attending" list="rsvpTypes" listKey="name" listValue="description"/></td>
	      </tr>
        <tr>
          <th>Max Adults</th>
          <td><s:textfield width="5" key="user.maxAdults"/></td>
        </tr>
        <tr>
          <th>Max Kids</th>
          <td><s:textfield width="5" key="user.maxKids"/></td>
        </tr>
	      <tr>
	        <th>Num Adults</th>
	        <td><s:textfield width="5" key="user.numAdults"/></td>
	      </tr>
	      <tr>
	        <th>Num Kids</th>
	        <td><s:textfield width="5" key="user.numKids"/></td>
	      </tr>
	      <tr>
	        <th>Email</th>
	        <td><s:textfield width="50" key="user.email"/></td>
	      </tr>
	      <tr>
	        <th>Address</th>
	        <td><s:textfield width="50" key="user.address"/></td>
	      </tr>
	      <tr>
	        <th>City</th>
	        <td><s:textfield width="40" key="user.city"/></td>
	      </tr>
	      <tr>
	        <th>State</th>
	        <td><s:select key="user.state" list="states" emptyOption="true" listKey="name" listValue="description"/></td>
	      </tr>
	      <tr>
	        <th>Zip</th>
	        <td><s:textfield width="10" key="user.zip"/></td>
	      </tr>
	      <tr>
	        <th>Comment</th>
	        <td><s:textfield width="100" key="user.rsvpComment"/></td>
	      </tr>
        <tr>
          <th>Gift</th>
          <td><s:textfield width="100" key="user.gift"/></td>
        </tr>
        <tr>
          <th>Thankyou?</th>
          <td><s:checkbox key="user.thankyou"/></td>
        </tr>
	      <tr>
	        <td colspan="2">
	          <input type="submit" value="Save"/>
	        </td>
	      </tr>
	    </table>
	  </form>
  </body>
</html>
</jsp:root>
