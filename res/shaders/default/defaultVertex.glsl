#version 330 core

layout (location = 0) in vec3 aPos;
layout (location = 1) in vec2 aTextureCoord;
layout (location = 2) in vec3 aNormal;

out vec2 textureCoord;
out vec3 normal;
out vec3 fragPos; // we do all the lighting position in world space

uniform mat4 transform;

uniform mat4 model;
uniform mat4 view;
uniform mat4 proj;

void main()
{
    gl_Position = proj * view * model * vec4(aPos.xyz, 1.0);
    fragPos = vec3(model * vec4(aPos.xyz, 1.0)); // convert the vertex local position to world position
    textureCoord = aTextureCoord;
    normal = mat3(transpose(inverse(model))) * aNormal;
    // normal = (model * vec4(aNormal, 0.0)).xyz;

    vec4 worldPos = model * vec4(aPos.xyz, 1.0);
}