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
	<h2>Product Form</h2>
	</div>
	<form id="bulkForm" method="post" action="">
	  <div class="form-create">
	    <div class="row name">
	      <span class="col-5"><label for="productName">Product Name:</label></span>
	      <div class="col-7"><input class="form-control" type="text" id="productName" name="productName" /></div>
	    </div>
	    <div class="row description">
	      <span class="col-5"><label for="productDescription">Product Description:</label></span>
	      <div class="col-7"><input class="form-control" type="text" id="productDescription" name="productDescription" /></div>
	    </div>
	    <div class="row price">
	      <span class="col-5"><label for="productPrice">Product Price:</label></span>
	      <div class="col-7"><input class="form-control" type="number" id="productPrice" name="productPrice" /></div>
	    </div>
	    <div class="button-group">
	    <input class="button-create" type="button" value="Create" onclick="button_onclick('demoApp/product/inputProduct')" />
	    </div>
	  </div>
	</form>

</body>
</html>