<?php

use Illuminate\Database\Seeder;

class EventsTableSeeder extends Seeder
{
    /**
     * Run the database seeds.
     *
     * @return void
     */
    public function run()
    {
        DB::table('events')->insert([
            'name' => 'party1',
            'author' => 'test',
            'date' => '2016-11-5 00:00:00',
            'attendees' => 0,
            'location' => 1,
        ]);
        DB::table('events')->insert([
            'name' => 'party2',
            'author' => 'test',
            'date' => '2016-11-5 00:00:00',
            'attendees' => 0,
            'location' => 1,
        ]);
        DB::table('events')->insert([
            'name' => 'party3',
            'author' => 'test',
            'date' => '2016-11-5 00:00:00',
            'attendees' => 0,
            'location' => 1,
        ]);
        DB::table('events')->insert([
            'name' => 'party1',
            'author' => 'test',
            'date' => '2016-11-5 00:00:00',
            'attendees' => 0,
            'location' => 2,
        ]);
        DB::table('events')->insert([
            'name' => 'party2',
            'author' => 'test',
            'date' => '2016-11-5 00:00:00',
            'attendees' => 0,
            'location' => 2,
        ]);
        DB::table('events')->insert([
            'name' => 'party3',
            'author' => 'test',
            'date' => '2016-11-5 00:00:00',
            'attendees' => 0,
            'location' => 2,
        ]);
        DB::table('events')->insert([
            'name' => 'party1',
            'author' => 'test',
            'date' => '2016-11-5 00:00:00',
            'attendees' => 0,
            'location' => 3,
        ]);
        DB::table('events')->insert([
            'name' => 'party2',
            'author' => 'test',
            'date' => '2016-11-5 00:00:00',
            'attendees' => 0,
            'location' => 3,
        ]);
        DB::table('events')->insert([
            'name' => 'party3',
            'author' => 'test',
            'date' => '2016-11-5 00:00:00',
            'attendees' => 0,
            'location' => 3,
        ]);
    }
}
