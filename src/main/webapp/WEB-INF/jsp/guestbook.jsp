<jsp:root xmlns:jsp="http://java.sun.com/JSP/Page"
  xmlns:c="http://java.sun.com/jsp/jstl/core"
  xmlns:s="/struts-tags"
  version="2.1">
<jsp:directive.page contentType="text/html"/>
<html>
  <head>
    <jsp:directive.include file="shared-includes.jsp"/>
    <script type="text/javascript">
      <![CDATA[
	      function submitRsvpForm() {
	    	  var attendingVal = $("#user_attending")[0].value;
	    	  var numAdults = $("#user_numAdults")[0].value;
	    	  if (attendingVal == "YES" && numAdults == 0) {
	    		  alert("Please select how many adults before submitting.  Thanks!");
	    	  }
	    	  else if (attendingVal != "YES" && numAdults > 0) {
	    		  alert("Please answer Yes! or set number of adults to 0.  Thanks!");
	    	  }
	    	  else {
	    		  $("#rsvpForm")[0].submit();
	    	  }
	      }
      ]]>
    </script>
  </head>
  <body>
    <div id="t-container">
      <jsp:directive.include file="header.jsp"/>
      <div class="content-pane">
        <c:if test="${loggedIn}">
          <c:if test="${user.hasRsvped}">
            <c:set var="rsvpVisibility" value="display:none"/>
            <c:set var="rsvpToggleVisibility" value="display:block"/>
          </c:if>
          <c:if test="${not user.hasRsvped}">
            <c:set var="rsvpVisibility" value="display:block"/>
            <c:set var="rsvpToggleVisibility" value="display:none"/>
          </c:if>
          <!--
          <div id="rsvp-toggle-pane" style="${rsvpToggleVisibility}">
            <p>
              <form>
                Welcome ${user.displayName}!  To change your RSVP, 
                <input type="button" onclick="$('#rsvp-toggle-pane').toggle(100); $('#rsvp-pane').toggle(100)" value="Click Here"/>.
              </form>
            </p>
          </div>
          <div id="rsvp-pane" style="${rsvpVisibility}">
	          <p>
	            Welcome ${user.displayName}!  Please RSVP below.  We really hope you can come!<br/>
	            The RSVP comment is just for us and will not be posted in the guestbook.
	          </p>
	          <form id="rsvpForm" action="RsvpUpdate" method="post">
	            <c:if test="${user.maxAdults == 1}">
	              <input type="hidden" id="user_numAdults" name="user.numAdults" value="1"/>
	            </c:if>
	            <p>
	              <table cellpadding="2">
	                <tr>
	                  <td>Are you attending?</td>
	                  <td><s:select key="user.attending" list="rsvpTypes" listKey="name" listValue="description"/></td>
	                </tr>
	                <c:if test="${user.maxAdults > 1}">
		                <tr>
		                  <td>How many adults?</td>
		                  <td><s:select key="user.numAdults" list="user.adultList"/></td>
		                </tr>
	                </c:if>
	                <c:if test="${user.maxKids > 0}">
		                <tr>
		                  <td>How many children?</td>
		                  <td><s:select key="user.numKids" list="user.kidList"/></td>
		                </tr>
	                </c:if>
	                <tr>
	                  <td>Comments?</td>
	                  <td><s:textarea key="user.rsvpComment" cols="50" rows="4"/></td>
	                </tr>
	                <tr>
	                  <td> </td>
	                  <td><input type="button" value="Save RSVP" onclick="submitRsvpForm()"/></td>
	                </tr>
	              </table>
	            </p>
	          </form>
	          <hr/>
          </div>
          -->
          <form action="GuestbookPost" method="post">
            <p>
              Post in our guestbook!  We'd love to hear your funny/witty/ridiculous comments!
            </p>
            <p>
              <table cellpadding="2">
                <tr>
                  <td>Subject:</td>
                  <td><s:textfield key="newEntry.subject" size="40"/></td>
                </tr>
                <tr>
                  <td>Message:</td>
                  <td><s:textarea key="newEntry.message" cols="50" rows="4"/></td>
                </tr>
                <tr>
                  <td> </td>
                  <td><s:submit value="Post Guestbook Message"/></td>
                </tr>
              </table>
            </p>
          </form>
        </c:if>
        <c:if test="${not loggedIn}">
          <p>
            If you would like to <!-- RSVP or --> post in the guestbook, please <a href="Authenticate?requestUrl=Guestbook">log in</a>.
          </p>
        </c:if>
        <c:forEach var="entry" items="${entries}">
          <hr/>
          <table>
            <tr>
              <td>Date:</td>
              <td>${entry.date}</td>
            </tr>
            <tr>
              <td>From:</td>
              <td>${entry.user.name}</td>
            </tr>
            <tr>
              <td>Subject:</td>
              <td>${entry.subject}</td>
            </tr>
            <tr>
              <td>Message:</td>
              <td>${entry.messageHtml}</td>
            </tr>
          </table>
        </c:forEach>
      </div>
      <jsp:directive.include file="footer.jsp"/>
    </div>
  </body>
</html>
</jsp:root>
