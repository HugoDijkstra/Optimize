package optimize;

import java.nio.FloatBuffer;
import java.nio.IntBuffer;
import org.lwjgl.*;
import org.lwjgl.glfw.*;
import org.lwjgl.opengl.*;
import org.lwjgl.opengl.GL15;
import org.lwjgl.system.*;

import java.nio.*;

import static org.lwjgl.glfw.Callbacks.*;
import static org.lwjgl.glfw.GLFW.*;
import static org.lwjgl.opengl.GL30C.*;
import static org.lwjgl.system.MemoryStack.*;
import static org.lwjgl.system.MemoryUtil.*;
import org.lwjgl.*;
import org.lwjgl.opengl.*;
import org.lwjgl.system.*;

import java.io.*;
import java.nio.*;
import java.util.*;

import static org.lwjgl.opengl.GL30C.*;
import static org.lwjgl.system.MemoryStack.*;
import static org.lwjgl.system.MemoryUtil.*;

public class Mesh {

    private IntBuffer indices;
    int indiceCount;
    private FloatBuffer vertexes;
    int vertexCount;
    private int positionsVBO;

    public Mesh(FloatBuffer vertexes, IntBuffer indices)
    {
        this.vertexes = vertexes;
        vertexCount = vertexes.array().length;
        this.indices = indices;
        this.indiceCount = indices.array().length;
        LoadMesh();
    }

    private void LoadMesh()
    {
        positionsVBO = glGenBuffers();
        glBindBuffer(GL_ARRAY_BUFFER, positionsVBO);
        glBufferData(GL_ARRAY_BUFFER, vertexes, GL_STATIC_DRAW);
    }

    public void Bind()
    {
        glBindBuffer(GL_ARRAY_BUFFER, positionsVBO);
    }

    public void Draw()
    {
        glDrawArrays(GL_TRIANGLES, 0, vertexCount);
    }
}
