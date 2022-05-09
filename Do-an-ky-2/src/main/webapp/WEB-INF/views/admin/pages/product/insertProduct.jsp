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
					<li class="breadcrumb-item"><a href="createProduct">Add
							product</a></li>
				</ul>
			</div>
		</div>
	</div>
</div>

<div class="container-fluid">
	<div class="row">
		<div class="col-12">
			<h4>Add Product</h4>
			<form:form action="insertProduct" method="post"
				modelAttribute="product" enctype="multipart/form-data">
				<div class="row mt-3">
					<div class="col-2 ml-4">
						<h5> Name</h5>
					</div>
					<div class="col-9">
						<form:input type="text" placeholder="Product name"
							class="form-control" path="name" />
						<form:errors path="name" class="text-danger mt-2 d-block"></form:errors>
					</div>
				</div>

				<div class="row mt-3">
					<div class="col-2 ml-4">
						<h5>Price</h5>
					</div>
					<div class="col-9">
						<form:input type="number" min="0" placeholder="Product price"
							class="form-control" path="price" />
						<form:errors path="price" class="text-danger mt-2 d-block"></form:errors>
					</div>
				</div>

				<div class="row mt-3">
					<div class="col-2 ml-4">
						<h5>Discount</h5>
					</div>
					<div class="col-9">
						<form:input type="number" min="0" placeholder="Product discount"
							class="form-control" path="discount"/>
						<span class="text-danger mt-2 d-block">${discount}</span>
					</div>
				</div>

				<div class="row mt-3">
					<div class="col-2 ml-4">
						<h5>Image</h5>
					</div>
					<div class="col-9">
						<input type="file" class="form-control-file" 
							name="image" id="exampleFormControlFile1">
							<span class="text-danger mt-2 d-block">${ImageNull}</span>
					</div>
				</div>

				<div class="row mt-3">
					<div class="col-2 ml-4">
						<h5>Related photos</h5>
					</div>
					<div class="col-9">
						<input type="file" class="form-control-file" 
							name="images" id="exampleFormControlFile1" multiple>
					</div>
				</div>

				<div class="row mt-3">
					<div class="col-2 ml-4">
						<h5>Category</h5>
					</div>
					<div class="col-9">
						<form:select class="custom-select mr-sm-2" path="cateId">
							<!-- <option selected>Choose...</option> -->
							<c:forEach items="${category}" var="list">
								<option value="${list.cateId}">${list.name}</option>
							</c:forEach>
						</form:select>
						<form:errors path="cateId" class="text-danger mt-2 d-block"></form:errors>
					</div>
				</div>

				<div class="row mt-3">
					<div class="col-2 ml-4">
						<h5>Brand</h5>
					</div>
					<div class="col-9">
						<form:select class="custom-select mr-sm-2" path="brandId">
							<!-- <option selected>Choose...</option> -->
							<c:forEach items="${brand}" var="list">
								<option value="${list.brandId}">${list.name}</option>
							</c:forEach>
						</form:select>
						<form:errors path="brandId" class="text-danger mt-2 d-block"></form:errors>
					</div>
				</div>

				<div class="row mt-3">
					<div class="col-2 ml-4">
						<h5>Short description</h5>
					</div>
					<div class="col-9">
						<form:textarea path="shortDescription" />
						<form:errors path="shortDescription" class="text-danger mt-2 d-block"></form:errors>
					</div>
				</div>

				<div class="row mt-3">
					<div class="col-2 ml-4">
						<h5>Description</h5>
					</div>
					<div class="col-9">
						<form:textarea path="description" />
						<form:errors path="description" class="text-danger mt-2 d-block"></form:errors>
					</div>
				</div>

				<div class="row mt-3">
					<div class="col-2 ml-4">
						<h5>Quanity</h5>
					</div>
					<div class="col-9">
						<form:input type="number" min="1" placeholder="Product quanity"
							class="form-control" path="quanity" />
						<form:errors path="quanity" class="text-danger mt-2 d-block"></form:errors>
					</div>
				</div>

				<div class="row mt-3">
					<div class="col-2 ml-4">
						<h5>Status</h5>
					</div>
					<div class="col-1">
						<div class="form-check mt-2">
							<form:radiobutton class="form-check-input" value="1"
								path="status"/>
							<label class="form-check-label" for="gridRadios1">Show </label>
						</div>
					</div>
					<div class="col-1">
						<div class="form-check mt-2">
							<form:radiobutton class="form-check-input" value="2"
								path="status" checked="checked"/>
							<label class="form-check-label" for="gridRadios1">Hidden
							</label>
						</div>
					</div>
				</div>

				<input class="btn btn-success mt-4 ml-4" type="submit"
					value="Insert">
			</form:form>
		</div>
	</div>
</div>

<jsp:include page="../../layouts/footer.jsp" flush="true"></jsp:include>