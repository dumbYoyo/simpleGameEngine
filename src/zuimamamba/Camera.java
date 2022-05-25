package zuimamamba;

import org.joml.Matrix4f;
import org.joml.Vector3f;
import org.lwjgl.glfw.GLFW;

public class Camera {
    public Vector3f position = new Vector3f(0, 0, -3);
    private Vector3f front = new Vector3f(0 , 0, -1);
    private Vector3f up = new Vector3f(0, 1, 0);
    private Vector3f target = new Vector3f();
    private Vector3f rotation = new Vector3f();
    private float moveSpeed = 3f;
    private float rotateSpeed = 3f;
    private float yaw = 0f;
    private float pitch = 0f;

    public void init() {
        target = position.add(front);
    }

    public Matrix4f getViewMatrix() {
        Matrix4f view = new Matrix4f().identity();
        bullShitMovement(view);
        // niceTrickNot(view);
        return view;
    }

    private void bullShitMovement(Matrix4f view) {
        view.translate(position);
        view.rotate(yaw, new Vector3f(0, 1, 0));
        view.rotate(pitch, new Vector3f(1, 0, 0));
        inputs(Window.deltaTime);
    }

    private void niceTrickNot(Matrix4f view) {
        view.lookAt(position, target, up);

        inputsNew(Window.deltaTime);
    }

    private void inputs(double delta) {
        // camera translation
        if (GLFW.glfwGetKey(Window.window, GLFW.GLFW_KEY_S) == GLFW.GLFW_PRESS) {
            position.z -= moveSpeed * delta;
        }
        if (GLFW.glfwGetKey(Window.window, GLFW.GLFW_KEY_W) == GLFW.GLFW_PRESS) {
            position.z += moveSpeed * delta;
        }
        if (GLFW.glfwGetKey(Window.window, GLFW.GLFW_KEY_A) == GLFW.GLFW_PRESS) {
            position.x += moveSpeed * delta;
        }
        if (GLFW.glfwGetKey(Window.window, GLFW.GLFW_KEY_D) == GLFW.GLFW_PRESS) {
            position.x -= moveSpeed * delta;
        }
        if (GLFW.glfwGetKey(Window.window, GLFW.GLFW_KEY_Q) == GLFW.GLFW_PRESS) {
            position.y += moveSpeed * delta;
        }
        if (GLFW.glfwGetKey(Window.window, GLFW.GLFW_KEY_E) == GLFW.GLFW_PRESS) {
            position.y -= moveSpeed * delta;
        }

        // TODO: fps camera movement
        // camera rotation
        if (GLFW.glfwGetKey(Window.window, GLFW.GLFW_KEY_LEFT) == GLFW.GLFW_PRESS) {
            yaw -= rotateSpeed * delta;
        }
        if (GLFW.glfwGetKey(Window.window, GLFW.GLFW_KEY_RIGHT) == GLFW.GLFW_PRESS) {
            yaw += rotateSpeed * delta;
        }
        if (GLFW.glfwGetKey(Window.window, GLFW.GLFW_KEY_UP) == GLFW.GLFW_PRESS) {
            pitch += rotateSpeed * delta;
        }
        if (GLFW.glfwGetKey(Window.window, GLFW.GLFW_KEY_DOWN) == GLFW.GLFW_PRESS) {
            pitch -= rotateSpeed * delta;
        }
    }

    private void inputsNew(double delta) {
        front = new Vector3f(0, 0, -1);
        if (GLFW.glfwGetKey(Window.window, GLFW.GLFW_KEY_W) == GLFW.GLFW_PRESS) {
            position = position.add(front.mul(moveSpeed * (float) delta));
        }
        if (GLFW.glfwGetKey(Window.window, GLFW.GLFW_KEY_S) == GLFW.GLFW_PRESS) {
            position = position.sub(front.mul(moveSpeed * (float) delta));
        }
        if (GLFW.glfwGetKey(Window.window, GLFW.GLFW_KEY_A) == GLFW.GLFW_PRESS) {
            position = front.cross(up).mul(moveSpeed * (float) delta);
        }
        if (GLFW.glfwGetKey(Window.window, GLFW.GLFW_KEY_D) == GLFW.GLFW_PRESS) {
            position = position.sub(front.mul(moveSpeed * (float) delta));
        }
    }
}
