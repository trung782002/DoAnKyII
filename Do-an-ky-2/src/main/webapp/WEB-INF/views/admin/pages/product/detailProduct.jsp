<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<jsp:include page="../../layouts/header.jsp" flush="true"></jsp:include>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<div class="page-header col-12">
	<div class="page-block">
		<div class="row align-items-center">
			<div class="col-md-12">
				<div class="page-header-title">
					<h5 class="m-b-10">Form Elements</h5>
				</div>
				<ul class="breadcrumb">
					<li class="breadcrumb-item"><a href="admin"><i
							class="feather icon-home"></i></a></li>
					<li class="breadcrumb-item">Product management</li>
					<li class="breadcrumb-item"><a href="insertProduct">Detail
							product</a></li>
				</ul>
			</div>
		</div>
	</div>
</div>

<div class="container-fluid">
	<div class="row">
		<div class="col-1"></div>
		<div class="col-6">
			<img
				src="<c:url value="http://localhost:8080/Do-an-ky-2/resources"/>/image/${product.imageUrl}"
				alt="product" class="img-fluid img-thumbnail " width="90%">
		</div>
		<div class="col-4">
			<h4>Name : ${product.name}</h4>
			<h4 class="mt-4">Price : ${product.price}</h4>
			<h4 class="mt-4">Discount : ${product.discount}</h4>
			<b class="mt4"> Short Description : ${product.shortDescription}</b><br>
			<b class="mt-4">Category : ${product.cateId}</b><br> <b
				class="mt-4">Brand : ${product.brandId}</b><br> <b class="mt-4">Quanity
				: ${product.quanity}</b>
		</div>
	</div>
	<div class="row">
		<div class="col-1"></div>
		<div class="col-6">
			<c:forEach items="${productimages}" var="list">
				<img
					src="<c:url value="http://localhost:8080/Do-an-ky-2/resources"/>/image/${list.imageUrl}"
					alt="product" class="img-fluid img-thumbnail mt-3" width="20%">
			</c:forEach>
		</div>
		<div class="col-4">
			<b>Description : ${product.description}</b>
		</div>
	</div>
</div>

<jsp:include page="../../layouts/footer.jsp" flush="true"></jsp:include>