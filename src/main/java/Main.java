import ratpack.handling.Context;
import ratpack.handling.Handler;
import ratpack.launch.HandlerFactory;
import ratpack.launch.LaunchConfig;
import ratpack.launch.LaunchConfigBuilder;
import ratpack.server.RatpackServerBuilder;

import java.io.File;

public class Main {

    public static void main(String[] args) throws Exception {

        LaunchConfig launchConfig = LaunchConfigBuilder
                .baseDir(new File(System.getProperty("user.dir")))
                .port(5050)
                .build(new HandlerFactory() {
                    public Handler create(LaunchConfig launchConfig) {
                        return new Handler() {
                            public void handle(Context context) throws Exception {
                                context.render("Hello World");
                            }
                        };
                    }
                });

        RatpackServerBuilder.build(launchConfig).start();
    }
}
