# Adopción de Mascotas - MVC SpringBoot

Este proyecto es una aplicación de sistema de adopción de mascotas desarrollada con el patrón de arquitectura MVC utilizando Spring Boot en el IDE Eclipse y una base de datos MySQL gestionada con MySQL Workbench.

## Descripción del Proyecto

La aplicación permite gestionar un sistema de adopción de mascotas, proporcionando funcionalidades específicas para diferentes tipos de usuarios: Administrador, Empleado y Cliente.

### Funcionalidades

- **Listar Mascotas**: Los usuarios pueden ver una lista de todas las mascotas disponibles para adopción.
- **Agregar Mascotas**: Los empleados pueden añadir nuevas mascotas al sistema.
- **Editar Mascotas**: Los empleados pueden editar la información de las mascotas existentes.
- **Solicitudes de Adopción**: Los clientes pueden mandar solicitudes de adopción, que son gestionadas por los empleados.
- **Cambio de Estado de Mascotas**: Una vez que una solicitud es aceptada por un empleado, la mascota cambia su estado a "adoptada".
- **Generar Reportes**: El administrador puede generar reportes de mascotas y de refugios asociados.
- **Gestión de Empleados**: Los empleados están asociados a refugios específicos y gestionan las solicitudes de adopción.

### Roles de Usuarios

- **Administrador**: Gestiona el sistema en su totalidad, puede generar reportes y tiene acceso completo a todas las funcionalidades.
- **Empleado**: Asociado a un refugio, puede listar, agregar y editar mascotas, así como gestionar las solicitudes de adopción.
- **Cliente**: Puede ver las mascotas disponibles y mandar solicitudes de adopción.

## Tecnologías Utilizadas

- **Spring Boot**: Framework principal para el desarrollo de la aplicación.
- **Spring Tools 4 Eclipse IDE**: Entorno de desarrollo utilizado para construir la aplicación.
- **MySQL**: Sistema de gestión de bases de datos.
- **MySQL Workbench**: Herramienta utilizada para gestionar la base de datos MySQL.

## Instalación

Para ejecutar esta aplicación localmente, sigue los siguientes pasos:

1. **Clona el repositorio**:
    ```bash
    git clone https://github.com/tu_usuario/adopcion-mascotas-mvc-springboot.git
    ```

2. **Importa el proyecto en Eclipse**:
    - Abre Eclipse IDE.
    - Selecciona `File > Import > Maven > Existing Maven Projects`.
    - Navega hasta el directorio donde clonaste el repositorio y selecciona el proyecto.

3. **Configura la base de datos**:
    - Crea una base de datos MySQL usando MySQL Workbench.
    - Actualiza el archivo `application.properties` con tus credenciales y configuración de la base de datos:
      ```properties
      spring.datasource.url=jdbc:mysql://localhost/adpcionmascotas
      spring.datasource.username=tu_usuario
      spring.datasource.password=tu_contraseña
      spring.jpa.hibernate.ddl-auto=update
      ```

4. **Ejecuta la aplicación**:
    - Corre la aplicación desde Eclipse: `Run > Run As > Spring Boot App`.

## Uso

Una vez que la aplicación esté en funcionamiento, puedes acceder a ella mediante `http://localhost:8080`. Desde allí, podrás iniciar sesión como administrador, empleado o cliente y comenzar a utilizar las funcionalidades descritas.

## Contribuciones

Las contribuciones son bienvenidas. Por favor, sigue estos pasos para contribuir:

1. Haz un fork del repositorio.
2. Crea una nueva rama (`git checkout -b feature/nueva-funcionalidad`).
3. Haz commit de tus cambios (`git commit -am 'Agrega nueva funcionalidad'`).
4. Empuja la rama (`git push origin feature/nueva-funcionalidad`).
5. Abre un Pull Request.

## Licencia

Este proyecto está bajo la Licencia MIT. Para más detalles, consulta el archivo [LICENSE](LICENSE).

---

¡Gracias por usar nuestra aplicación de Adopción de Mascotas!
