<?php

use Illuminate\Support\Facades\Schema;
use Illuminate\Database\Schema\Blueprint;
use Illuminate\Database\Migrations\Migration;

class CreateEventsTable extends Migration {
    /**
     * Run the migrations.
     *
     * @return void
     */
    public function up()
    {
        Schema::create('events', function (Blueprint $table) {
            $table->increments('id')->unsigned()->primary();
            $table->string('name')->after('id');
            $table->string('author')->after('name');
            $table->dateTime('date')->after('author');
            $table->integer('attendees')->after('date');
            $table->integer('location')->after('attendees')->unsigned();

            $table->foreign('location')->references('id')->on('colleges');
        });
    }

    /**
     * Reverse the migrations.
     *
     * @return void
     */
    public function down()
    {
        Schema::dropIfExists('events');
    }
}