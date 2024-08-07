const body = document.querySelector("body"),
    sidebar = body.querySelector("nav"),
    sidebarToggle = body.querySelector(".sidebar-toggle");

sidebarToggle.addEventListener("click", () => {
    sidebar.classList.toggle("close");
});

let arrow = document.querySelectorAll(".arrow");
for (var i = 0; i < arrow.length; i++) {
    arrow[i].addEventListener("click", (e) => {
        let arrowParent = e.target.parentElement.parentElement; //selecting main parent of arrow
        arrowParent.classList.toggle("showMenu");
    });
}


/*=============== DARK LIGHT THEME ===============*/
const themeButton = document.getElementById('theme-button');
const darkTheme = 'dark-theme';
const iconTheme = 'ri-sun-line';

// Previously selected topic (if user selected)
const selectedTheme = localStorage.getItem('selected-theme');
const selectedIcon = localStorage.getItem('selected-icon');

// We obtain the current theme that the interface has by validating the dark-theme class
const getCurrentTheme = () => document.body.classList.contains(darkTheme) ? 'dark' : 'light';
const getCurrentIcon = () => themeButton.classList.contains(iconTheme) ? 'ri-moon-line' : 'ri-sun-line';

// We validate if the user previously chose a topic
if (selectedTheme) {
    // If the validation is fulfilled, we ask what the issue was to know if we activated or deactivated the dark
    document.body.classList[selectedTheme === 'dark' ? 'add' : 'remove'](darkTheme);
    themeButton.classList[selectedIcon === 'ri-moon-line' ? 'add' : 'remove'](iconTheme);
}

// Activate / deactivate the theme manually with the button
themeButton.addEventListener('click', () => {
    // Add or remove the dark / icon theme
    document.body.classList.toggle(darkTheme);
    themeButton.classList.toggle(iconTheme);
    // We save the theme and the current icon that the user chose
    localStorage.setItem('selected-theme', getCurrentTheme());
    localStorage.setItem('selected-icon', getCurrentIcon());
});

// Seleccionamos el input de búsqueda y el contenedor de resultados
const searchInput = document.querySelector('.search-box input');
const searchResults = document.createElement('div');
searchResults.classList.add('search-results-container');
document.querySelector('.search-box').appendChild(searchResults);

// Autocompletado y búsqueda
searchInput.addEventListener('input', (e) => {
  const searchTerm = e.target.value.toLowerCase();

  const menuItems = {
    principal: "principal",
    apertura: "aperturaCuenta",
    prestamo: "prestamoNuevo",
    tarjeta: "tarjetaNueva",
    seguro: "seguroDeGastos"
  };

  const filteredResults = [];
  
  for (const key in menuItems) {
    const menuItem = document.getElementById(menuItems[key]);
    if (!menuItem) continue;

    const link = menuItem.querySelector("a");
    if (!link) continue;

    const linkTextElement = link.querySelector(".link_name");
    const linkText = linkTextElement ? linkTextElement.textContent.toLowerCase() : '';

    if (linkText.includes(searchTerm)) {
      filteredResults.push({
        title: linkText,
        url: link.href
      });
    }
  }

  // Limpiamos el contenedor de resultados
  searchResults.innerHTML = '';

  // Agregamos los resultados filtrados al contenedor
  filteredResults.forEach((item) => {
    const resultHTML = `
      <div class="result-item" data-url="${item.url}">
        ${item.title}
      </div>
    `;
    searchResults.insertAdjacentHTML('beforeend', resultHTML);
  });

  if (filteredResults.length === 0) {
    searchResults.innerHTML = '<div>No se encontraron coincidencias.</div>';
  }
});

// Navegación con Enter
searchInput.addEventListener('keypress', (e) => {
  if (e.key === 'Enter') {
    const firstResult = document.querySelector('.result-item');
    if (firstResult) {
      document.querySelector('iframe[name="myframe"]').src = firstResult.getAttribute('data-url');
      searchResults.innerHTML = ''; // Limpiar los resultados después de seleccionar uno
    }
  }
});

// Navegación con clic en resultados
searchResults.addEventListener('click', (e) => {
  if (e.target.classList.contains('result-item')) {
    const url = e.target.getAttribute('data-url');
    document.querySelector('iframe[name="myframe"]').src = url;
    searchResults.innerHTML = ''; // Limpiar los resultados después de seleccionar uno
  }
});

// Obtener los elementos
var modal = document.getElementById("miModal");
var btn = document.getElementById("abrirModal");

// Función para abrir el modal
btn.onclick = function() {
  modal.style.display = "block";
}


// Cerrar el modal si el usuario hace clic fuera de él
window.onclick = function(event) {
  if (event.target == modal) {
    modal.style.display = "none";
  }
}

// Obtener el elemento de la X
var cerrar = document.querySelector('.cerrar');

// Agregar un evento para cerrar el modal
cerrar.addEventListener('click', function() {
  modal.style.display = 'none';
  return false;
});

// Funcionalidad para abrir otros modales
  var openPerfilBtn = document.getElementById("openPerfil");
  var openConfiguracionBtn = document.getElementById("openConfiguracion");

  openPerfilBtn.onclick = function() {
    document.getElementById("modalPerfil").style.display = "block";
    modal.style.display = "none"; // Cerrar el modal principal
  }

  openConfiguracionBtn.onclick = function() {
    document.getElementById("modalConfiguracion").style.display = "block";
    modal.style.display = "none"; // Cerrar el modal principal
  }

  // Cerrar otros modales
  document.querySelectorAll('.cerrar').forEach(function(cerrarBtn) {
    cerrarBtn.addEventListener('click', function() {
      var parentModal = cerrarBtn.closest('.modal');
      parentModal.style.display = 'none';
    });
  });

  window.onclick = function(event) {
    var modals = document.querySelectorAll('.modal');
    modals.forEach(function(modal) {
      if (event.target == modal) {
        modal.style.display = "none";
      }
    });
  }