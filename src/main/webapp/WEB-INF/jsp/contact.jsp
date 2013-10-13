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
        <h2>Contact Us!</h2>
        <p>
          If you have any questions about anything, feel free to email, call, or
          use this handy form to send us a message.  Well try to get back to you
          soon.
        </p>
        <form action="ContactUpdate" method="post">
          <table cellpadding="2">
            <tr>
              <td>Subject:</td>
              <td><input name="subject" size="50"/></td>
            </tr>
            <tr>
              <td>Message:</td>
              <td><s:textarea name="message" rows="15" cols="50"/></td>
            </tr>
            <tr>
              <td> </td>
              <td><input type="submit" value="Send"/></td>
            </tr>
          </table>
        </form>
      </div>
      <jsp:directive.include file="footer.jsp"/>
    </div>
  </body>
</html>
</jsp:root>
