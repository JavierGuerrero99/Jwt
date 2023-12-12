document.getElementById('loginForm').addEventListener('submit', function(event) {
  event.preventDefault(); // Evitar el envío del formulario por defecto

  const username = document.getElementById('username').value;
  const password = document.getElementById('password').value;

  // Validación simple (verificar campos vacíos)
  if (username.trim() === '' || password.trim() === '') {
    alert('Por favor, completa todos los campos');
    return;
  }

  // Datos a enviar a la API
  const data = {
    username: username,
    password: password
  };

  // URL de la API para autenticación
  const apiUrl = 'http://localhost:8080/auth/login';

  // Enviar solicitud POST a la API
  fetch(apiUrl, {
    method: 'POST',
    headers: {
      'Content-Type': 'application/json'
    },
    body: JSON.stringify(data)
  })
  .then(response => {
    if (!response.ok) {
      throw new Error('Error en la solicitud');
    }
    return response.json();
  })
  .then(responseData => {
    // Manejar la respuesta de la API
    // Por ejemplo, redirigir a otra página si la autenticación es exitosa
    alert('¡Inicio de sesión exitoso!');
    // Puedes agregar lógica adicional aquí, como guardar tokens de sesión, redireccionar, etc.
    console.log(responseData); // Aquí puedes ver la respuesta de la API
  	window.location.href='../html/usuario.html';
  })
  .catch(error => {
    console.error('Error:', error);
    // Manejar errores de la API, por ejemplo, mostrar un mensaje de error al usuario
    alert('Credenciales incorrectas. Por favor, inténtalo de nuevo.');
  });
});
