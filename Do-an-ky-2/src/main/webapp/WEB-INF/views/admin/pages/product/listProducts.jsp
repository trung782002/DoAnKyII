<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<jsp:include page="../../layouts/header.jsp" flush="true"></jsp:include>

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
					<li class="breadcrumb-item"><a href="listProducts">List
							products</a></li>
				</ul>
			</div>
		</div>
	</div>
</div>

<div class="container-fluid">
	<div class="row">
		<div class="col-12">
			<c:if test="${not empty success}">
				<div class="alert alert-success alert-dismissible fade show"
					role="alert">
					<strong>${success}</strong>
					<button type="button" class="close" data-dismiss="alert"
						aria-label="Close">
						<span aria-hidden="true">&times;</span>
					</button>
				</div>
			</c:if>

			<c:if test="${not empty errors}">
				<div class="alert alert-danger alert-dismissible fade show"
					role="alert">
					<strong>${errors}</strong>
					<button type="button" class="close" data-dismiss="alert"
						aria-label="Close">
						<span aria-hidden="true">&times;</span>
					</button>
				</div>
			</c:if>
			<h4>List Products</h4>
			<form method="get" action="searchProduct">
				<div class="row mb-4">
					<div class="col-3">
						<input type="text" class="form-control" name="Name">
					</div>
					<div class="col-3">
						<button type="submit" class="btn btn-primary">
							<i class="fas fa-search"></i>
						</button>
					</div>
				</div>
			</form>
			<table class="table">
				<thead class="thead-dark">
					<tr>
						<th scope="col" width="12%">Name</th>
						<th scope="col" width="10%">ImageUrl</th>
						<th scope="col">Price</th>
						<th scope="col">Discount</th>
						<th scope="col">CateId</th>
						<th scope="col">BrandId</th>
						<th scope="col">Quanity</th>
						<th scope="col">Status</th>
						<th></th>
					</tr>
				</thead>
				<tbody>
					<c:forEach items="${list}" var="list">
						<tr>
							<td>${list.name}</td>
							<td><img
								src="<c:url value="http://localhost:8080/Do-an-ky-2/resources"/>/image/${list.imageUrl}"
								alt="product" class="img-fluid img-thumbnail" width="100%"></td>
							<td>${list.price}</td>
							<td>${list.discount}</td>
						    <c:forEach items="${categories}" var="category">
								<c:if test="${list.cateId == category.cateId}">
									<td>${category.name}</td>
								</c:if>
							</c:forEach>
							<c:forEach items="${brands}" var="brand">
								<c:if test="${list.brandId == brand.brandId}">
									<td>${brand.name}</td>
								</c:if>
							</c:forEach>
							<td>${list.quanity}</td>
							<td style="color: ${list.status == 2? "red" : "#6699FF"} ">${list.status == 1? "Show" : "Hidden"}</td>
							<td> <a class="mr-3" href="getByIdProduct?ProId=${list.proId}"> <i
									class="fas fa-edit"></i>
							     </a>
							     <a class="mr-3" href="deleteProduct?ProId=${list.proId}">
									<i class="fas fa-backspace text-danger"></i>
							     </a>
							</td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
		</div>
	</div>
</div>

<jsp:include page="../../layouts/footer.jsp" flush="true"></jsp:include>