
const inputId = document.getElementById("inputId")
const inputName = document.getElementById("inputName")
const inputBrand = document.getElementById("inputBrand")
const inputYear = document.getElementById("inputYear")
const inputDescription = document.getElementById("inputDescription")
const tableBody = document.getElementById("tableBody")

const contenedorId = document.getElementById("contenedorId")
const btnModal = document.getElementsByClassName("btn-modal")

function obtener(){
    var requestOptions = {
        method: 'GET',
        redirect: 'follow'
      };
      
      fetch("http://localhost:/api/Car/all", requestOptions)
        .then(response => response.json())
        .then(result => {
            result.forEach(element => {
                tableBody.innerHTML += `

                <tr>
                   <td>${element.name}</td>
                   <td>${element.brand}</td>
                   <td>${element.year}</td>
                   <td>${element.description}</td>
                   <td>
                     <button button type="button" class="btn btn-info" data-bs-toggle="modal" data-bs-target="#formModal" onclick="onClickDetails(${element.idCar})">Details</button>
                   </td>
                 </tr>
                 `

            });
        })
        .catch(error => console.log('error', error));

}
function obtenerPorId(id){
    var requestOptions = {
        method: 'GET',
        redirect: 'follow'
      };
      
      fetch(`http://localhost:/api/Car/${id}`, requestOptions)
        .then(response => response.json())
        .then(result => {
        

          inputId.value = result.idCar
          inputName.value = result.name
          inputBrand.value = result.brand
          inputYear.value = result.year
          inputDescription.value = result.description
          

        })
        .catch(error => console.log('error', error));

}


function onClickAdd(){
    contenedorId.style.display = "none"
    btnModal[0].style.display = "block"
    btnModal[1].style.display = "none"
    btnModal[2].style.display = "none"

}

function onClickDetails(id){
    contenedorId.style.display = "block"
    btnModal[0].style.display = "none"
    btnModal[1].style.display = "block"
    btnModal[2].style.display = "block"

    obtenerPorId(id)



}


obtener()