Spring Dependency Injection beyond the basic tutorials
======================================================

Example of use of the @Configurable annotation to be able to inject objects created outside of
the control of any container. Domain objects often fall into this category because they are
often created programmatically using the new operator, or by an ORM tool as a result of a
database query. (Adapted from Spring documentation).

http://stackoverflow.com/questions/6902353/spring-dependency-injection-beyond-the-basic-tutorials

I've created the project with Spring Roo which already includes all relevant AspectJ support, but 
in case you've to add the dependencies yourself, be sure to include the following JARs: aspectjrt,
aspectjweaver, spring-aspects. Also, Java 1.6+ is required.

In this Example the Person class is created with the new operator, however, it needs to have a
dependency injected (the property is called cache).

1. Add @Configurable annotation to Person class, in my case I specified autowiring by type.
@Configurable(autowire=Autowire.BY_TYPE), but it's also possible to choose BY_NAME.

2. Add @Autowired annotation to cache property of Person

3. Add <context:spring-configured/> to applicationContext.xml, also adding the relative namespace.
Spring Roo will take care of it by default.

4. Add the bean to be injected in applicationContext.xml
<bean id="myCache" class="org.obliquid.springdi.cache.NullCache"/>
An alternative strategy would be to mark it as a @Component (or @Service, @Repository) and add
the package to component-scan:
<context:component-scan base-package="org.obliquid.springdi"/>
However, in my case there could be multiple implementations and I want to be able to configure
which one to use with XML.

The main program will log the following:

    Id: 1, Name: 'Benjamin Kirk', Cache: org.obliquid.springdi.cache.NullCache@33788d
    Id: 1067, Name: 'Eloise Berry', Cache: org.obliquid.springdi.cache.NullCache@33788d


