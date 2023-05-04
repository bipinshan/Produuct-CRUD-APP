<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!doctype html>
<html lang="en">
  <head>
<%@include file="base.jsp"%>
  </head>
  <body>
<div class="container mt-3">
<div class="row">
<div class="col-md-6 offset-md-3">
<h1 class="text-center mb-3">Change Product Details</h1>
<div class="alert alert-danger" role="alert">
  <form:errors path="product.*"/>
</div>
<form action="${pageContext.request.contextPath }/handle-product" method="post">
<input type="hidden" value="${product.id}" name="id"/>
  <div class="form-group">
    <label for="name">Product Name</label>
    <input type="text" class="form-control" id="name"
    aria-describedby="emailHelp" placeholder="Enter the product name here" name="name" value="${product.name}">
  </div>
  <div class="form-group">
    <label for="description">Product Description</label>
    <textarea class="form-control" id="description"
    placeholder="Enter the product description" name="description" rows="5">${product.description}</textarea>
  </div>
  <div class="form-group">
    <label for="price">Product Price</label>
        <input type="text" class="form-control" id="price"
        aria-describedby="emailHelp" placeholder="Enter the product price here" name="price" value="${product.price}">
  </div>
   <div class="container text-center">
   <a href="${pageContext.request.contextPath }/" class="btn btn-outline-warning">Back</a>
  <button type="submit" class="btn btn-primary">Update</button>
  </div>
</form>
</div>
</div>
</div>
  </body>