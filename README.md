# Challenge-Hotel-Alura-G4<br>

En esta ocasión le muestro el desarrollo del tercer desafío del programa Oracle One Education.<br>
Gestionado por Alura Latam en asociación con Oracle, en representación del grupo 4 (G4) "Back End".<br>
Durante el proceso será necesario realizar una conexión con una base de datos, en este caso en particular usé una base de datos en MySQL.<br><br>


## El desfío en desarrollo presenta los retos siguientes:<br>
- Conectarse a una base de datos MySQL y a través de esa conexión administrar las reservas y huespedes de nuestro hotel.<br>
- Nuestro programa debe contar con protección de acceso por medio de usuario y contraseña.<br>
- Guardar en la base de datos los registros de reservas y huespedes que llegan al Hotel implementando JDBC en java.<br>
- Editar cada uno de los campos de los registros tanto en reservas como en los huespedes, pero manteniendo protegidos sus respectivos números identificadores "ID".<br>
- Eliminar las reservas y huespedes.<br>
- Buscar registros dentro de la base de datos, en este caso usé búsqueda por medio de su ID.<br><br>


## Componentes y funciones del programa<br>

- PANTALLA INICIAL CON UN BOTON PARA HACER LOGIN<br>
![Login](https://user-images.githubusercontent.com/121276241/233530736-a812be89-51cb-45cc-be11-e2ffc2b71036.png)<br>

- PANTALLA DE INICIO DE SESIÓN<br>

La cúal contará con una verificasión para confirmar que los datos de usuario y contraseña sean correctos.<br><br>
![inicio de sesion](https://user-images.githubusercontent.com/121276241/233531210-e2dc22ea-7c71-44e1-9ebc-08d3a6325d26.png) ![error inicio de sesion](https://user-images.githubusercontent.com/121276241/233530539-57777511-cf5c-4b51-bce9-123c94e135c9.png)<br>

- UN MENÚ PRINCIPAL<br>
En donde se puede elegir entre registrar una nueva reserva o buscar registros guardados en la base de datos sobre las reservas y huespedes<br>
![menu principal](https://user-images.githubusercontent.com/121276241/233531414-aa620f5e-2369-421c-9dcc-bd3dc44a3607.png)<br>

- EN LA SECCIÓN DE REGISTRO DE NUEVA RESERVA<br>
Cuenta con la restricción en cuanto a las fechas de entrada como de salida para evitar que por error introduzcan las fechas de manera equivocada.<br>
El programa debe devolver automaticamente el valor de dicha reserva para luego proceder a seleccionar la forma de pago de la reserva<br><br>
![error en fechas de reserva](https://user-images.githubusercontent.com/121276241/233533281-0794abaa-f218-4c07-8285-9314cdf5004d.png) ![valor reserva](https://user-images.githubusercontent.com/121276241/233849972-99674ba3-49f1-44c3-892f-36c3d2921c71.png)<br>

- REGISTRO DE HUESPED<br>
Una vez guardada la reserva, pasa a la ventana para registrar al huesped que realiza la reserva, registrando su nombre, apellido, fecha de nacimiento, número de telefono y seleccionando la nacionalidad, colocando de manera automatica el número de reserva.<br>
Si todo salió bien, nos lanza un aviso que se guardó correctamente<br><br>
![registro de huesped](https://user-images.githubusercontent.com/121276241/233850833-5e9a42a6-1023-44c3-a089-78a5a1840bca.png) ![exito guardado](https://user-images.githubusercontent.com/121276241/233855440-fe85b91a-1a62-42f6-bb90-776dd47e9da4.png)<br>

- SECCIÓN DE BÚSQUEDA<br>
En esta sección debemos ser capaces de poder ver y editar los campos tanto en reservas como en huespedes, manteniendo protegidos los campos de los ID.<br><br>

![busqueda reserva](https://user-images.githubusercontent.com/121276241/233855939-13894e35-bd74-4dc0-8f77-b7f5324a221e.png) ![busqueda huesped](https://user-images.githubusercontent.com/121276241/233855954-08b478ea-1bf6-4e0b-8396-aef2eddad79d.png)<br>![ids protegidos](https://user-images.githubusercontent.com/121276241/233856573-2c178aae-6946-40fa-817b-01e5750f5e90.png)<br>

En el caso de las reservas, una vez modificado algun campo de fecha, se debe actualizar el valor de la reserva<br><br>
![edicion de reservas](https://user-images.githubusercontent.com/121276241/233856897-c5cc9180-53cb-4851-a5da-5b07183f5e59.png)![edicion de reservas actualiza valor](https://user-images.githubusercontent.com/121276241/233856911-b49f4ee1-c337-4126-b62b-d2390e40466e.png)


Eliminar los registros guardados en las reservas y huespedes<br><br>

![eliminar reserva](https://user-images.githubusercontent.com/121276241/233856112-1bbc7aa8-7ef4-4a39-b4b6-47947211f9eb.png) ![borrar huesped](https://user-images.githubusercontent.com/121276241/233856121-24a2669a-a35b-443c-9f00-c3deff8e8f9a.png)<br>

![exito eliminar reserva](https://user-images.githubusercontent.com/121276241/233856486-2d92fe5d-e7fa-48c7-82af-09c6254e9281.png) ![exito eliminar huesped](https://user-images.githubusercontent.com/121276241/233856493-7daa58b5-00e3-4ba1-97bf-b4cc95768487.png)<br>

Buscar por parametros en nuestros registro, en este caso lo realicé busqueda por ID<br>

![busqueda por id](https://user-images.githubusercontent.com/121276241/233856077-d4bada85-67cf-438e-b713-2ff976aef8e8.png)<br>

Actualizar nuestra tabla una vez borrado un registro<br>
![actualiza las reservas restantes](https://user-images.githubusercontent.com/121276241/233856813-77aaa3e9-3d6f-4dcd-913a-de32170358c8.png)<br>








