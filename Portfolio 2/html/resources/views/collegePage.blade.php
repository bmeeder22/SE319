<!DOCTYPE html>
<!--
	Transit by TEMPLATED
	templated.co @templatedco
	Released for free under the Creative Commons Attribution 3.0 license (templated.co/license)
-->
<html lang="en">
	<head>
		<meta charset="UTF-8">
		<title>{{ $name }} - Hit Up</title>
		<meta http-equiv="content-type" content="text/html; charset=utf-8" />
		<meta name="description" content="" />
		<meta name="keywords" content="" />
		<!--[if lte IE 8]><script src="js/html5shiv.js"></script><![endif]-->
		<script src="{{ asset("js/jquery.min.js") }}" >     </script>
		<script src="{{ asset("js/skel.min.js") }}" >       </script>
		<script src="{{ asset("js/skel-layers.min.js") }}" ></script>
		<script src="{{ asset("js/init.js") }}" >           </script>
		<noscript>
			<link rel="stylesheet" href="{{ asset('css/skel.css') }}" />
			<link rel="stylesheet" href="{{ asset('css/style.css') }}" />
			<link rel="stylesheet" href="{{ asset('css/style-xlarge.css') }}" />
		</noscript>
	</head>
	<body>

		<!-- Header -->
			<header id="header">
				<h1><a href= "{{ URL::route('home') }}" >Hit Up</a></h1>
				<nav id="nav">
					<ul>
						<li><a href="{{ URL::route('home') }}">Home</a></li>
						<li><a href="{{ URL::route('generic') }}">Service One</a></li>
						<li><a href="{{ URL::route('elements') }}">Service Two</a></li>
						<li><a href="#three" class="button special">Thow an Event</a></li>
					</ul>
				</nav>
			</header>

		<!-- Main -->
			<section id="main" class="wrapper">
				<div class="container">

					<header class="major">
						<h2>{{$name}}</h2>
					</header>

					<a href="#" class="image fit"><div style = "height: 300px; overflow: hidden"><img src= {{ $image }} alt="" /></div></a>
					<h3> Tonight </h3>
					<div class="table-wrapper">
								<table class = "alt">
									<thead>
										<tr>
											<th>Name</th>
											<th>Address</th>
											<th>Time</th>
											<th>Description</th>
											<th>Attendees</th>
											<th></th>
										</tr>
									</thead>
									<tbody>
										@if($product[0] != "null" || sizeof($product) == 0)
											@for ($i = 0; $i < sizeof($product); $i++)
                                                <?php $count=0; ?>
                                                @if($today == substr($product[$i]['date'], 0, 10))
                                                    <?php $count+=1; ?>
                                                    <tr>
                                                        <td>{{$product[$i]['event_name']}}</td>
                                                        <td><a href = "http://maps.google.com/?q={{$product[$i]['address']}}" target="_blank">{{$product[$i]['address']}}</a></td>
                                                        <td>{{$product[$i]['date']}}</td>
                                                        <td>{{$product[$i]['descrip']}}</td>
                                                        <td>{{$product[$i]['attendees']}} people have Hit Up</td>
                                                        <td><a href="{{route('party',['id'=> $product[$i]['event_id']])}}" class="button small">Hit Up</a></td>
                                                    </tr>
                                                @endif
											@endfor
                                            @if($count == 0)
                                                <tr>
                                                    <td colspan="5">No Data Available In The Table</td>
                                                </tr>
                                            @endif
										@else
											<tr>
												<td colspan="5">No Data Available In The Table</td>
											</tr>
										@endif
									</tbody>
								</table>
							</div>
				<h3> Upcoming </h3>
					<div class="table-wrapper">
								<table>
									<thead>
										<tr>
											<th>Name</th>
											<th>Address</th>
											<th>Date and time</th>
										</tr>
									</thead>
									<tbody>
										@if($product[0] != "null")
											@for ($i = 0; $i < sizeof($product); $i++)
											@if(substr($product[$i]['date'], 0, 10) > $today)
												<tr>
													<td>{{$product[$i]['event_name']}}</td>
													<td><a href = "http://maps.google.com/?q={{$product[$i]['address']}}" target="_blank">{{$product[$i]['address']}}</a></td>
													<td>{{$product[$i]['date']}}</td>
													<td>{{$product[$i]['descrip']}}</td>
													<td>{{$product[$i]['attendees']}} people have Hit Up</td>
													<td><a href="{{route('party',['id'=> $product[$i]['event_id']])}}" class="button small">Hit Up</a></td>
												</tr>
											@endif
											@endfor
										@else
											<tr>
												<td colspan="5">No Data Available In The Table</td>
											</tr>
										@endif
									</tbody>
								</table>
							</div>
				        </div>
				    </div>
			</section>

			<section id="three" class="wrapper style3 special">
				<div class="container">
					<header class="major">
						<h2>Throw an Event here!</h2>
						<p>Input time, and address, we take care of the rest!</p>
					</header>
				</div>
				<div class="container 50%">
					{!! Form::open(['route' => 'create']) !!}
						<div class="row uniform">
							<div class="6u 12u$(small)">
								{!! Form::text('name', null, ['placeholder' => 'Event Name', 'id'=>"name"]) !!}
							</div>
							<div class="6u$ 12u$(small)">
								{!! Form::text('address', null, ['placeholder' => 'Address']) !!}
							</div>
							
							<div class="3u 12u$(small)">
								{!! Form::label('Date and Time:') !!}
							</div>
							<div class="6u 12u$(small)">
								<input name="date" id="date" value= "date", placeholder="10/15/2015", type="date">
								<!--{!! Form::text('date', null, ['placeholder' => '10/15/2015', 'type'=>"date", 'id'=>"date"]) !!}-->
							</div>
							<div class="3u 12u$(small)">
								{!! Form::text('time', null, ['value="20:00",' => 'Time', 'type'=>"time"]) !!}
								<input type="hidden" name="colid" value= {{$id}}>
							</div>
							<div class="12u$">
								{!! Form::textarea('description', null, ['placeholder' => 'Description', 'rows'=>"4"]) !!}
							</div>
							
							<div class="12u$">
								<ul class="actions">
									{!! Form::submit('Submit', ['class' => "special big"]) !!}

								</ul>
							</div>
						</div>
					{!! Form::close() !!}
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