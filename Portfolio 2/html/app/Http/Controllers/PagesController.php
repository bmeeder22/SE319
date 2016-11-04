<?php

namespace App\Http\Controllers;

use Illuminate\Support\Facades\DB;
use Illuminate\Http\RedirectResponse;
use App\Http\Controllers\Controller;
use Illuminate\Http\Request;


class PagesController extends Controller
{
	function __construct() {
		global $college;
		$college = array('UMN','ISU','UND');
	}

    function generic() {
    	return view('generic');
    }

    function elements() {
    	return view('elements');
    }

    function test() {
    	return view('test');
    }

    function create(Request $request) {
        $name = $request->input('name');
        $address = $request->input('address');
        $date  = $request->input('date');
        $time  = $request->input('time');
        $descrip = $request->input('description');
        $input = $request->all();

        $datetime = $date . ' ' . $time. ':00';

        $id = DB::select("SELECT id FROM colleges WHERE abbrev=?",[$input['colid']])[0]->id;

        DB::insert("
INSERT INTO `events` (`event_name`, `address`, `descrip`, `date`, `attendees`, `location`)
VALUES(?, ?, ?, ?, 0, ?);", [$name, $address, $descrip, $datetime, $id]);

        $this->updateDates();

        return back();
    }

    function college($id) {
    	$data['id']=$id;
    	global $college;
    	if($id == $college[0]) {
    		$data['name'] = 'University of Minnesota';
    		$data['image'] = 'http://www.fabuloussavers.com/new_wallpaper/University_Of_Minnesota_Desktop_Wallpaper_freecomputerdesktopwallpaper_1600.jpg';
    	}
    	else if($id == $college[1]) {
    		$data['name'] = 'Iowa State University'; 
    		$data['image'] = 'http://www.nmnathletics.com.edgesuite.net/pics3/0/UX/UXDZMUPGOYZUQPC.20080214172052.jpg';
    	}
    	else if($id == $college[2]) {
    		$data['name'] = 'University of North Dakota'; 
    		$data['image'] = 'http://s3.amazonaws.com/cstest/teams%2F106%2Fnorth-dakota-university-of-logo.jpg';
    	}

    	$results = DB::select("SELECT * FROM events INNER JOIN colleges WHERE events.location=colleges.id AND colleges.abbrev=? ORDER BY events.attendees DESC;", [$id]);

        if(isset($results) && sizeof($results) > 0) {
            $product[0] = get_object_vars($results[0]);
            for($i=1; $i<sizeof($results); $i++) {
                array_push($product, get_object_vars($results[$i]));
            }
        }
        else {
            $product[0] = "null";
        }
        $data['today'] = date('Y-m-d');
    	return view('collegePage', $data)->with('product',$product);
    }

    function hit($id) {
        DB::table('events')->where('event_id', $id)->increment('attendees', 1);
        return back();
    }

    function updateDates() {
        $time = date("Y-m-d H:i:s");
        DB::table('events')->where('date', '<', $time)->delete();
//        DB::delete("DELETE * FROM events WHERE `date`<?", [$time]);
    }

    function store() {
//        $input = Request::all();
//
//        DB::table('Parties')->insertGetId(
//    [ 'name' => $input['name'], 'address' => $input['address'], 'colid' => $input['colid'], 'date' => $input['date'], 'time' => $input['time'], 'descrip' => $input['description'], 'attends' => 1 ]
//);
//        return redirect()->route('college', $input['colid']);
    }
}