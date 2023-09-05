let nombrePokemon = null;
let imgPokemon = null;
let contentButtons = null;
let btnBack = null;
let btnNext = null;
let contentCard = null;

window.onload = function () {
  nombrePokemon = document.getElementById("nombrePokemon");
  imgPokemon = document.getElementById("imgPokemon");
  contentCard = document.getElementById("contentCard");    
  contentButtons = document.getElementById("contentButtons");
  btnBack = document.getElementById("btnBack");
  btnNext = document.getElementById("btnNext");

  pokemonsLoad("https://pokeapi.co/api/v2/pokemon");
  console.log(nombrePokemon);
}



function cambiarContenido(nombre, url) {
  console.log("Cambiando imagen: ", nombre, url);
  nombrePokemon.textContent = nombre;
  
  fetch(url)
    .then(respuesta => respuesta.json())
    .then(data => {
      imgPokemon.setAttribute("src", data.sprites.other.dream_world.front_default);
      contentCard.innerHTML = "";
      var temp = `
      <div class="card" ">
        <div class="card-body">
          <h5 class="card-title">INFORMACION:</h5>
          <p class="card-text"> <span class="fw-bold"> Altura:</span>  ${data.height}</p>
          <p class="card-text"> <span class="fw-bold"> Peso: </span> ${data.weight}</p>
          <p class="card-text"> <span class="fw-bold"> Habilidades:</span>  ${data.abilities[0].ability.name}`;

      if (data.abilities[1]) {
        temp += `, ${data.abilities[1].ability.name}`;
      }
      
      temp += `</p>
          <p class="card-text"> <span class="fw-bold"> Tipo: </span> ${data.types[0].type.name}</p>
        </div>
      </div>
      `;
      contentCard.innerHTML += temp;
    }
    );
}


function pokemonsLoad(endpoint) {
  console.log("Iniciando consumo API: ", endpoint);

  fetch(endpoint)
    .then(respuesta => respuesta.json())
    .then(data => {
      contentButtons.innerHTML = "";
      for (var i = 0; i < data.results.length; i++) {

        var temp = `<button class="btn btn-outline-primary col-2 m-2 p-3"onclick="cambiarContenido('${data.results[i].name}', '${data.results[i].url}'   )" >${data.results[i].name}
                        
                    </button>`;

        contentButtons.innerHTML += temp;
        
      }
      btnBack.setAttribute("onclick", `pokemonsLoad("${data.previous}")`);
      btnNext.setAttribute("onclick", `pokemonsLoad("${data.next}")`);
    });
}