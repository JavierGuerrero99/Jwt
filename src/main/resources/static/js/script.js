document.getElementById('registrationForm').addEventListener('submit', function(event) {
  event.preventDefault(); // Evitar el envío del formulario por defecto

  const form = document.getElementById('registrationForm');
  const formData = new FormData(form);

  // Convertir los datos del formulario a un objeto JSON
  const data = {};
  formData.forEach((value, key) => {
    data[key] = value;
  });

  // Ejemplo de URL de la API (reemplaza con tu URL)
  const apiUrl = ' http://localhost:8080/auth/register';

  // Realizar una solicitud POST a la API con los datos del formulario
  fetch(apiUrl, {
    method: 'POST',
    headers: {
      'Content-Type': 'application/json',
    },
    body: JSON.stringify(data),
  })
  .then(response => {
    if (!response.ok) {
      throw new Error('Error al registrar usuario');
    }
    return response.json();
  })
  .then(data => {
    // Manejar la respuesta de la API después del registro exitoso
    console.log('Usuario registrado:', data);
    alert("Usuario registrado");
    // Aquí puedes redirigir a otra página, mostrar un mensaje de éxito, etc.
  })
  .catch(error => {
    console.error('Error:', error);
    // Aquí puedes mostrar un mensaje de error al usuario
  });
});
