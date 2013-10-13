<div id="t-header">
  <div id="t-header-image" style="width:1014; height:544; text-transform: uppercase; background-image:url('images/homepage-bg-date.jpg');">
    <a id="home-invite-link" href="Invitation" style="position:absolute; top:140; left:330; width:350; height:290"></a>
    <a href="Ceremony" style="position:absolute; top:70px; left:457px">Ceremony</a>
    <a href="Schedule" style="position:absolute; top:107px; left:295px">Schedule</a>
    <a href="Guestbook" style="position:absolute; top:107px; left:627px"><!--RSVP/-->Guestbook</a>
    <a href="Accommodations" style="position:absolute; top:170px; left:202px">Hotels</a>
    <a href="Music" style="position:absolute; top:170px; left:717px">Music</a>
    <a href="Attractions" style="position:absolute; top:244px; left:157px">Attractions</a>
    <a href="Registry" style="position:absolute; top:244px; left:757px">Registry</a>
    <a href="Story" style="position:absolute; top:318px; left:182px">Our Story</a>
    <a href="Contact" style="position:absolute; top:318px; left:737px">Contact</a>
    <a href="Photos" style="position:absolute; top:392px; left:207px">Photo Gallery</a>
    <c:if test="${loggedIn}">
      <a href="Logout" style="position:absolute; top:392px; left:707px">Log Out</a>
    </c:if>
    <c:if test="${not loggedIn}">
      <a href="Authenticate" style="position:absolute; top:392px; left:707px">Log In</a>
    </c:if>
  </div>
  <div>
