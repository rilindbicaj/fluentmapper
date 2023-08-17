module fluentmapper.provider {
    requires fluentmapper.api;
    requires org.objectweb.asm.tree;
    requires java.xml;
    requires org.slf4j;
    requires jakarta.xml.bind;

    opens com.bicicom.fluentmapper.provider.model to jakarta.xml.bind;
    exports com.bicicom.fluentmapper.provider.core;
}