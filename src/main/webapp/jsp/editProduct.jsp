<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="m" uri="http://iplass.org/tags/mtp"%>
<%@ page import="org.iplass.mtp.entity.GenericEntity"%>
<%@ page import="org.iplass.mtp.entity.Entity"%>
<%@ page import="org.iplass.mtp.entity.SearchResult"%>
<%@ page import="org.iplass.mtp.command.RequestContext"%>
<%@ page import="org.iplass.mtp.web.template.TemplateUtil"%>

<%
  RequestContext context = TemplateUtil.getRequestContext();
/*   @SuppressWarnings("unchecked") */
  Entity editProduct = (Entity) context.getAttribute("editProduct");
%>

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
	<h1>Edit Product</h1>
	<c:if test="${editProduct != null}">
		<form id="bulkForm" method="post" action="">
			<input type="hidden" name="productId" value="${editProduct.getOid()}"/>
			<div>
				<label for="productName">Product Name:</label>
				<input type="text" id="productName" name="productName" value="${editProduct.getName()}"/>
			</div>
			<div>
				<label for="productDescription">Product Description:</label>
				<input type="text" id="productDescription" name="productDescription" value="${editProduct.getDescription()}"/>
			</div>
			<div>
				<input type="button" value="Edit" onclick="button_onclick('demoApp/product/editProductSuccessful')" />
			</div>
		</form>
	</c:if>
	<c:if test="${editProduct == null}">
		<p style="color:red">Product not found or an error occurred.</p>
	</c:if>
</body>
</html>