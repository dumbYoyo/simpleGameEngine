package zuimamamba;

import org.lwjgl.glfw.GLFW;
import org.lwjgl.opengl.GL;
import org.lwjgl.opengl.GL11;

public class Window {
    private int width = 1280, height = 720;
    public static long window;
    private String title = "General theory of computers";
    private double lastFrame = 0;
    public static double deltaTime = 0;

    private Renderer renderer;

    public Window() {
        if (!GLFW.glfwInit()) {
            System.err.println("Failed to init glfw");
        }

        window = GLFW.glfwCreateWindow(width, height, title, 0, 0);
        if (window == GL11.GL_FALSE) {
            System.err.println("Failed to create window");
        }

        GLFW.glfwMakeContextCurrent(window);
        GL.createCapabilities();

        GL11.glViewport(0, 0, width, height);

        renderer = new Renderer();
        renderer.init();

        run();

        GLFW.glfwTerminate();
    }

    private void run() {
        while (!GLFW.glfwWindowShouldClose(window)) {
            GL11.glEnable(GL11.GL_DEPTH_TEST);
            GL11.glClear(GL11.GL_COLOR_BUFFER_BIT | GL11.GL_DEPTH_BUFFER_BIT);
            GL11.glClearColor(0, 0, 0, 1);
            // deltaTime = 0f;
            // lastFrame = 0f;

            renderer.render();
            renderer.update();

            GLFW.glfwSwapBuffers(window);
            GLFW.glfwPollEvents();
            double currentFrame = GLFW.glfwGetTime();
            deltaTime = currentFrame - lastFrame;
            lastFrame = currentFrame;
        }
    }
}
