package com.bicicom.fluentmapper.provider.benchmarks;

import org.openjdk.jmh.annotations.*;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

public class ParserBenchmarks {

    public static void main(String[] args) throws IOException {
        parserTime();
        //org.openjdk.jmh.Main.main(args);
    }

    @Benchmark
    @BenchmarkMode(Mode.All)
    @OutputTimeUnit(TimeUnit.MILLISECONDS)
    @Fork(value = 1, warmups = 1)
    @Warmup(iterations = 1, time = 1, timeUnit = TimeUnit.SECONDS)
    @Measurement(iterations = 1, time = 1)
    public static void parserTime() {
//        FluentMapper fluentMapper = FluentMapper.createConfigured(config -> {
//            config.withMappingsPackage("com.bicicom.fluentmapper.provider.benchmarks.mappings");
//        });
//        fluentMapper.execute();
    }

}
