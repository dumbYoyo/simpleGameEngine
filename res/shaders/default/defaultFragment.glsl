#version 330 core

out vec4 fragColor;

struct Material
{
    sampler2D diffuse_samp;
    sampler2D specular_samp_1;
    sampler2D specular_samp_2;
    float shininess;
};

struct Light
{
    vec3 position;
    vec3 direction;
    vec3 ambient;
    vec3 diffuse;
    vec3 specular;

    float constant;
    float linear;
    float quadratric;

    float cutOff;

    int type;
};

struct Properties
{
    vec4 objectColor;
    int hasColor;
    int hasSpecular;
    int hasEmission;
};

in vec2 textureCoord;
in vec3 normal;
in vec3 fragPos;

uniform vec3 lightColor;
uniform vec3 viewPos;

uniform Material material;
uniform Light light;
uniform Properties properties;

void main()
{
    vec3 norm = normalize(normal);

    // 0 = point, 1 = directional, 2 = spot
    vec3 lightDir;
    if (light.type == 0)
    {
        lightDir = normalize(light.position - fragPos);// point light
    }
    if (light.type == 1)
    {
        lightDir = normalize(-light.direction); // directional light
    }

    float diff = max(dot(norm, lightDir), 0.0);
    vec3 diffuse = light.diffuse * diff * texture(material.diffuse_samp, textureCoord).rgb;


    vec3 viewDir = normalize(viewPos - fragPos);
    vec3 reflectedDir = reflect(-lightDir, norm);
    float spec = pow(max(dot(viewDir, reflectedDir), 0.0), material.shininess);

    vec3 specular;
    if (properties.hasSpecular == 0)
    {
        specular = vec3(0);
    }
    else
    {
        specular = light.specular * spec * texture(material.specular_samp_1, textureCoord).rgb;
    }

    vec3 emmision;
    if (properties.hasEmission == 0)
    {
        emmision =  vec3(0);
    }
    else
    {
        emmision =  texture(material.specular_samp_2, textureCoord).rgb;
    }


    vec3 ambience = light.ambient * vec3(texture(material.diffuse_samp, textureCoord));


    // point light
    if (light.type == 0)
    {
        // attenuation
        float distance = length(light.position - fragPos);
        float attenuation = 1.0 / (light.constant + light.linear * distance + light.quadratric * (distance * distance));
        ambience *= attenuation;
        specular *= attenuation;
        diffuse *= attenuation;
        emmision *= attenuation;
    }



    vec3 result = specular + diffuse + ambience + emmision;


    int spotLight = 0;
    // spot light
    if (light.type == 2)
    {
        float theta = dot(lightDir, normalize(-light.direction));

        if (theta > light.cutOff)
        {
            if (properties.hasColor == 1)
            {
                fragColor = properties.objectColor * vec4(result, 1.0);
            }
            else
            {
                fragColor = vec4(result, 1.0);
            }
        }
        else
        {
            fragColor = vec4(ambience * texture(material.diffuse_samp, textureCoord).rgb, 1.0);
        }
    }





    // 1 == true, 0 == false
    // if else statement is here so that the object can have any color or texture it wants
    if (properties.hasColor == 1)
    {
        fragColor = properties.objectColor * vec4(result, 1.0);
    }
    else
    {
        fragColor = vec4(result, 1.0);
    }
}