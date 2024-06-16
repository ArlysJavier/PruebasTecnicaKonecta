# PruebasTecnicaKonecta
prueba técnica analista de desarrollo IVR

prueba numero 1
para este desarrollo se realizo una api Rest en springboot la cual realiza las consultas de siguiente fecha de pago 
bajo peticiones http.
el programa consite en que la aplicacion realiza el consumo de la api: calendarific para obtener los dias festivos de 
colombia en el 2024 
imagen de la api calendarific gratuita.

![image](https://github.com/ArlysJavier/PruebasTecnicaKonecta/assets/114090836/6bc626ae-d27e-453d-90c0-a05b9e499904)

Api Key para consumo: zavfpQjky3yT3EvL5G5cU6RZCVUSCs62

Pasos para ejecutar la aplicacion.
se implementa swagger-ui realiza las peticiones a la api de manera visual.

url para visualizar swagger luego de ejecutar la api en local: http://localhost:8080/swagger-ui/index.html
-seleccionamos el controlador
-presionamos en el boton Try it out
- ingresamos la fecha de consulta y presionamos en el boton execute.
imagen swagger-ui.

![image](https://github.com/ArlysJavier/PruebasTecnicaKonecta/assets/114090836/b8ed64da-7726-46b0-9564-7cb898e2f525)

para la prueba vamos a ingeras la fecha: 2024-03-30 que es sábado, debido a la semana santa, la fecha a devolver será 2024-03-27. como el caso de prueba de punto 1

![image](https://github.com/ArlysJavier/PruebasTecnicaKonecta/assets/114090836/a8fdf5b6-f4db-47db-a17d-7f9e4b02db79)

respuesta.

![image](https://github.com/ArlysJavier/PruebasTecnicaKonecta/assets/114090836/808b043d-b973-477a-8d70-2913f2d9c510)

como se visualiza el la interface la respuesta: La próxima fecha de pago es: 2024-03-27 debido a que es el dia habil segun el calendario.

ahora hacemos otra consulta para la fecha: 2024-06-30 y los resultados son: 

![image](https://github.com/ArlysJavier/PruebasTecnicaKonecta/assets/114090836/eb580798-91d6-4eb8-864f-8e3497e1ceef)

entrada:

![image](https://github.com/ArlysJavier/PruebasTecnicaKonecta/assets/114090836/d8f05490-498b-4ace-92ac-c7d2cc0740bc)

salida.

![image](https://github.com/ArlysJavier/PruebasTecnicaKonecta/assets/114090836/05d09512-067d-4a1e-b5cd-d08ae595584e)


************************************************ Punto #2 ********************************************************

para este punto desarrollamos un front basico en react para la visualizacion del registro de empleados y de solicitudes
se realizo el registro de los datos en BD Oracle, y sea realizo el backen base en Node.js 

intructivo.

para la creacion de un nuevo empleado, llenamos los parametros solicitados al inicio en la obcion Crear Nuevo Empleado, ponemos la fecha de ingreso.

![image](https://github.com/ArlysJavier/PruebasTecnicaKonecta/assets/114090836/e6a6a6e3-cacd-41f8-8d67-d7de044e5e92)

presionamos el boton Guardar.
ahora si consultamos desde postman la peticion get de todos los registros podemos visualizar que se ha creado el nuvo empleado en la BD.

![image](https://github.com/ArlysJavier/PruebasTecnicaKonecta/assets/114090836/c53cd80a-5b3d-4b8b-9f60-f63ea6e43d9a)

creamos 3 empleados mas y podemos visualizar que se han ingresado a la BD

![image](https://github.com/ArlysJavier/PruebasTecnicaKonecta/assets/114090836/700b4f6d-74ee-445b-94f8-f16b3616b3db)

ahora podemos consultar el empleado por el ID desde en front y podemos visualizar la informacion de el empleado.

camos a preguntar el el empleado Id=2

![image](https://github.com/ArlysJavier/PruebasTecnicaKonecta/assets/114090836/fd20edec-5503-4aa0-ab38-ef9dd3f08525)

resultador:
![image](https://github.com/ArlysJavier/PruebasTecnicaKonecta/assets/114090836/fc3fe41b-17a8-40ed-b36e-27105d21f931)

ahora en la interface de solicitudes podemos crear una nueva solicitud llenando los capos requeridos en la IU y presionando el boton garddar se
crea una nueva solicitud de servisio la cual se visualizara en el listado de servicios.

![image](https://github.com/ArlysJavier/PruebasTecnicaKonecta/assets/114090836/aebcb4ff-e771-4224-b7ea-905e221eb3e0)

presionamos Guardar y podemos visualizar el registro en el listado.

![image](https://github.com/ArlysJavier/PruebasTecnicaKonecta/assets/114090836/5f8ab13c-9f12-4a44-889e-51c915e13a67)

de este modo podemos crear las solicitudes que se requieran.

![image](https://github.com/ArlysJavier/PruebasTecnicaKonecta/assets/114090836/a2cdac27-3f78-478b-aaf2-6627d1c8c509)

y si queremos eliminar alguna solicitud presionamos el boton eliminar de la cada solicitud. en este caso borramos la solicitud 2.

![image](https://github.com/ArlysJavier/PruebasTecnicaKonecta/assets/114090836/3207f14e-8bb6-4218-9e6f-314a3d8546b4)

***************************************************  GRACIAS ***********************************************************+**


































