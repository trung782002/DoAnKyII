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
					<li class="breadcrumb-item"><a href="categoryManagement">Category
							management</a></li>
				</ul>
			</div>
		</div>
	</div>
</div>

<div class="container-fluid">
	<div class="row">
		<div class="col-6">

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

			<h4>List Categories</h4>
			<table class="table">
				<thead class="thead-dark">
					<tr>
						<th scope="col">Id</th>
						<th scope="col">Name</th>
						<th scope="col">Status</th>
						<th scope="col"></th>
					</tr>
				</thead>
				<tbody>
					<c:forEach items="${list}" var="list">
						<tr>
							<th scope="row">${list.cateId}</th>
							<td>${list.name}</td>
							<td style="color: ${list.status? "green" : "red"}">${list.status? "Show" : "Hidden"}</td>
							<td><a class="mr-3"
								href="getByIdCategory?CateId=${list.cateId}"><i
									class="fas fa-edit"></i></a><a
								href="deleteCategory?CateId=${list.cateId}"><i
									class="fas fa-trash text-danger"></i></a></td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
		</div>
		<div class="col-6">
			<h4>Add Category</h4>
			<form:form action="createCategory" method="post"
				modelAttribute="category">

				<label for="exampleInputEmail1">Category name</label>
				<form:input type="text" placeholder="Category name"
					class="form-control" path="name" />
				<form:errors path="name" style="color:red"></form:errors>
				<b style="color: red">${uniquename}</b>

				<div class="form-check mt-2">
					<form:radiobutton class="form-check-input" value="true"
						path="status" />
					<label class="form-check-label" for="gridRadios1">Show </label>
				</div>

				<div class="form-check mb-2">
					<form:radiobutton class="form-check-input" value="false"
						path="status" />
					<label class="form-check-label" for="gridRadios1">Hidden </label>
				</div>

				<input class="btn btn-outline-success" type="submit" value="Insert">

			</form:form>
		</div>
	</div>
</div>
<jsp:include page="../../layouts/footer.jsp" flush="true"></jsp:include>