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
        <h2>Thank you so much!</h2>
        <p>
          You've successfully contributed to our honeymoon!  A receipt for your
          purchase has been emailed to you.  If you used a PayPal account, you
          can log into <a href="http://www.paypal.com/us">your account</a> to view the
          details of your transaction.
        </p>
        <p>Thanks again!  We can't wait to see youat the wedding!</p>
        <p>Elizabeth and Ryan</p>
      </div>
      <jsp:directive.include file="footer.jsp"/>
    </div>
  </body>
</html>
</jsp:root>




