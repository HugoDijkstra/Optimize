package optimize;

import org.lwjgl.*;
import org.lwjgl.glfw.*;
import org.lwjgl.opengl.*;
import org.lwjgl.system.*;

import java.nio.*;

import static org.lwjgl.glfw.Callbacks.*;
import static org.lwjgl.glfw.GLFW.*;
import static org.lwjgl.opengl.GL11.*;
import static org.lwjgl.system.MemoryStack.*;
import static org.lwjgl.system.MemoryUtil.*;

public class Game {
    private long window;
    private int width, height;

    private Renderer renderer;
    public Game() {
        this(1280, 720);
    }

    public Game(int width, int height)
    {
        this.width = width;
        this.height = height;
        init();

        FloatBuffer vertexes = memAllocFloat(4*3);
        IntBuffer indices = memAllocInt(6);
        vertexes.put(-1f);
        vertexes.put(-1f);
        vertexes.put(0f);

        vertexes.put(1f);
        vertexes.put(1f);
        vertexes.put(0f);

        vertexes.put(1f);
        vertexes.put(-1f);
        vertexes.put(0f);

        vertexes.put(-1f);
        vertexes.put(1f);
        vertexes.put(0f);

        indices.put(0);
        indices.put(1);
        indices.put(2);

        indices.put(1);
        indices.put(2);
        indices.put(3);



        Mesh m = new Mesh(vertexes, indices);
    }

    public void init() {
        GLFWErrorCallback.createPrint(System.err).set();
        if (!glfwInit()) {
            throw new IllegalStateException("Unable to initialize GLFW");
        }
        glfwDefaultWindowHints();
        glfwWindowHint(GLFW_VISIBLE, GLFW_FALSE);
        glfwWindowHint(GLFW_RESIZABLE, GLFW_TRUE);

        window = glfwCreateWindow(1280, 720, "Optimize", NULL, NULL);

        if (window == NULL) {
            throw new RuntimeException("Could not create window");
        }
        glfwMakeContextCurrent(window);
        glfwShowWindow(window);

        renderer = new Renderer(window);
    }

    public void Run() {
        GL.createCapabilities();
        glClearColor(0f, 0f, 0f, 0f);

        while (!glfwWindowShouldClose(window)) {
            glClear(GL_COLOR_BUFFER_BIT | GL_DEPTH_BUFFER_BIT);
            glfwSwapBuffers(window);
            glfwPollEvents();
        }
    }
}
