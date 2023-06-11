import com.bicicom.fluentmapper.core.FluentMapperProvider;

module fluentmapper.provider {
    requires fluentmapper.api;
    requires org.objectweb.asm.tree;
    requires java.xml;
    requires org.dom4j;
    requires org.slf4j;

    provides FluentMapperProvider
            with com.bicicom.fluentmapper.provider.core.DefaultFluentMapperProvider;
}