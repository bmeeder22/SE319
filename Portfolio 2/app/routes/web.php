<?php

/*
|--------------------------------------------------------------------------
| Web Routes
|--------------------------------------------------------------------------
|
| Here is where you can register web routes for your application. These
| routes are loaded by the RouteServiceProvider within a group which
| contains the "web" middleware group. Now create something great!
|
*/

Route::get('/', ['as' => 'home', function () {
    return view('index');
}]);

Route::get('clear', function () {
	\DB::table('Parties')->truncate();
	return redirect()->route('home');
});

Route::get('/generic', ['as' => 'generic', 'uses' => 'Pagescontroller@generic']);

Route::get('elements', ['as' => 'elements', 'uses' => 'Pagescontroller@elements']);

Route::get('/college/{id}', ['as'=>'college', 'uses' => 'Pagescontroller@college']);

Route::get('/test', 'Pagescontroller@test');

Route::get('/party/{id}', ['as' => 'party', 'uses' => 'Pagescontroller@hit']);

Route::post('/test', ['as' => 'store', 'uses' => 'Pagescontroller@store']);
