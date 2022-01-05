package com.stuber;

import com.quankcy.stuber.generator.RandomGenerator;
import com.quankcy.stuber.SeedMapper;
import com.pojos.NoDependency;
import com.quankcy.stuber.Seeder;

@Seeder(name = "NoDependencySeeder name")
public interface NoDependencySeeder extends com.stuber.Seed<NoDependencySeeder> {

//    NoDependencySeeder INSTANCE = Seeders.getSeeder( NoDependencySeeder.class );

    @SeedMapper( source = "privateFieldWithAnnotation" , generator = RandomGenerator.class)
    NoDependencySeeder seed(NoDependency noDependency);

}
