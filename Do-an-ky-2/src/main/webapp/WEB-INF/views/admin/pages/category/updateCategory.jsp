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
			<h4>Update Category</h4>
			<form:form action="updateCategory" method="post"
				modelAttribute="category">
				<input type="hidden" name="name1" value="${name1}">
				<label for="exampleInputEmail1">Category name</label>
				<form:input path="cateId" type="hidden"/>
				<form:input type="text" placeholder="Category name"
					class="form-control" path="name" />
				<form:errors path="name" style="color:red"></form:errors>
				<b style="color:red">${uniquename}</b>
				<div class="form-check mt-2">
					<form:radiobutton class="form-check-input" 
						value="true" path="status" />
					<label class="form-check-label" for="gridRadios1">Show </label>
				</div>
				
				<div class="form-check mb-2">
					<form:radiobutton class="form-check-input" 
						value="false" path="status" />
					<label class="form-check-label" for="gridRadios1">Hidden </label>
				</div>
				
                <input class="btn btn-outline-success" type="submit" value="Update">
                
			</form:form>
		</div>
	</div>
</div>
<jsp:include page="../../layouts/footer.jsp" flush="true"></jsp:include>