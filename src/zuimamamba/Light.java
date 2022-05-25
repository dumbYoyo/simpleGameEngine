package zuimamamba;

import org.joml.Vector3f;

public class Light extends GameObject {
    public Vector3f color;
    public Vector3f ambient;
    public Vector3f diffuse;
    public Vector3f specular;
    // TODO: this must have its own class

    public float constant;
    public float linear;
    public float quadratic;

    public Vector3f direction;

    public String lightType;

    public Light() {
        color = new Vector3f(1f);
        ambient = new Vector3f(0.1f);
        diffuse = new Vector3f(1f);
        specular = new Vector3f(1f);
        direction = new Vector3f(-0.2f, -1.0f, -0.3f);
        constant = 1f;
        linear = 0.09f;
        quadratic = 0.032f;
    }

    public void init(String lightType) {
        this.lightType = lightType;

        this.init("Cube", "res/imgs/blank.png",
                "res/shaders/light/vertexShader.glsl", "res/shaders/light/fragmentShader.glsl",
                0);
    }
}
