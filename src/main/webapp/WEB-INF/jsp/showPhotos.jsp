<jsp:root xmlns:jsp="http://java.sun.com/JSP/Page"
  xmlns:c="http://java.sun.com/jsp/jstl/core"
  xmlns:s="/struts-tags"
  version="2.1">
<jsp:directive.page contentType="text/html" />
<html>
  <head>
    <title>Photo Library</title>
  </head>
  <body>
    <h2>Photo Library</h2>
    <div style="float:right;"><a href="Edit">Back to Admin Home</a></div>
    <p>
      To upload another photo, browse and click "Upload".<br/>
      <form action="UploadPhoto" method="post" enctype="multipart/form-data">
        <s:file name="photo"/>
        <input type="submit" value="Upload"/>
      </form>
    </p>
    <table border="1">
      <tr>
        <th>Name</th>
        <th>Thumbnail</th>
      </tr>
      <c:forEach var="photo" items="${photos}">
        <tr>
          <td>/images/${photo}</td>
          <td><a href="/images/${photo}"><img height="25" src="/images/${photo}"/></a></td>
        </tr>
      </c:forEach>
    </table>
  </body>
</html>
</jsp:root>
