# Conversor de Monedas

Una aplicación Java que permite realizar conversiones entre diferentes monedas utilizando tipos de cambio en tiempo real a través de la API de ExchangeRate-API.

## Características

- Conversión en tiempo real entre diferentes monedas
- Historial de conversiones realizadas
- Interfaz de consola intuitiva
- Soporte para múltiples pares de divisas
- Almacenamiento de historial durante la sesión

## Requisitos Técnicos

- Java 8 o superior
- Conexión a Internet (para acceder a la API de tipos de cambio)
- API Key de ExchangeRate-API

## Configuración

1. Crea un archivo `config.properties` en la carpeta `src/main/resources` con el siguiente contenido:
   ```properties
   API_KEY=tu_api_key_aqui
   ```

2. Reemplaza `tu_api_key_aqui` con tu API Key de [ExchangeRate-API](https://www.exchangerate-api.com/)

## Uso

1. Ejecuta la aplicación
2. Selecciona una de las siguientes opciones:
   - 1: Realizar conversión
   - 2: Ver historial
   - 3: Salir

### Realizar una Conversión

1. Ingresa la moneda de origen (ejemplo: USD)
2. Ingresa la moneda de destino (ejemplo: EUR)
3. Ingresa la cantidad a convertir
4. El programa mostrará el resultado de la conversión

### Ver Historial

Selecciona la opción 2 para ver un listado de todas las conversiones realizadas durante la sesión actual.

## Estructura del Proyecto

```
src/
├── cl/
│   └── com/
│       └── conversor/
│           ├── model/
│           │   ├── ConversionRecord.java
│           │   └── ExchangeRate.java
│           ├── service/
│           │   └── CurrencyService.java
│           └── MainApp.java
```

## Tecnologías Utilizadas

- Java
- ExchangeRate-API para tipos de cambio en tiempo real
- HttpURLConnection para llamadas API
- JSON para procesamiento de respuestas API

## Notas

- La aplicación requiere una conexión a Internet activa para funcionar
- Las tasas de cambio se obtienen en tiempo real
- El historial se mantiene solo durante la sesión actual
- Utiliza códigos de moneda estándar ISO 4217 (ejemplo: USD, EUR, GBP)