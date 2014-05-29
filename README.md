# jimix

[![Build Status](https://travis-ci.org/manuel-woelker/jimix.svg)](https://travis-ci.org/manuel-woelker/jimix)

A modern JMX web console

## Features

 * Zero third-party dependencies
 * Basic Web UI
 * Simple REST interface (CORS enabled)
 * Auto-refresh with display of value deltas
 * Invoking operations and setting attributes
 
## Screenshot

![screenshot](https://raw.github.com/manuel-woelker/jimix/screenshots/screenshot.png)

## Planned features
 
 * Adapters for all major web frameworks
 * Authentication
 
## Usage

Refer to the samples directory for detailed usage examples.

### WAR

Maven

```
<dependency>
    <groupId>org.woelker.jimix</groupId>
    <artifactId>jimix-servlet</artifactId>
    <version>1.2.0</version>
</dependency>
```

web.xml

```
<servlet>
    <servlet-name>jimix</servlet-name>
    <servlet-class>org.woelker.jimix.servlet.JimixServlet</servlet-class>
</servlet>

<servlet-mapping>
    <servlet-name>jimix</servlet-name>
    <url-pattern>/jimix/*</url-pattern>
</servlet-mapping>
```

### servlet (jetty)

Maven


```
<dependency>
    <groupId>org.woelker.jimix</groupId>
    <artifactId>jimix-servlet</artifactId>
    <version>1.2.0</version>
</dependency>
```

Jetty

```
Server server = new Server(8080);
ServletContextHandler context = new ServletContextHandler(ServletContextHandler.SESSIONS);
context.setContextPath("/");
server.setHandler(context);

context.addServlet(new ServletHolder(new JimixServlet()), "/jimix/*");
server.start();
server.join();
```

### Dropwizard

Maven


```
<dependency>
    <groupId>org.woelker.jimix</groupId>
    <artifactId>jimix-dropwizard</artifactId>
    <version>1.2.0</version>
</dependency>
```

Dropwizard

```
@Override
public void initialize(Bootstrap<Configuration> bootstrap) {
    bootstrap.addBundle(new JimixBundle());
}
```

### Vert.x

Maven


```
<dependency>
    <groupId>org.woelker.jimix</groupId>
    <artifactId>jimix-vertx</artifactId>
    <version>1.2.0</version>
</dependency>
```

Vert.x

```
Vertx vertx = new DefaultVertx();
HttpServer server = vertx.createHttpServer();

RouteMatcher routeMatcher = new RouteMatcher();

routeMatcher.allWithRegEx("/jimix(.*)", new JimixVertxHandler());

server.requestHandler(routeMatcher).listen(8080, "localhost");
```






