<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<jsp:include page="../../layouts/header.jsp" flush="true"></jsp:include>

<div class="page-header col-12">
	<div class="page-block">
		<div class="row align-items-center">
			<div class="col-md-12">
				<div class="page-header-title">
					<h5 class="m-b-10">Form Elements</h5>
				</div>
				<ul class="breadcrumb">
					<li class="breadcrumb-item">
						<a href="admin"><i class="feather icon-home"></i></a>
					</li>
					<li class="breadcrumb-item"><a href="configuration">Configuration</a></li>
				</ul>
			</div>
		</div>
	</div>
</div>

<div class="row m-1 m-lg-3">
	<div class="col-12">
		<h3>ListConfig</h3>
		<c:forEach items="${list}" var="c">
			<a href="initUpdateConfig?id=${c.id}"><button type="button"
					class="btn btn-primary btn-sm">Update</button></a>
			<div class="mt-4">
				<h5 class="fw-bold mb-1">LogoImage</h5>
				<div>
					<img
						src="<c:url value="http://localhost:8080/Do-an-ky-2/resources"/>/image/${c.logoImage }"
						alt="brand" class="img-fluid img-thumbnail">
				</div>
			</div>
			<div class="mt-4">
				<h5 class="fw-bold mb-1">BannerImage</h5>
				<div>
					<img
						src="<c:url value="http://localhost:8080/Do-an-ky-2/resources"/>/image/${c.bannerImage }"
						alt="brand" class="img-fluid img-thumbnail">
				</div>
			</div>
			<div class="mt-4">
				<h5 class="fw-bold mb-1">Address</h5>
				<div>${c.address }</div>
			</div>
			<div class="mt-4">
				<h5 class="fw-bold mb-1">Map</h5>
				<div style="width: 100%;">${c.map }</div>
			</div>
			<div class="mt-4">
				<h5 class="fw-bold ">Email</h5>
				<div>${c.email }</div>
			</div>
			<div class="mt-4">
				<h5 class="fw-bold ">Phone</h5>
				<div>${c.phone }</div>
			</div>
		</c:forEach>
	</div>
</div>

<jsp:include page="../../layouts/footer.jsp" flush="true"></jsp:include>