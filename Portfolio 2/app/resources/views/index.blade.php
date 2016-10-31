<!DOCTYPE html>
<!--
	Transit by TEMPLATED
	templated.co @templatedco
	Released for free under the Creative Commons Attribution 3.0 license (templated.co/license)
-->
<html lang="en">
	<head>
		<meta charset="UTF-8">
		<title>Hit Up - Home</title>
		<meta http-equiv="content-type" content="text/html; charset=utf-8" />
		<meta name="description" content="" />
		<meta name="keywords" content="" />
		<!--[if lte IE 8]><script src="js/html5shiv.js"></script><![endif]-->

		<script src="{{ asset('js/jquery.min.js') }}"></script>
		<script src="{{ asset('js/skel.min.js') }}"></script>
		<script src="{{ asset('js/skel-layers.min.js') }}"></script>
		<script src="{{ asset('js/init.js') }}"></script>

		<noscript>
			<link rel="stylesheet" href="css/skel.css" /> 
			<link rel="stylesheet" href="{{ asset('css/style.css') }}" />
			<link rel="stylesheet" href="css/style-xlarge.css" /> 
		</noscript>
	</head>
	<body class="landing">

		<!-- Header -->
			<header id="header">
				<h1><a href= "{{ URL::route('home') }}" >Hit Up</a></h1>
				<nav id="nav">
					<ul>
						<li><a href="{{ URL::route('home') }}">Home</a></li>
						<li><a href="{{ URL::route('generic') }}">Service One</a></li>
						<li><a href="{{ URL::route('elements') }}">Service Two</a></li>
						<li><a href="#three" class="button special">Throw an Event</a></li>
					</ul>
				</nav>
			</header>

		<!-- Banner -->
			<section id="banner">
				<h2>Welcome to Hit Up</h2>
				<p>The site for finding events around campus.</p>
				<ul class="actions">
					<li>
						<a href="#colleges" class="button big">Get Started</a>
					</li>
				</ul>
			</section>

		<!-- One -->
			<section id="one" class="wrapper style1 special">
				<div class="container">
					<div class="row 150%">
						<div class="4u 12u$(medium)">
							<section class="box">
								<i class="icon big rounded color1 fa-glass"></i>
								<h3>Going out on the town</h3>
								<p>Everyone is looking for something do to. We can help find parties and events around cmapus every night of the week.</p>
							</section>
						</div>
						<div class="4u 12u$(medium)">
							<section class="box">
								<i class="icon big rounded color9 fa-users"></i>
								<h3>Thousands of users across campus</h3>
								<p>With a great community and continued updates there will always be something on Hit Up.</p>
							</section>
						</div>
						<div class="4u$ 12u$(medium)">
							<section class="box">
								<i class="icon big rounded color6 fa-calendar"></i>
								<h3>Throw an event</h3>
								<p>If you would like to throw an event on campus, we can help you get the word out. Simply <a href="#three">sign up</a> to get started.</p>
							</section>
						</div>
					</div>
				</div>
			</section>

		<!-- one and a half -->
		<div id = "colleges">
		<section id="one" class="wrapper style1 special">
				<div class="container">
					<header class="major">
						<h2>Find your Campus!</h2>
						<p>Can't find your campus? <a href="{{ URL::route('generic') }}">Submit</a> a request!</p>
					</header>
					<div class="row 150%">
						<div class="4u 12u$(medium)">
							<section class="box">
								<a href="{{ URL::route('college',['id' => 'UMN']) }}"><i class="icon big rounded color6 fa-university"></i></a>
								<h3><a href="{{ URL::route('college',['id' => 'UMN']) }}">University of Minnesota</a></h3>
							</section>
						</div>
						<div class="4u 12u$(medium)">
							<section class="box">
								<a href="{{ URL::route('college',['id' => 'ISU']) }}"><i class="icon big rounded color7 fa-university"></i></a>
								<h3><a href="{{ URL::route('college',['id' => 'ISU']) }}">Iowa State </br> Universty</a></h3>
							</section>
						</div>
						<div class="4u$ 12u$(medium)">
							<section class="box">
								<a href="{{ URL::route('college',['id' => 'UND']) }}"><i class="icon big rounded color10 fa-university"></i></a>
								<h3><a href="{{ URL::route('college',['id' => 'UND']) }}">University of North Dakota</a></h3>
							</section>
						</div>
					</div>
				</div>
			</section>
			</div>
		<!-- Two -->
		<!--
			<section id="two" class="wrapper style2 special">
				<div class="container">
					<header class="major">
						<h2>Throw an Event here!</h2>
						<p>Input time, and address, we take care of the rest!</p>
					</header>
					<section class="profiles">
						<div class="row">
							<section class="3u 6u(medium) 12u$(xsmall) profile">
								<img src="images/profile_placeholder.gif" alt="" />
								<h4>Lorem ipsum</h4>
								<p>Lorem ipsum dolor</p>
							</section>
							<section class="3u 6u$(medium) 12u$(xsmall) profile">
								<img src="images/profile_placeholder.gif" alt="" />
								<h4>Voluptatem dolores</h4>
								<p>Ullam nihil repudi</p>
							</section>
							<section class="3u 6u(medium) 12u$(xsmall) profile">
								<img src="images/profile_placeholder.gif" alt="" />
								<h4>Doloremque quo</h4>
								<p>Harum corrupti quia</p>
							</section>
							<section class="3u$ 6u$(medium) 12u$(xsmall) profile">
								<img src="images/profile_placeholder.gif" alt="" />
								<h4>Voluptatem dicta</h4>
								<p>Et natus sapiente</p>
							</section>
						</div>
					</section>
					<footer>
						<p>Lorem ipsum dolor sit amet, consectetur adipisicing elit. Quibusdam dolore illum, temporibus veritatis eligendi, aliquam, dolor enim itaque veniam aut eaque sequi qui quia vitae pariatur repudiandae ab dignissimos ex!</p>
						<ul class="actions">
							<li>
								<a href="#" class="button big">Lorem ipsum dolor sit</a>
							</li>
						</ul>
					</footer>
				</div>
			</section>
		-->
		<!-- Three -->
			<section id="three" class="wrapper style3 special">
				<div class="container">
					<header class="major">
						<h2>Throw an Event here!</h2>
						<p>Input time, and address, we take care of the rest!</p>
					</header>
				</div>
				<div class="container 50%">
					<form action="#" method="post">
						<div class="row uniform">
							<div class="6u 12u$(small)">
								<input name="name" id="name" value="" placeholder="Name" type="text">
							</div>
							<div class="6u$ 12u$(small)">
								<input name="email" id="email" value="" placeholder="Email" type="email">
							</div>
							<div class="12u$">
								<textarea name="message" id="message" placeholder="Message" rows="6"></textarea>
							</div>
							<div class="12u$">
								<ul class="actions">
									<li><input value="Send Message" class="special big" type="submit"></li>
								</ul>
							</div>
						</div>
					</form>
				</div>
			</section>

		<!-- Footer -->
			<footer id="footer">
				<div class="container">
					
					<div class="row">
						<div class="8u 12u$(medium)">
							<ul class="copyright">
								<li>&copy; Untitled. All rights reserved.</li>
								<li>Design: <a href="http://templated.co">TEMPLATED</a></li>
								<li>Images: <a href="http://unsplash.com">Unsplash</a></li>
							</ul>
						</div>
						<div class="4u$ 12u$(medium)">
							<ul class="icons">
								<li>
									<a href= "http://www.facebook.com" class="icon rounded fa-facebook"><span class="label">Facebook</span></a>
								</li>
								<li>
									<a href= "http://www.twitter.com" class="icon rounded fa-twitter"><span class="label">Twitter</span></a>
								</li>
								<li>
									<a href= "http://www.google.com" class="icon rounded fa-google-plus"><span class="label">Google+</span></a>
								</li>
								<li>
									<a href= "http://www.linkedin.com" class="icon rounded fa-linkedin"><span class="label">LinkedIn</span></a>
								</li>
							</ul>
						</div>
					</div>
				</div>
			</footer>

	</body>
</html>