package uk.q3c.util;

import com.google.inject.AbstractModule;
import com.google.inject.TypeLiteral;
import com.google.inject.multibindings.MapBinder;
import uk.q3c.util.clazz.ClassNameUtils;
import uk.q3c.util.clazz.DefaultClassNameUtils;
import uk.q3c.util.clazz.DefaultUnenhancedClassIdentifier;
import uk.q3c.util.clazz.UnenhancedClassIdentifier;
import uk.q3c.util.data.DataItemConverter;
import uk.q3c.util.data.collection.AnnotationList;
import uk.q3c.util.data.collection.AnnotationListConverter;

/**
 * Created by David Sowerby on 08 Aug 2017
 */
public class UtilModule extends AbstractModule {
    @Override
    protected void configure() {

        TypeLiteral<Class<?>> classLiteral = new TypeLiteral<Class<?>>() {
        };

        TypeLiteral<DataItemConverter> dataConverterLiteral = new TypeLiteral<DataItemConverter>() {
        };

        // We could just include the AnnotationListConverter in DataConverter, but this mmethod allows us to test -
        // we also need to at least create an empty map anyway
        MapBinder customDataConverters = MapBinder.newMapBinder(binder(), classLiteral, dataConverterLiteral);
        customDataConverters.addBinding(AnnotationList.class).to(AnnotationListConverter.class);
        bindClassNameUtils();
        bindClassIdentifier();


    }

    protected void bindClassIdentifier() {
        bind(UnenhancedClassIdentifier.class).to(DefaultUnenhancedClassIdentifier.class);
    }

    protected void bindClassNameUtils() {
        bind(ClassNameUtils.class).to(DefaultClassNameUtils.class);
    }
}
