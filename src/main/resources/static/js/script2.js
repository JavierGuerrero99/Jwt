// URL de la API para obtener datos de cursos
const apiUrl = 'http://localhost:8080/api/v1/courses';

// Función para obtener los datos de la API y construir la tabla
function obtenerCursos() {
  fetch(apiUrl)
    .then(response => {
      if (!response.ok) {
        throw new Error('Error al obtener los datos');
      }
      return response.json();
    })
    .then(data => {
      // Construir la tabla con los datos recibidos
      construirTabla(data);
    })
    .catch(error => {
      console.error('Error:', error);
      // Manejar errores de la API
      // Por ejemplo, mostrar un mensaje de error al usuario
      // O realizar alguna otra acción para manejar el error
    });
}

// Función para construir la tabla con los datos recibidos
function construirTabla(data) {
  // Obtener el elemento HTML donde se insertará la tabla
  const tablaContainer = document.getElementById('tablaContainer');

  // Crear la tabla y sus encabezados
  const table = document.createElement('table');
  const headerRow = table.insertRow();
  for (const key in data[0]) {
    if (data[0].hasOwnProperty(key)) {
      const headerCell = document.createElement('th');
      headerCell.textContent = key;
      headerRow.appendChild(headerCell);
    }
  }

  // Insertar los datos en la tabla
  data.forEach(obj => {
    const row = table.insertRow();
    for (const key in obj) {
      if (obj.hasOwnProperty(key)) {
        const cell = row.insertCell();
        cell.textContent = obj[key];
      }
    }
  });

  // Agregar la tabla al contenedor HTML
  tablaContainer.appendChild(table);
}

// Llamar a la función para obtener los cursos cuando se cargue la página
window.addEventListener('load', obtenerCursos);
