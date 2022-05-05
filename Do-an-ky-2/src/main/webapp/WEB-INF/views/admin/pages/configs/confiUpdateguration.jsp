<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<jsp:include page="../../layouts/header.jsp" flush="true"></jsp:include>
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
					<li class="breadcrumb-item"><a href="configuration">Configuration</a></li>
					<li class="breadcrumb-item"><a href="insertProduct">UpdateConfig</a></li>
				</ul>
			</div>
		</div>
	</div>
</div>
<div class="container-fluid">
	<div class="row">
		<h3>Update Config</h3>
		<h3 style="color: red">${error}</h3>
		<div class="card-body">
			<form:form method="post" action="updateConfig"
				modelAttribute="config" class="main-form full"
				enctype="multipart/form-data">
				<form:input path="id" type="hidden" readonly="readonly" />

				<div class="row">
					<div class="col-12">
						<div class="input-box form-group">
							<div class="row">
								<label for="product-tags" class="col-md-3 control-label">logoImage
								</label>
								<div class="col-md-9">
									<input type="file" name="img" class="form-control-file"
										id="exampleFormControlFile1"><img
										src="<c:url value="http://localhost:8080/Do-an-ky-2/resources"/>/image/${config.logoImage}"
										alt="config" class="img-fluid img-thumbnail">
									<form:input path="logoImage" type="hidden" />
								</div>

							</div>
						</div>
					</div>
					<div class="col-12">
						<div class="input-box form-group">
							<div class="row">
								<label for="product-tags" class="col-md-3 control-label">bannerImage
								</label>
								<div class="col-md-9">
									<input type="file" name="img1" class="form-control-file"
										id="exampleFormControlFile1"><img
										src="<c:url value="http://localhost:8080/Do-an-ky-2/resources"/>/image/${config.bannerImage}"
										alt="config" class="img-fluid img-thumbnail">
									<form:input path="bannerImage" type="hidden" />
								</div>

							</div>
						</div>
					</div>
					<div class="col-12">
						<div class="input-box form-group required">
							<div class="row">
								<label for="p-name" class="col-md-3 control-label">address</label>
								<div class="col-md-9">
									<form:input type="text" class="form-control"
										 path="address"/>
										
									<form:errors path="address" style="color:red"></form:errors>
								</div>
							</div>
						</div>
					</div>
					<div class="col-12">
						<div class="input-box form-group required">
							<div class="row">
								<label for="p-name" class="col-md-3 control-label">map</label>
								<div class="col-md-9">
									<form:input type="text" class="form-control"
										placeholder="map" path="map" />
									<form:errors path="map" style="color:red"></form:errors>
								</div>
							</div>
						</div>
					</div>
					<div class="col-12">
						<div class="input-box form-group required">
							<div class="row">
								<label for="p-name" class="col-md-3 control-label">email</label>
								<div class="col-md-9">
									<form:input type="text" class="form-control"
										placeholder="email" path="email" />
									<form:errors path="email" style="color:red"></form:errors>
								</div>
							</div>
						</div>
					</div>
					<div class="col-12">
						<div class="input-box form-group required">
							<div class="row">
								<label for="p-name" class="col-md-3 control-label">phone</label>
								<div class="col-md-9">
									<form:input type="text" class="form-control"
										placeholder="phone" path="phone" />
									<form:errors path="phone" style="color:red"></form:errors>
								</div>
							</div>
						</div>
					</div>
					<input type="submit" value="update">
				</div>
			</form:form>
		</div>
	</div>
</div>

<jsp:include page="../../layouts/footer.jsp" flush="true"></jsp:include>