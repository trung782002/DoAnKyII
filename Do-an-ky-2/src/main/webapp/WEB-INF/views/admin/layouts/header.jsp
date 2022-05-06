<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<head>
<title>Eiser admin</title>
<meta charset="UTF-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1.0, user-scalable=0, minimal-ui">
<meta http-equiv="X-UA-Compatible" content="IE=edge" />
<!-- Favicon icon -->
<link rel="icon" href="${pageContext.request.contextPath}/<c:url value="assets"/>/admin/images/favicon.ico"
	type="image/x-icon">

<!-- vendor css -->
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/<c:url value="assets"/>/admin/css/style.css">
</head>

<body>
	<!-- [ Pre-loader ] start -->
	<div class="loader-bg">
		<div class="loader-track">
			<div class="loader-fill"></div>
		</div>
	</div>
	<!-- [ Pre-loader ] End -->

	<jsp:include page="../layouts/sidebar.jsp" flush="true"></jsp:include>

	<!-- [ Header ] start -->
	<header
		class="navbar pcoded-header navbar-expand-lg navbar-light header-dark">
		<div class="m-header">
			<a class="mobile-menu" id="mobile-collapse" href="#!"><span></span></a>
			<a href="#!" class="b-brand"> <!-- ========   change your logo hear   ============ -->
				<img src="${pageContext.request.contextPath}/<c:url value="assets"/>/admin/images/logo.png" alt=""
				class="logo"> <img
				src="${pageContext.request.contextPath}/<c:url value="assets"/>/admin/images/logo-icon.png" alt=""
				class="logo-thumb">
			</a> <a href="#!" class="mob-toggler"> <i
				class="feather icon-more-vertical"></i>
			</a>
		</div>
		<div class="collapse navbar-collapse">
			<ul class="navbar-nav mr-auto">

				<li class="nav-item">
					<div class="dropdown">
						<a class="dropdown-toggle h-drop" href="#" data-toggle="dropdown">
							Dropdown </a>
						<div class="dropdown-menu profile-notification ">
							<ul class="pro-body">
								<li><a href="user-profile.html" class="dropdown-item"><i
										class="fas fa-circle"></i> Profile</a></li>
								<li><a href="email_inbox.html" class="dropdown-item"><i
										class="fas fa-circle"></i> My Messages</a></li>
								<li><a href="auth-signin.html" class="dropdown-item"><i
										class="fas fa-circle"></i> Lock Screen</a></li>
							</ul>
						</div>
					</div>
				</li>
				<li class="nav-item">
					<div class="dropdown mega-menu">
						<a class="dropdown-toggle h-drop" href="#" data-toggle="dropdown">
							Mega </a>
						<div class="dropdown-menu profile-notification ">
							<div class="row no-gutters">
								<div class="col">
									<h6 class="mega-title">UI Element</h6>
									<ul class="pro-body">
										<li><a href="#!" class="dropdown-item"><i
												class="fas fa-circle"></i> Alert</a></li>
										<li><a href="#!" class="dropdown-item"><i
												class="fas fa-circle"></i> Button</a></li>
										<li><a href="#!" class="dropdown-item"><i
												class="fas fa-circle"></i> Badges</a></li>
										<li><a href="#!" class="dropdown-item"><i
												class="fas fa-circle"></i> Cards</a></li>
										<li><a href="#!" class="dropdown-item"><i
												class="fas fa-circle"></i> Modal</a></li>
										<li><a href="#!" class="dropdown-item"><i
												class="fas fa-circle"></i> Tabs & pills</a></li>
									</ul>
								</div>
								<div class="col">
									<h6 class="mega-title">Forms</h6>
									<ul class="pro-body">
										<li><a href="#!" class="dropdown-item"><i
												class="feather icon-minus"></i> Elements</a></li>
										<li><a href="#!" class="dropdown-item"><i
												class="feather icon-minus"></i> Validation</a></li>
										<li><a href="#!" class="dropdown-item"><i
												class="feather icon-minus"></i> Masking</a></li>
										<li><a href="#!" class="dropdown-item"><i
												class="feather icon-minus"></i> Wizard</a></li>
										<li><a href="#!" class="dropdown-item"><i
												class="feather icon-minus"></i> Picker</a></li>
										<li><a href="#!" class="dropdown-item"><i
												class="feather icon-minus"></i> Select</a></li>
									</ul>
								</div>
								<div class="col">
									<h6 class="mega-title">Application</h6>
									<ul class="pro-body">
										<li><a href="#!" class="dropdown-item"><i
												class="feather icon-mail"></i> Email</a></li>
										<li><a href="#!" class="dropdown-item"><i
												class="feather icon-clipboard"></i> Task</a></li>
										<li><a href="#!" class="dropdown-item"><i
												class="feather icon-check-square"></i> To-Do</a></li>
										<li><a href="#!" class="dropdown-item"><i
												class="feather icon-image"></i> Gallery</a></li>
										<li><a href="#!" class="dropdown-item"><i
												class="feather icon-help-circle"></i> Helpdesk</a></li>
									</ul>
								</div>
								<div class="col">
									<h6 class="mega-title">Extension</h6>
									<ul class="pro-body">
										<li><a href="#!" class="dropdown-item"><i
												class="feather icon-file-plus"></i> Editor</a></li>
										<li><a href="#!" class="dropdown-item"><i
												class="feather icon-file-minus"></i> Invoice</a></li>
										<li><a href="#!" class="dropdown-item"><i
												class="feather icon-calendar"></i> Full calendar</a></li>
										<li><a href="#!" class="dropdown-item"><i
												class="feather icon-upload-cloud"></i> File upload</a></li>
										<li><a href="#!" class="dropdown-item"><i
												class="feather icon-scissors"></i> Image cropper</a></li>
									</ul>
								</div>
							</div>
						</div>
					</div>
				</li>
			</ul>
			<ul class="navbar-nav ml-auto">
				<li>
					<div class="dropdown">
						<a class="dropdown-toggle" href="#" data-toggle="dropdown"> <i
							class="icon feather icon-bell"></i> <span
							class="badge badge-pill badge-danger">5</span>
						</a>
						<div class="dropdown-menu dropdown-menu-right notification">
							<div class="noti-head">
								<h6 class="d-inline-block m-b-0">Notifications</h6>
								<div class="float-right">
									<a href="#!" class="m-r-10">mark as read</a> <a href="#!">clear
										all</a>
								</div>
							</div>
							<ul class="noti-body">
								<li class="n-title">
									<p class="m-b-0">NEW</p>
								</li>
								<li class="notification">
									<div class="media">
										<img class="img-radius"
											src="${pageContext.request.contextPath}/<c:url value="assets"/>/admin/images/user/avatar-1.jpg"
											alt="Generic placeholder image">
										<div class="media-body">
											<p>
												<strong>John Doe</strong><span class="n-time text-muted"><i
													class="icon feather icon-clock m-r-10"></i>5 min</span>
											</p>
											<p>New ticket Added</p>
										</div>
									</div>
								</li>
								<li class="n-title">
									<p class="m-b-0">EARLIER</p>
								</li>
								<li class="notification">
									<div class="media">
										<img class="img-radius"
											src="${pageContext.request.contextPath}/<c:url value="assets"/>/admin/images/user/avatar-2.jpg"
											alt="Generic placeholder image">
										<div class="media-body">
											<p>
												<strong>Joseph William</strong><span
													class="n-time text-muted"><i
													class="icon feather icon-clock m-r-10"></i>10 min</span>
											</p>
											<p>Prchace New Theme and make payment</p>
										</div>
									</div>
								</li>
								<li class="notification">
									<div class="media">
										<img class="img-radius"
											src="${pageContext.request.contextPath}/<c:url value="assets"/>/admin/images/user/avatar-1.jpg"
											alt="Generic placeholder image">
										<div class="media-body">
											<p>
												<strong>Sara Soudein</strong><span class="n-time text-muted"><i
													class="icon feather icon-clock m-r-10"></i>12 min</span>
											</p>
											<p>currently login</p>
										</div>
									</div>
								</li>
								<li class="notification">
									<div class="media">
										<img class="img-radius"
											src="${pageContext.request.contextPath}/<c:url value="assets"/>/admin/images/user/avatar-2.jpg"
											alt="Generic placeholder image">
										<div class="media-body">
											<p>
												<strong>Joseph William</strong><span
													class="n-time text-muted"><i
													class="icon feather icon-clock m-r-10"></i>30 min</span>
											</p>
											<p>Prchace New Theme and make payment</p>
										</div>
									</div>
								</li>
							</ul>
							<div class="noti-footer">
								<a href="#!">show all</a>
							</div>
						</div>
					</div>
				</li>
				<li class="nav-item"><a href="#!" class="pop-search"><i
						class="feather icon-search"></i></a>
					<div class="search-bar">
						<input type="text" class="form-control border-0 shadow-none"
							placeholder="Search hear">
						<button type="button" class="close" aria-label="Close">
							<span aria-hidden="true">&times;</span>
						</button>
					</div>
				</li>
			</ul>
		</div>
	</header>
	<!-- [ Header ] end -->

	<!-- [ Main Content ] start -->
	<div class="pcoded-main-container">
		<div class="pcoded-content">
			<!-- [ Main Content ] start -->
			<div class="row">