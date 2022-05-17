<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<jsp:include page="../../layouts/header.jsp" flush="true"></jsp:include>

<jsp:include page="../../layouts/menu.jsp" flush="true"></jsp:include>

<!--================Home Banner Area =================-->
<section class="banner_area">
	<div class="banner_inner d-flex align-items-center">
		<div class="container">
			<div
				class="banner_content d-md-flex justify-content-between align-items-center">
				<div class="mb-3 mb-md-0">
					<h2>Blog</h2>
					<p>Very us move be blessed multiply night</p>
				</div>
				<div class="page_link">
					<a href="home">Home</a> <a href="blog">Blog </a>
				</div>
			</div>
		</div>
	</div>
</section>
<!--================End Home Banner Area =================-->

<!--================Blog Area =================-->
<section class="blog_area section_gap">
	<div class="container">
		<div class="row">
			<c:forEach items="${listBlogs}" var="blog">
			<div class="col-lg-4 mb-5 mb-lg-0">
				<div class="blog_left_sidebar">
					<article class="blog_item">
						<div class="blog_item_img">
							<a href="blogDetail?blogId=${blog.id}">
								<img class="card-img rounded-0" src="<c:url value="assets"/>/customer/img/blog/${blog.mainImageUrl}" alt=""> 
							</a>
							<!-- <a href="#" class="blog_item_date">
								<h3>15</h3>
								<p>Jan</p>
							</a> -->
						</div>
						<div class="blog_details">
							<a class="d-inline-block" href="blogDetail?blogId=${blog.id}"><h2>${blog.name}</h2></a>
							<p>${blog.title}</p>
							<ul class="blog-info-link">
								<!-- <li><a href="#"><i class="ti-user"></i> Travel, Lifestyle</a></li>
								<li><a href="#"><i class="ti-comments"></i> 03 Comments</a></li> -->
								<li class="mainColor">${blog.createdAt}</li>
							</ul>
						</div>
					</article>
				</div>
			</div>
			</c:forEach>
			
			<%-- <div class="col-lg-4">
				<div class="blog_right_sidebar">
					<aside class="single_sidebar_widget search_widget">
						<form action="#">
							<div class="form-group">
								<div class="input-group mb-3">
									<input type="text" class="form-control"
										placeholder="Search Keyword">
									<div class="input-group-append">
										<button class="btn" type="button">
											<i class="ti-search"></i>
										</button>
									</div>
								</div>
							</div>
							<button class="main_btn rounded-0 w-100" type="submit">Search</button>
						</form>
					</aside>

					<aside class="single_sidebar_widget post_category_widget">
						<h4 class="widget_title">Category</h4>
						<ul class="list cat-list">
							<li><a href="#" class="d-flex">
									<p>Resaurant food</p>
									<p>(37)</p>
							</a></li>
							<li><a href="#" class="d-flex">
									<p>Travel news</p>
									<p>(10)</p>
							</a></li>
							<li><a href="#" class="d-flex">
									<p>Modern technology</p>
									<p>(03)</p>
							</a></li>
							<li><a href="#" class="d-flex">
									<p>Product</p>
									<p>(11)</p>
							</a></li>
							<li><a href="#" class="d-flex">
									<p>Inspiration</p>
									<p>21</p>
							</a></li>
							<li><a href="#" class="d-flex">
									<p>Health Care (21)</p>
									<p>09</p>
							</a></li>
						</ul>
					</aside>

					<aside class="single_sidebar_widget popular_post_widget">
						<h3 class="widget_title">Recent Post</h3>
						<div class="media post_item">
							<img src="<c:url value="assets"/>/customer/img/blog/popular-post/post1.jpg" alt="post">
							<div class="media-body">
								<a href="single-blog.html">
									<h3>From life was you fish...</h3>
								</a>
								<p>January 12, 2019</p>
							</div>
						</div>
						<div class="media post_item">
							<img src="<c:url value="assets"/>/customer/img/blog/popular-post/post2.jpg" alt="post">
							<div class="media-body">
								<a href="single-blog.html">
									<h3>The Amazing Hubble</h3>
								</a>
								<p>02 Hours ago</p>
							</div>
						</div>
						<div class="media post_item">
							<img src="<c:url value="assets"/>/customer/img/blog/popular-post/post3.jpg" alt="post">
							<div class="media-body">
								<a href="single-blog.html">
									<h3>Astronomy Or Astrology</h3>
								</a>
								<p>03 Hours ago</p>
							</div>
						</div>
						<div class="media post_item">
							<img src="<c:url value="assets"/>/customer/img/blog/popular-post/post4.jpg" alt="post">
							<div class="media-body">
								<a href="single-blog.html">
									<h3>Asteroids telescope</h3>
								</a>
								<p>01 Hours ago</p>
							</div>
						</div>
					</aside>
					<aside class="single_sidebar_widget tag_cloud_widget">
						<h4 class="widget_title">Tag Clouds</h4>
						<ul class="list">
							<li><a href="#">project</a></li>
							<li><a href="#">love</a></li>
							<li><a href="#">technology</a></li>
							<li><a href="#">travel</a></li>
							<li><a href="#">restaurant</a></li>
							<li><a href="#">life style</a></li>
							<li><a href="#">design</a></li>
							<li><a href="#">illustration</a></li>
						</ul>
					</aside>


					<aside class="single_sidebar_widget instagram_feeds">
						<h4 class="widget_title">Instagram Feeds</h4>
						<ul class="instagram_row flex-wrap">
							<li><a href="#"> <img class="img-fluid"
									src="<c:url value="assets"/>/customer/img/instagram/widget-i1.png" alt="">
							</a></li>
							<li><a href="#"> <img class="img-fluid"
									src="<c:url value="assets"/>/customer/img/instagram/widget-i2.png" alt="">
							</a></li>
							<li><a href="#"> <img class="img-fluid"
									src="<c:url value="assets"/>/customer/img/instagram/widget-i3.png" alt="">
							</a></li>
							<li><a href="#"> <img class="img-fluid"
									src="<c:url value="assets"/>/customer/img/instagram/widget-i4.png" alt="">
							</a></li>
							<li><a href="#"> <img class="img-fluid"
									src="<c:url value="assets"/>/customer/img/instagram/widget-i5.png" alt="">
							</a></li>
							<li><a href="#"> <img class="img-fluid"
									src="<c:url value="assets"/>/customer/img/instagram/widget-i6.png" alt="">
							</a></li>
						</ul>
					</aside>


					<aside class="single_sidebar_widget newsletter_widget">
						<h4 class="widget_title">Newsletter</h4>

						<form action="#">
							<div class="form-group">
								<input type="email" class="form-control"
									placeholder="Enter email" required>
							</div>
							<button class="main_btn rounded-0 w-100" type="submit">Subscribe</button>
						</form>
					</aside>
				</div>
			</div> --%>
		</div>
				<nav class="blog-pagination justify-content-center d-flex">
					<ul class="pagination">
						<li class="page-item"><a href="#" class="page-link"
							aria-label="Previous"> <span aria-hidden="true"> <span
									class="ti-arrow-left"></span>
							</span>
						</a></li>
						<li class="page-item"><a href="#" class="page-link">1</a></li>
						<li class="page-item active"><a href="#" class="page-link">2</a>
						</li>
						<li class="page-item"><a href="#" class="page-link"
							aria-label="Next"> <span aria-hidden="true"> <span
									class="ti-arrow-right"></span>
							</span>
						</a></li>
					</ul>
				</nav>
	</div>
</section>
<!--================Blog Area =================-->

<jsp:include page="../../layouts/footer.jsp" flush="true"></jsp:include>