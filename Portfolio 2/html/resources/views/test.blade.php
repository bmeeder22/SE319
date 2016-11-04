<html>
	
	<head>
		<meta charset="UTF-8">
		<title>Hit Up</title>
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
		<section id="three" class="wrapper style3 special">
				<div class="container">
					<header class="major">
						<h2>Throw an Event here!</h2>
						<p>Input time, and address, we take care of the rest!</p>
					</header>
				</div>
				<div class="container 50%">
					{!! Form::open(['url' => 'test']) !!}
						<div class="row uniform">
							<div class="6u 12u$(small)">
								<!--<input name="name" id="name" value="" placeholder="Name" type="text">-->
								{!! Form::text('name', null, ['placeholder' => 'Name', 'id'=>"name"]) !!}
							</div>
							<div class="6u$ 12u$(small)">
								<!--<input name="address" id="address" value="" placeholder="address" type="text">-->
								{!! Form::text('address', null, ['placeholder' => 'Address']) !!}
							</div>
							
							<div class="3u 12u$(small)">
								<!--<label> Date and Time:</label>-->
								{!! Form::label('Date and Time:') !!}
							</div>
							<div class="6u 12u$(small)">
								<input name="date" id="date" value= "date", placeholder="10/15/2015", type="date">
								<!--{!! Form::text('date', null, ['placeholder' => '10/15/2015', 'type'=>"date", 'id'=>"date"]) !!}-->
							</div>
							<div class="3u 12u$(small)">
								<!--<input name="time" id="time" value="20:00", placeholder="Time", type="time">-->
								{!! Form::text('time', null, ['value="20:00",' => 'Time', 'type'=>"time"]) !!}
								<input type="hidden" name="colid" value='ISU'>
							</div>
							<div class="12u$">
								<!--<textarea name="description" id="description" placeholder="Description" rows="4"></textarea>-->
								{!! Form::textarea('description', null, ['placeholder' => 'Description', 'rows'=>"4"]) !!}
							</div>
							
							<div class="12u$">
								<ul class="actions">
									<!--<li><input value="Submit" class="special big" type="submit"></li>-->
									{!! Form::submit('Submit', ['class' => "special big"]) !!}

								</ul>
							</div>
						</div>
					{!! Form::close() !!}
				</div>
			</section>
	</body>
</html>