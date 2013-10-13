<jsp:root xmlns:jsp="http://java.sun.com/JSP/Page"
  xmlns:c="http://java.sun.com/jsp/jstl/core"
  xmlns:s="/struts-tags"
  version="2.1">
<jsp:directive.page contentType="text/html" />
<html>
  <head>
    <title>Content Edit Page</title>
  </head>
  <body>
    <h2>Content Editing Page</h2>
    <div style="float:right;"><a href="Edit">Back to Admin Home</a></div>
    <form action="ContentUpdate" method="post">
      Simply edit the contained HTML and click "Save All" at any point.
      <hr/>
      <h4>Ceremony Page</h4>
      <textarea name="ceremonyData" rows="25" cols="100">${ceremonyData}</textarea><br/>
      <input type="submit" value="Save All"/>
      <hr/>
      <h4>Schedule Page</h4>
      <textarea name="scheduleData" rows="25" cols="100">${scheduleData}</textarea><br/>
      <input type="submit" value="Save All"/>
      <hr/>
      <h4>Accommodations Page</h4>
      <textarea name="hotelData" rows="25" cols="100">${hotelData}</textarea><br/>
      <input type="submit" value="Save All"/>
      <hr/>
      <h4>Attractions Page</h4>
      <textarea name="attractionData" rows="25" cols="100">${attractionData}</textarea><br/>
      <input type="submit" value="Save All"/>
      <hr/>
      <h4>Story Page</h4>
      <textarea name="storyData" rows="25" cols="100">${storyData}</textarea><br/>
      <input type="submit" value="Save All"/>
      <hr/>
      <h4>Photo Page</h4>
      <textarea name="photoData" rows="25" cols="100">${photoData}</textarea><br/>
      <input type="submit" value="Save All"/>
    </form>
  </body>
</html>
</jsp:root>