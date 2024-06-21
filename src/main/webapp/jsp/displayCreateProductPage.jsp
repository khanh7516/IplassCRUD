<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="m" uri="http://iplass.org/tags/mtp"%>
<%@ page import="org.iplass.mtp.entity.GenericEntity"%>
<%@ page import="org.iplass.mtp.entity.Entity"%>
<%@ page import="org.iplass.mtp.entity.SearchResult"%>
<%@ page import="org.iplass.mtp.command.RequestContext"%>
<%@ page import="org.iplass.mtp.web.template.TemplateUtil"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<script type="text/javascript" src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
<script type="text/javascript">
function button_onclick(action) {
    var $form = $("#bulkForm");
    $form.attr("action", "${m:tcPath()}/" + action).submit();
}
</script>

</head>
<body>

	<h2>Product Form</h2>
	<form id="bulkForm" method="post" action="">
	  <table>
	    <tr>
	      <td><label for="productName">Product Name:</label></td>
	      <td><input type="text" id="productName" name="productName" /></td>
	    </tr>
	    <tr>
	      <td><label for="productDescription">Product Description:</label></td>
	      <td><input type="text" id="productDescription" name="productDescription" /></td>
	    </tr>
	  </table>
	  <input type="button" value="Create" onclick="button_onclick('demoApp/product/inputProduct')" />
	</form>

</body>
</html>