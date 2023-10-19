# Prueba-T-cnica-Landscape
Prueba técnica para CRUD en Springboot

# DOCKER - Comandos

docker build -t spring-boot-docker .
docker run -p 8080:8084 spring-boot-docker

*Nota: reemplazar en los verbos, el puerto 8084, por el puerto 8080

# SWAGGER

http://localhost:8084/v2/api-docs
http://localhost:8084/swagger-ui.html#/

*Nota: reemplazar, el puerto 8084, por el puerto 8080, si se levanta docker primero para correr la aplicación

# SONARQUBE Ref.: https://docs.sonarsource.com/sonarqube/10.2/analyzing-source-code/scanners/sonarscanner-for-maven/ 

Importante: descargar Sonarqube (https://www.sonarsource.com/products/sonarqube/downloads/, Comunnity Edition es suficiente para levantarlo), levantarlo localmente con Java11 (otras versiones pueden presentar conflictos, especialmente con ElasticSearch), crear proyecto y definir un token asociado al proyecto (seguir flujos de pasos de la interfaz). Luego debe configurarse un setting.xml, si está incorporado Maven a nivel de proyecto y no se está usando el .m2 de Apache Maven de la unidad de disco local (C: por ejemplo), el setting.xml puede ir en la carpeta resources del proyecto mismo. 

Settings.xml

<?xml version="1.0" encoding="UTF-8"?>
<settings xmlns="http://maven.apache.org/SETTINGS/1.2.0"
          xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
          xsi:schemaLocation="http://maven.apache.org/SETTINGS/1.2.0 https://maven.apache.org/xsd/settings-1.2.0.xsd">
    <pluginGroups>
        <pluginGroup>org.sonarsource.scanner.maven</pluginGroup>
    </pluginGroups>
    <profiles>
        <profile>
            <id>sonar</id>
            <activation>
                <activeByDefault>true</activeByDefault>
            </activation>
            <properties>
                <!-- Optional URL to server. Default value is http://localhost:9000 -->
                <sonar.host.url>
                  http://localhost:9000
                </sonar.host.url>
            </properties>
        </profile>
     </profiles>
</settings>

Luego implementar el comando por consola (o si se usa Eclipse o STS, sin el prefijo mvn, en el caso de configurar un build de Maven)

mvn clean verify sonar:sonar -Dsonar.projectKey=PROJECTKEY -Dsonar.projectName='PROJECTNAME' -Dsonar.host.url=http://HOST:9000 -Dsonar.token=TOKEN

*Nota: Sonarqube con Maven a nivel de proyecto

# POSTMAN COLLECTION

{
	"info": {
		"_postman_id": "8a3f02ed-0888-4eb4-864a-af0af90059ad",
		"name": "Prueba Técnica Landscape",
		"schema": "https://schema.getpostman.com/json/collection/v2.1.0/collection.json",
		"_exporter_id": "10869783"
	},
	"item": [
		{
			"name": "GET",
			"request": {
				"method": "GET",
				"header": [
					{
						"key": "Authorization",
						"value": "Bearer eyJhbGciOiJIUzUxMiJ9.eyJqdGkiOiJzb2Z0dGVrSldUIiwic3ViIjoiYWRtaW4iLCJhdXRob3JpdGllcyI6WyJST0xFX1VTRVIiXSwiaWF0IjoxNjk3MzMxNDg2LCJleHAiOjE2OTczMzIwODZ9.UWnpTaasv4eSMjWnQvH5LyOCez_yBGDgUikwAChRIyT7jzDpjKxkkKPCyzvqhuGL59icFEEB53wGdTfXqEuJYQ",
						"type": "text"
					}
				],
				"url": {
					"raw": "localhost:8084/usuarios/",
					"host": [
						"localhost"
					],
					"port": "8084",
					"path": [
						"usuarios",
						""
					]
				}
			},
			"response": []
		},
		{
			"name": "SAVE",
			"event": [
				{
					"listen": "prerequest",
					"script": {
						"exec": [
							"postman.setEnvironmentVariable(\"timestamp\",\"2023-10-12\");\r",
							"postman.setEnvironmentVariable(\"permittype\",\"VISUALIZACION_DASHBOARDS\");"
						],
						"type": "text/javascript"
					}
				}
			],
			"request": {
				"method": "POST",
				"header": [
					{
						"key": "Authorization",
						"value": "Bearer eyJhbGciOiJIUzUxMiJ9.eyJqdGkiOiJzb2Z0dGVrSldUIiwic3ViIjoiYWRtaW4iLCJhdXRob3JpdGllcyI6WyJST0xFX1VTRVIiXSwiaWF0IjoxNjk3MzMxNDg2LCJleHAiOjE2OTczMzIwODZ9.UWnpTaasv4eSMjWnQvH5LyOCez_yBGDgUikwAChRIyT7jzDpjKxkkKPCyzvqhuGL59icFEEB53wGdTfXqEuJYQ",
						"type": "text"
					}
				],
				"body": {
					"mode": "raw",
					"raw": "{\r\n   \"nombre\":\"usuario001\",\r\n   \"email\":\"email001\",\r\n   \"contraseña\":\"001\",\r\n   \"accesos\" : [\r\n        {\r\n            \"timestamp\" : \"{{timestamp}}\"\r\n        }\r\n    ],\r\n   \"permisos\": [\r\n        {\r\n            \"permiso\" : \"{{permittype}}\"\r\n        }\r\n    ]\r\n}",
					"options": {
						"raw": {
							"language": "json"
						}
					}
				},
				"url": {
					"raw": "localhost:8084/usuarios",
					"host": [
						"localhost"
					],
					"port": "8084",
					"path": [
						"usuarios"
					]
				}
			},
			"response": []
		},
		{
			"name": "PUT",
			"event": [
				{
					"listen": "prerequest",
					"script": {
						"exec": [
							"postman.setEnvironmentVariable(\"timestamp\",\"2023-10-13\");\r",
							"postman.setEnvironmentVariable(\"permittype\",\"ADMIN\");"
						],
						"type": "text/javascript"
					}
				}
			],
			"request": {
				"method": "PUT",
				"header": [
					{
						"key": "Authorization",
						"value": "Bearer eyJhbGciOiJIUzUxMiJ9.eyJqdGkiOiJzb2Z0dGVrSldUIiwic3ViIjoiYWRtaW4iLCJhdXRob3JpdGllcyI6WyJST0xFX1VTRVIiXSwiaWF0IjoxNjk3MzMxNDg2LCJleHAiOjE2OTczMzIwODZ9.UWnpTaasv4eSMjWnQvH5LyOCez_yBGDgUikwAChRIyT7jzDpjKxkkKPCyzvqhuGL59icFEEB53wGdTfXqEuJYQ",
						"type": "text"
					}
				],
				"body": {
					"mode": "raw",
					"raw": "{\r\n   \"nombre\" :\"usuario002\",\r\n   \"email\" :\"email002\",\r\n   \"contraseña\" :\"002\",\r\n   \"permiso\" : \"{{permittype}}\",\r\n   \"timestamp\" : \"{{timestamp}}\"\r\n}",
					"options": {
						"raw": {
							"language": "json"
						}
					}
				},
				"url": {
					"raw": "localhost:8084/usuarios/email001",
					"host": [
						"localhost"
					],
					"port": "8084",
					"path": [
						"usuarios",
						"email001"
					]
				}
			},
			"response": []
		},
		{
			"name": "DELETE",
			"event": [
				{
					"listen": "prerequest",
					"script": {
						"exec": [
							""
						],
						"type": "text/javascript"
					}
				}
			],
			"request": {
				"method": "DELETE",
				"header": [
					{
						"key": "Authorization",
						"value": "Bearer eyJhbGciOiJIUzUxMiJ9.eyJqdGkiOiJzb2Z0dGVrSldUIiwic3ViIjoiYWRtaW4iLCJhdXRob3JpdGllcyI6WyJST0xFX1VTRVIiXSwiaWF0IjoxNjk3MzMxNDg2LCJleHAiOjE2OTczMzIwODZ9.UWnpTaasv4eSMjWnQvH5LyOCez_yBGDgUikwAChRIyT7jzDpjKxkkKPCyzvqhuGL59icFEEB53wGdTfXqEuJYQ",
						"type": "text"
					}
				],
				"body": {
					"mode": "raw",
					"raw": "",
					"options": {
						"raw": {
							"language": "json"
						}
					}
				},
				"url": {
					"raw": "localhost:8084/usuarios/email002",
					"host": [
						"localhost"
					],
					"port": "8084",
					"path": [
						"usuarios",
						"email002"
					]
				}
			},
			"response": []
		},
		{
			"name": "AUTH",
			"request": {
				"auth": {
					"type": "bearer"
				},
				"method": "POST",
				"header": [],
				"body": {
					"mode": "urlencoded",
					"urlencoded": [
						{
							"key": "usuario",
							"value": "admin",
							"type": "text"
						},
						{
							"key": "contraseña",
							"value": "admin",
							"type": "text"
						}
					]
				},
				"url": {
					"raw": "localhost:8084/auth",
					"host": [
						"localhost"
					],
					"port": "8084",
					"path": [
						"auth"
					]
				}
			},
			"response": []
		}
	]
}