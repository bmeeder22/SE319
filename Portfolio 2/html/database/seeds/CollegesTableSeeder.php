<?php

use Illuminate\Database\Seeder;

class CollegesTableSeeder extends Seeder
{
    /**
     * Run the database seeds.
     *
     * @return void
     */
    public function run()
    {
        DB::table('colleges')->insert([
            'name' => 'University of Minnesota',
            'abbrev' => 'UMN',
        ]);
        DB::table('colleges')->insert([
            'name' => 'Iowa State University',
            'abbrev' => 'ISU',
        ]);
        DB::table('colleges')->insert([
            'name' => 'North Dakota State University',
            'abbrev' => 'NDSU',
        ]);
    }
}
