<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<jsp:include page="../layouts/header.jsp" flush="true"></jsp:include>

<jsp:include page="../layouts/menu.jsp" flush="true"></jsp:include>

<!--================Home Banner Area =================-->
<section class="banner_area">
	<div class="banner_inner d-flex align-items-center">
		<div class="container">
			<div
				class="banner_content d-md-flex justify-content-between align-items-center">
				<div class="mb-3 mb-md-0">
					<h2>Contact Us</h2>
					<p>Very us move be blessed multiply night</p>
				</div>
				<div class="page_link">
					<a href="home">Home</a> <a href="contact">Contact Us</a>
				</div>
			</div>
		</div>
	</div>
</section>
<!--================End Home Banner Area =================-->

<!-- ================ contact section start ================= -->

<section class="section_gap">
	<div class="container">
		<div class="d-none d-sm-block mb-5 pb-4">
			${config.map}
		</div>


		<div class="row">
			<div class="col-12">
				<h2 class="contact-title">Get in Touch</h2>
			</div>
			<div class="col-lg-8 mb-4 mb-lg-0">
				<form class="form-contact contact_form" action="contact_process.php"
					method="post" id="contactForm" novalidate="novalidate">
					<div class="row">
						<div class="col-12">
							<div class="form-group">
								<textarea class="form-control w-100" name="message" id="message"
									cols="30" rows="9" placeholder="Enter Message"></textarea>
							</div>
						</div>
						<div class="col-sm-6">
							<div class="form-group">
								<input class="form-control" name="name" id="name" type="text"
									placeholder="Enter your name">
							</div>
						</div>
						<div class="col-sm-6">
							<div class="form-group">
								<input class="form-control" name="email" id="email" type="email"
									placeholder="Enter email address">
							</div>
						</div>
						<div class="col-12">
							<div class="form-group">
								<input class="form-control" name="subject" id="subject"
									type="text" placeholder="Enter Subject">
							</div>
						</div>
					</div>
					<div class="form-group mt-lg-3">
						<button type="submit" class="main_btn">Send Message</button>
					</div>
				</form>
			</div>

			<div class="col-lg-4">
				<div class="media contact-info">
					<span class="contact-info__icon"><i class="ti-home"></i></span>
					<div class="media-body">
						<h3>Viet Nam</h3>
						<p>${config.address}</p>
					</div>
				</div>
				<div class="media contact-info">
					<span class="contact-info__icon"><i class="ti-tablet"></i></span>
					<div class="media-body">
						<h3>
							<a href="tel:${config.phone}">${config.phone}</a>
						</h3>
						<p>Mon to Fri 9am to 6pm</p>
					</div>
				</div>
				<div class="media contact-info">
					<span class="contact-info__icon"><i class="ti-email"></i></span>
					<div class="media-body">
						<h3>
							<a href="mailto:${config.email}">${config.email}</a>
						</h3>
						<p>Send us your query anytime!</p>
					</div>
				</div>
			</div>
		</div>
	</div>
</section>
<!-- ================ contact section end ================= -->

<jsp:include page="../layouts/footer.jsp" flush="true"></jsp:include>