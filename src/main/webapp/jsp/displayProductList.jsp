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
	<h1>Product List</h1>	
	<table>
  <thead>
    <tr>
    <th>Product Name</th>
    <th>Product Description</th>
    <th>Edit</th>
	<th>Delete</th>
    </tr>
  </thead>
  <tbody>
  <% for (Entity p : productList) { %>
    <tr>
    <td><%= p.getName() %></td>
    <td><%= p.getDescription() %></td>
    <td><a href="<%= URLHelper.getProductEditPath(p.getOid().toString()) %>">Edit</a></td>
    <td><a href="<%= URLHelper.getProductDeletePath(p.getOid().toString()) %>">Delete</a></td>
    </tr>
   <%}%>
  </tbody>
</table>

<a href="${m:tcPath()}/demoApp/product/displayCreateProductPage">Create New Product</a>

</body>
</html>