<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!--================Header Menu Area =================-->
<header class="header_area">
	<div class="top_menu">
		<div class="container">
			<div class="row">
				<div class="col-lg-7">
					<div class="float-left">
						<p>Phone: +01 256 25 235</p>
						<p>email: info@eiser.com</p>
					</div>
				</div>
				<div class="col-lg-5">
					<div class="float-right">
						<ul class="right_side">
							<li><a href="cart"> gift card </a></li>
							<li><a href="tracking.html"> track order </a></li>
							<li><a href="contact.html"> Contact Us </a></li>
						</ul>
					</div>
				</div>
			</div>
		</div>
	</div>
	<div class="main_menu">
		<div class="container">
			<nav class="navbar navbar-expand-lg navbar-light w-100">
				<!-- Brand and toggle get grouped for better mobile display -->
				<a class="navbar-brand logo_h" href="home"> <img
					src="<c:url value="assets"/>/customer/img/logo.png" alt="" />
				</a>
				<button class="navbar-toggler" type="button" data-toggle="collapse"
					data-target="#navbarSupportedContent"
					aria-controls="navbarSupportedContent" aria-expanded="false"
					aria-label="Toggle navigation">
					<span class="icon-bar"></span> <span class="icon-bar"></span> <span
						class="icon-bar"></span>
				</button>
				<!-- Collect the nav links, forms, and other content for toggling -->
				<div class="collapse navbar-collapse offset w-100"
					id="navbarSupportedContent">
					<div class="row w-100 mr-0">
						<div class="col-lg-7 pr-0">
							<ul class="nav navbar-nav center_nav pull-right">
								<li class="nav-item"><a class="nav-link" href="home">Home</a></li>
								<li class="nav-item"><a class="nav-link" href="allCategory">Shop</a></li>
								<li class="nav-item"><a class="nav-link" href="blog">Blog</a></li>
								<!-- <li class="nav-item submenu dropdown"><a href="#"
									class="nav-link dropdown-toggle" data-toggle="dropdown"
									role="button" aria-haspopup="true" aria-expanded="false">Pages</a>
									<ul class="dropdown-menu">
										<li class="nav-item"><a class="nav-link"
											href="tracking.html">Tracking</a></li>
										<li class="nav-item"><a class="nav-link"
											href="elements.html">Elements</a></li>
									</ul></li> -->
								<li class="nav-item"><a class="nav-link" href="contact">Contact</a></li>
							</ul>
						</div>

						<div class="col-lg-5 pr-0">
							<ul class="nav navbar-nav navbar-right right_nav pull-right">
								<li class="nav-item"><a href="#" class="icons"> <i
										class="ti-search" aria-hidden="true"></i>
								</a></li>

								<li class="nav-item"><a href="cart" class="icons"> <i
										class="ti-shopping-cart"></i>
								</a></li>

								<li class="nav-item"><a href="login" class="icons"> <i
										class="ti-user" aria-hidden="true"></i>
								</a></li>
							</ul>
						</div>
					</div>
				</div>
			</nav>
		</div>
	</div>
</header>
<!--================Header Menu Area =================-->