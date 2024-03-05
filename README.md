Informe CellTechHub

Nombres: Anderson Vilatuña, Kevin Cola,Samuel Cuti, Estefania Sanchez

Objetivos

- Desarrollar una plataforma de software intuitiva y fácil de usar.
- Automatizar la gestión de ventas y el control de inventario.
- Proporcionar herramientas para optimizar los procesos comerciales en tiendas de accesorios para celulares.

Introducción

CellTechHub es un sistema de software de venta de accesorios para celulares desarrollado para facilitar los procesos de control de inventarios y gestión de ventas. Esta plataforma fue construida con el objetivo de mejorar la efectividad y la experiencia del usuario en la administración. En este informe presentaremos sobre el proyecto CellTechHub, detallando sus procedimientos de desarrollo, características implementadas y evaluaciones de efectividad funcional.

Requerimientos:

1. Sistema de autenticación de usuarios.
2. Funcionalidad de registro y gestión de clientes.
3. Registro de transacciones de compra y generación de notas de venta.
4. Gestión de inventario, incluyendo la actualización automática de stock.
5. Visualización de imágenes de productos para los usuarios.
1. Interfaz de usuario intuitiva y fácil de usar.
2. Seguridad de datos y protección de la información del cliente.

Etapas de Desarrollo:

1. Análisis de requisitos y diseño preliminar.
2. Implementación de la estructura base del sistema.
3. Desarrollo de las funcionalidades principales, como el sistema de autenticación y la gestión de inventario.
4. Pruebas
5. 
Pantalla Login 
En esta pantalla de inicio de sesión el usuario ingresa sus credenciales y seleccionar su rol (Cajero o Administrador) para acceder a diferentes funcionalidades dentro de la aplicación. Además, realiza la verificación de las credenciales ingresadas con una base de datos y muestra mensajes de error en caso de credenciales inválidas o usuario no encontrado.
![image](https://github.com/SamuelCU/CellTechHub/assets/150813921/fd737f7f-6505-4505-9077-e1a3a0d2d158)

 
Pantalla Administrador 

La pantalla del administrador contiene botones para acceder a diferentes funcionalidades de la aplicación, como:
  - Acceder a la sección de cajero.
  - Acceder a la sección de estadísticas.
  - Acceder a la sección de productos.
  - Salir del sistema y volver a la pantalla de inicio de sesión.
 ![image](https://github.com/SamuelCU/CellTechHub/assets/150813921/ceaf5812-055b-4b53-a272-7fae6029ec09)

Pantalla Cajeros

Esta Pantalla Permite al cajero buscar información sobre otros cajeros mediante la introducción de su número de identificación. Muestra la información del cajero buscado en una tabla, incluyendo su nombre, tipo de empleado y ventas. Permite al cajero agregar un nuevo cajero pulsando el botón "Agregar". Ofrece la opción de salir del sistema, Proporciona un botón de retorno que permite al cajero volver a la pantalla anterior, en este caso, la pantalla de administrador.
 ![image](https://github.com/SamuelCU/CellTechHub/assets/150813921/aeb9a6ea-3471-441d-9852-d6811e15c680)

Pantalla Registro Cajeros

La pantalla Registro cajero permite al administrador ingresar los datos del nuevo cajero, como nombre, cédula y contraseña, el botón "Agregar" permite al administrador confirmar la creación del nuevo cajero, Antes de agregar al cajero, se verifica que las contraseñas ingresadas coincidan para evitar errores. 
 ![image](https://github.com/SamuelCU/CellTechHub/assets/150813921/02f41e99-3a4c-4e02-abd3-0470660d9be1)

Pantalla Estadística

La Pantalla estadística proporciona la interfaz de usuario para visualizar estadísticas de los empleados, incluyendo su nombre, tipo de empleado y ventas, Permite al usuario ver los datos de todos los empleados, incluyendo su identificación, nombre y tipo de empleado. Muestra una fila adicional con el total de ventas de todos los empleados.
 ![image](https://github.com/SamuelCU/CellTechHub/assets/150813921/b50fd62f-8dc6-4328-b8ac-1afd8856883b)

Pantalla Productos 

La pantalla Productos nos permite  buscar productos utilizando un campo de texto y un botón de búsqueda, Muestra una tabla con los productos encontrados, Ofrece botones para agregar nuevos productos y para realizar acciones relacionadas con los productos seleccionados en la tabla, También incluye una etiqueta de imagen para mostrar algún tipo de imagen relacionada con los productos.
 ![image](https://github.com/SamuelCU/CellTechHub/assets/150813921/c0fa0611-32ec-47d8-a8de-7d31150acb55)

Pantalla Nuevo Producto

Esta pantalla permite al usuario ingresar información sobre el nuevo producto, como nombre, descripción. Ofrece la opción de agregar una imagen al producto, Proporciona botones para confirmar y agregar el producto, así como para agregar una imagen.
 ![image](https://github.com/SamuelCU/CellTechHub/assets/150813921/622b6484-7423-4719-b8c5-8d381ff8a8a5)

Pantalla Cajero

La pantalla permite al cajero acceder a dos secciones principales de la aplicación los botones "Clientes" y "Ventas" permiten al cajero navegar a las respectivas secciones para gestionar clientes y realizar ventas. Hay un botón para salir del sistema, que permite al cajero cerrar la sesión y volver a la pantalla de inicio de sesión.
 ![image](https://github.com/SamuelCU/CellTechHub/assets/150813921/cc04aed9-0acc-420a-ba9a-8a2ea0e71731)

Pantalla Cliente

La pantalla cliente nos permite al usuario ver y manejar información sobre clientes proporciona la opción para agregar nuevos clientes, para poder registrar usuarios que no estén en el sistema.
 ![image](https://github.com/SamuelCU/CellTechHub/assets/150813921/201307ca-5ac1-4e58-8882-a21e6cbaec30)

Pantalla Registro Cliente

La pantalla registro cliente permite al usuario ingresar información sobre un nuevo cliente, como nombre, dirección, teléfono, etc. Ofrece opciones para agregar el nuevo cliente a la base de datos del sistema, proporciona los botones para regresar a la pantalla anterior y para salir del sistema.
 ![image](https://github.com/SamuelCU/CellTechHub/assets/150813921/f9c1c2f9-4c8b-47f6-8eb5-275ad1d018dc)

Pantalla Ventas

La pantalla Ventas permite buscar la venta mediante código o por su categoría también nos proporciona un botón agregar
 ![image](https://github.com/SamuelCU/CellTechHub/assets/150813921/4cbdf7c0-5581-4d7c-8265-3f326e90fa89)

Pantalla PDF

La pantalla Pdf nos permite visualizar la factura o el comprobante de la venta con la información, del cliente, el vendedor, la fecha etc. Y cuanta con un botón aceptar para confirmar 
 ![image](https://github.com/SamuelCU/CellTechHub/assets/150813921/3947b232-8cd8-4fc1-a278-67bbb3bc2f8c)

Conclusiones

Tras el desarrollo de la aplicación, hemos logrado crear un sistema funcional y fácil de usar. La aplicación ofrece una interfaz intuitiva que permite a los usuarios realizar tareas específicas de manera eficiente, como gestionar clientes, productos y ventas, lo que mejora la productividad y la experiencia del usuario.
Definir objetivos claros, establecer el alcance del proyecto y distribuir las tareas de manera adecuada han sido fundamentales para llevar a cabo el desarrollo de manera organizada y cumplir con los plazos establecidos.
En la realización de este proyecto, hemos mejorado nuestras habilidades técnicas y de gestión. El aprendizaje constante nos ha permitido superar desafíos técnicos, adaptarnos a nuevas tecnologías y enriquecer nuestra experiencia profesional. El seguimiento de requisitos y la retroalimentación del cliente son fundamentales para entregar un producto final satisfactorio.

Recomendaciones

Recomendamos implementar técnicas de gestión del tiempo efectivas, como la elaboración de cronogramas detallados y la asignación adecuada de recursos, para optimizar el uso del tiempo y cumplir con los plazos establecidos.
Es esencial documentar detalladamente el proceso de desarrollo y adherirse a buenas prácticas de programación, como estándares de codificación y control de versiones, para asegurar la calidad y la facilidad de mantenimiento del producto final.
Proporcionar oportunidades de formación y capacitación continua a los miembros del equipo para mejorar sus habilidades técnicas y profesionales. Esto puede incluir cursos de actualización en tecnologías relevantes y desarrollo de habilidades.
# CellTechHub
Plataforma para Tienda de Accesorios de celulares
