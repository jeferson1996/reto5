const inputId = document.getElementById("inputId")
const inputStart_date = document.getElementById("inputStart_date")
const inputDevolution_date = document.getElementById("inputDevolution_date")
const inputStatus= document.getElementById("inputStatus")
const tableBody = document.getElementById("tableBody")
const tableStatus = document.getElementById("tableStatus")
const tableTop = document.getElementById("tableTop")

const contenedorId = document.getElementById("contenedorId")
const btnModal = document.getElementsByClassName("btn-modal")

function obtener(){
    var requestOptions = {
        method: 'GET',
        redirect: 'follow'
      };
      
      fetch("http://localhost:/api/Reservation/all", requestOptions)
        .then(response => response.json())
        .then(result => {
            result.forEach(element => {

                tableBody.innerHTML += `

              <tr>
                 <td>${element.startDate}</td>
                 <td>${element.devolutionDate}</td>
                 <td>${element.status}</td>
                 <td>
                   <button button type="button" class="btn btn-info" data-bs-toggle="modal" data-bs-target="#formModal" onclick="onClickDetails(${element.idReservation})">Details</button>
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
      
      fetch(`http://localhost:/api/Reservation/${id}`,requestOptions)
        .then(response => response.json())
        .then(result => {

            inputId.value = result.idReservation
            inputStart_date.value = result.startDate
            inputDevolution_date.value = result.devolutionDate
            inputStatus.value = result.status

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

function obtenerStatus(){

    var requestOptions = {
        method: 'GET',
        redirect: 'follow'
      };
      
      fetch("http://localhost:/api/Reservation/report-status", requestOptions)
        .then(response => response.json())
        .then(result => {

            tableStatus.innerHTML +=
           `
              <tr>
                 <td>${result.completed}</td>
                 <td>${result.cancelled}</td>          
             </tr>
              `  

        })
        .catch(error => console.log('error', error));


}

function obtenerTop(){
  var requestOptions = {
      method: 'GET',
      redirect: 'follow'
    };
    
    fetch("http://localhost:/api/Reservation/report-clients", requestOptions)
      .then(response => response.json())
      .then(result => {
          result.forEach(element => {

              tableTop.innerHTML += `

            <tr>
               <td>${element.total}</td>
               <td>${element.client.name}</td>
             </tr>
            `                   
        });


      })
      .catch(error => console.log('error', error));

}


obtener()
obtenerStatus()
obtenerTop()