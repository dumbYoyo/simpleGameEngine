package zuimamamba;

import org.joml.Vector3f;
import org.joml.Vector4f;
import org.lwjgl.opengl.GL13;

public class GameObject {
    public Mesh mesh = null;
    public Vector3f position = new Vector3f(0, 0, 0);
    public Vector3f scale = new Vector3f(1, 1, 1);
    public Vector3f rotationAxis = new Vector3f(0, 0, 0);
    public Light lightToUse = null;
    public float rotationAngle = 0;
    public String activateTexturePath_1, activateTexturePath_2, activateTexturePath_3;

    public Properties properties = new Properties();
    public Material material = new Material();

    public void init() {
        float[] vertices = {
                -0.5f, 0.5f, 0.0f,
                -0.5f, -0.5f, 0.0f,
                0.5f, -0.5f, 0.0f,
                0.5f, 0.5f, 0.0f
        };
        float[] textureCoord = {
                1.0f, 1.0f,
                1.0f, 0.0f,
                0.0f, 0.0f,
                0.0f, 1.0f
        };
        float[] normals = {
                0.0f, 0.0f, -1.0f,
                0.0f, 0.0f, -1.0f,
                0.0f, 0.0f, -1.0f,
                0.0f, 0.0f, -1.0f,
        };
        int[] indices = {
                0, 1, 2, 2, 3, 0
        };

        mesh = new Mesh(vertices, textureCoord, normals, indices);
        mesh.setTexture("res/imgs/pic.png");
    }

    public void init(String vertexShaderPath, String fragmentShaderPath) {
        float[] vertices = {
                -0.5f, 0.5f, 0.0f,
                -0.5f, -0.5f, 0.0f,
                0.5f, -0.5f, 0.0f,
                0.5f, 0.5f, 0.0f
        };
        float[] textureCoord = {
                1.0f, 1.0f,
                1.0f, 0.0f,
                0.0f, 0.0f,
                0.0f, 1.0f
        };
        float[] normals = {
                0.0f, 0.0f, -1.0f,
                0.0f, 0.0f, -1.0f,
                0.0f, 0.0f, -1.0f,
                0.0f, 0.0f, -1.0f,
        };
        int[] indices = {
                0, 1, 2, 2, 3, 0
        };

        mesh = new Mesh(vertices, textureCoord, normals, indices, vertexShaderPath, fragmentShaderPath);
        mesh.setTexture("res/imgs/pic.png");
    }

    public void init(String texturePath) {
        float[] vertices = {
                -0.5f, 0.5f, 0.0f,
                -0.5f, -0.5f, 0.0f,
                0.5f, -0.5f, 0.0f,
                0.5f, 0.5f, 0.0f
        };
        float[] textureCoord = {
                1.0f, 1.0f,
                1.0f, 0.0f,
                0.0f, 0.0f,
                0.0f, 1.0f
        };
        float[] normals = {
                0.0f, 0.0f, -1.0f,
                0.0f, 0.0f, -1.0f,
                0.0f, 0.0f, -1.0f,
                0.0f, 0.0f, -1.0f,
        };
        int[] indices = {
                0, 1, 2, 2, 3, 0
        };

        mesh = new Mesh(vertices, textureCoord, normals, indices);
        mesh.setTexture(texturePath);
    }

    public void init(String texturePath, String vertexShaderPath, String fragmentShaderPath) {
        float[] vertices = {
                -0.5f, 0.5f, 0.0f,
                -0.5f, -0.5f, 0.0f,
                0.5f, -0.5f, 0.0f,
                0.5f, 0.5f, 0.0f
        };
        float[] textureCoord = {
                1.0f, 1.0f,
                1.0f, 0.0f,
                0.0f, 0.0f,
                0.0f, 1.0f
        };
        float[] normals = {
                0.0f, 0.0f, -1.0f,
                0.0f, 0.0f, -1.0f,
                0.0f, 0.0f, -1.0f,
                0.0f, 0.0f, -1.0f,
        };
        int[] indices = {
                0, 1, 2, 2, 3, 0
        };

        mesh = new Mesh(vertices, textureCoord, normals, indices, vertexShaderPath, fragmentShaderPath);
        mesh.setTexture(texturePath);
    }

    public void init(float[] vertices, float[] textureCoord, float[] normals, int[] indices, String vertexShaderPath, String fragmentShaderPath) {
        mesh = new Mesh(vertices, textureCoord, normals, indices, vertexShaderPath, fragmentShaderPath);
        mesh.setTexture("res/imgs/pic.png");
    }

    public void init(float[] vertices, float[] textureCoord, float[] normals, int[] indices, String texturePath) {
        mesh = new Mesh(vertices, textureCoord, normals, indices);
        mesh.setTexture(texturePath);
    }

    public void init(float[] vertices, float[] textureCoord, float[] normals, int[] indices) {
        mesh = new Mesh(vertices, textureCoord, normals, indices);
        mesh.setTexture("res/imgs/pic.png");
    }

    public void init(float[] vertices, float[] textureCoord, float[] normals, int[] indices, String texturePath, String vertexShaderPath, String fragmentShaderPath) {
        mesh = new Mesh(vertices, textureCoord, normals, indices, vertexShaderPath, fragmentShaderPath);
        mesh.setTexture(texturePath);
    }

    public void init(String primitiveShape, int uselessShit) {
        switch (primitiveShape) {
            case "Square":
                createSquare("res/imgs/pic.png");
            case "Cube":
                createCube("res/imgs/pic.png");
        }
    }

    public void init(String primitiveShape, String vertexShaderPath, String fragmentShaderPath, int uselessShit) {
        switch (primitiveShape) {
            case "Square":
                createSquare("res/imgs/pic.png", vertexShaderPath, fragmentShaderPath);
            case "Cube":
                createCube("res/imgs/pic.png", vertexShaderPath, fragmentShaderPath);
        }
    }

    public void init(String primitiveShape, String texturePath, int uselessShit) {
        switch (primitiveShape) {
            case "Square":
                createSquare(texturePath);
            case "Cube":
                createCube(texturePath);
        }
    }

    public void init(String primitiveShape, String texturePath, String vertexShaderPath, String fragmentShaderPath, int uselessShit) {
        switch (primitiveShape) {
            case "Square":
                createSquare(texturePath, vertexShaderPath, fragmentShaderPath);
            case "Cube":
                createCube(texturePath, vertexShaderPath, fragmentShaderPath);
        }
    }
















    public void init(Light light) {
        this.lightToUse = light;
        float[] vertices = {
                -0.5f, 0.5f, -0.5f,
                -0.5f, -0.5f, -0.5f,
                0.5f, -0.5f, -0.5f,
                0.5f, 0.5f, -0.5f,

                -0.5f, 0.5f, 0.5f,
                -0.5f, -0.5f, 0.5f,
                0.5f, -0.5f, 0.5f,
                0.5f, 0.5f, 0.5f,

                0.5f, 0.5f, -0.5f,
                0.5f, -0.5f, -0.5f,
                0.5f, -0.5f, 0.5f,
                0.5f, 0.5f, 0.5f,

                -0.5f, 0.5f, -0.5f,
                -0.5f, -0.5f, -0.5f,
                -0.5f, -0.5f, 0.5f,
                -0.5f, 0.5f, 0.5f,

                -0.5f, 0.5f, 0.5f,
                -0.5f, 0.5f, -0.5f,
                0.5f, 0.5f, -0.5f,
                0.5f, 0.5f, 0.5f,

                -0.5f, -0.5f, 0.5f,
                -0.5f, -0.5f, -0.5f,
                0.5f, -0.5f, -0.5f,
                0.5f, -0.5f, 0.5f
        };

        int[] indices = {
                0, 1, 3,
                3, 1, 2,
                4, 5, 7,
                7, 5, 6,
                8, 9, 11,
                11, 9, 10,
                12, 13, 15,
                15, 13, 14,
                16, 17, 19,
                19, 17, 18,
                20, 21, 23,
                23, 21, 22
        };

        float[] textureCoord = {
                0, 0,
                0, 1,
                1, 1,
                1, 0,
                0, 0,
                0, 1,
                1, 1,
                1, 0,
                0, 0,
                0, 1,
                1, 1,
                1, 0,
                0, 0,
                0, 1,
                1, 1,
                1, 0,
                0, 0,
                0, 1,
                1, 1,
                1, 0,
                0, 0,
                0, 1,
                1, 1,
                1, 0
        };

        float[] normals = {
                0.0f, 0.0f, -1.0f,
                0.0f, 0.0f, -1.0f,
                0.0f, 0.0f, -1.0f,
                0.0f, 0.0f, -1.0f,

                0.0f, 0.0f, 1.0f,
                0.0f, 0.0f, 1.0f,
                0.0f, 0.0f, 1.0f,
                0.0f, 0.0f, 1.0f,

                1.0f, 0.0f, 0.0f,
                1.0f, 0.0f, 0.0f,
                1.0f, 0.0f, 0.0f,
                1.0f, 0.0f, 0.0f,

                -1.0f, 0.0f, 0.0f,
                -1.0f, 0.0f, 0.0f,
                -1.0f, 0.0f, 0.0f,
                -1.0f, 0.0f, 0.0f,

                0.0f, 1.0f, 0.0f,
                0.0f, 1.0f, 0.0f,
                0.0f, 1.0f, 0.0f,
                0.0f, 1.0f, 0.0f,

                0.0f, -1.0f, 0.0f,
                0.0f, -1.0f, 0.0f,
                0.0f, -1.0f, 0.0f,
                0.0f, -1.0f, 0.0f,
        };

        mesh = new Mesh(vertices, textureCoord, normals, indices);
        mesh.setTexture("res/imgs/pic.png");
    }

    public void init(String vertexShaderPath, String fragmentShaderPath, Light light) {
        this.lightToUse = light;
        float[] vertices = {
                -0.5f, 0.5f, -0.5f,
                -0.5f, -0.5f, -0.5f,
                0.5f, -0.5f, -0.5f,
                0.5f, 0.5f, -0.5f,

                -0.5f, 0.5f, 0.5f,
                -0.5f, -0.5f, 0.5f,
                0.5f, -0.5f, 0.5f,
                0.5f, 0.5f, 0.5f,

                0.5f, 0.5f, -0.5f,
                0.5f, -0.5f, -0.5f,
                0.5f, -0.5f, 0.5f,
                0.5f, 0.5f, 0.5f,

                -0.5f, 0.5f, -0.5f,
                -0.5f, -0.5f, -0.5f,
                -0.5f, -0.5f, 0.5f,
                -0.5f, 0.5f, 0.5f,

                -0.5f, 0.5f, 0.5f,
                -0.5f, 0.5f, -0.5f,
                0.5f, 0.5f, -0.5f,
                0.5f, 0.5f, 0.5f,

                -0.5f, -0.5f, 0.5f,
                -0.5f, -0.5f, -0.5f,
                0.5f, -0.5f, -0.5f,
                0.5f, -0.5f, 0.5f
        };

        int[] indices = {
                0, 1, 3,
                3, 1, 2,
                4, 5, 7,
                7, 5, 6,
                8, 9, 11,
                11, 9, 10,
                12, 13, 15,
                15, 13, 14,
                16, 17, 19,
                19, 17, 18,
                20, 21, 23,
                23, 21, 22
        };

        float[] textureCoord = {
                0, 0,
                0, 1,
                1, 1,
                1, 0,
                0, 0,
                0, 1,
                1, 1,
                1, 0,
                0, 0,
                0, 1,
                1, 1,
                1, 0,
                0, 0,
                0, 1,
                1, 1,
                1, 0,
                0, 0,
                0, 1,
                1, 1,
                1, 0,
                0, 0,
                0, 1,
                1, 1,
                1, 0
        };

        float[] normals = {
                0.0f, 0.0f, -1.0f,
                0.0f, 0.0f, -1.0f,
                0.0f, 0.0f, -1.0f,
                0.0f, 0.0f, -1.0f,

                0.0f, 0.0f, 1.0f,
                0.0f, 0.0f, 1.0f,
                0.0f, 0.0f, 1.0f,
                0.0f, 0.0f, 1.0f,

                1.0f, 0.0f, 0.0f,
                1.0f, 0.0f, 0.0f,
                1.0f, 0.0f, 0.0f,
                1.0f, 0.0f, 0.0f,

                -1.0f, 0.0f, 0.0f,
                -1.0f, 0.0f, 0.0f,
                -1.0f, 0.0f, 0.0f,
                -1.0f, 0.0f, 0.0f,

                0.0f, 1.0f, 0.0f,
                0.0f, 1.0f, 0.0f,
                0.0f, 1.0f, 0.0f,
                0.0f, 1.0f, 0.0f,

                0.0f, -1.0f, 0.0f,
                0.0f, -1.0f, 0.0f,
                0.0f, -1.0f, 0.0f,
                0.0f, -1.0f, 0.0f,
        };

        mesh = new Mesh(vertices, textureCoord, normals, indices, vertexShaderPath, fragmentShaderPath);
        mesh.setTexture("res/imgs/pic.png");
    }

    public void init(String texturePath, Light light) {
        this.lightToUse = light;
        float[] vertices = {
                -0.5f, 0.5f, -0.5f,
                -0.5f, -0.5f, -0.5f,
                0.5f, -0.5f, -0.5f,
                0.5f, 0.5f, -0.5f,

                -0.5f, 0.5f, 0.5f,
                -0.5f, -0.5f, 0.5f,
                0.5f, -0.5f, 0.5f,
                0.5f, 0.5f, 0.5f,

                0.5f, 0.5f, -0.5f,
                0.5f, -0.5f, -0.5f,
                0.5f, -0.5f, 0.5f,
                0.5f, 0.5f, 0.5f,

                -0.5f, 0.5f, -0.5f,
                -0.5f, -0.5f, -0.5f,
                -0.5f, -0.5f, 0.5f,
                -0.5f, 0.5f, 0.5f,

                -0.5f, 0.5f, 0.5f,
                -0.5f, 0.5f, -0.5f,
                0.5f, 0.5f, -0.5f,
                0.5f, 0.5f, 0.5f,

                -0.5f, -0.5f, 0.5f,
                -0.5f, -0.5f, -0.5f,
                0.5f, -0.5f, -0.5f,
                0.5f, -0.5f, 0.5f
        };

        int[] indices = {
                0, 1, 3,
                3, 1, 2,
                4, 5, 7,
                7, 5, 6,
                8, 9, 11,
                11, 9, 10,
                12, 13, 15,
                15, 13, 14,
                16, 17, 19,
                19, 17, 18,
                20, 21, 23,
                23, 21, 22
        };

        float[] textureCoord = {
                0, 0,
                0, 1,
                1, 1,
                1, 0,
                0, 0,
                0, 1,
                1, 1,
                1, 0,
                0, 0,
                0, 1,
                1, 1,
                1, 0,
                0, 0,
                0, 1,
                1, 1,
                1, 0,
                0, 0,
                0, 1,
                1, 1,
                1, 0,
                0, 0,
                0, 1,
                1, 1,
                1, 0
        };

        float[] normals = {
                0.0f, 0.0f, -1.0f,
                0.0f, 0.0f, -1.0f,
                0.0f, 0.0f, -1.0f,
                0.0f, 0.0f, -1.0f,

                0.0f, 0.0f, 1.0f,
                0.0f, 0.0f, 1.0f,
                0.0f, 0.0f, 1.0f,
                0.0f, 0.0f, 1.0f,

                1.0f, 0.0f, 0.0f,
                1.0f, 0.0f, 0.0f,
                1.0f, 0.0f, 0.0f,
                1.0f, 0.0f, 0.0f,

                -1.0f, 0.0f, 0.0f,
                -1.0f, 0.0f, 0.0f,
                -1.0f, 0.0f, 0.0f,
                -1.0f, 0.0f, 0.0f,

                0.0f, 1.0f, 0.0f,
                0.0f, 1.0f, 0.0f,
                0.0f, 1.0f, 0.0f,
                0.0f, 1.0f, 0.0f,

                0.0f, -1.0f, 0.0f,
                0.0f, -1.0f, 0.0f,
                0.0f, -1.0f, 0.0f,
                0.0f, -1.0f, 0.0f,
        };

        mesh = new Mesh(vertices, textureCoord, normals, indices);
        mesh.setTexture(texturePath);
    }

    public void init(String texturePath, String vertexShaderPath, String fragmentShaderPath, Light light) {
        this.lightToUse = light;
        float[] vertices = {
                -0.5f, 0.5f, -0.5f,
                -0.5f, -0.5f, -0.5f,
                0.5f, -0.5f, -0.5f,
                0.5f, 0.5f, -0.5f,

                -0.5f, 0.5f, 0.5f,
                -0.5f, -0.5f, 0.5f,
                0.5f, -0.5f, 0.5f,
                0.5f, 0.5f, 0.5f,

                0.5f, 0.5f, -0.5f,
                0.5f, -0.5f, -0.5f,
                0.5f, -0.5f, 0.5f,
                0.5f, 0.5f, 0.5f,

                -0.5f, 0.5f, -0.5f,
                -0.5f, -0.5f, -0.5f,
                -0.5f, -0.5f, 0.5f,
                -0.5f, 0.5f, 0.5f,

                -0.5f, 0.5f, 0.5f,
                -0.5f, 0.5f, -0.5f,
                0.5f, 0.5f, -0.5f,
                0.5f, 0.5f, 0.5f,

                -0.5f, -0.5f, 0.5f,
                -0.5f, -0.5f, -0.5f,
                0.5f, -0.5f, -0.5f,
                0.5f, -0.5f, 0.5f
        };

        int[] indices = {
                0, 1, 3,
                3, 1, 2,
                4, 5, 7,
                7, 5, 6,
                8, 9, 11,
                11, 9, 10,
                12, 13, 15,
                15, 13, 14,
                16, 17, 19,
                19, 17, 18,
                20, 21, 23,
                23, 21, 22
        };

        float[] textureCoord = {
                0, 0,
                0, 1,
                1, 1,
                1, 0,
                0, 0,
                0, 1,
                1, 1,
                1, 0,
                0, 0,
                0, 1,
                1, 1,
                1, 0,
                0, 0,
                0, 1,
                1, 1,
                1, 0,
                0, 0,
                0, 1,
                1, 1,
                1, 0,
                0, 0,
                0, 1,
                1, 1,
                1, 0
        };

        float[] normals = {
                0.0f, 0.0f, -1.0f,
                0.0f, 0.0f, -1.0f,
                0.0f, 0.0f, -1.0f,
                0.0f, 0.0f, -1.0f,

                0.0f, 0.0f, 1.0f,
                0.0f, 0.0f, 1.0f,
                0.0f, 0.0f, 1.0f,
                0.0f, 0.0f, 1.0f,

                1.0f, 0.0f, 0.0f,
                1.0f, 0.0f, 0.0f,
                1.0f, 0.0f, 0.0f,
                1.0f, 0.0f, 0.0f,

                -1.0f, 0.0f, 0.0f,
                -1.0f, 0.0f, 0.0f,
                -1.0f, 0.0f, 0.0f,
                -1.0f, 0.0f, 0.0f,

                0.0f, 1.0f, 0.0f,
                0.0f, 1.0f, 0.0f,
                0.0f, 1.0f, 0.0f,
                0.0f, 1.0f, 0.0f,

                0.0f, -1.0f, 0.0f,
                0.0f, -1.0f, 0.0f,
                0.0f, -1.0f, 0.0f,
                0.0f, -1.0f, 0.0f,
        };

        mesh = new Mesh(vertices, textureCoord, normals, indices, vertexShaderPath, fragmentShaderPath);
        mesh.setTexture(texturePath);
    }

    public void init(float[] vertices, float[] textureCoord, float[] normals, int[] indices, String vertexShaderPath, String fragmentShaderPath, Light light) {
        this.lightToUse = light;
        mesh = new Mesh(vertices, textureCoord, normals, indices, vertexShaderPath, fragmentShaderPath);
        mesh.setTexture("res/imgs/pic.png");
    }

    public void init(float[] vertices, float[] textureCoord, float[] normals, int[] indices, String texturePath, Light light) {
        this.lightToUse = light;
        mesh = new Mesh(vertices, textureCoord, normals, indices);
        mesh.setTexture(texturePath);
    }

    public void init(float[] vertices, float[] textureCoord, float[] normals, int[] indices, Light light) {
        this.lightToUse = light;
        mesh = new Mesh(vertices, textureCoord, normals, indices);
        mesh.setTexture("res/imgs/pic.png");
    }

    public void init(float[] vertices, float[] textureCoord, float[] normals, int[] indices, String texturePath, String vertexShaderPath, String fragmentShaderPath, Light light) {
        this.lightToUse = light;
        mesh = new Mesh(vertices, textureCoord, normals, indices, vertexShaderPath, fragmentShaderPath);
        mesh.setTexture(texturePath);
    }

    public void init(String primitiveShape, int uselessShit, Light light) {
        switch (primitiveShape) {
            case "Square":
                createSquare("res/imgs/pic.png", light);
            case "Cube":
                createCube("res/imgs/pic.png", light);
        }
    }

    public void init(String primitiveShape, String vertexShaderPath, String fragmentShaderPath, int uselessShit, Light light) {
        switch (primitiveShape) {
            case "Square":
                createSquare("res/imgs/pic.png", vertexShaderPath, fragmentShaderPath, light);
            case "Cube":
                createCube("res/imgs/pic.png", vertexShaderPath, fragmentShaderPath, light);
        }
    }

    public void init(String primitiveShape, String texturePath, int uselessShit, Light light) {
        switch (primitiveShape) {
            case "Square":
                createSquare(texturePath, light);
            case "Cube":
                createCube(texturePath, light);
        }
    }

    public void init(String primitiveShape, String texturePath, String vertexShaderPath, String fragmentShaderPath, int uselessShit, Light light) {
        switch (primitiveShape) {
            case "Square":
                createSquare(texturePath, vertexShaderPath, fragmentShaderPath, light);
            case "Cube":
                createCube(texturePath, vertexShaderPath, fragmentShaderPath, light);
        }
    }


    private void activateTexture() {
        mesh.activateTexture(mesh.shader.getTexture(), GL13.GL_TEXTURE0);
    }

    private boolean loaded = false;
    private int counter = 0;
    private int texture1, texture2, texture3;

    private void activateTexture(String texturePath_1) {
        this.activateTexturePath_1 = texturePath_1;
        if (!loaded) {
            for (int i = 0; i < 1; i++) {
                counter += 1;
                if (counter == 1) {
                    texture1 = Shader.loadTexture(activateTexturePath_1, 0);
                }
            }
            loaded = true;
        }

        mesh.activateTexture(texture1, GL13.GL_TEXTURE1);
    }

    private void activateTexture(String texturePath_1, String texturePath_2) {
        this.activateTexturePath_1 = texturePath_1;
        this.activateTexturePath_2 = texturePath_2;
        if (!loaded) {
            for (int i = 0; i < 2; i++) {
                counter += 1;
                switch (counter) {
                    case 1 -> {
                        texture1 = Shader.loadTexture(activateTexturePath_1, 0);

                    }

                    case 2 -> {
                        texture2 = Shader.loadTexture(activateTexturePath_2, 0);

                    }
                }
            }
            loaded = true;
        }

        mesh.activateTexture(texture1, GL13.GL_TEXTURE1);
        mesh.activateTexture(texture2, GL13.GL_TEXTURE2);
    }

    private void activateTexture(String texturePath_1, String texturePath_2, String texturePath_3) {
        this.activateTexturePath_1 = texturePath_1;
        this.activateTexturePath_2 = texturePath_2;
        this.activateTexturePath_3 = texturePath_3;
        if (!loaded) {
            for (int i = 0; i < 3; i++) {
                counter += 1;
                switch (counter) {
                    case 1 -> {
                        texture1 = Shader.loadTexture(activateTexturePath_1, 0);
                        // mesh.activateTexture(texture, GL13.GL_TEXTURE0);
                    }

                    case 2 -> {
                        texture2 = Shader.loadTexture(activateTexturePath_2, 0);
                        // mesh.activateTexture(texture, GL13.GL_TEXTURE0);
                    }

                    case 3 -> {
                        texture3 = Shader.loadTexture(activateTexturePath_3, 0);
                        // mesh.activateTexture(texture, GL13.GL_TEXTURE0);
                    }
                }
            }
            loaded = true;
        }

        mesh.activateTexture(texture1, GL13.GL_TEXTURE1);
        mesh.activateTexture(texture2, GL13.GL_TEXTURE2);
        mesh.activateTexture(texture3, GL13.GL_TEXTURE3);
    }




















    public void setMaterial(int diffuse_textureUnit_1, int specular_textureUnit_1, float shininess, Light light) {
        this.lightToUse = light;
        material.specular_1 = specular_textureUnit_1;
        material.diffuse = diffuse_textureUnit_1;
        material.shininess = shininess;
        mesh.shader.tellExistence_int(material.diffuse, "material.diffuse_samp");
        mesh.shader.tellExistence_int(material.specular_1, "material.specular_samp_1");
        mesh.shader.tellExistence_float(material.shininess, "material.shininess");
    }

    public void setMaterial(int diffuse_textureUnit_1, int specular_textureUnit_1, int emission_textureUnit_2, float shininess, Light light) {
        this.lightToUse = light;
        material.specular_1 = specular_textureUnit_1;
        material.emission_1 = emission_textureUnit_2;
        material.diffuse = diffuse_textureUnit_1;
        material.shininess = shininess;
        mesh.shader.tellExistence_int(material.diffuse, "material.diffuse_samp");
        mesh.shader.tellExistence_int(material.specular_1, "material.specular_samp_1");
        mesh.shader.tellExistence_int(material.emission_1, "material.specular_samp_2");
        mesh.shader.tellExistence_float(material.shininess, "material.shininess");
    }

    public void setMaterial(int diffuse_textureUnit_1, int specular_textureUnit_1, float shininess,
                            String specularUniformName, String shininessUniformName,
                            Light light) {
        this.lightToUse = light;
        material.specular_1 = specular_textureUnit_1;
        material.diffuse = diffuse_textureUnit_1;
        material.shininess = shininess;
        mesh.shader.tellExistence_int(material.diffuse, "material.diffuse_samp");
        mesh.shader.tellExistence_int(material.specular_1, "material.specular_samp_1");
        mesh.shader.tellExistence_int(material.specular_1, specularUniformName);
        mesh.shader.tellExistence_float(material.shininess, shininessUniformName);
    }

    public void setMaterial(int diffuse_textureUnit_1, int specular_textureUnit_1, float shininess,
                            String specularUniformName, String shininessUniformName,
                            String lightPositionUniformName, String lightColorUniformName, String lightAmbientUniformName, String lightDiffuseUniformName, String lightSpecularUniformName,
                            Light light) {
        this.lightToUse = light;
        material.specular_1 = specular_textureUnit_1;
        material.diffuse = diffuse_textureUnit_1;
        material.shininess = shininess;
        mesh.shader.tellExistence_int(diffuse_textureUnit_1, "material.diffuse_samp");
        mesh.shader.tellExistence_int(specular_textureUnit_1, "material.specular_samp_1");
        mesh.shader.tellExistence_int(material.specular_1, specularUniformName);
        mesh.shader.tellExistence_float(material.shininess, shininessUniformName);

        mesh.shader.tellExistence_vec3(light.position, lightPositionUniformName);
        mesh.shader.tellExistence_vec3(light.color, lightColorUniformName);
        mesh.shader.tellExistence_vec3(light.ambient, lightAmbientUniformName);
        mesh.shader.tellExistence_vec3(light.diffuse, lightDiffuseUniformName);
        mesh.shader.tellExistence_vec3(light.specular, lightSpecularUniformName);
    }

    // not sure if this will work
    public void setProperties(Vector4f objectColor, boolean hasColor, boolean hasSpecular, boolean hasEmission) {
        // 1 = true, 0 = false
        properties.hasColor = hasColor;
        properties.hasSpecular = hasSpecular;
        properties.hasEmission = hasEmission;
        properties.color = objectColor;

        if (properties.hasColor) {
            mesh.shader.tellExistence_vec4(properties.color, "properties.objectColor");
            mesh.shader.tellExistence_int(1, "properties.hasColor");
        } else {
            mesh.shader.tellExistence_int(0, "properties.hasColor");
        }

        if (properties.hasSpecular) {
            mesh.shader.tellExistence_int(1, "properties.hasSpecular");
        } else {
            mesh.shader.tellExistence_int(0, "properties.hasSpecular");
        }

        if (properties.hasEmission) {
            mesh.shader.tellExistence_int(1, "properties.hasEmission");
        } else {
            mesh.shader.tellExistence_int(0, "properties.hasEmission");
        }
    }

    public void setProperties(Vector4f objectColor, boolean hasColor, boolean hasSpecular, boolean hasEmission,
                              String propertyObjectColorUniformName, String propertyHasColorUniformName) {
        properties.hasColor = hasColor;
        properties.hasSpecular = hasSpecular;
        properties.hasEmission = hasEmission;
        properties.color = objectColor;

        if (properties.hasColor) {
            mesh.shader.tellExistence_vec4(properties.color, propertyObjectColorUniformName);
            mesh.shader.tellExistence_int(1, propertyHasColorUniformName);
        } else {
            mesh.shader.tellExistence_int(0, propertyHasColorUniformName);
        }

        if (properties.hasSpecular) {
            mesh.shader.tellExistence_int(1, "properties.hasSpecular");
        } else {
            mesh.shader.tellExistence_int(0, "properties.hasSpecular");
        }

        if (properties.hasEmission) {
            mesh.shader.tellExistence_int(1, "properties.hasEmission");
        } else {
            mesh.shader.tellExistence_int(0, "properties.hasEmission");
        }
    }

    public void setTexture1(String texturePath) {
        mesh.setTexture(texturePath);
    }

    public void render() {
        mesh.bind();

        if (activateTexturePath_1 != null && activateTexturePath_2 == null && activateTexturePath_3 == null) {
            activateTexture(activateTexturePath_1);
        } else {
            activateTexture();
        }

        if (activateTexturePath_2 != null && activateTexturePath_1 == null && activateTexturePath_3 == null) {
            activateTexture(activateTexturePath_2);
        } else {
            activateTexture();
        }

        if (activateTexturePath_1 != null && activateTexturePath_2 != null && activateTexturePath_3 == null) {
            activateTexture(activateTexturePath_1, activateTexturePath_2);
        } else {
            activateTexture();
        }

       if (activateTexturePath_1 != null && activateTexturePath_2 != null && activateTexturePath_3 != null) {
           activateTexture(activateTexturePath_1, activateTexturePath_2, activateTexturePath_3);
       } else {
           activateTexture();
       }

        mesh.render(false);
        mesh.unBind();
    }

    // I don't really need this thing
    public void render(boolean autoBind) {
        if (!autoBind) {
            mesh.render(false);
        } else {
            mesh.render(true);
        }
    }

    public void update() {
        mesh.setPosition(position);
        mesh.setScale(scale);
        mesh.setRotationAngle(rotationAngle);
        mesh.setRotationAxis(rotationAxis);

        if (lightToUse != null) {
            if (lightToUse.lightType.equals("Point")) {
                mesh.shader.tellExistence_int(0, "light.type");
            } else if (lightToUse.lightType.equals("Directional")) {
                mesh.shader.tellExistence_int(1, "light.type");
            } else if (lightToUse.lightType.equals("Spot")) {
                mesh.shader.tellExistence_int(2, "light.type");
                mesh.shader.tellExistence_vec3(new Vector3f(0, 1, 0), "light.position");
                mesh.shader.tellExistence_vec3(new Vector3f( 0, -10, 1), "light.direction");
                mesh.shader.tellExistence_float((float) Math.cos(12), "light.cutOff");
            }
            mesh.shader.tellExistence_vec3(lightToUse.direction, "light.direction");
            mesh.shader.tellExistence_float(lightToUse.constant, "light.constant");
            mesh.shader.tellExistence_float(lightToUse.linear, "light.linear");
            mesh.shader.tellExistence_float(lightToUse.quadratic, "light.quadratic");
            mesh.shader.tellExistence_vec3(lightToUse.position, "light.position");
            mesh.shader.tellExistence_vec3(lightToUse.color, "lightColor");
            mesh.shader.tellExistence_vec3(lightToUse.ambient, "light.ambient");
            mesh.shader.tellExistence_vec3(lightToUse.diffuse, "light.diffuse");
            mesh.shader.tellExistence_vec3(lightToUse.specular, "light.specular");
        }
    }

    private void createSquare(String texturePath) {
        float[] vertices = {
                -0.5f, 0.5f, 0.0f,
                -0.5f, -0.5f, 0.0f,
                0.5f, -0.5f, 0.0f,
                0.5f, 0.5f, 0.0f
        };
        float[] textureCoord = {
                1.0f, 1.0f,
                1.0f, 0.0f,
                0.0f, 0.0f,
                0.0f, 1.0f
        };
        float[] normals = {
                0.0f, 0.0f, -1.0f,
                0.0f, 0.0f, -1.0f,
                0.0f, 0.0f, -1.0f,
                0.0f, 0.0f, -1.0f,
                0.0f, 0.0f, -1.0f,
                0.0f, 0.0f, -1.0f,
        };
        int[] indices = {
                0, 1, 2, 2, 3, 0
        };

        mesh = new Mesh(vertices, textureCoord, normals, indices);
        mesh.setTexture(texturePath);
    }

    private void createCube(String texturePath) {
        float[] vertices = {
                -0.5f, 0.5f, -0.5f,
                -0.5f, -0.5f, -0.5f,
                0.5f, -0.5f, -0.5f,
                0.5f, 0.5f, -0.5f,

                -0.5f, 0.5f, 0.5f,
                -0.5f, -0.5f, 0.5f,
                0.5f, -0.5f, 0.5f,
                0.5f, 0.5f, 0.5f,

                0.5f, 0.5f, -0.5f,
                0.5f, -0.5f, -0.5f,
                0.5f, -0.5f, 0.5f,
                0.5f, 0.5f, 0.5f,

                -0.5f, 0.5f, -0.5f,
                -0.5f, -0.5f, -0.5f,
                -0.5f, -0.5f, 0.5f,
                -0.5f, 0.5f, 0.5f,

                -0.5f, 0.5f, 0.5f,
                -0.5f, 0.5f, -0.5f,
                0.5f, 0.5f, -0.5f,
                0.5f, 0.5f, 0.5f,

                -0.5f, -0.5f, 0.5f,
                -0.5f, -0.5f, -0.5f,
                0.5f, -0.5f, -0.5f,
                0.5f, -0.5f, 0.5f
        };

        int[] indices = {
                0, 1, 3,
                3, 1, 2,
                4, 5, 7,
                7, 5, 6,
                8, 9, 11,
                11, 9, 10,
                12, 13, 15,
                15, 13, 14,
                16, 17, 19,
                19, 17, 18,
                20, 21, 23,
                23, 21, 22
        };

        float[] textureCoord = {
                0, 0,
                0, 1,
                1, 1,
                1, 0,
                0, 0,
                0, 1,
                1, 1,
                1, 0,
                0, 0,
                0, 1,
                1, 1,
                1, 0,
                0, 0,
                0, 1,
                1, 1,
                1, 0,
                0, 0,
                0, 1,
                1, 1,
                1, 0,
                0, 0,
                0, 1,
                1, 1,
                1, 0,
        };

        float[] normals = {
                0.0f, 0.0f, -1.0f,
                0.0f, 0.0f, -1.0f,
                0.0f, 0.0f, -1.0f,
                0.0f, 0.0f, -1.0f,

                0.0f, 0.0f, 1.0f,
                0.0f, 0.0f, 1.0f,
                0.0f, 0.0f, 1.0f,
                0.0f, 0.0f, 1.0f,

                1.0f, 0.0f, 0.0f,
                1.0f, 0.0f, 0.0f,
                1.0f, 0.0f, 0.0f,
                1.0f, 0.0f, 0.0f,

                -1.0f, 0.0f, 0.0f,
                -1.0f, 0.0f, 0.0f,
                -1.0f, 0.0f, 0.0f,
                -1.0f, 0.0f, 0.0f,

                0.0f, 1.0f, 0.0f,
                0.0f, 1.0f, 0.0f,
                0.0f, 1.0f, 0.0f,
                0.0f, 1.0f, 0.0f,

                0.0f, -1.0f, 0.0f,
                0.0f, -1.0f, 0.0f,
                0.0f, -1.0f, 0.0f,
                0.0f, -1.0f, 0.0f,

        };

        mesh = new Mesh(vertices, textureCoord, normals, indices);
        mesh.setTexture(texturePath);
    }

    private void createSquare(String texturePath, String vertexShaderPath, String fragmentShaderPath) {
        float[] vertices = {
                -0.5f, 0.5f, 0.0f,
                -0.5f, -0.5f, 0.0f,
                0.5f, -0.5f, 0.0f,
                0.5f, 0.5f, 0.0f
        };
        float[] textureCoord = {
                1.0f, 1.0f,
                1.0f, 0.0f,
                0.0f, 0.0f,
                0.0f, 1.0f
        };
        int[] indices = {
                0, 1, 2, 2, 3, 0
        };
        float[] normals = {
                0.0f, 0.0f, -1.0f,
                0.0f, 0.0f, -1.0f,
                0.0f, 0.0f, -1.0f,
                0.0f, 0.0f, -1.0f,
        };

        mesh = new Mesh(vertices, textureCoord, normals, indices, vertexShaderPath, fragmentShaderPath);
        mesh.setTexture(texturePath);
    }

    private void createCube(String texturePath, String vertexShaderPath, String fragmentShaderPath) {
        float[] vertices = {
                -0.5f, 0.5f, -0.5f,
                -0.5f, -0.5f, -0.5f,
                0.5f, -0.5f, -0.5f,
                0.5f, 0.5f, -0.5f,

                -0.5f, 0.5f, 0.5f,
                -0.5f, -0.5f, 0.5f,
                0.5f, -0.5f, 0.5f,
                0.5f, 0.5f, 0.5f,

                0.5f, 0.5f, -0.5f,
                0.5f, -0.5f, -0.5f,
                0.5f, -0.5f, 0.5f,
                0.5f, 0.5f, 0.5f,

                -0.5f, 0.5f, -0.5f,
                -0.5f, -0.5f, -0.5f,
                -0.5f, -0.5f, 0.5f,
                -0.5f, 0.5f, 0.5f,

                -0.5f, 0.5f, 0.5f,
                -0.5f, 0.5f, -0.5f,
                0.5f, 0.5f, -0.5f,
                0.5f, 0.5f, 0.5f,

                -0.5f, -0.5f, 0.5f,
                -0.5f, -0.5f, -0.5f,
                0.5f, -0.5f, -0.5f,
                0.5f, -0.5f, 0.5f
        };

        int[] indices = {
                0, 1, 3,
                3, 1, 2,
                4, 5, 7,
                7, 5, 6,
                8, 9, 11,
                11, 9, 10,
                12, 13, 15,
                15, 13, 14,
                16, 17, 19,
                19, 17, 18,
                20, 21, 23,
                23, 21, 22
        };

        float[] textureCoord = {
                0, 0,
                0, 1,
                1, 1,
                1, 0,
                0, 0,
                0, 1,
                1, 1,
                1, 0,
                0, 0,
                0, 1,
                1, 1,
                1, 0,
                0, 0,
                0, 1,
                1, 1,
                1, 0,
                0, 0,
                0, 1,
                1, 1,
                1, 0,
                0, 0,
                0, 1,
                1, 1,
                1, 0
        };

        float[] normals = {
                0.0f, 0.0f, -1.0f,
                0.0f, 0.0f, -1.0f,
                0.0f, 0.0f, -1.0f,
                0.0f, 0.0f, -1.0f,

                0.0f, 0.0f, 1.0f,
                0.0f, 0.0f, 1.0f,
                0.0f, 0.0f, 1.0f,
                0.0f, 0.0f, 1.0f,

                1.0f, 0.0f, 0.0f,
                1.0f, 0.0f, 0.0f,
                1.0f, 0.0f, 0.0f,
                1.0f, 0.0f, 0.0f,

                -1.0f, 0.0f, 0.0f,
                -1.0f, 0.0f, 0.0f,
                -1.0f, 0.0f, 0.0f,
                -1.0f, 0.0f, 0.0f,

                0.0f, 1.0f, 0.0f,
                0.0f, 1.0f, 0.0f,
                0.0f, 1.0f, 0.0f,
                0.0f, 1.0f, 0.0f,

                0.0f, -1.0f, 0.0f,
                0.0f, -1.0f, 0.0f,
                0.0f, -1.0f, 0.0f,
                0.0f, -1.0f, 0.0f,
        };

        mesh = new Mesh(vertices, textureCoord, normals, indices, vertexShaderPath, fragmentShaderPath);
        mesh.setTexture(texturePath);
    }








    private void createSquare(String texturePath, Light light) {
        this.lightToUse = light;
        float[] vertices = {
                -0.5f, 0.5f, 0.0f,
                -0.5f, -0.5f, 0.0f,
                0.5f, -0.5f, 0.0f,
                0.5f, 0.5f, 0.0f
        };
        float[] textureCoord = {
                1.0f, 1.0f,
                1.0f, 0.0f,
                0.0f, 0.0f,
                0.0f, 1.0f
        };
        float[] normals = {
                0.0f, 0.0f, -1.0f,
                0.0f, 0.0f, -1.0f,
                0.0f, 0.0f, -1.0f,
                0.0f, 0.0f, -1.0f,
                0.0f, 0.0f, -1.0f,
                0.0f, 0.0f, -1.0f,
        };
        int[] indices = {
                0, 1, 2, 2, 3, 0
        };

        mesh = new Mesh(vertices, textureCoord, normals, indices);
        mesh.setTexture(texturePath);
    }

    private void createCube(String texturePath, Light light) {
        this.lightToUse = light;

        float[] vertices = {
                -0.5f, 0.5f, -0.5f,
                -0.5f, -0.5f, -0.5f,
                0.5f, -0.5f, -0.5f,
                0.5f, 0.5f, -0.5f,

                -0.5f, 0.5f, 0.5f,
                -0.5f, -0.5f, 0.5f,
                0.5f, -0.5f, 0.5f,
                0.5f, 0.5f, 0.5f,

                0.5f, 0.5f, -0.5f,
                0.5f, -0.5f, -0.5f,
                0.5f, -0.5f, 0.5f,
                0.5f, 0.5f, 0.5f,

                -0.5f, 0.5f, -0.5f,
                -0.5f, -0.5f, -0.5f,
                -0.5f, -0.5f, 0.5f,
                -0.5f, 0.5f, 0.5f,

                -0.5f, 0.5f, 0.5f,
                -0.5f, 0.5f, -0.5f,
                0.5f, 0.5f, -0.5f,
                0.5f, 0.5f, 0.5f,

                -0.5f, -0.5f, 0.5f,
                -0.5f, -0.5f, -0.5f,
                0.5f, -0.5f, -0.5f,
                0.5f, -0.5f, 0.5f
        };

        int[] indices = {
                0, 1, 3,
                3, 1, 2,
                4, 5, 7,
                7, 5, 6,
                8, 9, 11,
                11, 9, 10,
                12, 13, 15,
                15, 13, 14,
                16, 17, 19,
                19, 17, 18,
                20, 21, 23,
                23, 21, 22
        };

        float[] textureCoord = {
                0, 0,
                0, 1,
                1, 1,
                1, 0,
                0, 0,
                0, 1,
                1, 1,
                1, 0,
                0, 0,
                0, 1,
                1, 1,
                1, 0,
                0, 0,
                0, 1,
                1, 1,
                1, 0,
                0, 0,
                0, 1,
                1, 1,
                1, 0,
                0, 0,
                0, 1,
                1, 1,
                1, 0,
        };

        float[] normals = {
                0.0f, 0.0f, -1.0f,
                0.0f, 0.0f, -1.0f,
                0.0f, 0.0f, -1.0f,
                0.0f, 0.0f, -1.0f,

                0.0f, 0.0f, 1.0f,
                0.0f, 0.0f, 1.0f,
                0.0f, 0.0f, 1.0f,
                0.0f, 0.0f, 1.0f,

                1.0f, 0.0f, 0.0f,
                1.0f, 0.0f, 0.0f,
                1.0f, 0.0f, 0.0f,
                1.0f, 0.0f, 0.0f,

                -1.0f, 0.0f, 0.0f,
                -1.0f, 0.0f, 0.0f,
                -1.0f, 0.0f, 0.0f,
                -1.0f, 0.0f, 0.0f,

                0.0f, 1.0f, 0.0f,
                0.0f, 1.0f, 0.0f,
                0.0f, 1.0f, 0.0f,
                0.0f, 1.0f, 0.0f,

                0.0f, -1.0f, 0.0f,
                0.0f, -1.0f, 0.0f,
                0.0f, -1.0f, 0.0f,
                0.0f, -1.0f, 0.0f,

        };

        mesh = new Mesh(vertices, textureCoord, normals, indices);
        mesh.setTexture(texturePath);
    }

    private void createSquare(String texturePath, String vertexShaderPath, String fragmentShaderPath, Light light) {
        this.lightToUse = light;
        float[] vertices = {
                -0.5f, 0.5f, 0.0f,
                -0.5f, -0.5f, 0.0f,
                0.5f, -0.5f, 0.0f,
                0.5f, 0.5f, 0.0f
        };
        float[] textureCoord = {
                1.0f, 1.0f,
                1.0f, 0.0f,
                0.0f, 0.0f,
                0.0f, 1.0f
        };
        int[] indices = {
                0, 1, 2, 2, 3, 0
        };
        float[] normals = {
                0.0f, 0.0f, -1.0f,
                0.0f, 0.0f, -1.0f,
                0.0f, 0.0f, -1.0f,
                0.0f, 0.0f, -1.0f,
        };

        mesh = new Mesh(vertices, textureCoord, normals, indices, vertexShaderPath, fragmentShaderPath);
        mesh.setTexture(texturePath);
    }

    private void createCube(String texturePath, String vertexShaderPath, String fragmentShaderPath, Light light) {
        this.lightToUse = light;
        float[] vertices = {
                -0.5f, 0.5f, -0.5f,
                -0.5f, -0.5f, -0.5f,
                0.5f, -0.5f, -0.5f,
                0.5f, 0.5f, -0.5f,

                -0.5f, 0.5f, 0.5f,
                -0.5f, -0.5f, 0.5f,
                0.5f, -0.5f, 0.5f,
                0.5f, 0.5f, 0.5f,

                0.5f, 0.5f, -0.5f,
                0.5f, -0.5f, -0.5f,
                0.5f, -0.5f, 0.5f,
                0.5f, 0.5f, 0.5f,

                -0.5f, 0.5f, -0.5f,
                -0.5f, -0.5f, -0.5f,
                -0.5f, -0.5f, 0.5f,
                -0.5f, 0.5f, 0.5f,

                -0.5f, 0.5f, 0.5f,
                -0.5f, 0.5f, -0.5f,
                0.5f, 0.5f, -0.5f,
                0.5f, 0.5f, 0.5f,

                -0.5f, -0.5f, 0.5f,
                -0.5f, -0.5f, -0.5f,
                0.5f, -0.5f, -0.5f,
                0.5f, -0.5f, 0.5f
        };

        int[] indices = {
                0, 1, 3,
                3, 1, 2,
                4, 5, 7,
                7, 5, 6,
                8, 9, 11,
                11, 9, 10,
                12, 13, 15,
                15, 13, 14,
                16, 17, 19,
                19, 17, 18,
                20, 21, 23,
                23, 21, 22
        };

        float[] textureCoord = {
                0, 0,
                0, 1,
                1, 1,
                1, 0,
                0, 0,
                0, 1,
                1, 1,
                1, 0,
                0, 0,
                0, 1,
                1, 1,
                1, 0,
                0, 0,
                0, 1,
                1, 1,
                1, 0,
                0, 0,
                0, 1,
                1, 1,
                1, 0,
                0, 0,
                0, 1,
                1, 1,
                1, 0
        };

        float[] normals = {
                0.0f, 0.0f, -1.0f,
                0.0f, 0.0f, -1.0f,
                0.0f, 0.0f, -1.0f,
                0.0f, 0.0f, -1.0f,

                0.0f, 0.0f, 1.0f,
                0.0f, 0.0f, 1.0f,
                0.0f, 0.0f, 1.0f,
                0.0f, 0.0f, 1.0f,

                1.0f, 0.0f, 0.0f,
                1.0f, 0.0f, 0.0f,
                1.0f, 0.0f, 0.0f,
                1.0f, 0.0f, 0.0f,

                -1.0f, 0.0f, 0.0f,
                -1.0f, 0.0f, 0.0f,
                -1.0f, 0.0f, 0.0f,
                -1.0f, 0.0f, 0.0f,

                0.0f, 1.0f, 0.0f,
                0.0f, 1.0f, 0.0f,
                0.0f, 1.0f, 0.0f,
                0.0f, 1.0f, 0.0f,

                0.0f, -1.0f, 0.0f,
                0.0f, -1.0f, 0.0f,
                0.0f, -1.0f, 0.0f,
                0.0f, -1.0f, 0.0f,
        };

        mesh = new Mesh(vertices, textureCoord, normals, indices, vertexShaderPath, fragmentShaderPath);
        mesh.setTexture(texturePath);
    }




}

// I use it as a namespace for organization
class Material {
    public int diffuse = 0;
    public int specular_1 = 0;
    public int specular_2 = 0;
    public int emission_1 = 0;
    public float shininess = 0;
}

class Properties {
    public Vector4f color = new Vector4f();
    public boolean hasColor = false;
    public boolean hasSpecular = false;
    public boolean hasEmission = false;
}
