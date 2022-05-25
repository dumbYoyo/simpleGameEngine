package zuimamamba;

import org.joml.Vector3f;
import org.joml.Vector4f;
import org.lwjgl.BufferUtils;
import org.lwjgl.opengl.GL11;
import org.lwjgl.opengl.GL20;
import org.lwjgl.opengl.GL30;
import org.lwjgl.stb.STBImage;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.IntBuffer;

public class Shader {
    private int vertexID, fragmentID, shaderProgramID;
    private String vertexSrc, fragmentSrc;
    private int texture;

    public Shader() {
        vertexSrc = loadFile("res/shaders/default/defaultVertex.glsl");
        fragmentSrc = loadFile("res/shaders/default/defaultFragment.glsl");

        // vertex shader
        vertexID = GL20.glCreateShader(GL20.GL_VERTEX_SHADER);
        GL20.glShaderSource(vertexID, vertexSrc);
        GL20.glCompileShader(vertexID);
        int success = GL20.glGetShaderi(vertexID, GL20.GL_COMPILE_STATUS);
        if (success == GL11.GL_FALSE) {
            int len = GL20.glGetShaderi(vertexID, GL20.GL_INFO_LOG_LENGTH);
            System.err.println("ERROR in " + "VertexShader" + ": " + GL20.glGetShaderInfoLog(vertexID, len));
            assert false : "";
        }

        // fragment shader
        fragmentID = GL20.glCreateShader(GL20.GL_FRAGMENT_SHADER);
        GL20.glShaderSource(fragmentID, fragmentSrc);
        GL20.glCompileShader(fragmentID);
        success = GL20.glGetShaderi(fragmentID, GL20.GL_COMPILE_STATUS);
        if (success == GL11.GL_FALSE) {
            int len = GL20.glGetShaderi(fragmentID, GL20.GL_INFO_LOG_LENGTH);
            System.err.println("ERROR in " + "FragmentShader" + ": " + GL20.glGetShaderInfoLog(fragmentID, len));
            assert false : "";
        }

        // shader program
        shaderProgramID = GL20.glCreateProgram();
        GL20.glAttachShader(shaderProgramID, vertexID);
        GL20.glAttachShader(shaderProgramID, fragmentID);
        GL20.glLinkProgram(shaderProgramID);

        success = GL20.glGetProgrami(shaderProgramID, GL20.GL_LINK_STATUS);
        if (success == GL11.GL_FALSE) {
            int len = GL20.glGetProgrami(shaderProgramID, GL20.GL_INFO_LOG_LENGTH);
            System.out.println("FAILED to link shaderProgram: " + GL20.glGetProgramInfoLog(shaderProgramID, len));
            assert false : "";
        }
    }

    public Shader(String vertexPath, String fragmentPath) {
        String vertexSrc = loadFile(vertexPath);
        String fragmentSrc = loadFile(fragmentPath);

        // vertex shader
        vertexID = GL20.glCreateShader(GL20.GL_VERTEX_SHADER);
        GL20.glShaderSource(vertexID, vertexSrc);
        GL20.glCompileShader(vertexID);
        int success = GL20.glGetShaderi(vertexID, GL20.GL_COMPILE_STATUS);
        if (success == GL11.GL_FALSE) {
            int len = GL20.glGetShaderi(vertexID, GL20.GL_INFO_LOG_LENGTH);
            System.err.println("ERROR in " + "VertexShader" + ": " + GL20.glGetShaderInfoLog(vertexID, len));
            assert false : "";
        }

        // fragment shader
        fragmentID = GL20.glCreateShader(GL20.GL_FRAGMENT_SHADER);
        GL20.glShaderSource(fragmentID, fragmentSrc);
        GL20.glCompileShader(fragmentID);
        success = GL20.glGetShaderi(fragmentID, GL20.GL_COMPILE_STATUS);
        if (success == GL11.GL_FALSE) {
            int len = GL20.glGetShaderi(fragmentID, GL20.GL_INFO_LOG_LENGTH);
            System.err.println("ERROR in " + "FragmentShader" + ": " + GL20.glGetShaderInfoLog(fragmentID, len));
            assert false : "";
        }

        // shader program
        shaderProgramID = GL20.glCreateProgram();
        GL20.glAttachShader(shaderProgramID, vertexID);
        GL20.glAttachShader(shaderProgramID, fragmentID);
        GL20.glLinkProgram(shaderProgramID);

        success = GL20.glGetProgrami(shaderProgramID, GL20.GL_LINK_STATUS);
        if (success == GL11.GL_FALSE) {
            int len = GL20.glGetProgrami(shaderProgramID, GL20.GL_INFO_LOG_LENGTH);
            System.out.println("FAILED to link shaderProgram: " + GL20.glGetProgramInfoLog(shaderProgramID, len));
            assert false : "";
        }
    }

    public void bind() {
        GL20.glUseProgram(shaderProgramID);
    }

    public void unbind() {
        GL20.glUseProgram(0);
    }

    // TODO: make it so that i can use multiple textures without memory leak
    public int loadTexture(String texturePath) {
        texture = GL11.glGenTextures();

        GL11.glTexParameteri(GL11.GL_TEXTURE_2D, GL11.GL_TEXTURE_WRAP_S, GL11.GL_REPEAT);
        GL11.glTexParameteri(GL11.GL_TEXTURE_2D, GL11.GL_TEXTURE_WRAP_T, GL11.GL_REPEAT);
        GL11.glTexParameteri(GL11.GL_TEXTURE_2D, GL11.GL_TEXTURE_MIN_FILTER, GL11.GL_LINEAR_MIPMAP_LINEAR);
        GL11.glTexParameteri(GL11.GL_TEXTURE_2D, GL11.GL_TEXTURE_MAG_FILTER, GL11.GL_LINEAR);

        IntBuffer x = BufferUtils.createIntBuffer(1);
        IntBuffer y = BufferUtils.createIntBuffer(1);
        IntBuffer ch = BufferUtils.createIntBuffer(1);
        ByteBuffer data = STBImage.stbi_load(texturePath, x, y, ch, 0);

        if (data != null) {
            int format;

            GL11.glBindTexture(GL11.GL_TEXTURE_2D, texture);
            GL11.glTexImage2D(GL11.GL_TEXTURE_2D, 0, GL11.GL_RGBA, x.get(), y.get(), 0, GL11.GL_RGBA, GL11.GL_UNSIGNED_BYTE, data);
            GL30.glGenerateMipmap(GL11.GL_TEXTURE_2D);
        } else {
            System.err.println("Failed to load stb image");
        }

        if (data != null) {
            STBImage.stbi_image_free(data);
        }

        return texture;
    }

    public static int loadTexture(String texturePath, int uselessShit) {
        int texture = GL11.glGenTextures();

        GL11.glTexParameteri(GL11.GL_TEXTURE_2D, GL11.GL_TEXTURE_WRAP_S, GL11.GL_REPEAT);
        GL11.glTexParameteri(GL11.GL_TEXTURE_2D, GL11.GL_TEXTURE_WRAP_T, GL11.GL_REPEAT);
        GL11.glTexParameteri(GL11.GL_TEXTURE_2D, GL11.GL_TEXTURE_MIN_FILTER, GL11.GL_LINEAR_MIPMAP_LINEAR);
        GL11.glTexParameteri(GL11.GL_TEXTURE_2D, GL11.GL_TEXTURE_MAG_FILTER, GL11.GL_LINEAR);

        IntBuffer x = BufferUtils.createIntBuffer(1);
        IntBuffer y = BufferUtils.createIntBuffer(1);
        IntBuffer ch = BufferUtils.createIntBuffer(1);
        ByteBuffer data = STBImage.stbi_load(texturePath, x, y, ch, 0);

        if (data != null) {
            GL11.glBindTexture(GL11.GL_TEXTURE_2D, texture);
            GL11.glTexImage2D(GL11.GL_TEXTURE_2D, 0, GL11.GL_RGBA, x.get(), y.get(), 0, GL11.GL_RGBA, GL11.GL_UNSIGNED_BYTE, data);
            GL30.glGenerateMipmap(GL11.GL_TEXTURE_2D);
        } else {
            System.err.println("Failed to load stb image");
        }

        if (data != null) {
            STBImage.stbi_image_free(data);
        }

        return texture;
    }

    public void tellExistence_vec3(Vector3f value, String uniformName) {
        bind();
        int location = GL20.glGetUniformLocation(shaderProgramID, uniformName);
        GL20.glUniform3f(location, value.x, value.y, value.z);
    }

    public void tellExistence_vec4(Vector4f value, String uniformName) {
        bind();
        int location = GL20.glGetUniformLocation(shaderProgramID, uniformName);
        GL20.glUniform4f(location, value.x, value.y, value.z, value.w);
    }

    public void tellExistence_float(float value, String uniformName) {
        bind();
        int location = GL20.glGetUniformLocation(shaderProgramID, uniformName);
        GL20.glUniform1f(location, value);
    }

    public void tellExistence_int(int value, String uniformName) {
        bind();
        int location = GL20.glGetUniformLocation(shaderProgramID, uniformName);
        GL20.glUniform1i(location, value);
    }

    private String loadFile(String path) {
        StringBuilder stringBuilder = new StringBuilder();

        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(path));) {
            String s = "";
            while ((s = bufferedReader.readLine()) != null) {
                stringBuilder.append(s).append("\n");
            }
        } catch (IOException e) {
            System.err.println("Cant find your non-existent file at: " + path);
        }

        return stringBuilder.toString();
    }

    public int getTexture() {
        return texture;
    }

    public int getShaderProgramID() {
        return shaderProgramID;
    }
}
