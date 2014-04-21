package org.woelker.jimix.samples.jetty;

import com.yammer.metrics.Metrics;
import com.yammer.metrics.core.Gauge;
import com.yammer.metrics.core.MetricName;
import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.servlet.ServletContextHandler;
import org.eclipse.jetty.servlet.ServletHolder;
import org.woelker.jimix.servlet.JimixServlet;

public class JimixSampleJetty {

    public static void main(String[] args) throws Exception {
        new JimixSampleJetty().run();
    }

    private void run() throws Exception {
        addSampleMetrics();

        Server server = new Server(8080);
        ServletContextHandler context = new ServletContextHandler(ServletContextHandler.SESSIONS);
        context.setContextPath("/");
        server.setHandler(context);

        context.addServlet(new ServletHolder(new JimixServlet()), "/jimix/*");
        server.start();
        server.join();
        
        

    }

    private void addSampleMetrics() {
        Metrics.newGauge(JimixSampleJetty.class, "foo", new Gauge<Long>() {
            long current = 0;

            @Override
            public Long value() {
                return current++;
            }
        });
        Metrics.newGauge(JimixSampleJetty.class, "foo", "bar", new Gauge<Long>() {
            long current = 0;

            @Override
            public Long value() {
                return current++;
            }
        });
        final MetricName metricName = new MetricName("fizz", "buzz", "foo");
        Metrics.newGauge(metricName, new Gauge<Long>() {
            long current = 0;

            @Override
            public Long value() {
                return current++;
            }
        });
    }

}