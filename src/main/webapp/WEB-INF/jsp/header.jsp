<div id="t-header">
  <div id="t-header-image" style="width:1014; height:201; background-image:url('images/page-bg-date.jpg');">
  </div>
</div>
<div id="menu-container">
<div id="leftnav">
  <a href="Home">Home</a>
  <a href="Invitation">Invitation</a>
  <a href="Ceremony">Ceremony</a>
  <a href="Schedule">Schedule</a>
  <a href="Accommodations">Hotels</a>
  <a href="Attractions">Attractions</a>
  <a href="Story">Our Story</a>
  <a href="Photos">Photo Gallery</a>
  <a href="Music">Music</a>
  <a href="Guestbook"><!--RSVP/-->Guestbook</a>
  <a href="Registry">Registry</a>
  <a href="Contact">Contact</a>
  <c:if test="${loggedIn}">
    <a href="Logout">Log Out</a>
  </c:if>
  <c:if test="${not loggedIn}">
    <a href="Authenticate">Log In</a>
  </c:if>
  <c:if test="${isAdmin}">
    <a href="Edit">Administration</a>
  </c:if>
 </div>
	<style>
	#leftnav {
	  float: left; width: 160px; padding-left: 50px; padding-top:20px
	}
	#leftnav a {
	  display:block;
	  margin-bottom:8px;
	}
	#leftnav a:hover {
	  text-decoration: underline;
	}
	</style>
  <div class="min-height-div">
