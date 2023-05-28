const inputId = document.getElementById("inputId")
const inputMessage = document.getElementById("inputMessage")
const inputClient = document.getElementById("inputClient")
const inputCar = document.getElementById("inputCar")
const tableBody = document.getElementById("tableBody")


const contenedorId = document.getElementById("contenedorId")
const btnModal = document.getElementsByClassName("btn-modal")


function obtener(){
    var requestOptions = {
        method: 'GET',
        redirect: 'follow'
      };
      
      fetch("http://localhost:/api/Message/all", requestOptions)
        .then(response => response.json())
        .then(result => {

            result.forEach(element => {
                tableBody.innerHTML += `

             <tr>
                <td>${element.messageText}</td>
                <td>${element.client.name}</td>
                <td>${element.car.name}</td>
                <td>
                  <button button type="button" class="btn btn-info" data-bs-toggle="modal" data-bs-target="#formModal" onclick="onClickDetails(${element.idMessage})">Details</button>
                </td>
              </tr>

             `        
            });

        })
        .catch(error => console.log('error', error))

}

function obtenerPorId(id){
    var requestOptions = {
        method: 'GET',
        redirect: 'follow'
      };
      
      fetch(`http://localhost:/api/Message/${id}`, requestOptions)
        .then(response => response.json())
        .then(result => {
     
          inputId.value = result.idMessage
          inputMessage.value = result.messageText
          inputClient.value = result.client.name
          inputCar.value = result.car.name

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