<jsp:root xmlns:jsp="http://java.sun.com/JSP/Page"
  xmlns:c="http://java.sun.com/jsp/jstl/core"
  xmlns:s="/struts-tags"
  version="2.1">
<jsp:directive.page contentType="text/html" />
<html>
  <head>
    <meta name="ROBOTS" content="NOINDEX, NOFOLLOW, NOARCHIVE, NOSNIPPET, NOODP"/>
    <title>Welcome to our WedSite!</title>
    <script type="text/javascript" src="js/lib/jquery.js"><jsp:text/></script>
    <script type="text/javascript">
      $(function(){
        document.authForm.passcode.focus();
      });
    </script>
  </head>
  <body>
    <div style="margin:auto; text-align:center; width:100%; top:80px">
      &#160;<br/>
      &#160;<br/>
      &#160;<br/>
      <img src="images/cartoon-b-and-g5b.jpg"/>
      <h3>Welcome to our WedSite!</h3>
      <p>
        Please enter the passcode you received in your invitation.
      </p>
      <c:if test="${not empty message}">
        <span class="error">${message}</span>
      </c:if>
      <form name="authForm" action="Authenticate" method="post">
        <p>
          <input type="hidden" name="requestUrl" value="${requestUrl}"/>
          Passcode: <input name="passcode" type="text" size="25"/> <input type="submit" value="Go!"/>
          or <input type="button" onclick="document.location='Home';" value="Skip"/>
        </p>
      </form>
    </div>
  </body>
</html>
</jsp:root>
