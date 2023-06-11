import com.bicicom.fluentmapper.core.FluentMapperProvider;

module fluentmapper.api {
    uses FluentMapperProvider;
    exports com.bicicom.fluentmapper.expression;
    exports com.bicicom.fluentmapper.model.builder;
    exports com.bicicom.fluentmapper.core;
    exports com.bicicom.fluentmapper.core.config;
}