//Número de prueba de tarjeta de credito AMERICAN EX.        346465744650837
//Número de prueba de tarjeta de credito VISA                4452538377251602
//Número de prueba de tarjeta de credito MSCARD              5391683456120939

//Prueba: 5888888091418885

//Pasos:
/*1.  Toma los digitos ingresados por el usuarios
 *2. verifica la longitud de los digitos ingresados
 *3. Transforma a numero la variable
 *4. Coloca cada numero dentro del arreglo
 *5. Voltea el arreglo
 *6. Ejecuta el algoritmo de Luhn
 *7. Verifica si es VISA, Mastercard o American Express
 *8. Modifica la pestaña de respuesta
 */

function verificarTarjeta() {
  try {
    //Paso 1
    const tarjeta = document.getElementById("tarjeta").value;
    let longitud_tarjeta = String(tarjeta).length;
    tarjeta = Number(tarjeta);
    if (tarjeta == "" || tarjeta === null || isNaN(tarjeta) === true) {
      //Mostrar alerta de que no ha introducido una tarjeta
      alert(
        "Usted no ha ingresado ningún número de tarjeta para ser evaluada. \n Por favor ingrese una si desea continuar."
      );
    } else {
      //Comienza Algoritmo de Luhn
      //Además, utilizo esta parte para codificar el número de tarjeta, excepto los últimos 4 digitos
      let num_tarjeta = new Array();
      for (let i = 0; i < longitud_tarjeta; i++) {
        num_tarjeta[i] = String(tarjeta).charAt(i);
      }

      //Invertir el arreglo
      let num_tarjeta_inversa = num_tarjeta.reverse();

      let total_numeros = new Array();
      //Ver cuales son posiciones pares y multiplicarlas por dos, si el resultado es mayor a 10 se sumaran
      //Problemas en la suma
      for (let i = 1; i <= longitud_tarjeta; i++) {
        //Verificar que sea una posicion par
        if (i % 2 == 0) {
          let mult = Number(num_tarjeta_inversa[i - 1]) * 2;
          if (mult >= 10) {
            let num1 = String(mult).charAt(0);
            let num2 = String(mult).charAt(1);
            total_numeros[i - 1] = Number(num1) + Number(num2);
          } else {
            total_numeros[i - 1] = Number(mult);
          }
        } else {
          total_numeros[i - 1] = Number(num_tarjeta_inversa[i - 1]);
        }
      }

      //Realizar la suma
      let suma = 0;

      for (let i = 0; i < total_numeros.length; i++) {
        suma += total_numeros[i];
      }

      //y el modulo para verificar si es una tarjeta valida
      num_tarjeta = num_tarjeta.reverse();

      let digitos = num_tarjeta.slice(longitud_tarjeta - 4);
      let num_tarjeta_cifrada = "#".repeat(longitud_tarjeta - 4) + digitos;

      if (suma % 10 == 0) {

        //Verificar que tipo de tarjeta es
        let tipo_tarjeta;
        if (num_tarjeta[0] == 4 || num_tarjeta[0] === "4") {
          tipo_tarjeta = "Visa";
          document.getElementById("img-respuesta").src = "resources/visa.png";
        } else if (
          (num_tarjeta[0] == 3 && num_tarjeta[1] == 4) ||
          (num_tarjeta[0] == "3" && num_tarjeta[1] == "4")
        ) {
          tipo_tarjeta = "American Express";
          document.getElementById("img-respuesta").src =
            "resources/american-express.png";
        } else {
          tipo_tarjeta = "Mastercard";
          document.getElementById("img-respuesta").src =
            "resources/master-card.png";
        }

        document.getElementById(
          "respuesta-tarjeta"
        ).innerText = `El número de tarjeta ${num_tarjeta_cifrada} es una tarjeta valida de ${tipo_tarjeta}`;
      } else {
        //Tarjeta invalida
        document.getElementById(
          "respuesta-tarjeta"
        ).innerText = `El número de tarjeta ${num_tarjeta_cifrada} es una tarjeta invalida`;
        document.getElementById("img-respuesta").src = "resources/invalida.png";
      }
      //Manejo de la interfaz
      document.getElementById("respuesta").classList.remove("hide");
      document.getElementById("left").classList.add("hide");
      document.getElementById("rigth").classList.add("hide");
    }
  } catch (error) {
    alert(error);
  } finally {
    //Limpiar el input
    document.getElementById("tarjeta").value = "";
  }
}

function volverInicio() {
  try {
    document.getElementById("respuesta").classList.add("hide");
    document.getElementById("left").classList.remove("hide");
    document.getElementById("rigth").classList.remove("hide");
    document.getElementById("tarjeta").value = "";
  } catch (error) {
    alert(error);
  }
}

