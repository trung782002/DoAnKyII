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
					<li class="breadcrumb-item"><a href="insertProduct">Update
							product</a></li>
				</ul>
			</div>
		</div>
	</div>
</div>

<div class="container-fluid">
	<div class="row">
		<div class="col-12">
			<h4>Update Product</h4>
			<form:form action="updateProduct" method="post"
				modelAttribute="product" enctype="multipart/form-data">
				<form:input type="hidden" path="proId"/>
				<div class="row mt-3">
					<div class="col-3 ml-4">
						<h5>Product name</h5>
					</div>
					<div class="col-8">
						<form:input type="text" placeholder="Product name"
							class="form-control" path="name" />
						<form:errors path="name" style="color:red"></form:errors>
					</div>
				</div>

				<div class="row mt-3">
					<div class="col-3 ml-4">
						<h5>Product price</h5>
					</div>
					<div class="col-8">
						<form:input type="number" placeholder="Product price"
							class="form-control" path="price" />
						<form:errors path="price" style="color:red"></form:errors>
					</div>
				</div>

				<div class="row mt-3">
					<div class="col-3 ml-4">
						<h5>Product discount</h5>
					</div>
					<div class="col-8">
						<form:input type="number" placeholder="Product discount"
							class="form-control" path="discount" />
						<form:errors path="discount" style="color:red"></form:errors>
					</div>
				</div>

				<div class="row mt-3">
					<div class="col-3 ml-4">
						<h5>Product Image</h5>
					</div>
					<div class="col-8">
						<input type="file" class="form-control-file" 
							name="image" id="exampleFormControlFile1"> <img
							src="<c:url value="http://localhost:8080/Do-an-ky-2/resources"/>/image/${product.imageUrl}"
							alt="product" class="img-fluid img-thumbnail mt-3" width="10%">
							<form:input type="hidden" path="imageUrl"/>
					</div>
				</div>

				<div class="row mt-3">
					<div class="col-3 ml-4">
						<h5>Description Images</h5>
					</div>
					<div class="col-8">
						<input type="file" class="form-control-file" 
							name="images" id="exampleFormControlFile1" multiple>
						<c:forEach items="${productimages}" var="list">
							<img
								src="<c:url value="http://localhost:8080/Do-an-ky-2/resources"/>/image/${list.imageUrl}"
								alt="product" class="img-fluid img-thumbnail mt-3" width="10%">
						</c:forEach>
					</div>
				</div>

				<div class="row mt-3">
					<div class="col-3 ml-4">
						<h5>Category</h5>
					</div>
					<div class="col-8">
						<form:select class="custom-select mr-sm-2" path="cateId">
							<!-- <option selected>Choose...</option> -->
							<c:forEach items="${category}" var="list">
								<option ${list.cateId == product.cateId?"selected" : ""}  value="${list.cateId}">${list.name}</option>
							</c:forEach>
						</form:select>
						<form:errors path="cateId" style="color:red"></form:errors>
					</div>
				</div>

				<div class="row mt-3">
					<div class="col-3 ml-4">
						<h5>Brand</h5>
					</div>
					<div class="col-8">
						<form:select class="custom-select mr-sm-2" path="brandId">
							<!-- <option selected>Choose...</option> -->
							<c:forEach items="${brand}" var="list">
								<option ${list.brandId == product.brandId?"selected" : ""} value="${list.brandId}">${list.name}</option>
							</c:forEach>
						</form:select>
						<form:errors path="brandId" style="color:red"></form:errors>
					</div>
				</div>

				<div class="row mt-3">
					<div class="col-3 ml-4">
						<h5>Product shortDescription</h5>
					</div>
					<div class="col-8">
						<form:input type="" placeholder="Product shortDescription"
							class="form-control" path="shortDescription" />
						<form:errors path="shortDescription" style="color:red"></form:errors>
					</div>
				</div>

				<div class="row mt-3">
					<div class="col-3 ml-4">
						<h5>Product description</h5>
					</div>
					<div class="col-8">
						<form:input type="" placeholder="Product description"
							class="form-control" path="description" />
						<form:errors path="description" style="color:red"></form:errors>
					</div>
				</div>

				<div class="row mt-3">
					<div class="col-3 ml-4">
						<h5>Product quanity</h5>
					</div>
					<div class="col-8">
						<form:input type="number" placeholder="Product quanity"
							class="form-control" path="quanity" />
						<form:errors path="quanity" style="color:red"></form:errors>
					</div>
				</div>

				<div class="row mt-3">
					<div class="col-3 ml-4">
						<h5>Product Status</h5>
					</div>
					<div class="col-1">
						<div class="form-check mt-2">
							<form:radiobutton class="form-check-input" value="true"
								path="status" />
							<label class="form-check-label" for="gridRadios1">Show </label>
						</div>
					</div>
					<div class="col-1">
						<div class="form-check mt-2">
							<form:radiobutton class="form-check-input" value="false"
								path="status" />
							<label class="form-check-label" for="gridRadios1">Hidden
							</label>
						</div>
					</div>
				</div>

				<input class="btn btn-outline-success mt-4 ml-4" type="submit"
					value="Insert">

			</form:form>
		</div>
	</div>
</div>

<jsp:include page="../../layouts/footer.jsp" flush="true"></jsp:include>