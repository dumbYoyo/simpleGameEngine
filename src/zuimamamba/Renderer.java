package zuimamamba;

import org.joml.Vector3f;
import org.joml.Vector4f;
import org.lwjgl.glfw.GLFW;

import java.util.ArrayList;

public class Renderer {
    private GameObject gameObject = new GameObject();
    private GameObject cube = new GameObject();
    private Light lightSource = new Light();
    private Camera camera = new Camera();

    private ArrayList<GameObject> gms = new ArrayList<>();

    public void init() {
        lightSource.init("Point");
        lightSource.position = new Vector3f(0, 0, 0);

        camera.init();

        gameObject.init("res/imgs/pic.png", lightSource);
        gameObject.position = new Vector3f(0, -1, 0);
        gameObject.scale = new Vector3f(20f, 0.4f, 20f);
        gameObject.activateTexturePath_1 = "res/imgs/pic.png";
        gameObject.setMaterial(0, 1,  32f, lightSource);
        gameObject.setProperties(new Vector4f(0 / 255f, 153 / 255f, 204 / 255f, 1), false, false, false);

        cube.init("res/imgs/container.png", lightSource);
        cube.position = new Vector3f(0, 0, 2);
        cube.activateTexturePath_1 = "res/imgs/container_specular.png";
        cube.activateTexturePath_2 = "res/imgs/lighting_maps_specular_color.png";
        cube.setMaterial(0, 1, 2, 32f, lightSource);
        cube.setProperties(null, false, true, true);

        for (int i = 0; i < 10; i++) {
            Vector3f[] positions = {
                    new Vector3f( 0.0f,  0.0f,  0.0f),
                    new Vector3f( 2.0f,  5.0f, -15.0f),
                    new Vector3f(-1.5f, -2.2f, -2.5f),
                    new Vector3f(-3.8f, -2.0f, -12.3f),
                    new Vector3f( 2.4f, -0.4f, -3.5f),
                    new Vector3f(-1.7f,  3.0f, -7.5f),
                    new Vector3f( 1.3f, -2.0f, -2.5f),
                    new Vector3f( 1.5f,  2.0f, -2.5f),
                    new Vector3f( 1.5f,  0.2f, -1.5f),
                    new Vector3f(-1.3f,  1.0f, -1.5f)
            };

            GameObject gm = new GameObject();
            gm.init("res/imgs/container.png", lightSource);
            gms.add(gm);
            gm.position = positions[i];
            gm.rotationAngle = 20f * i;
            gm.rotationAxis = new Vector3f(1.0f, 0.3f, 0.5f);
            gm.activateTexturePath_1 = "res/imgs/container_specular.png";
            gm.activateTexturePath_2 = "res/imgs/lighting_maps_specular_color.png";
            gm.setMaterial(0, 1, 2, 32f, lightSource);
            gm.setProperties(null, false, true, true);
        }
    }

    public void render() {
        lightSource.render();
        gameObject.render();
        cube.render();
        for (GameObject gm : gms) {
            // gm.render();
        }
    }

    public void update() {
        lightSource.update();
        gameObject.update();
        cube.update();
        cube.rotationAngle = 90.0f * (float) GLFW.glfwGetTime();
        cube.rotationAxis = new Vector3f(0, 0, 1);
        // gameObject.rotationAngle = 90 * (float) GLFW.glfwGetTime();
        // gameObject.rotationAxis = new Vector3f(0, 1, 0);

        // gameObject.mesh.shader.tellExistence_vec3(lightSource.position, "lightPosition");

        for (GameObject gm : gms) {
            gm.update();
        }

        if (GLFW.glfwGetKey(Window.window, GLFW.GLFW_KEY_J) == GLFW.GLFW_PRESS) {
            lightSource.position.x += 10 * Window.deltaTime;
            // lightSource.lightType = "Point";
        }

        if (GLFW.glfwGetKey(Window.window, GLFW.GLFW_KEY_K) == GLFW.GLFW_PRESS) {
            lightSource.position.x -= 10 * Window.deltaTime;
            // lightSource.lightType = "Directional";
        }
        if (GLFW.glfwGetKey(Window.window, GLFW.GLFW_KEY_I) == GLFW.GLFW_PRESS) {
            lightSource.position.z += 10 * Window.deltaTime;
        }
        if (GLFW.glfwGetKey(Window.window, GLFW.GLFW_KEY_M) == GLFW.GLFW_PRESS) {
            lightSource.position.z -= 10 * Window.deltaTime;
        }



        // TODO: why does this use so much memory
        if (GLFW.glfwGetKey(Window.window, GLFW.GLFW_KEY_A) == GLFW.GLFW_PRESS) {
            // mesh.setTexture("res/imgs/blank.png");
        }

        if (GLFW.glfwGetKey(Window.window, GLFW.GLFW_KEY_D) == GLFW.GLFW_PRESS) {
            // mesh.setTexture("res/imgs/pic.png");
        }
    }
}
