1. Requisitos y Funcionalidades

• Requisitos Funcionales:
Registro de usuarios con nombre, correo electrónico, contraseña y detalles del teléfono.
Validaciones de datos de entrada (formato de correo electrónico, longitud de contraseña, correo electrónico único).
Almacenamiento de información de usuario en base de datos en memoria en este caso H2.
• Requisitos No Funcionales:
Seguridad: Manejo seguro de contraseñas.
Escalabilidad: Capacidad de manejar un crecimiento en el número de usuarios.
Mantenibilidad: Facilidad de mantenimiento y actualización del servicio.

2. Diseño de la Arquitectura

• Capa de Presentación (Controlador)
Manejo de solicitudes HTTP.
Validación de datos de entrada.
Invocación de servicios de negocio.

• Capa de Negocio (Servicio)
Validación de lógica de negocio.
Interacción con la capa de persistencia para almacenar o recuperar datos.

• Capa de Persistencia (Base de Datos)
Almacenamiento de datos de usuario en H2.

2.1. Objetivo del Servicio
El objetivo de este servicio es recibir y registrar la información de usuarios y los teléfonos asociados asociados a este.

2.2. Alcance del Servicio
Este servicio debe permitir registrar la información de usuarios y los teléfonos asociados a cada usuario.

3. Diagrama de componentes

https://github.com/tejadaeder/reto-tecnico-Usuarios-Sermaluc/blob/main/assets/componentes.png

4. Diagrama de Flujo (Secuencia) del Servicio

https://github.com/tejadaeder/reto-tecnico-Usuarios-Sermaluc/blob/main/assets/secuencia.png

5. Diagrama de Despliegue

https://github.com/tejadaeder/reto-tecnico-Usuarios-Sermaluc/blob/main/assets/despliegue.png

6. Integración

https://github.com/tejadaeder/reto-tecnico-Usuarios-Sermaluc/blob/main/assets/integracion1.png

https://github.com/tejadaeder/reto-tecnico-Usuarios-Sermaluc/blob/main/assets/integracion2.png

7. Documentación de API

Se realizo con swagger. 

Al ejecutarlo se podra ver en esta ruta: http://localhost:8080/swagger-ui/index.html#/

http://localhost:8080/swagger-ui/index.html

https://github.com/tejadaeder/reto-tecnico-Usuarios-Sermaluc/blob/main/assets/swagger1.png

https://github.com/tejadaeder/reto-tecnico-Usuarios-Sermaluc/blob/main/assets/swagger2.png

Con esta dependencia nuestro proyecto contará con unos “endpoints” a través de los cuales cualquier persona que acceda a la dirección referente a Swagger.

8. MANEJO DE MENSAJE DE ERRORES

https://github.com/tejadaeder/reto-tecnico-Usuarios-Sermaluc/blob/main/assets/manejoErrores.png

9. TEST UNITARIOS

Se realizaron pruebas unitarias con mockito a la capa de servicio y capa de controller.

https://github.com/tejadaeder/reto-tecnico-Usuarios-Sermaluc/blob/main/assets/test1.png

https://github.com/tejadaeder/reto-tecnico-Usuarios-Sermaluc/blob/main/assets/test2.png






