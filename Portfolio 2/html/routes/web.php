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

Route::get('/generic', ['as' => 'generic', 'uses' => 'PagesController@generic']);

Route::get('elements', ['as' => 'elements', 'uses' => 'PagesController@elements']);

Route::get('/college/{id}', ['as'=>'college', 'uses' => 'PagesController@college']);

Route::post('/create', 'PagesController@create')->name('create');

Route::get('/party/{id}', 'PagesController@hit')->name('party');

Route::post('/test', ['as' => 'store', 'uses' => 'PagesController@store']);
