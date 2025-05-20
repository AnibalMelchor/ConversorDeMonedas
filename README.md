<h1 align="center"> CONVERSOR DE MONEDAS </h1>

- Estado del proyecto: Finalizado.

- Este es un proyecto en java que permite convertir monedas latinoamericanas a dólar estadounidense y viceversa utilizando una **API externa de tipo de cambio** (ExchangeRate API).

##Tecnoloigias utilizadas 
-Java 11+
- HTTP Client (`java.net.http.HttpClient`)
- Gson (para parseo de JSON)
- API externa: [ExchangeRate-API](https://www.exchangerate-api.com/)

## ¿Qué hace este proyecto?

-El usuario mediante un menu elige el tipo de conversion que desea.
-Por ejempo Dólar a Peso Aargentino.
-Posteriormente ingresa la cantidad a convertir 
-Finalmente le muestra un mensaje de su conversion, mostrando el valor ingresado a convetir y su valor final en la monenda deseada
-El menu es un bucle que se va mostrando hasta que el usuario ingresa la opcion de salir 

## 📦 Estructura del proyecto
```bash
.
ConversorMonedas
├── lib/
├── src/
│   ├── Main.java              # Clase principal que ejecuta el programa
│   ├── Conversor.java         # Lógica de conversión de monedas
│   └── Monedas.java           # Clase para mapear la respuesta JSON
├── README.md
└── ...
```

<ul>Desarrolador:
    <li>Anibal Melchor Cordero</li>
</ul>

