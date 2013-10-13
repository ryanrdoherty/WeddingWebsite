<jsp:root xmlns:jsp="http://java.sun.com/JSP/Page"
  xmlns:c="http://java.sun.com/jsp/jstl/core"
  xmlns:s="/struts-tags"
  version="2.1">
<jsp:directive.page contentType="text/html"/>
<html>
  <head>
    <jsp:directive.include file="shared-includes.jsp"/>
  </head>
  <body>
    <div id="t-container">
      <jsp:directive.include file="header.jsp"/>
      <div class="content-pane">
        <h2>${title}</h2>
        ${data}
      </div>
      <jsp:directive.include file="footer.jsp"/>
    </div>
  </body>
</html>
</jsp:root>
