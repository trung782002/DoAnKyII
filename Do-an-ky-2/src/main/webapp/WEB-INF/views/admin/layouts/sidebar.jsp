<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!-- [ navigation menu ] start -->
<nav class="pcoded-navbar  ">
	<div class="navbar-wrapper  ">
		<div class="navbar-content scroll-div ">
			<div class="main-menu-header">
				<%-- <img class="img-radius"
					src="<c:url value="assets"/>/admin/images/user/avatar-2.jpg"
					alt="User-Profile-Image"> --%>
				<div class="user-details">
					<span>John Doe</span>
					<div id="more-details">
						UX Designer <i class="fa fa-chevron-down m-l-5"></i>
					</div>
				</div>
			</div>
			<div class="collapse" id="nav-user-link">
				<ul class="list-unstyled">
					<li class="list-group-item"><a href="user-profile.html"><i
							class="feather icon-user m-r-5"></i>View Profile</a></li>
					<li class="list-group-item"><a
						href="auth-normal-sign-in.html"><i
							class="feather icon-log-out m-r-5"></i>Logout</a></li>
				</ul>
			</div>

			<ul class="nav pcoded-inner-navbar ">
				<li class="nav-item">
					<a href="admin" class="nav-link ">
						<span class="pcoded-micon"><i class="feather icon-home"></i></span>
						<span class="pcoded-mtext">Dashboard</span>
					</a>
				</li>
				
				<!-- Category -->
				<li class="nav-item">
					<a href="categoryManagement" class="nav-link ">
						<span class="pcoded-micon"><i class="feather icon-home"></i></span>
						<span class="pcoded-mtext">Category Management</span>
					</a>
				</li>
				
				<!-- Brand -->
				<li class="nav-item">
					<a href="brandManagement" class="nav-link ">
						<span class="pcoded-micon"><i class="feather icon-home"></i></span>
						<span class="pcoded-mtext">Brand Management</span>
					</a>
				</li>
				
				<!-- Product -->
				<li class="nav-item pcoded-hasmenu">
                    <a href="#" class="nav-link ">
                    	<span class="pcoded-micon"><i class="feather icon-layout"></i></span>
                    	<span class="pcoded-mtext">Product Management</span>
                    </a>
                    <ul class="pcoded-submenu">
                        <li><a href="listProducts" >List products</a></li>
                        <li><a href="insertProduct" >Add product</a></li>
                    </ul>
                </li>
                
                <!-- Blog -->
				<li class="nav-item pcoded-hasmenu">
                    <a href="#!" class="nav-link ">
                    	<span class="pcoded-micon"><i class="feather icon-layout"></i></span>
                    	<span class="pcoded-mtext">Blog Management</span>
                    </a>
                    <ul class="pcoded-submenu">
                        <li><a href="listBlogs" >List blogs</a></li>
                        <li><a href="insertBlog" >Add blog</a></li>
                    </ul>
                </li>
				
				<!-- Order -->
				<li class="nav-item">
					<a href="orderManagement" class="nav-link ">
						<span class="pcoded-micon"><i class="feather icon-home"></i></span>
						<span class="pcoded-mtext">Order Management</span>
					</a>
				</li>
				
				<!-- Account -->
				<li class="nav-item">
					<a href="accountManagement" class="nav-link ">
						<span class="pcoded-micon"><i class="feather icon-user"></i></span>
						<span class="pcoded-mtext">Account Management</span>
					</a>
				</li>
				
				<!-- Review -->
				<li class="nav-item">
					<a href="reviewManagement" class="nav-link ">
						<span class="pcoded-micon"><i class="feather icon-home"></i></span>
						<span class="pcoded-mtext">Review Management</span>
					</a>
				</li>
				
				<!-- Contact -->
				<li class="nav-item">
					<a href="contactManagement" class="nav-link ">
						<span class="pcoded-micon"><i class="feather icon-home"></i></span>
						<span class="pcoded-mtext">Contact Management</span>
					</a>
				</li>
				
				<!-- Config -->
				<li class="nav-item">
					<a href="configuration" class="nav-link ">
						<span class="pcoded-micon"><i class="feather icon-home"></i></span>
						<span class="pcoded-mtext">Configuration</span>
					</a>
				</li>
			</ul>
		</div>
	</div>
</nav>
<!-- [ navigation menu ] end -->