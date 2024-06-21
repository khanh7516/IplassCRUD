<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="m" uri="http://iplass.org/tags/mtp"%>
<%@ page import="org.iplass.mtp.entity.GenericEntity"%>
<%@ page import="org.iplass.mtp.entity.Entity"%>
<%@ page import="org.iplass.mtp.entity.SearchResult"%>
<%@ page import="org.iplass.mtp.command.RequestContext"%>
<%@ page import="org.iplass.mtp.web.template.TemplateUtil"%>
<%-- <%@ page import="demo.entity.Product"%> --%>
<%@ page import="demo.utils.URLHelper"%>
<%
  RequestContext context = TemplateUtil.getRequestContext();
  @SuppressWarnings("unchecked")
  SearchResult<Entity> productList = (SearchResult<Entity>) context.getAttribute("productList");
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
	<h1>Product List</h1>
	</div>
	<div class="table-container">	
	<table>
  <thead>
    <tr class="row">
    <th class=col-3>Image</th>
    <th class="col-2">Product Name</th>
    <th class="col-3">Product Description</th>
    <th class="col-2">Price</th>
    <th class="col-1">Edit</th>
	<th class="col-1">Delete</th>
    </tr>
  </thead>
  <tbody>
  <% for (Entity p : productList) { %>
    <tr class="row">
    <td class="col-3"> <img class="card-img-top img-thumbnail img-fluid all-product-img" src="<%= URLHelper.getProductImageResource(p) %>" alt="<%= p.getName() %>"></td>
    <td class="col-2"><%= p.getName() %></td>
    <td class="col-3"><%= p.getDescription() %></td>
    <td class="col-2"><%= p.getValue("price") != null ? p.getValue("price").toString() : "" %></td>
    <td class="col-1"><a href="<%= URLHelper.getProductEditPath(p.getOid().toString()) %>">Edit</a></td>
    <td class="col-1"><a href="<%= URLHelper.getProductDeletePath(p.getOid().toString()) %>">Delete</a></td>
    </tr>
   <%}%>
  </tbody>
</table>
<div class="button-group">
	<a class="button-create" href="${m:tcPath()}/demoApp/product/displayCreateProductPage">Create New Product</a>
</div>
</div>

</body>
</html>