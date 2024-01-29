/**
 * Provides the implementation of Fluentmapper's API.
 */
module fluentmapper.provider {
    requires fluentmapper.api;
    requires org.objectweb.asm.tree;
    requires java.xml;
    requires org.slf4j;
    requires jakarta.xml.bind;

    opens dev.bici.fluentmapper.provider.model to jakarta.xml.bind;
    exports dev.bici.fluentmapper.provider.core;
}