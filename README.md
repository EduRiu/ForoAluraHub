# ForoAluraHub
 Challenge Back End N°3

# Desafío Foro Hub

el objetivo del desafio es construir una API Rest desarrollada directamente desde el back-end.
Se realizara con el Java y Spring Boot,
Aplicando conceptos avanzados en la creación de endpoints, implementación de capas de seguridad




## FORMA DE USO
Al ser una aplicacion de  consola, se requiere usar Insomnia es un cliente de API de código abierto que te permite enviar solicitudes de API sin escribir ningún código.

HTTP Request que se pueden consultar

Autenticar
{
"email": "edu@rdo.com",
"pass": "123456"
}
CrearTopico
{
"id": "1",
"mensaje" :"Error en compilacion",
"nombre": "FRENTE",
"titulo": "reza Malena"
}
ListarTopico
{
metodo GET que devuelve los topicos en al bd
}
ActualizarTopico
{
"id": "4",
"mensaje" :"Error en compilacion editado"
}
DesactivarTopico
{
se envia el id del topico a desactivar
http://localhost:8080/topicos/3
}
## Repositorio
el repositorio del proyecto es https://github.com/EduRiu/ForoAluraHub
## Autor
Eduardo Riu
