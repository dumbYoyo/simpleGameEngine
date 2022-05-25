package zuimamamba;

import org.joml.Matrix4f;
import org.joml.Vector3f;
import org.lwjgl.BufferUtils;
import org.lwjgl.opengl.*;

import java.nio.FloatBuffer;
import java.nio.IntBuffer;

public class Mesh {
    private int vaoID, vboID, iboID, tboID, nboID;
    private int[] indices;
    public Shader shader;
    private Vector3f position = new Vector3f();
    private Vector3f rotationAxis = new Vector3f();
    private Vector3f scale = new Vector3f(1, 1, 1);
    private float rotationAngle = 0;
    private Camera camera = new Camera();
    private int fuku;

    public Mesh() {
        float[] vertices = {
                -0.5f, 0.5f, 0.0f,
                -0.5f, -0.5f, 0.0f,
                0.5f, -0.5f, 0.0f,
        };
        int[] indices = {
                0, 1, 2
        };

        this.indices = indices;

        shader = new Shader();

        vaoID = GL30.glGenVertexArrays();
        GL30.glBindVertexArray(vaoID);

        vboID = GL15.glGenBuffers();
        GL15.glBindBuffer(GL15.GL_ARRAY_BUFFER, vboID);
        FloatBuffer vboBuffer = BufferUtils.createFloatBuffer(vertices.length);
        vboBuffer.put(vertices).flip();
        GL15.glBufferData(GL15.GL_ARRAY_BUFFER, vboBuffer, GL15.GL_STATIC_DRAW);
        GL30.glVertexAttribPointer(0, 3, GL11.GL_FLOAT, false, 0, 0);
        GL30.glEnableVertexAttribArray(0);

        iboID = GL15.glGenBuffers();
        GL15.glBindBuffer(GL15.GL_ELEMENT_ARRAY_BUFFER, iboID);
        IntBuffer iboBuffer = BufferUtils.createIntBuffer(indices.length);
        iboBuffer.put(indices).flip();
        GL15.glBufferData(GL15.GL_ELEMENT_ARRAY_BUFFER, iboBuffer, GL15.GL_STATIC_DRAW);
    }

    public Mesh(float[] vertices, float[] textureCoord, float[] normals, int[] indices) {
        this.indices = indices;

        shader = new Shader();
        // fuku = shader.loadTexture("res/imgs/container_specular.png");

        vaoID = GL30.glGenVertexArrays();
        GL30.glBindVertexArray(vaoID);

        vboID = GL15.glGenBuffers();
        GL15.glBindBuffer(GL15.GL_ARRAY_BUFFER, vboID);
        FloatBuffer vboBuffer = BufferUtils.createFloatBuffer(vertices.length);
        vboBuffer.put(vertices).flip();
        GL15.glBufferData(GL15.GL_ARRAY_BUFFER, vboBuffer, GL15.GL_STATIC_DRAW);
        GL30.glVertexAttribPointer(0, 3, GL11.GL_FLOAT, false, 0, 0);
        GL30.glEnableVertexAttribArray(0);

        tboID = GL15.glGenBuffers();
        GL15.glBindBuffer(GL15.GL_ARRAY_BUFFER, tboID);
        FloatBuffer tboBuffer = BufferUtils.createFloatBuffer(textureCoord.length);
        tboBuffer.put(textureCoord).flip();
        GL15.glBufferData(GL15.GL_ARRAY_BUFFER, tboBuffer, GL15.GL_STATIC_DRAW);
        GL30.glVertexAttribPointer(1, 2, GL11.GL_FLOAT, false, 0, 0);
        GL30.glEnableVertexAttribArray(1);

        nboID = GL15.glGenBuffers();
        GL15.glBindBuffer(GL15.GL_ARRAY_BUFFER, nboID);
        FloatBuffer nboBuffer = BufferUtils.createFloatBuffer(normals.length);
        nboBuffer.put(normals).flip();
        GL15.glBufferData(GL15.GL_ARRAY_BUFFER, nboBuffer, GL15.GL_STATIC_DRAW);
        GL30.glVertexAttribPointer(2, 3, GL11.GL_FLOAT, false, 0, 0);
        GL30.glEnableVertexAttribArray(2);

        iboID = GL15.glGenBuffers();
        GL15.glBindBuffer(GL15.GL_ELEMENT_ARRAY_BUFFER, iboID);
        IntBuffer iboBuffer = BufferUtils.createIntBuffer(indices.length);
        iboBuffer.put(indices).flip();
        GL15.glBufferData(GL15.GL_ELEMENT_ARRAY_BUFFER, iboBuffer, GL15.GL_STATIC_DRAW);
    }

    public Mesh(float[] vertices, float[] textureCoord, float[] normals, int[] indices, String vertexShaderPath, String fragmentShaderPath) {
        this.indices = indices;

        shader = new Shader(vertexShaderPath, fragmentShaderPath);

        vaoID = GL30.glGenVertexArrays();
        GL30.glBindVertexArray(vaoID);

        vboID = GL15.glGenBuffers();
        GL15.glBindBuffer(GL15.GL_ARRAY_BUFFER, vboID);
        FloatBuffer vboBuffer = BufferUtils.createFloatBuffer(vertices.length);
        vboBuffer.put(vertices).flip();
        GL15.glBufferData(GL15.GL_ARRAY_BUFFER, vboBuffer, GL15.GL_STATIC_DRAW);
        GL30.glVertexAttribPointer(0, 3, GL11.GL_FLOAT, false, 0, 0);
        GL30.glEnableVertexAttribArray(0);

        tboID = GL15.glGenBuffers();
        GL15.glBindBuffer(GL15.GL_ARRAY_BUFFER, tboID);
        FloatBuffer tboBuffer = BufferUtils.createFloatBuffer(textureCoord.length);
        tboBuffer.put(textureCoord).flip();
        GL15.glBufferData(GL15.GL_ARRAY_BUFFER, tboBuffer, GL15.GL_STATIC_DRAW);
        GL30.glVertexAttribPointer(1, 2, GL11.GL_FLOAT, false, 0, 0);
        GL30.glEnableVertexAttribArray(1);

        nboID = GL15.glGenBuffers();
        GL15.glBindBuffer(GL15.GL_ARRAY_BUFFER, nboID);
        FloatBuffer nboBuffer = BufferUtils.createFloatBuffer(normals.length);
        nboBuffer.put(normals).flip();
        GL15.glBufferData(GL15.GL_ARRAY_BUFFER, nboBuffer, GL15.GL_STATIC_DRAW);
        GL30.glVertexAttribPointer(2, 3, GL11.GL_FLOAT, false, 0, 0);
        GL30.glEnableVertexAttribArray(2);

        iboID = GL15.glGenBuffers();
        GL15.glBindBuffer(GL15.GL_ELEMENT_ARRAY_BUFFER, iboID);
        IntBuffer iboBuffer = BufferUtils.createIntBuffer(indices.length);
        iboBuffer.put(indices).flip();
        GL15.glBufferData(GL15.GL_ELEMENT_ARRAY_BUFFER, iboBuffer, GL15.GL_STATIC_DRAW);
    }

    public void bind() {
        shader.bind();
        GL11.glBindTexture(GL11.GL_TEXTURE_2D, shader.getTexture());
        GL30.glBindVertexArray(vaoID);
        GL15.glBindBuffer(GL15.GL_ARRAY_BUFFER, vboID);
        GL15.glBindBuffer(GL15.GL_ARRAY_BUFFER, tboID);
        GL30.glEnableVertexAttribArray(0);
        GL30.glEnableVertexAttribArray(1);
        GL30.glEnableVertexAttribArray(2);

        // transformationMatrix();
        modelMatrix();
        viewMatrix();
        projectionMatrix();
    }

    public void unBind() {
        GL30.glDisableVertexAttribArray(0);
        GL30.glDisableVertexAttribArray(1);
        GL30.glDisableVertexAttribArray(2);
        GL11.glBindTexture(GL11.GL_TEXTURE_2D, 0);
        GL15.glBindBuffer(GL15.GL_ARRAY_BUFFER, 0);
        GL30.glBindVertexArray(0);
        shader.unbind();
    }

    public void render(boolean autoBind) {
        if (autoBind) {
            shader.bind();
            GL11.glBindTexture(GL11.GL_TEXTURE_2D, shader.getTexture());
            GL30.glBindVertexArray(vaoID);
            GL15.glBindBuffer(GL15.GL_ARRAY_BUFFER, vboID);
            GL15.glBindBuffer(GL15.GL_ARRAY_BUFFER, tboID);
            GL30.glEnableVertexAttribArray(0);
            GL30.glEnableVertexAttribArray(1);
            GL30.glEnableVertexAttribArray(2);

            // transformationMatrix();
            modelMatrix();
            viewMatrix();
            // TODO: MOVE THESE matrices to camera class
            projectionMatrix();

            GL15.glDrawElements(GL11.GL_TRIANGLES, indices.length, GL11.GL_UNSIGNED_INT, 0);

            int err;
            while ((err = GL11.glGetError()) != GL11.GL_NO_ERROR) {
                System.out.println("OPENGL error: " + err);
            }

            GL30.glDisableVertexAttribArray(0);
            GL30.glDisableVertexAttribArray(1);
            GL30.glDisableVertexAttribArray(2);
            GL15.glBindBuffer(GL15.GL_ARRAY_BUFFER, 0);
            GL11.glBindTexture(GL11.GL_TEXTURE_2D, 0);
            GL30.glBindVertexArray(0);
            shader.unbind();
        } else {
            GL15.glDrawElements(GL11.GL_TRIANGLES, indices.length, GL11.GL_UNSIGNED_INT, 0);

            int err;
            while ((err = GL11.glGetError()) != GL11.GL_NO_ERROR) {
                System.out.println("OPENGL error: " + err);
            }
        }
    }

    public void setTexture(String texturePath) {
        shader.loadTexture(texturePath);
    }

    public void setPosition(Vector3f position) {
        this.position = position;
    }

    public void setRotationAxis(Vector3f rotationAxis) {
        this.rotationAxis = rotationAxis;
    }

    public void setScale(Vector3f scale) {
        this.scale = scale;
    }

    public void setRotationAngle(float rotationAngle) {
        this.rotationAngle = rotationAngle;
    }

    public void activateTexture(int textureID, int textureBank) {
        GL20.glActiveTexture(textureBank);
        GL20.glBindTexture(GL11.GL_TEXTURE_2D, textureID);
    }

    private void transformationMatrix() {
        Matrix4f trans = new Matrix4f().identity();
        trans.translate(position);
        trans.rotate((float) Math.toRadians(rotationAngle), rotationAxis);
        trans.scale(scale);

        int transLocation = GL20.glGetUniformLocation(shader.getShaderProgramID(), "transform");
        FloatBuffer transBuffer = BufferUtils.createFloatBuffer(16);
        trans.get(transBuffer);
        GL20.glUniformMatrix4fv(transLocation, false, transBuffer);
    }

    private void modelMatrix() {
        Matrix4f model = new Matrix4f().identity();
        model.rotate((float) Math.toRadians(rotationAngle), rotationAxis);
        model.translate(position);
        model.scale(scale);

        int modelLocation = GL20.glGetUniformLocation(shader.getShaderProgramID(), "model");
        FloatBuffer modelBuffer = BufferUtils.createFloatBuffer(16);
        model.get(modelBuffer);
        GL20.glUniformMatrix4fv(modelLocation, false, modelBuffer);
    }

    private void viewMatrix() {
        Matrix4f view =  camera.getViewMatrix();
        shader.tellExistence_vec3(new Vector3f(camera.position.x, camera.position.y, camera.position.z), "viewPos");

        int viewLocation = GL20.glGetUniformLocation(shader.getShaderProgramID(), "view");
        FloatBuffer viewBuffer = BufferUtils.createFloatBuffer(16);
        view.get(viewBuffer);
        GL20.glUniformMatrix4fv(viewLocation, false, viewBuffer);
    }

    private void projectionMatrix() {
        Matrix4f proj = new Matrix4f().identity();
        proj.perspective(45, 1280f/720, 0.1f, 1000f);

        int projLocation = GL20.glGetUniformLocation(shader.getShaderProgramID(), "proj");
        FloatBuffer projBuffer = BufferUtils.createFloatBuffer(16);
        proj.get(projBuffer);
        GL20.glUniformMatrix4fv(projLocation, false, projBuffer);
    }
}
