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
        'address' => '1236 Lincoln Way Ames IA 50014',
        'descrip' => 'TEST',
        'date' => '2016-11-5 00:00:00',
        'attendees' => 0,
        'location' => 1,
    ]);
        DB::table('events')->insert([
            'name' => 'party2',
            'address' => '1236 Lincoln Way Ames IA 50014',
            'descrip' => 'TEST',
            'date' => '2016-11-5 00:00:00',
            'attendees' => 0,
            'location' => 1,
        ]);
        DB::table('events')->insert([
            'name' => 'party3',
            'address' => '1236 Lincoln Way Ames IA 50014',
            'descrip' => 'TEST',
            'date' => '2016-11-5 00:00:00',
            'attendees' => 0,
            'location' => 1,
        ]);
        DB::table('events')->insert([
            'name' => 'party1',
            'address' => '1236 Lincoln Way Ames IA 50014',
            'descrip' => 'TEST',
            'date' => '2016-11-5 00:00:00',
            'attendees' => 0,
            'location' => 2,
        ]);
        DB::table('events')->insert([
            'name' => 'party2',
            'address' => '1236 Lincoln Way Ames IA 50014',
            'descrip' => 'TEST',
            'date' => '2016-11-5 00:00:00',
            'attendees' => 0,
            'location' => 2,
        ]);
        DB::table('events')->insert([
            'name' => 'party3',
            'address' => '1236 Lincoln Way Ames IA 50014',
            'descrip' => 'TEST',
            'date' => '2016-11-5 00:00:00',
            'attendees' => 0,
            'location' => 2,
        ]);
        DB::table('events')->insert([
            'name' => 'party1',
            'address' => '1236 Lincoln Way Ames IA 50014',
            'descrip' => 'TEST',
            'date' => '2016-11-5 00:00:00',
            'attendees' => 0,
            'location' => 3,
        ]);
        DB::table('events')->insert([
            'name' => 'party2',
            'address' => '1236 Lincoln Way Ames IA 50014',
            'descrip' => 'TEST',
            'date' => '2016-11-5 00:00:00',
            'attendees' => 0,
            'location' => 3,
        ]);
        DB::table('events')->insert([
            'name' => 'party3',
            'address' => '1236 Lincoln Way Ames IA 50014',
            'descrip' => 'TEST',
            'date' => '2016-11-5 00:00:00',
            'attendees' => 0,
            'location' => 3,
        ]);
    }
}
