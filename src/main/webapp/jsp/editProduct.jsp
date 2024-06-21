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
<%
	request.setAttribute("staticContentPath", TemplateUtil.getStaticContentPath());
%>
<head>
<meta charset="ISO-8859-1">
<link rel="stylesheet" href="${m:esc(staticContentPath)}/styles/bootstrap.min.css?cv=<%=TemplateUtil.getAPIVersion()%>">
<link rel="stylesheet" href="${m:esc(staticContentPath)}/styles/open-iconic-bootstrap.min.css?cv=<%=TemplateUtil.getAPIVersion()%>">
<link rel="stylesheet" href="${m:esc(staticContentPath)}/styles/demoCRUD.css?cv=<%=TemplateUtil.getAPIVersion()%>">
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
	<div class="title">
	<h1>Edit Product</h1>
	</div>
	<c:if test="${editProduct != null}">
		<form id="bulkForm" method="post" action="">
		<div class="form-create">
			<input style="display: none" type="text" name="productId" value="${editProduct.getOid()}"/>
			<div class="row name">
				<label class="col-5" for="productName">Product Name:</label>
				<div class="col-7"><input class="form-control" type="text" id="productName" name="productName" value="${editProduct.getName()}"/></div>
			</div>
			<div class="row description">
				<label class="col-5" for="productDescription">Product Description:</label>
				<div class="col-7"><input class="form-control" type="text" id="productDescription" name="productDescription" value="${editProduct.getDescription()}"/></div>
			</div>
			<div class="row price">
		      <span class="col-5"><label for="productPrice">Product Price:</label></span>
		      <div class="col-7"><input class="form-control" type="text" id="productPrice" name="productPrice" value="${editProduct.getValue('price').toString()}"/></div>
		    </div>
			<div class="button-group">
				<input class="button-create" type="button" value="Edit" onclick="button_onclick('demoApp/product/editProductSuccessful')" />
			</div>
			</div>
		</form>
	</c:if>
	<c:if test="${editProduct == null}">
		<p style="color:red">Product not found or an error occurred.</p>
	</c:if>
</body>
</html>