package optimize;

import org.lwjgl.*;
import org.lwjgl.opengl.*;
import org.lwjgl.system.*;

import java.io.*;
import java.nio.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.*;

import static org.lwjgl.opengl.GL30C.*;
import static org.lwjgl.system.MemoryStack.*;
import static org.lwjgl.system.MemoryUtil.*;

public class Renderer {
    private long window;

    private int vertexShader;
    private int fragmentShader;

    private static String VERTEX_SHADER = "
    #version 330 core
    layout (location = 0) in vec3 aPos; // the position variable has attribute position 0
      
    out vec4 vertexColor; // specify a color output to the fragment shader
    
    void main()
    {
        gl_Position = vec4(aPos, 1.0); // see how we directly give a vec3 to vec4's constructor
        vertexColor = vec4(0.5, 0.0, 0.0, 1.0); // set the output variable to a dark-red color
    }";


    private static String FRAGMENT_SHADER = "
    #version 330 core
    out vec4 FragColor;
      
    in vec4 vertexColor; // the input variable from the vertex shader (same name and same type)  
    
    void main()
    {
        FragColor = vertexColor;
    } 
    ";

    public Renderer(long window){
        this.window = window;


    }

    public void CompileShader()
    {
        vertexShader = glCreateShader(GL_VERTEX_SHADER);
        fragmentShader = glCreateShader(GL_FRAGMENT_SHADER);

        glShaderSource(vertexShader,VERTEX_SHADER);
        
    }

}
