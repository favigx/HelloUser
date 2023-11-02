localStorage.getItem("user");
localStorage.getItem("pass");

let loginLink = document.getElementById("loginLink");
let addmemberLink = document.getElementById("addmemberLink");

let List = document.getElementsByClassName("List");
let addmember = document.getElementsByClassName("addmember")
let header = document.getElementsByClassName("header");

let text = document.getElementById("text");
let underText = document.getElementById("underText")

let fnameInput = document.getElementById("fnameInput");
let lnameInput = document.getElementById("lnameInput");
let emailInput = document.getElementById("emailInput");
let cityInput = document.getElementById("cityInput");
let admincheck = document.getElementById("admincheck");

let txt = document.getElementById("txt");

if (localStorage.getItem("user")){
    logOut();
    changeText();  
}

if(!localStorage.getItem("user")){
    hideRemoveBtn();
    hideAddmemberLink();
    
    if(header == header){               // Den här if-satsen är rätt knasig och något jag exprimenterade fram,
        window.location.replace("/");   // Den styr så att inte en icke inloggad admin kan besöka url: /addmember.
    }                                   // Jag förstår att det måste finnas en simplare väg att ta.
}
 
function logOut(){

    loginLink.innerText="Logga ut";
        
        if(loginLink.innerText == "Logga ut"){

            loginLink.addEventListener("click", () =>{
                localStorage.removeItem("user");
                localStorage.removeItem("pass");
                alert("Du är nu utloggad.");
                window.location.assign("/");
            })
        }
}
function changeText(){
    admincheck.style.color="green";
    admincheck.innerText="Inloggad som admin";
    text.textContent="Välkommen admin!";
    underText.textContent="En inloggad admin kan lägga till samt ta bort medlemmar";
}

function hideRemoveBtn(){

    for (let i = 0; i < List.length; i++) {
        removeBtn.remove();
    } 
}

function hideAddmemberLink(){
    addmemberLink.remove();

    for (let i = 0; i < header.length; i++) {   // Den här for-loopen hör till if-satsen ovan.
    
        txt.remove();
        txtt.remove();
    }
}

function removeAlert(){
    alert("Medlem borttagen!");      
}

function addAlert(){

    if (fnameInput.value == "" || lnameInput.value == "" || emailInput.value == "" || cityInput.value == "") {
        alert("Du måste fylla i hela formuläret för att lägga till en ny medlem!");
    return false;
    }
    else{
        alert("Du har lagt till en ny medlem!")
    }
}