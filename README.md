# LAB05-ARSW-BACKEND
# LAB 5 — Tablero Interactivo Colaborativo

Aplicación web que permite a múltiples usuarios dibujar simultáneamente en un tablero compartido en tiempo real.

## 📋 Descripción

El tablero interactivo debe cumplir con los siguientes requisitos:

- Permitir que **múltiples usuarios dibujen en línea** de forma simultánea.
- Cada trazo realizado por un usuario debe **aparecer en el tablero de todos los demás**.
- Cada usuario inicia sesión con un **color diferente** asignado automáticamente.
- Incluir un **botón de borrado global**: al presionarlo, el tablero se borra para todos los usuarios conectados.

---

## 📚 Preparación y Revisión de Conceptos

Antes de comenzar, se recomienda revisar el tutorial oficial de React:
👉 https://react.dev/learn/tutorial-tic-tac-toe

### 1. Introducción a p5.js

Revisa y comprende el proyecto de introducción a la programación usando p5.js:
- Demo: https://ldbn.is.escuelaing.edu.co/ipp5/public_html/
- Código fuente: https://github.com/dnielben/ipp5

### 2. Ejemplo de tablero interactivo

Inspírate en este ejemplo de eventos con p5.js:
👉 https://ldbn.is.escuelaing.edu.co/ipp5/public_html/04eventos/index.html

### 3. Estados en React

Para reaccionar a cambios de estado:
👉 https://react.dev/learn/reacting-to-input-with-state

### 4. Referencias (Refs) en React

Para referenciar objetos externos no administrados por React:
👉 https://react.dev/learn/referencing-values-with-refs

### 5. Temporizadores con Refs

Puedes usar un temporizador para simular interacción en tiempo real con un servidor:
👉 https://react.dev/learn/referencing-values-with-refs#example-building-a-stopwatch

### 6. Efectos en React

Para comunicarte con sistemas externos:
👉 https://react.dev/learn/synchronizing-with-effects

---

## 🛠️ Paso a Paso

### Paso 7 — Dibujar en el browser con p5.js (HTML estático)

Crea un archivo `index.html`:

```html
<html>
  <head>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/p5.js/0.7.1/p5.min.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/p5.js/0.7.1/addons/p5.dom.min.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/p5.js/0.7.1/addons/p5.sound.min.js"></script>
    <link rel="stylesheet" type="text/css" href="style.css">
  </head>
  <body>
    <script src="js/sketch.js"></script>
  </body>
</html>
```

Crea el archivo `js/sketch.js`:

```javascript
// Esta función se ejecuta una sola vez al inicio del script.
function setup() {
  createCanvas(640, 480);
}

// Esta función se ejecuta repetidas veces indefinidamente.
function draw() {
  if (mouseIsPressed === true) {
    fill(0, 0, 0);
    ellipse(mouseX, mouseY, 20, 20);
  }
  if (mouseIsPressed === false) {
    fill(255, 255, 255);
  }
}
```

---

### Paso 8 — Componente React con p5.js

Crea un proyecto React e integra el canvas de p5 como componente:

```jsx
import { useRef } from 'react';
import p5 from 'p5';

function App() {
  const sketch = function (p) {
    p.setup = function () {
      p.createCanvas(700, 410);
    };

    p.draw = function () {
      if (p.mouseIsPressed === true) {
        p.fill(0, 0, 0);
        p.ellipse(p.mouseX, p.mouseY, 20, 20);
      }
      if (p.mouseIsPressed === false) {
        p.fill(255, 255, 255);
      }
    };
  };

  const myp5 = useRef(new p5(sketch, 'container'));

  return (
    <div>
      <hr />
      <div id="container"></div>
      <hr />
    </div>
  );
}

export default App;
```

---

### Paso 9 — Integración Frontend + Backend

Conecta el frontend en **React** con el backend en **Java Spring**.

### Paso 10 — Configurar CORS en el servidor

Para que el cliente React (sobre Node.js) pueda comunicarse con el backend en repositorios separados, habilita el Cross-Origin Resource Sharing (CORS) en Spring:

- Guía rápida: https://spring.io/guides/gs/rest-service-cors
- Documentación completa de CORS: https://developer.mozilla.org/en-US/docs/Web/HTTP/CORS

---

## 📦 Entregables

1. ✅ **Repositorio en GitHub** con el código fuente del proyecto.
2. ✅ **Proyecto desplegado en AWS EC2**.
   - Guía de inicio: https://docs.aws.amazon.com/AWSEC2/latest/UserGuide/EC2_GetStarted.html
