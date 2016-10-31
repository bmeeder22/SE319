<?php

namespace App\Http\Controllers;

use App\User;
use App\Http\Controllers\Controller;
use Request;

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

    function college($id) {
    	$data['id']=$id;
    	global $college;
        $this->updateDates();
    	if($id == $college[0]) {
    		$data['name'] = 'University of Minnesota'; 
    		$data['image'] = 'http://www.fabuloussavers.com/new_wallpaper/University_Of_Minnesota_Desktop_Wallpaper_freecomputerdesktopwallpaper_1600.jpg';
    		$results = \DB::select("SELECT * FROM (SELECT `_rowid_`,* FROM `Parties` WHERE 1=1 AND `colid` LIKE 'UMN' ORDER BY `attends` DESC);");
    	}
    	if($id == $college[1]) {
    		$data['name'] = 'Iowa State University'; 
    		$data['image'] = 'http://www.nmnathletics.com.edgesuite.net/pics3/0/UX/UXDZMUPGOYZUQPC.20080214172052.jpg';
    		$results = \DB::select("SELECT * FROM (SELECT `_rowid_`,* FROM `Parties` WHERE 1=1 AND `colid` LIKE 'ISU' ORDER BY `attends` DESC);");
    	}
    	if($id == $college[2]) {
    		$data['name'] = 'University of North Dakota'; 
    		$data['image'] = 'http://s3.amazonaws.com/cstest/teams%2F106%2Fnorth-dakota-university-of-logo.jpg';
    		$results = \DB::select("SELECT * FROM (SELECT `_rowid_`,* FROM `Parties` WHERE 1=1 AND `colid` LIKE 'UND' ORDER BY `attends` DESC);");
    	}
        if(isset($results)) {
            if(sizeof($results) > 0) {
                $product[0] = get_object_vars($results[0]);
                for($i=1; $i<sizeof($results); $i++) {
                    array_push($product, get_object_vars($results[$i]));
                }
            }
            else {
                $product[0] = "null";
            }
        }
        else {
            $product[0] = "null";
        }
        $data['today'] = date('Y-m-d');
    	return view('collegePage', $data)->with('product',$product);
    }

    function hit($id) {
        \DB::table('Parties')->where('id', $id)->increment('attends', 1);
        //return Redirect::back()->with('message','Operation Successful !');
        return view('party');
        //\DB::table('Parties')->increment('attends', 1, ['id' => $id]);
    }

    function updateDates() {
        $today = date("Y-m-d");
        \DB::table('Parties')->where('date', '<', $today)->delete();
    }

    function store() {
        $input = Request::all();

        \DB::table('Parties')->insertGetId(
    [ 'name' => $input['name'], 'address' => $input['address'], 'colid' => $input['colid'], 'date' => $input['date'], 'time' => $input['time'], 'descrip' => $input['description'], 'attends' => 1 ]
);
        return redirect()->route('college', $input['colid']);
    }
}